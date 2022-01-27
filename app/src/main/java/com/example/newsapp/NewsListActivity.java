package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.newsapp.retrofit.APIUtils;
import com.example.newsapp.retrofit.NewsInterface;
import com.example.newsapp.source.Article;
import com.example.newsapp.source.Haberler;
import com.example.newsapp.source.MagazinHaberler;
import com.example.newsapp.source.SaglikHaberleri;
import com.example.newsapp.source.TeknolojiHaberler;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {
    Integer myId;
    String id;
    NewsInterface newsInterface;
    ArrayList<String> imageList;
    ArrayList<String> authorList;
    ArrayList<String> titleList;
    ArrayList<String> contentList;
    ArrayList<String> webUrlList;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        newsInterface = APIUtils.getNewsInterface();
        imageList = new ArrayList<>();
        authorList = new ArrayList<>();
        titleList = new ArrayList<>();
        contentList = new ArrayList<>();
        webUrlList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(imageList, titleList, authorList,contentList ,webUrlList,getApplication());
        recyclerView.setAdapter(recyclerViewAdapter);


        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        myId = Integer.parseInt(id);

        if (myId == 1) {
            newsInterface.tumHaberler().enqueue(new Callback<Haberler>() {
                @Override
                public void onResponse(Call<Haberler> call, Response<Haberler> response) {
                    List<Article> sporList = response.body().getArticles();

                    for (Article sL : sporList) {
                        titleList.add(sL.getTitle());
                        imageList.add(sL.getUrlToImage());
                        authorList.add(sL.getAuthor());
                        contentList.add(sL.getDescription());
                        webUrlList.add(sL.getUrl());
                    }

                    recyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<Haberler> call, Throwable t) {

                }
            });

            /*
        }else if(myId == 2){
            newsInterface.saglikHaberler().enqueue(new Callback<SaglikHaberleri>() {
                @Override
                public void onResponse(Call<SaglikHaberleri> call, Response<SaglikHaberleri> response) {
                    List<Article> healtyList = response.body().getArticles();

                    for(Article hL:healtyList) {
                        titleList.add(hL.getTitle());
                        imageList.add(hL.getUrlToImage());
                        authorList.add(hL.getAuthor());
                    }

                    recyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<SaglikHaberleri> call, Throwable t) {

                }
            });

        }else if(myId == 3){
            newsInterface.magazinHaberler().enqueue(new Callback<MagazinHaberler>() {
                @Override
                public void onResponse(Call<MagazinHaberler> call, Response<MagazinHaberler> response) {
                    List<Article> magazineList = response.body().getArticles();

                    for (Article mL: magazineList){
                        titleList.add(mL.getTitle());
                        imageList.add(mL.getUrlToImage());
                        authorList.add(mL.getAuthor());
                    }

                    recyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<MagazinHaberler> call, Throwable t) {

                }
            });
        }else if(myId == 4){
            newsInterface.teknolojiHaberler().enqueue(new Callback<TeknolojiHaberler>() {
                @Override
                public void onResponse(Call<TeknolojiHaberler> call, Response<TeknolojiHaberler> response) {
                    List<Article> technologyList = response.body().getArticles();

                    for (Article tL: technologyList){
                        titleList.add(tL.getTitle());
                        imageList.add(tL.getUrlToImage());
                        authorList.add(tL.getAuthor());
                    }

                    recyclerViewAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<TeknolojiHaberler> call, Throwable t) {

                }
            });
        }

             */
        }


    }
}
