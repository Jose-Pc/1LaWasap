package com.example.alumno.lawasap;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jose on 7/11/17.
 */

public class BBDD extends SQLiteOpenHelper {

    String sqlCrearContactos = "CREATE TABLE contactos (nombre TEXT,telefono Integer, id_foto Integer)";
    String sqlCrearChats = "CREATE TABLE mensajes(id_emisor Integer,id_receptor Integer,mensaje TEXT, fecha DATE)";

    public BBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    public BBDD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }



    int id_Propio = chatsActivity.getId_Emisor();


    @Override
    public void onCreate(SQLiteDatabase sqLiteDB) {
        sqLiteDB.execSQL(sqlCrearContactos);
        sqLiteDB.execSQL(sqlCrearChats);

        if(sqLiteDB!=null){

            sqLiteDB.execSQL("INSERT INTO Contactos (nombre,telefono,id_foto) VALUES ('Luis','666111111','"+R.drawable.foto1+"')");
            sqLiteDB.execSQL("INSERT INTO Contactos (nombre,telefono,id_foto) VALUES ('Laura','666111222','"+R.drawable.foto2+"')");
            sqLiteDB.execSQL("INSERT INTO Contactos (nombre,telefono,id_foto) VALUES ('Juan','666111333','"+R.drawable.foto3+"')");
        }
        if(sqLiteDB!=null){

            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('"+id_Propio+"','666111111','hola soy Jose','2017-12-01 03:32:09 ')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('666111111','"+id_Propio+"','hola Jose.Soy luis','2017-12-15 03:32:09')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('"+id_Propio+"','666111111','Heee pardal que haces','2017-12-17 03:32:09')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('"+id_Propio+"','666111222','hola  laura','2017-12-13 03:32:09')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('666111222','"+id_Propio+"','hola Jose.como estas','2017-12-17 03:32:04')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('"+id_Propio+"','666111333','hola soy juan, buuaaag','2017-12-14 03:32:04')");
            sqLiteDB.execSQL("INSERT INTO mensajes (id_emisor,id_receptor,mensaje,fecha) VALUES ('666111333','"+id_Propio+"','hola soy juan222','2017-12-31 03:32:22')");
        }

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLitDB, int version, int versionNew) {

        //Eliminamos la tabla de contactos en caso de cambie la tabla en caso real migras datos.
        sqLitDB.execSQL("DROP TABLE IF EXISTS contactos");
        sqLitDB.execSQL("DROP TABLE IF EXISTS chats");

        sqLitDB.execSQL(sqlCrearContactos);//Vuelves a crearla.
        sqLitDB.execSQL(sqlCrearChats);//Vuelves a crearla.
    }
}
