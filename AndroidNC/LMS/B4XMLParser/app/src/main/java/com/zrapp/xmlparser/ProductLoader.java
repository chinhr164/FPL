package com.zrapp.xmlparser;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductLoader {
    List productDTOList = new ArrayList();
    ProductDTO productDTO; // dùng làm biến tạm chứa nội dung sản phẩm
    String textContent; // dùng làm biến tạm để đọc nội dung của 1 thẻ

    public List getProductDTOList(InputStream inputStream) {
        // khởi tạo cho XML parser
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            //======
            // truyền vào nguồn dữ liệu xmml: có thể đọc từ file hoặc từ internet
            parser.setInput(inputStream, null);

            // xác định event type khi xmlPull nó hoạt động
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                // trong khi chưa đọc hết thẻ cuối cùng của tài liệu thì eventType khác End_DOC
                String tagName = parser.getName(); // lấy tên thẻ

                Log.d("zzzzz", "Tag name =  " + tagName + ", Độ sâu của thẻ = " + parser.getDepth());

                switch (eventType){
                    case XmlPullParser.START_TAG:
                        // nếu đọc vào thẻ mở của 1 phần tử sản phẩm thì tạo mới DTO
                        if(tagName.equalsIgnoreCase("product"))
                            productDTO = new ProductDTO();

                        break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:

                        if(tagName.equalsIgnoreCase("product")){
                            productDTOList.add( productDTO );
                        }else if(tagName.equalsIgnoreCase("name")){
                            productDTO.setName(  textContent );
                        }else if(tagName.equalsIgnoreCase("price")){
                            productDTO.setPrice( Integer.parseInt(textContent) );
                        }

                        break;
                    default:
                        Log.d("zzzz", "eventType khác: " + eventType);
                        break;
                }
                eventType = parser.next();
            }
        }
        catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productDTOList;
    }
}
