package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.newsapp.retrofit.APIUtils;
import com.example.newsapp.retrofit.NewsInterface;
import com.example.newsapp.source.Article;
import com.example.newsapp.source.Haberler;
import com.example.newsapp.source.Source;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    NewsInterface newsInterface;
    CardView cardViewSpor,cardViewHealty,cardViewTec,cardViewMagazine;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initilaize();
        newsInterface = APIUtils.getNewsInterface();

        cardViewSpor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewsListActivity.class);
                intent.putExtra("id","1");
                startActivity(intent);
            }
        });



        cardViewHealty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewsListActivity.class);
                intent.putExtra("id","2");
                startActivity(intent);
            }
        });

        cardViewMagazine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewsListActivity.class);
                intent.putExtra("id","3");
                startActivity(intent);
            }
        });

        cardViewTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewsListActivity.class);
                intent.putExtra("id","4");
                startActivity(intent);
            }
        });


    }

    private void initilaize() {
        cardViewSpor = findViewById(R.id.cardViewSpor);
        cardViewHealty = findViewById(R.id.cardViewHealty);
        cardViewMagazine = findViewById(R.id.cardViewMagazine);
        cardViewTec = findViewById(R.id.cardViewTec);
    }


}