package com.example.hozoor;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Classes extends AppCompatActivity {

    TextView add;
    Database database;
    private SQLiteDatabase mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                        AlertDialog.Builder  builder=new AlertDialog.Builder ( Classes.this);
                        View view1 = getLayoutInflater ().inflate ( R.layout.custom_dialog_add_calss, null );

                final EditText New_kelas=(TextInputEditText) view1.findViewById( R.id.name_class);
                TextView afzodn = (TextView)view1.findViewById ( R.id.btn_afzodn_new_class );
                final TextView cancel = (TextView)view1.findViewById ( R.id.btn_cancel_new_class );

                afzodn.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {

                        if (!New_kelas.getText ().toString ().isEmpty ())
                        {
                            ContentValues cv =new ContentValues (  );
                            cv.put ( "Class" , String.valueOf ( New_kelas ) );
                           mdatabase.insert ( "school" ,null , cv ) ;

                        }
                        else
                        {
                            Toast.makeText ( Classes.this, "نام کلاس را وارد کنید", Toast.LENGTH_SHORT ).show ();
                        }
                    }
                } );

                cancel.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent ( getApplicationContext () ,Classes.class );
                        startActivity ( intent );
                        finish ();
                    }
                } );

                builder.setView ( view1 );
                AlertDialog dialog = builder.create ();
                dialog.show ();

            }
        });
    }

}
