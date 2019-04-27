package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class pilihhewanuser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihhewanuser);
    }

    public void pilihSapi(View view) {
        Intent sapi = new Intent(pilihhewanuser.this, ScreenUser.class);
        startActivity(sapi);
    }

    public void pilihAyam(View view) {
        Intent ayam = new Intent(pilihhewanuser.this, ScreenUser.class);
        startActivity(ayam);
    }
}
