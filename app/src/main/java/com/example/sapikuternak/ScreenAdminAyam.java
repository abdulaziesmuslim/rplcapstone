package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ScreenAdminAyam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_admin);
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
                Intent changepassword = new Intent(ScreenAdminAyam.this, Password.class);
                startActivity(changepassword);
                break;
        }
        return true;

    }

    //imageButton To Do List
    public void todolistAyam(View view) {
        Intent todo = new Intent(ScreenAdminAyam.this, TodoListAdminAyam.class);
        startActivity(todo);
    }

    public void reportingAyam(View view) {
        Intent ReportingLayout = new Intent(ScreenAdminAyam.this, ReportAdmin.class);
        startActivity(ReportingLayout);
    }
}
