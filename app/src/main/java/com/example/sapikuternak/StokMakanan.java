package com.example.sapikuternak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StokMakanan extends AppCompatActivity {

    EditText etPakan,etPakan2;
    Button button_save;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_ternak);

        etPakan = findViewById(R.id.editText);
        etPakan2 = findViewById(R.id.editText2);
        button_save = findViewById(R.id.button);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> pakan = new HashMap<>();
                pakan.put("jumlah", etPakan.getText().toString());


                    db.collection("HasilTernak").add(pakan)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Intent intent = new Intent(StokMakanan.this, ScreenUser.class);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
}
