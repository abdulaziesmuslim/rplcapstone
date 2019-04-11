package com.example.sapikuternak;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginscreen extends AppCompatActivity {
    private static final String TAG = "EmailPassword";
    private EditText mUsername;
    private EditText mPassword;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_loginscreen);

        mUsername = findViewById(R.id.plain_username);
        mPassword = findViewById(R.id.plain_password);


        mAuth = FirebaseAuth.getInstance();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user != null) {
                    Intent move = new Intent(loginscreen.this, ScreenUser.class);
                    move.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(move);
                    finish();
                }
            }
        };


    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(listener);


    }

    public void signIn(View view) {
//        signIn(mUsername.getText().toString(),mPassword.getText().toString());

        if (mUsername.getText().toString().equals("adminsapikuternak@gmail.com") &&
        mPassword.getText().toString().equals("123456")){
            Intent admin = new Intent(loginscreen.this, ScreenAdmin.class);
            startActivity(admin);
        }
        else{
            Intent user = new Intent(loginscreen.this, ScreenUser.class);
            startActivity(user);
        }

    }

    private void signIn(String email, String password) {

        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            Intent aa = new Intent(loginscreen.this,MainActivity.class);
                            startActivity(aa);
                            FirebaseUser user = mAuth.getCurrentUser();

//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(loginscreen.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            Toast.makeText(loginscreen.this,"Gagal",Toast.LENGTH_SHORT).show();
                        }
                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }

    private void hideProgressDialog() {
    }

    private void showProgressDialog() {
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = mUsername.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mUsername.setError("Required.");
            valid = false;
        } else {
            mUsername.setError(null);
        }

        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Required.");
            valid = false;
        } else {
            mPassword.setError(null);
        }

        return valid;
    }


}