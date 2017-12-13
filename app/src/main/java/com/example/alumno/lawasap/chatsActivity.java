package com.example.alumno.lawasap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alumno on 25/10/17.
 */

public class chatsActivity  extends Activity {
    public static final int id_Emisor= 666999666;

    public static int getId_Emisor() {
        return id_Emisor;
    }

    private AdapterView.OnItemClickListener ideContact = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

            long id_telf = id;

            //Log.e("QQQQQQQ",String.valueOf(id));
            //Intent intent = new Intent(chatsActivity.this, chatActivity.class);
            Intent intent = new Intent(getApplicationContext(), chatActivity.class);
            intent.putExtra("identificadorMens", id_telf);
            //based on item add info to intent
            startActivity(intent);
        }
    };
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chats);

        class_MiAdaptadorChats MiAdapter = new class_MiAdaptadorChats(this);
        ListView list_chats = (ListView) this.findViewById(R.id.listChats);
        list_chats.setAdapter(MiAdapter);


        list_chats.setOnItemClickListener(ideContact);

    }

}
