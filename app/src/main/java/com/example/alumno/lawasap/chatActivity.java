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
    ArrayList<class_mensage> Arr_mensaje = new ArrayList<class_mensage>();

    public void onClick(View v)
    {
        TextView texto=(TextView) findViewById(R.id.str_introTexto);
        class_mensage mess = new class_mensage(texto.getText().toString(),new Date(),"Jose");
        Arr_mensaje.add(mess);
        mostrarMensajes(Arr_mensaje.size()-1);// le dices que se posicione en en el ultimo mensaje creado del arrayList
        texto.setText("");


    }
    public void mostrarMensajes(int pos_mensaje){
        LinearLayout ly_conv =(LinearLayout) findViewById(R.id.layoutConversaciones);
        LinearLayout ly_fecha=(LinearLayout) findViewById(R.id.layoutConversaciones);
        ly_conv.addView(ly_fecha);


        for(int i=pos_mensaje; i < Arr_mensaje.size(); i++){
            TextView tv_fecha = new TextView(this);
            tv_fecha.setText((CharSequence) Arr_mensaje.get(i).getFecha());
            tv_fecha.setGravity(Gravity.CENTER);
            tv_fecha.setPadding(5,5,5,5);
            tv_fecha.setBackgroundColor(Color.rgb(218, 215, 215));
            ly_fecha.addView(tv_fecha);







            TextView tv = new TextView(this);
            tv.setText(Arr_mensaje.get(i).getRemintente() + "\n" + Arr_mensaje.get(i).getContenido() +"\n"+ Arr_mensaje.get(i).getFecha() );
            tv.setGravity(Gravity.RIGHT);
            tv.setPadding(5,5,5,5);
            tv.setBackgroundColor(Color.rgb(218, 215, 215));
            ly_conv.addView(tv);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);

        mostrarMensajes(0);


    }
}
