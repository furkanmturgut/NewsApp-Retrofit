package com.example.newsapp.retrofit;

public class APIUtils {

    public static  String BaseURL = "https://newsapi.org/";

    public static NewsInterface getNewsInterface(){
        return RetrofitBuilder.getClient(BaseURL).create(NewsInterface.class);
    }

}
