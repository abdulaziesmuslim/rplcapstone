package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class ScreenUserAyam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_user_ayam);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.password:
                Intent changepassword = new Intent(ScreenUserAyam.this, Password.class);
                startActivity(changepassword);
                break;
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent (this, loginscreen.class));
                finish();
                break;
        }
        return true;
    }

    //imageButton To Do List
    public void todolistAyam(View view) {
        Intent todo = new Intent(ScreenUserAyam.this, TodoListEmployeeAyam.class);
        startActivity(todo);
    }

    public void reportingAyam(View view) {
        Intent ReportingLayout = new Intent(ScreenUserAyam.this, ReportingLayout.class);
        startActivity(ReportingLayout);
    }

    public void hasilternak(View view) {
        Intent hasilternak = new Intent(ScreenUserAyam.this, HasilTernak.class);
        startActivity(hasilternak);
    }
}