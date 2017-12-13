package com.example.alumno.lawasap;

import android.content.Context;
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

public class class_MiAdaptadorContact extends BaseAdapter {

    List<class_contacto> valores;
    Context context;

    public class_MiAdaptadorContact(List<class_contacto> valores, Context context) {
        this.valores = valores;
        this.context = context;
    }


    @Override
    public int getCount() {
        return valores.size();
    }

    @Override
    public Object getItem(int position) {
        return valores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Es la primera vez que se va a usar la vista
        if (convertView == null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.plantilla_contacto, null);
        }

        TextView tvNombre = (TextView) convertView.findViewById(R.id.str_nombre);
        tvNombre.setText(valores.get(position).nombre);
        TextView tvTelefono = (TextView) convertView.findViewById(R.id.str_telf);
        tvTelefono.setText(valores.get(position).telefono);
        ImageView imgFoto = (ImageView) convertView.findViewById(R.id.ima_foto);
        imgFoto.setBackgroundResource(valores.get(position).foto);

        return convertView;
    }
}
