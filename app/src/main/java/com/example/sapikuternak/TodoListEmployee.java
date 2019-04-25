package com.example.sapikuternak;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TodoListEmployee extends AppCompatActivity {

    DatabaseReference databaseTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_employee);

//        String aa = databaseTodoList.getKey();
//        final TextView task1 = findViewById(R.id.task1);
//        final TextView task2 = findViewById(R.id.task2);
//        final TextView task3 = findViewById(R.id.task3);
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Pekerjaan")
//                .child(aa);
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                task1.setText(dataSnapshot.getValue().toString());
//                task2.setText(dataSnapshot.getValue().toString());
//                task3.setText(dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }
}
