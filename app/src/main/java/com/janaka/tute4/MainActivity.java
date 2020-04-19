package com.janaka.tute4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText Password;
    private Button SelectAll;
    private Button Add;
    private Button SignIn;
    private Button Delete;
    private Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        UserName = (EditText) findViewById(R.id.userName);
        Password = (EditText) findViewById(R.id.password);
        SelectAll = (Button) findViewById(R.id.selectButton);
        Add = (Button) findViewById(R.id.addBtn);
        SignIn = (Button) findViewById(R.id.SignInBtn);
        Delete = (Button) findViewById(R.id.DeleteBtn);
        Update = (Button) findViewById(R.id.UpdateBtn);



        Add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                addInfo(UserName.getText().toString(), Password.getText().toString());
            }
        } );



        SelectAll.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


        SignIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


        Delete.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );


        Update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
    }
}
