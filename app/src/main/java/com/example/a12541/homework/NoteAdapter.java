package com.example.a12541.homework;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 12541 on 2019/1/9.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{

    private List<Note> mNote;
    Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView noteContent;
        View noteView;

        public ViewHolder(View view){
            super(view);
            noteView = view;
            noteContent = (TextView)view.findViewById(R.id.receiver_note_content);

        }
    }

    public NoteAdapter(List<Note> note){
        mNote = note;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if(mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.noteView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Note note = mNote.get(position);
                Intent intent = new Intent(mContext, MissionActivity.class);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Note note = mNote.get(position);
        holder.noteContent.setText(note.getName());
    }

    @Override
    public int getItemCount(){
        return mNote.size();
    }
}
