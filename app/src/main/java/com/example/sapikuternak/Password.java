package com.example.sapikuternak;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Password extends AppCompatActivity {

    EditText changePassword;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        changePassword = (EditText)findViewById(R.id.changePassword);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    public void changePassword() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            dialog.setMessage("Merubah Password");
            dialog.show();
            user.updatePassword(changePassword.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(),
                                        "Password telah diubah",
                                        Toast.LENGTH_SHORT)
                                        .show();
                                finish();
                                auth.signOut();
                                Intent start = new Intent(Password.this,
                                        loginscreen.class);
                                startActivity(start);
                            }
                            else {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(),
                                        "Password tidak diubah",
                                        Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    });
        }
    }
}
