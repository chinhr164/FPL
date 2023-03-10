package com.zrapp.news;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NewsLoader {
    ArrayList<NewsDTO> list = new ArrayList<>();
    NewsDTO news;
    String textContent;

    public ArrayList<NewsDTO> getList(InputStream inputStream) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser(); parser.setInput(inputStream, null);
            int eventType = parser.getEventType(); while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName(); switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("item")) news = new NewsDTO(); break;
                    case XmlPullParser.TEXT:
                        textContent = parser.getText(); break;
                    case XmlPullParser.END_TAG:
                        if (news != null) {
                            if (tagName.equalsIgnoreCase("item")) list.add(news);
                            if (tagName.equalsIgnoreCase("title")) news.setTitle(textContent);
                            if (tagName.equalsIgnoreCase("description")) {
                                String des, img = null;
                                int indexS = textContent.indexOf("src=\"") + 5;
                                int indexE = textContent.indexOf(" ", indexS) - 1;
                                if (textContent.contains("src=\"")) {
                                    des = textContent.substring(textContent.indexOf("</br>") + 5);
                                    img = textContent.substring(indexS, indexE);
                                } else {
                                    des = textContent;
                                } news.setDescip(des); news.setImg(img);
                            } if (tagName.equalsIgnoreCase("link")) news.setLink(textContent);
                        } break;
                    default:
                        break;
                } eventType = parser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return list;
    }

}

