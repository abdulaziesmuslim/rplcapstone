package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pilihhewanadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihhewanadmin);
    }
    public void pilihSapi(View view) {
        Intent sapi = new Intent(pilihhewanadmin.this, ScreenAdmin.class);
        startActivity(sapi);
    }

    public void pilihAyam(View view) {
        Intent ayam = new Intent(pilihhewanadmin.this, ScreenAdmin.class);
        startActivity(ayam);
    }
}
