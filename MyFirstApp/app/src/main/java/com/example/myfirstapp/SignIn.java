package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }

    @Override
    protected void onResume() {
        super.onResume();
        findViewById(R.id.buttonLogin).setOnClickListener(this);
        findViewById(R.id.buttonLogin2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonLogin:
                Log.d("debug", "inside login button ");
                EditText userName = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                /*
                    we should get the data from json

                    try {
                    InputStream is = new FileInputStream("user_details.json");
                    String jsonTxt =
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                 */
                Log.d("debug", userName.getText().toString());
                Log.d("debug", password.getText().toString());
                if (userName.getText().toString().equals("test") && password.getText().toString().equals("test")){
                    Bundle bundle = new Bundle();
                    bundle.putString("SuccessLoggedInUser", "test");
                    Intent intent = new Intent(SignIn.this, PostLoginPage.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid Credentials supplied, taking you to Sign Up Page";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    // If user supplied invalid credentials, navigate to sign up page.
                    Intent intent = new Intent(SignIn.this, SignUp.class);
                    startActivity(intent);

                }
            case R.id.buttonLogin2:
                    Log.d("debug", "inside sign up button ");
                    startActivity(new Intent(SignIn.this, SignUp.class));
    }
}


}