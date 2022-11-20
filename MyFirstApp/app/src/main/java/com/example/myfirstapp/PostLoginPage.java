package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PostLoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login_page);

        Bundle bundle = getIntent().getExtras();
        String whoLoggedIn = bundle.getString("SuccessLoggedInUser");

        TextView LoginMsg = (TextView) findViewById(R.id.textView3);

        LoginMsg.setText( whoLoggedIn + ": User was successfully logged in ");

    }
}