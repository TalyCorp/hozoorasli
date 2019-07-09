package com.example.hozoor;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Classes extends AppCompatActivity {

    TextView add;
    Database database;
    private SQLiteDatabase sqLiteDatabase;
    private class_adaptor mclassadaptor;
    RecyclerView.LayoutManager layoutManager;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_classes );

        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar );

        Database mdatabase = new Database ( this );
        sqLiteDatabase = mdatabase.getWritableDatabase ();
        RecyclerView recyclerView = findViewById ( R.id.rec_1 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ,LinearLayoutManager.VERTICAL,false ) );
        mclassadaptor = new class_adaptor ( this, getAllItem () );

        recyclerView.setAdapter(mclassadaptor);

        FloatingActionButton fab = findViewById ( R.id.fab );
        fab.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder ( Classes.this );
                View view1 = getLayoutInflater ().inflate ( R.layout.custom_dialog_add_calss, null );

                final EditText New_kelas = (TextInputEditText) view1.findViewById ( R.id.name_class );
                TextView afzodn = (TextView) view1.findViewById ( R.id.btn_afzodn_new_class );
                final TextView cancel = (TextView) view1.findViewById ( R.id.btn_cancel_new_class );



                afzodn.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {

                        if (New_kelas.getText().toString().trim().length()==0 ) {


                        } else {
                            Toast.makeText ( Classes.this, "نام کلاس را وارد کنید", Toast.LENGTH_SHORT ).show ();
                            String name=New_kelas.getText().toString();
                            ContentValues cv=new ContentValues();
                            cv.put(Database.COLUMN_NAME,name);

                            sqLiteDatabase.insert(Database.TABLE_NAME,null,cv);

                            mclassadaptor.swapcursor(getAllItem());

                            New_kelas.getText().clear();
                        }


                    }
                } );

                cancel.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent ( getApplicationContext (), Classes.class );
                        startActivity ( intent );
                        finish ();
                    }
                } );

                builder.setView ( view1 );
                AlertDialog dialog = builder.create ();
                dialog.show ();

            }
        } );
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager ( layoutManager );

    }

    private Cursor getAllItem(){
        return sqLiteDatabase.query(
                Database.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                Database.COLUMN_TIMESTAMP+" DESC"

        );
}

}