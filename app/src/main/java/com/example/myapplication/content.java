package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.Model.Song;
import com.example.myapplication.database.Database;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class content extends AppCompatActivity {

    // ui
    private TextView contentName,contentArtist,contentcontent;

    //var

    private String sName,sArtist,sContent;




    private Database database;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        contentName=findViewById(R.id.Cname);
        contentArtist=findViewById(R.id.Cartist);
        contentcontent=findViewById(R.id.Ccontent);

        database=new Database(this);





        if (getIntent().hasExtra("SongName") && getIntent().hasExtra("SongArtist")
                && getIntent().hasExtra("SongContent")){

            sName=getIntent().getStringExtra("SongName");
            sArtist=getIntent().getStringExtra("SongArtist");
            sContent=getIntent().getStringExtra("SongContent");

            loadData();


        }else {
            Toast.makeText(this, "Sorry there is problem in loading the data", Toast.LENGTH_SHORT).show();
        }




    }

    private void loadData() {


        contentName.setText(sName);
        contentArtist.setText(sArtist);
        contentcontent.setText(sContent);

    }


}
