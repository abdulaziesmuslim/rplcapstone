package com.example.sapikuternak;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sapikuternak.Pekerjaan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;

public class TodoListAdmin extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private TodoListAdapter mAdapter;

    EditText editTextJob;
    ArrayList<TodoList> list;


    DatabaseReference databaseTodoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_admin);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        databaseTodoList = FirebaseDatabase.getInstance().getReference();

        list = new ArrayList<>();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int wordListSize = mWordList.size();
//                mWordList.addLast("Tugas  " + wordListSize);
//                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
//                mRecyclerView.smoothScrollToPosition(wordListSize);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        TodoListAdmin.this);

                alertDialogBuilder.setTitle("Masukkan Pekerjaan");


                LayoutInflater li = getLayoutInflater();
                View promptsView = li.inflate(R.layout.dialog, null);
                alertDialogBuilder.setView(promptsView);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.inputJob);

                final Button asd = (Button) promptsView
                        .findViewById(R.id.submit);

                asd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String job = userInput.getText().toString();
                        TodoList jobs = new TodoList(job);

                        if(!TextUtils.isEmpty(job)){
                            String aa = databaseTodoList.push().getKey();

//            Job j = new Job(id, job);

                            databaseTodoList.child("Pekerjaan").child(aa).setValue(jobs);

                            Toast.makeText(getApplicationContext(), "Pekerjaan ditambahkan", Toast.LENGTH_SHORT).show();

//                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Silahkan isi pekerjaan", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                // set dialog message
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }
        });

//        for (int i=0; i <= 1 ; i++) {
//            mWordList.addLast(" Tugas " + i);
//        }

        initView();
        setGridLayout();

        //FIREBASE
        DatabaseReference db = FirebaseDatabase.getInstance().getReference("Pekerjaan");
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                list.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    String Pekerjaan = ds.child("todo").getValue().toString();
                    Log.d("mencoba",Pekerjaan);
                    TodoList todoList = new TodoList(Pekerjaan);
                    list.add(todoList);
                }

                mAdapter = new TodoListAdapter(TodoListAdmin.this,list);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        mRecyclerView = findViewById(R.id.recyclerview);
//        mAdapter = new TodoListAdapter(this, mWordList);
//        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseTodoList.child("Pekerjaan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                list.clear();
//                for (DataSnapshot data : dataSnapshot.getChildren()){
//                    Pekerjaan aa =  data.getValue(Pekerjaan.class);
//                    aa.key = data.getKey();
//                    list.add(aa);
//                    mAdapter.notifyDataSetChanged();
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        editTextJob = (EditText)findViewById(R.id.job_item);
//        buttonSubmit = (Button)findViewById(R.id.submit);
//
//        buttonSubmit.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                addJob();
//            }
//        });
    }
    private void addJob(){
        String job = editTextJob.getText().toString();

        if(!TextUtils.isEmpty(job)){
            String id = databaseTodoList.push().getKey();

//            Job j = new Job(id, job);

            databaseTodoList.child(id).setValue(job);

            Toast.makeText(this, "Pekerjaan ditambahkan", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "Silahkan isi pekerjaan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public void initView(){
        mRecyclerView = findViewById(R.id.recyclerview);
    }

    private  void setGridLayout(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
    }

}