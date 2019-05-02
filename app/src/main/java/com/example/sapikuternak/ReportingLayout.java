package com.example.sapikuternak;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ReportingLayout extends AppCompatActivity {
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    ImageView gambar;
    private Button btSubmit;
    private EditText etReport1;
    private EditText etReport2;
    private EditText etReport3;
    private EditText etDeskripsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting_layout);
        gambar = findViewById(R.id.gambar);
        etReport1 = (EditText) findViewById(R.id.report1);
        etReport2 = (EditText) findViewById(R.id.report2);
        etReport3 = (EditText) findViewById(R.id.report3);
        etDeskripsi = (EditText) findViewById(R.id.description);
        btSubmit = (Button) findViewById(R.id.ononon);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(etReport1.getText().toString()) &&
                        !isEmpty(etReport2.getText().toString()) &&
                        !isEmpty(etReport3.getText().toString()) &&
                        !isEmpty(etDeskripsi.getText().toString())) {

                    submitReport(new Report(etReport1.getText().toString(),
                            etReport2.getText().toString(),
                            etReport3.getText().toString(),
                            etDeskripsi.getText().toString()));
                }
                else {
                    Toast.makeText(ReportingLayout.this,"Data tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                }
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(
                        etReport1.getWindowToken(), 0);
            }
        });

    }

    public void submit(View view) {
        Intent ScreenUser = new Intent(ReportingLayout.this, ScreenUser.class);
        startActivity(ScreenUser);

    }

    public void bukagambar(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 9001);
    }


    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                gambar.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(ReportingLayout.this, "Something went wrong",
                        Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(ReportingLayout.this, "You haven't picked Image",
                    Toast.LENGTH_LONG).show();
        }

    }

    private boolean isEmpty(String s) {
        return TextUtils.isEmpty(s);
    }

    private void updateBarang(Report report) {
        // kodingan untuk next tutorial ya :p
    }

    private void submitReport(Report report) {
//        database.child("report").push().setValue(report).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                etReport1.setText("");
//                etReport2.setText("");
//                etReport3.setText("");
//                etDeskripsi.setText("");
//                Toast.makeText(ReportingLayout.this,"Data berhasil ditambahkan", Toast.LENGTH_LONG).
//                        show();
//            }
//        });
    }




}
