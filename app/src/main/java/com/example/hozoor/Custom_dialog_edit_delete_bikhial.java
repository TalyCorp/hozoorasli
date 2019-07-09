package com.example.hozoor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Custom_dialog_edit_delete_bikhial extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.custom_dialog_edit_delete_bikhial );

        final AlertDialog.Builder  builder=new AlertDialog.Builder ( Custom_dialog_edit_delete_bikhial.this);
        View view1 = getLayoutInflater ().inflate ( R.layout.custom_dialog_edit_delete_bikhial, null );

        final TextView edit = (TextView)view1.findViewById ( R.id.btn_edit );
        TextView bikhial = (TextView)view1.findViewById ( R.id.btn_ok);
        TextView delete = (TextView)view1.findViewById ( R.id.btn_delete );

        edit.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent ( getApplicationContext () ,EditPage.class);
                startActivity ( intent );
                finish();
            }
        } );

        bikhial.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent ( getApplicationContext (),MainActivity.class );
                startActivity ( intent );
                finish ();

            }
        } );

        delete.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {



            }
        } );

        builder.setView ( view1 );
        AlertDialog dialog = builder.create ();
        dialog.show ();



    }
    }

