package com.example.sapikuternak;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.LinkedList;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder {
        public final EditText wordItemView;
        final TodoListAdapter mAdapter;

        public WordViewHolder(View itemView, TodoListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.job_item);
            this.mAdapter = adapter;

        }

    }

    public TodoListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @Override
    public TodoListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_todo_list, parent, false);
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
    }
}