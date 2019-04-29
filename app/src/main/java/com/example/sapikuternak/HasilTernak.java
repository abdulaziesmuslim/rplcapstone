package com.example.sapikuternak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class HasilTernak extends AppCompatActivity {

    Spinner spinner_hewan, spinner_hasilternak;
    EditText text_keterangan;
    Button button_save;
    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_ternak);

        spinner_hewan = findViewById(R.id.listternak);
        spinner_hasilternak = findViewById(R.id.listhasilternak);
        text_keterangan = findViewById(R.id.textketerangan);
        button_save = findViewById(R.id.buttonsave);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

                Map<String, Object> keterangan = new HashMap<>();
                keterangan.put("hewan", spinner_hewan.getSelectedItem());
                keterangan.put("hasil", spinner_hasilternak.getSelectedItem());
                keterangan.put("keterangan", text_keterangan.getText().toString());
                keterangan.put("tanggal", String.valueOf(df.format(c)));

                db.collection("HasilTernak").add(keterangan)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Intent intent = new Intent(HasilTernak.this, ScreenUser.class);
                                startActivity(intent);
                            }
                        });
            }
        });
    }
    //code here
}
