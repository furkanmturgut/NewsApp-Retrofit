package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    TextView text_news;
    ImageView image_news;
    String content,image,url;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        text_news  =findViewById(R.id.text_news);
        image_news = findViewById(R.id.image_detail);
        webView = findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        content = bundle.getString("content");
        image = bundle.getString("image");
        url = bundle.getString("url");


        Log.e("Content",content);
        Log.e("image",image);

        text_news.setText(content);
        Glide.with(this)
                .load(image.toString())
                .into(image_news);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

    }
}