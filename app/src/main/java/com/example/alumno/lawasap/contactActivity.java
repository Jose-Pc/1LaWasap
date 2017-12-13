package com.example.alumno.lawasap;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 23/10/17.
 */

public class contactActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_contactos);


        Cursor c=null;
        List<class_contacto> agenda = new ArrayList<>();



        BBDD agendaBBDD=new BBDD(this, "agendaBBDD", null, 1);
        SQLiteDatabase db = agendaBBDD.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos

        if(db != null) {
            c = db.rawQuery(" SELECT telefono AS _id,nombre,telefono,id_foto FROM Contactos ", null);
        }
        if(c.moveToFirst()){
            do {
                agenda.add(new class_contacto(c.getString(1),c.getString(2),c.getInt(3)));
            } while (c.moveToNext());
        }
        class_MiAdaptadorContact MiAdapter = new class_MiAdaptadorContact(agenda,this);
        ListView list_contactos = (ListView) this.findViewById(R.id.listContactos);
        list_contactos.setAdapter(MiAdapter);

    }
}
