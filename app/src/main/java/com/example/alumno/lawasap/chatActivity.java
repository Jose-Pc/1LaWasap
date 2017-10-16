package com.example.alumno.lawasap;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

import static com.example.alumno.lawasap.R.id.btn_enviarChat;

public class chatActivity extends Activity {
    ArrayList<class_mensage> cls_mensaje = new ArrayList<class_mensage>();

    public void onClick(View v)
    {
        TextView texto=(TextView) findViewById(R.id.str_introTexto);
        class_mensage mess = new class_mensage(texto.getText().toString(),new Date(),"Jose");
        cls_mensaje.add(mess);
        mostrarMensajes(cls_mensaje.size()-1);// le dices que se posicione en en el ultimo mensaje creado del arrayList
        texto.setText("");


    }
    public void mostrarMensajes(int pos_mensaje){
        LinearLayout ly_conv =(LinearLayout) findViewById(R.id.layoutConversaciones);

        for(int i=pos_mensaje; i < cls_mensaje.size(); i++){
            TextView tv = new TextView(this);
            tv.setText(cls_mensaje.get(i).getRemintente() + ":  " + cls_mensaje.get(i).getContenido() +"\n"+ cls_mensaje.get(i).getFecha() );
            tv.setGravity(Gravity.RIGHT);
            tv.setPadding(5,5,5,5);
            tv.setBackgroundColor(Color.rgb(218, 215, 215));
            ly_conv.addView(tv);
            ///aaaa
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);

        mostrarMensajes(0);


    }
}
