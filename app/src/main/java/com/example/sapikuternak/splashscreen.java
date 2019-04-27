package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashscreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread thread = new Thread() {
            public void run (){
                try {
                    sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(splashscreen.this, loginscreen.class);
                startActivity(intent);
                finish();
                }

            }
        }; thread.start();
    }
}
