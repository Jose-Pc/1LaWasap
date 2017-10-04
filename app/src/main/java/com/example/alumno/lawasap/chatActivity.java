package com.example.alumno.lawasap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class chatActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String text[];

        super.onCreate(savedInstanceState);

        LinearLayout layout_chat = new LinearLayout(this);
        layout_chat.setOrientation(LinearLayout.VERTICAL);
        setContentView(R.layout.layout_chat);

        LinearLayout layConver = new LinearLayout(this);
        layConver = layout_chat.getE
        TextView tv = new TextView(this);
        tv.setText("hola");
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        tv.setBackgroundColor(Color.rgb(125, 00, 00));
        layout_chat.addView(tv);


    }
}
