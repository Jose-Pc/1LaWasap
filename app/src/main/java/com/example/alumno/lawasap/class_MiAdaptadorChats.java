package com.example.alumno.lawasap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by alumno on 23/10/17.
 */

public class class_MiAdaptadorChats extends BaseAdapter {


    Context context;
    Cursor c;

    public class_MiAdaptadorChats(Context context) {

        this.context = context;
        BBDD agendaBBDD=new BBDD(context, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getReadableDatabase();
        if(db != null) {

            c = db.rawQuery("select  contactos.telefono,nombre,id_foto,mensaje,fecha from Contactos,mensajes where Contactos.telefono=id_emisor or Contactos.telefono=id_receptor and fecha=(select max(fecha) from mensajes) order by fecha", null);

        }

    }

    @Override
    public int getCount() {
        return c.getCount();
        //return agenda.size();
    }

    @Override
    public Object getItem(int position) {
        return c.moveToPosition(position);

    }

    @Override
    public long getItemId(int position) {
        c.moveToPosition(position);

        return c.getLong(0);
    }

    //@Override
    public View getView(int position, View convertView , ViewGroup parent) {

        //Es la primera vez que se va a usar la vista
        if (convertView == null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.plantilla_chats, null);
        }
        c.moveToPosition(position);
        TextView tvNombre = (TextView) convertView.findViewById(R.id.text_nombre);
        tvNombre.setText(c.getString(1));



       // Log.e("foto", String.valueOf(c.getInt(2)));


        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.ima_contacto);
        imgFoto.setBackgroundResource(c.getInt(2));

        TextView tvMensaje = (TextView) convertView.findViewById(R.id.text_UltMensaje);
        tvMensaje.setText(c.getString(3));

        TextView tvfecha = (TextView) convertView.findViewById(R.id.txtfehca);
        tvfecha.setText(c.getString(4));



        return convertView;
    }
}
