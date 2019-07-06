package com.example.hozoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Aboutus extends AppCompatActivity {

    TextView gmail;
    String[] name={"talycorp@gmail.com"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        gmail=(TextView) findViewById ( R.id.about_us_gmail );

        gmail.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse ( "talycorp@gmail.com" );

                Intent intent = new Intent ( Intent.ACTION_SEND );
                intent.putExtra ( Intent.EXTRA_EMAIL ,name );
                intent.setType ( "plain/text" );
                startActivity ( Intent.createChooser ( intent, "بفرس" ));


            }
        } );
    }
}
