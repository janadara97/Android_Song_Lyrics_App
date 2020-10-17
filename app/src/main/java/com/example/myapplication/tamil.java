package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import com.example.myapplication.Adapter.searchAdapter;
import com.example.myapplication.Model.Song;
import com.example.myapplication.database.Database;
import com.example.myapplication.database.Database2;
import com.example.myapplication.database.Database4;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class tamil extends AppCompatActivity implements searchAdapter.OnNoteListener  {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    searchAdapter adapter;
    Database4 database;
    MaterialSearchBar materialSearchBar;
    List<String> suggestList=new ArrayList<>();
    List<Song> song=new ArrayList<>();
    List<String> songg=new ArrayList<>();
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinhala);




        recyclerView=(RecyclerView)findViewById(R.id.recycler_search);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        materialSearchBar =(MaterialSearchBar)findViewById(R.id.search_bar);

        searchAdapter adapter1=new searchAdapter(this,song,this);
        recyclerView.setAdapter(adapter1);


        database=new Database4(this);
        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestList();
        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List <String> suggest =new ArrayList<>();
                for (String search:suggestList)
                {
                    if (search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))

                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled) {
                    adapter=new searchAdapter(getBaseContext(),database.getSongs());
                    recyclerView.setAdapter(adapter);
                    getaaa();
                }
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {

                startSearch(text.toString());
            }

            @Override
            public void onButtonClicked(int buttonCode) {

                //  recyclerView.setAdapter(adapter);
            }
        });

//default set all result
        getaaa();



    }






    private void getaaa(){

        adapter=new searchAdapter(this,database.getSongs(),this);
        recyclerView.setAdapter(adapter);

    }

    private void getaa(){

        adapter=new searchAdapter(this,database.getSongs(),this);
        recyclerView.setAdapter(adapter);

    }



    private void startSearch(String text) {
        adapter=new searchAdapter(this,database.getSongByName(text),this);
        recyclerView.setAdapter(adapter);

    }

    private void loadSuggestList() {

        suggestList=database.getNames();
        materialSearchBar.setLastSuggestions(suggestList);
    }

    @Override
    public void onNoteClick(int position) {

        song.addAll(database.getSongs());




        String title=song.get(position).getName();
        String artist=song.get(position).getArtist();
        String content=song.get(position).getContent();


        Log.d(TAG, "song_clicked: position "+position);
        Intent intent=new Intent(tamil.this,content.class);

        intent.putExtra("SongName",title);
        intent.putExtra("SongArtist",artist);
        intent.putExtra("SongContent",content);
        startActivity(intent);









    }

}
