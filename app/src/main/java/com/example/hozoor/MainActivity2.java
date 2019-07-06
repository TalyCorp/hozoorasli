package com.example.hozoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {
    TextView txt_information;
    TextInputLayout textinput_layout1, textinput_layout2, textinput_layout3;
    TextInputEditText text_input_Edittext1, textInputEditText2, textInputEditText3;
    Button btn_next;
    String preferneces_Name = "isFirstTime";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_information =(TextView) findViewById(R.id.txt_information);
        textinput_layout1 =(TextInputLayout) findViewById(R.id.textinput_layout1);
        textinput_layout2 =(TextInputLayout) findViewById(R.id.textinput_layout2);
        textinput_layout3 =(TextInputLayout)  findViewById(R.id.textinput_layout3);
        text_input_Edittext1 =(TextInputEditText) findViewById(R.id.text_input_Edittext1);
        textInputEditText2 =(TextInputEditText) findViewById(R.id.text_input_Edittext2);
        textInputEditText3 =(TextInputEditText) findViewById(R.id.text_input_Edittext3);
        btn_next = (Button) findViewById(R.id.btn_next);

btn_next.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        OpenHome();
    }
});

            FirstTime ();

    }

    public void FirstTime()
    {
        SharedPreferences sharedPreferences = getSharedPreferences ( preferneces_Name ,0 );
        if (sharedPreferences.getBoolean ( "First_Time" ,true ))
        {

            btn_next.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent ( getApplicationContext () , MainActivity.class );
                    startActivity ( intent );
                    finish ();

                }
            } );

            sharedPreferences.edit ().putBoolean ( "First_Time" ,false ).apply ();
        }
        else {
            Intent intent = new Intent ( getApplicationContext () , MainActivity.class );
            startActivity ( intent );
            finish ();
        }
    }

    public void OpenHome(){

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

}