package com.example.hozoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Situation extends AppCompatActivity {

    ImageView student , situation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_situation );

        student=(ImageView) findViewById ( R.id.image_student );
        situation=(ImageView) findViewById ( R.id.image_situation);

        student.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {



            }
        } );

        situation.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent ( getApplicationContext () , in_class.class );
                startActivity ( intent );

            }
        } );

      }
    }

