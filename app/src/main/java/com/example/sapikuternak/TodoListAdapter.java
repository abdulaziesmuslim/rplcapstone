package com.example.sapikuternak;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.WordViewHolder> {

    private ArrayList<TodoList> toDoArrayList;
    private Context mContext;

    TodoListAdapter(Context context, ArrayList<TodoList> todoLists){
        this.mContext = context;
        this.toDoArrayList = todoLists;
    }

    @NonNull
    @Override
    public TodoListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WordViewHolder(LayoutInflater.from(mContext).inflate(R.layout.cardview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListAdapter.WordViewHolder wordViewHolder, int i) {
        TodoList todoList = toDoArrayList.get(i);
//        WordViewHolder.bindTo(todoList);
        wordViewHolder.bindTo(todoList);

    }

    @Override
    public int getItemCount() {
        return toDoArrayList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        void bindTo(TodoList todoList){
            textView.setText(todoList.getTodo());
        }
    }

    /*private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final EditText wordItemView;
//        final TodoListAdapter mAdapter;

        public WordViewHolder(View itemView, TodoListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
//            this.mAdapter = adapter;

        }

    }

    public TodoListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @Override
    public TodoListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.cardview, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(TodoListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {

        return mWordList.size();
    }*/
}