package com.example.mukundmurarka.attendance;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TEACHERLIST extends AppCompatActivity {
    ListView teacherlist;
    ArrayList<String> namelist;
    ArrayList<String> totallist;

    SQLiteDatabase sqldatabase;
    Teacherdetail detailteacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlist);
        teacherlist = (ListView)findViewById(R.id.listtea);

        namelist = new ArrayList<>();
        totallist = new ArrayList<>();
        detailteacher = new Teacherdetail(TEACHERLIST.this);
        Cursor cursor = detailteacher.getData();
        sqldatabase = detailteacher.getWritableDatabase();

        if (cursor.moveToFirst()) {
            do {
                String name_t = cursor.getString(cursor.getColumnIndex("Name"));
                String email_t = cursor.getString(cursor.getColumnIndex("EMAILID"));
                String pass_t= cursor.getString(cursor.getColumnIndex("PASSWORD"));


                namelist.add(name_t);
                totallist.add(name_t + " " + email_t + " " + pass_t );

            }
            while (cursor.moveToNext());
        }
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(TEACHERLIST.this, android.R.layout.simple_list_item_1, totallist);
        teacherlist.setAdapter(arrayAdapter);

        teacherlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(TEACHERLIST.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure want to delete ?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        detailteacher.onDelete(namelist.get(position));

                        totallist.remove(position);

                        arrayAdapter.notifyDataSetChanged();

                        Toast.makeText(TEACHERLIST.this, "Item Deleted", Toast.LENGTH_LONG).show();
                        //

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

                return true;
            }

        });




    }
}
