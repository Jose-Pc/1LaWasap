package com.example.alumno.lawasap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Struct;

public class chatActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mensage msg = new mensage();
        String [] str_text= new String[3];
        str_text[0]= "Hola como estas.";
        str_text[1]= "Bien. Y tu.";
        str_text[2]= "Bien.";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);

        LinearLayout ly_conv =(LinearLayout) findViewById(R.id.layoutConversaciones);

        for(int i=0; i < str_text.length; i++){
            TextView tv = new TextView(this);
            tv.setText(str_text[i]);
            tv.setGravity(Gravity.RIGHT);
            tv.setPadding(5,5,5,5);
            tv.setBackgroundColor(Color.rgb(218, 215, 215));
            ly_conv.addView(tv);
        }
    }
}
