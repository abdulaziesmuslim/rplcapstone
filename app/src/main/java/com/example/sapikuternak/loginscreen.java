package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class loginscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
    }

    public void signIn(View view) {
        Intent intent = new Intent(loginscreen.this, ScreenUser.class);
        startActivity(intent);
        finish();
    }
}
