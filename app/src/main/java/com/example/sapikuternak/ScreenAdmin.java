package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ScreenAdmin extends AppCompatActivity {
    TextView  position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin);
        position = findViewById(R.id.position);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


        if (firebaseAuth.getCurrentUser().getEmail().equals("adminsapikuternak@gmail.com")) {

            position.setText("ADMIN");
        }
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
                Intent changepassword = new Intent(ScreenAdmin.this, Password.class);
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
    public void todolist(View view) {
        Intent todo = new Intent(ScreenAdmin.this, TodoListAdmin.class);
        startActivity(todo);
    }

    public void reporting(View view) {
        Intent ReportingLayout = new Intent(ScreenAdmin.this, ReportAdmin.class);
        startActivity(ReportingLayout);
    }
}
