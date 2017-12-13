package com.example.alumno.lawasap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.alumno.lawasap.R.id.btn_enviarChat;

public class chatActivity extends Activity {
    ArrayList<class_mensage> Arr_mensaje = new ArrayList<class_mensage>();
    long id_telf;

    BBDD agendaBBDD=new BBDD(this, "agendaBBDD", null, 1);
    public void onClick(View v)
    {
        TextView texto=(TextView) findViewById(R.id.str_introTexto);
        class_mensage mess = new class_mensage(texto.getText().toString(),new Date(),"Jose");

        SQLiteDatabase dbInsert = agendaBBDD.getWritableDatabase();

       // SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy HH:MM:SS");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(new Date());


       Log.e("prueba fecha", strDate);


        String txt_mens = texto.getText().toString();



        String sql = "Insert into mensajes values("+chatsActivity.getId_Emisor()+","+id_telf+",'"+txt_mens+"','"+strDate+"')";
        Log.e("prueba Insert",sql);
        dbInsert.execSQL(sql);


        mostrarMensajes(strDate);
        texto.setText("");


    }
    public void mostrarMensajes(String ultimaFecha){
        LinearLayout ly_conv =(LinearLayout) findViewById(R.id.layoutConversaciones);

        SQLiteDatabase db = agendaBBDD.getReadableDatabase();
        Cursor curContacto= null;
        Cursor curMens= null;
        if(db != null) {

            curContacto = db.rawQuery("select id_foto,nombre from contactos where telefono= "+id_telf+"", null);
            curContacto.moveToFirst();

            ImageView ima_prod = (ImageView)findViewById(R.id.img_fotoUser);
            ima_prod.setBackgroundResource(curContacto.getInt(0));

            TextView txtNombre=(TextView) findViewById(R.id.str_nomUser);
            txtNombre.setText(curContacto.getString(1));

            String sql;
           if(ultimaFecha==null){
               sql="select * from mensajes where id_emisor="+id_telf+" or id_receptor="+id_telf+" order by fecha";
           }
           else{
               sql= "select * from mensajes where id_emisor="+id_telf+" or id_receptor="+id_telf+" and fecha >'"+ ultimaFecha +"' order by fecha";
             //  curMens = db.rawQuery("select * from mensajes where id_emisor="+id_telf+" or id_receptor="+id_telf+" and fecha="+ultimaFecha+"",null);

           }
            Log.e("prueba muestra",sql);
            curMens = db.rawQuery(sql,null);





            while(curMens.moveToNext()){
                Log.e("Prueba",curMens.getString(2));


                LinearLayout ly_mensaje = new LinearLayout(this);
                ly_mensaje.setOrientation(LinearLayout.VERTICAL);

                TextView tv_fecha = new TextView(this);
                tv_fecha.setText(curMens.getString(3)+"\n");
                tv_fecha.setGravity(Gravity.CENTER);
                tv_fecha.setPadding(5,5,5,5);
                tv_fecha.setBackgroundColor(Color.rgb(218, 215, 215));
                ly_mensaje.addView(tv_fecha);

                TextView tv_cont = new TextView(this);
                tv_cont.setText(curMens.getString(2) +"\n");
                tv_cont.setGravity(Gravity.RIGHT);
                tv_cont.setPadding(5,5,5,5);
                tv_cont.setBackgroundColor(Color.rgb(218, 215, 215));
                ly_mensaje.addView(tv_cont);

                /*****
                 *
                 *          //VER CON PACO COMO SOLUCIONAR ESTO
                 *          MOSTRAR EL NOMBRE DE QUIEN ES EL MENSAJE
                 *
                 *
                 */
                TextView tv_persona = new TextView(this);
                tv_persona.setText(txtNombre.getText() +"\n");
                tv_persona.setGravity(Gravity.RIGHT);
                tv_persona.setPadding(5,5,5,5);
                tv_persona.setBackgroundColor(Color.rgb(218, 215, 215));
                ly_mensaje.addView(tv_persona);


                ly_conv.addView(ly_mensaje);
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chat);

        // Get the message from the intent
        Intent intent = getIntent();
        id_telf = intent.getLongExtra("identificadorMens",0);





        Log.e ("XXXXX", String.valueOf(id_telf));
        mostrarMensajes(null);


    }
}
