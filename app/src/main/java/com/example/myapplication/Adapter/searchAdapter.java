package com.example.myapplication.Adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.Song;
import com.example.myapplication.R;

import java.util.List;

import static android.content.ContentValues.TAG;


public class searchAdapter extends RecyclerView.Adapter<searchAdapter.ViewHolder> {


    private Context context;
    private List<Song> song;
    private OnNoteListener mOnNoteListener;

    public searchAdapter(Context context, List<Song> song, OnNoteListener onNoteListener) {

        this.context = context;
        this.song = song;
        this.mOnNoteListener=onNoteListener;

    }


    public searchAdapter(Context context, List<Song> song) {

        this.context = context;
        this.song = song;


    }
    public searchAdapter(OnNoteListener onNoteListener) {

        this.mOnNoteListener=onNoteListener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(itemview,mOnNoteListener);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(song.get(position).getName());
        holder.artist.setText(song.get(position).getArtist());
        holder.content.setText(song.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return song.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name, artist, content;
        OnNoteListener onNoteListener;


        public ViewHolder(View itemView,OnNoteListener onNoteListener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            artist = (TextView) itemView.findViewById(R.id.artist);
            content = (TextView) itemView.findViewById(R.id.content);
            this.onNoteListener=onNoteListener;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: " + getAdapterPosition());
        //    onNoteListener.onNoteClick(getAdapterPosition());

        }
    }

    public interface OnNoteListener {

        void onNoteClick(int position);
    }

}