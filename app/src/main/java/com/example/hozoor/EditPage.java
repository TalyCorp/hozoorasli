package com.example.hozoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditPage extends AppCompatActivity {

    Button beshe , nashe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_edit_page );

        beshe=(Button)findViewById ( R.id.beshe );
        nashe=(Button)findViewById ( R.id.nashe );


        nashe.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent ( getApplicationContext () , MainActivity.class  );
                startActivity ( intent );
                finish ();

            }
        } );

    }

}
