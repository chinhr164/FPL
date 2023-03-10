package com.example.ph21409_final_cp17306;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PH21409_MainActivity_CP17306 extends AppCompatActivity {


    private EditText PH21409_edIDtype_CP17306, PH21409_edIDP_CP17306, PH21409_edQty_CP17306,
            PH21409_edPrice_CP17306, PH21409_edDate_CP17306;
    private Button PH21409_btn_CP17306;
    private ListView PH21409_lv_CP17306;

    private EditText PH21409_dA_CP17306, PH21409_dB_CP17306;
    private TextView PH21409_dTv_CP17306;
    private Button PH21409_dBtn_CP17306;

    private PH21409_Database_CP17306 PH21409_db_CP17306;
    private ArrayList<PH21409_Product_CP17306> PH21409_list_CP17306 = new ArrayList<>();
    private PH21409_Adapter_CP17306 PH21409_adapter_CP17306;

    public static final String PH21409_TB_NAME_CP17306 = "Product";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PH21409_edIDtype_CP17306 = findViewById(R.id.PH21409_edIDtype_CP17306);
        PH21409_edIDP_CP17306 = findViewById(R.id.PH21409_edIDP_CP17306);
        PH21409_edQty_CP17306 = findViewById(R.id.PH21409_edQty_CP17306);
        PH21409_edPrice_CP17306 = findViewById(R.id.PH21409_edPrice_CP17306);
        PH21409_edDate_CP17306 = findViewById(R.id.PH21409_edDate_CP17306);


        PH21409_lv_CP17306 = findViewById(R.id.PH21409_lv_CP17306);
        PH21409_db_CP17306 = new PH21409_Database_CP17306(PH21409_MainActivity_CP17306.this);
        PH21409_db_CP17306.PH21409_queryData("CREATE TABLE IF NOT EXISTS " + PH21409_TB_NAME_CP17306 +
                "(PH21409_idType_CP17306 TEXT," +
                "PH21409_idP_CP17306 TEXT," +
                "PH21409_price_CP17306 TEXT," +
                "PH21409_qty_CP17306 TEXT," +
                "PH21409_date_CP17306 TEXT, " +
                "PRIMARY KEY (PH21409_idType_CP17306,PH21409_idP_CP17306))");

        PH21409_db_CP17306.PH21409_queryData("CREATE TABLE IF NOT EXISTS Type" +
                "(PH21409_idType_CP17306 TEXT PRIMARY KEY," +
                "PH21409_nameType_CP17306 TEXT) ");

        show();
        PH21409_btn_CP17306 = findViewById(R.id.PH21409_btn_CP17306);
        PH21409_btn_CP17306.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PH21409_idType_CP17306 = PH21409_edIDtype_CP17306.getText().toString().toUpperCase();
                String PH21409_idP_CP17306 = PH21409_edIDP_CP17306.getText().toString().toUpperCase();
                String PH21409_price_CP17306 = PH21409_edQty_CP17306.getText().toString();
                String PH21409_qty_CP17306 = PH21409_edPrice_CP17306.getText().toString();
                String PH21409_date_CP17306 = PH21409_edDate_CP17306.getText().toString();
                if (PH21409_idType_CP17306.equals("") || PH21409_idP_CP17306.equals("") ||
                        PH21409_price_CP17306.equals("") || PH21409_qty_CP17306.equals("") ||
                        PH21409_date_CP17306.equals("")) {
                } else {
                    if (PH21409_db_CP17306.PH21409_getData("SELECT * FROM "
                            + PH21409_TB_NAME_CP17306 + " WHERE PH21409_idP_CP17306='" + PH21409_idP_CP17306 + "'").getCount() != 0) {
                        PH21409_db_CP17306.PH21409_queryData("UPDATE " + PH21409_TB_NAME_CP17306 + " SET "
                                + "PH21409_idType_CP17306='" + PH21409_idType_CP17306 + "',"
                                + "PH21409_price_CP17306='" + PH21409_price_CP17306 + "',"
                                + "PH21409_qty_CP17306='" + PH21409_qty_CP17306 + "',"
                                + "PH21409_date_CP17306='" + PH21409_date_CP17306 + "' " +
                                "WHERE PH21409_idP_CP17306='" + PH21409_idP_CP17306 + "'");


                        Toast.makeText(PH21409_MainActivity_CP17306.this, "Update success!", Toast.LENGTH_LONG).show();
                    } else {
                        PH21409_db_CP17306.PH21409_queryData("INSERT INTO " + PH21409_TB_NAME_CP17306 + " VALUES('"
                                + PH21409_idType_CP17306 + "','"
                                + PH21409_idP_CP17306 + "','"
                                + PH21409_price_CP17306 + "','"
                                + PH21409_qty_CP17306 + "','"
                                + PH21409_date_CP17306 + "')");
                        Toast.makeText(PH21409_MainActivity_CP17306.this, "Add new Product success!", Toast.LENGTH_LONG).show();
                    }
                    show();
//
                }
            }
        });


        PH21409_lv_CP17306.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PH21409_btn_CP17306.setEnabled(true);
                PH21409_edIDtype_CP17306.setText(PH21409_list_CP17306.get(position).getPH21409_IDtype_CP17306());
                PH21409_edIDP_CP17306.setText(PH21409_list_CP17306.get(position).getPH21409_IDP_CP17306());
                PH21409_edQty_CP17306.setText(PH21409_list_CP17306.get(position).getPH21409_Qty_CP17306());
                PH21409_edPrice_CP17306.setText(PH21409_list_CP17306.get(position).getPH21409_Price_CP17306());
                PH21409_edDate_CP17306.setText(PH21409_list_CP17306.get(position).getPH21409_Date_CP17306());
            }
        });

        PH21409_lv_CP17306.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long id) {
                AlertDialog.Builder PH21409_Builder_CP17306 = new AlertDialog.Builder(PH21409_MainActivity_CP17306.this);
                View PH21409_view_CP17306 = getLayoutInflater().inflate(R.layout.dialog_total_class, null);
                View PH21409_mView_CP17306 = getLayoutInflater().inflate(R.layout.activity_main, null);
                PH21409_Builder_CP17306.setView(PH21409_view_CP17306);

                PH21409_dA_CP17306 = PH21409_view_CP17306.findViewById(R.id.PH21409_dA_CP17306);
                PH21409_dB_CP17306 = PH21409_view_CP17306.findViewById(R.id.PH21409_dB_CP17306);
                PH21409_dTv_CP17306 = PH21409_view_CP17306.findViewById(R.id.PH21409_dTV_CP17306);

                PH21409_dBtn_CP17306 = PH21409_view_CP17306.findViewById(R.id.PH21409_dBtn_CP17306);
                PH21409_dBtn_CP17306.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String PH21409_dAA_CP17306 = PH21409_dA_CP17306.getText().toString();
                        String PH21409_dBB_CP17306 = PH21409_dB_CP17306.getText().toString();
                        Cursor PH21409_c_CP17306 =
                                PH21409_db_CP17306.PH21409_getData("SELECT PH21409_idP_CP17306, MAX(PH21409_qty_CP17306) FROM " + PH21409_TB_NAME_CP17306 +
                                        " WHERE PH21409_date_CP17306 >= '" + PH21409_dAA_CP17306 +
                                        "' AND PH21409_date_CP17306 <= '" + PH21409_dAA_CP17306 +
                                        "' GROUP BY PH21409_idP_CP17306");
                        PH21409_c_CP17306.moveToPosition(0);
                        PH21409_dTv_CP17306.setText(PH21409_c_CP17306.getString(0));
                        PH21409_c_CP17306.close();
                    }
                });

                AlertDialog PH21409_Dialog_CP17306 = PH21409_Builder_CP17306.create();
                PH21409_Dialog_CP17306.show();

                PH21409_mView_CP17306.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        PH21409_Dialog_CP17306.dismiss();
                        return true;
                    }
                });

                return true;
            }
        });
    }

    public void show() {
        PH21409_list_CP17306.clear();
        Cursor PH21409_c_CP17306 = PH21409_db_CP17306.PH21409_getData("SELECT * FROM " + PH21409_TB_NAME_CP17306);
//        PH21409_c.moveToFirst();
        while (PH21409_c_CP17306.moveToNext()) {
            String PH21409_idType_CP17306 = PH21409_c_CP17306.getString(0);
            String PH21409_idP_CP17306 = PH21409_c_CP17306.getString(1);
            String PH21409_price_CP17306 = PH21409_c_CP17306.getString(2);
            String PH21409_qty_CP17306 = PH21409_c_CP17306.getString(3);
            String PH21409_date_CP17306 = PH21409_c_CP17306.getString(4);

            PH21409_list_CP17306.add(new PH21409_Product_CP17306(PH21409_idType_CP17306, PH21409_idP_CP17306, PH21409_price_CP17306, PH21409_qty_CP17306, PH21409_date_CP17306));
        }
        PH21409_c_CP17306.close();
        PH21409_adapter_CP17306 = new PH21409_Adapter_CP17306(PH21409_MainActivity_CP17306.this, R.layout.ph21409_item_row_cp17306, PH21409_list_CP17306);
        PH21409_lv_CP17306.setAdapter(PH21409_adapter_CP17306);
    }
}
