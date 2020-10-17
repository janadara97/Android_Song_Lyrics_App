package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.view.View;

import com.example.myapplication.Adapter.searchAdapter;

import com.example.myapplication.database.Database;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

       RecyclerView recyclerView;
       RecyclerView.LayoutManager layoutManager;
       searchAdapter adapter;
       Database database;
       MaterialSearchBar materialSearchBar;
       List<String> suggestList=new ArrayList<>();


    ImageView sinhalaB;
    ImageView englishB;
    ImageView hindiB;
    ImageView tamilB;
    ImageView bgapp, clover;
    LinearLayout textLyrics, textHome, menus;
    Animation frombottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        bgapp = (ImageView) findViewById(R.id.bgapp);
        clover = (ImageView) findViewById(R.id.clover);
        textLyrics = (LinearLayout) findViewById(R.id.textLyrics);
        textHome = (LinearLayout) findViewById(R.id.textHome);
        menus = (LinearLayout) findViewById(R.id.menus);


        textHome.startAnimation(frombottom);
        menus.startAnimation(frombottom);


        bgapp.animate().translationY(-2000).setDuration(1000).setStartDelay(1800);
        clover.animate().alpha(0).setDuration(1000).setStartDelay(800);
        textLyrics.animate().translationY(140).alpha(0).setDuration(1000).setStartDelay(800);


        sinhalaB = (ImageView) findViewById(R.id.sinhalaB);
        sinhalaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });

        sinhalaB = (ImageView) findViewById(R.id.englishB);
        sinhalaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        sinhalaB = (ImageView) findViewById(R.id.hindiB);
        sinhalaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        sinhalaB = (ImageView) findViewById(R.id.tamilB);
        sinhalaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });






    }




  /*  public void changeFragment(View view) {

        Fragment fragment;
        if (view == findViewById(R.id.sinhalaB)) {

            fragment = new sinhala();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.sinhalaf, fragment);
            ft.commit();
        }

        if (view == findViewById(R.id.englishB)) {

            fragment = new english();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.englishf, fragment);
            ft.commit();

        }

        if (view == findViewById(R.id.hindiB)) {

            fragment = new hindi();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.hindif, fragment);
            ft.commit();
        }

        if (view == findViewById(R.id.tamilB)) {

            fragment = new tamil();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.tamilf, fragment);
            ft.commit();
        }


    }


*/

        public void openActivity1 () {
            Intent intent = new Intent(this, sinhala.class);
            startActivity(intent);


        }
        public void openActivity2 () {
            Intent intent = new Intent(this, english.class);
            startActivity(intent);


        }
        public void openActivity3 () {
            Intent intent = new Intent(this, hindi.class);
            startActivity(intent);


        }
        public void openActivity4 () {
            Intent intent = new Intent(this, tamil.class);
            startActivity(intent);


        }
    }
