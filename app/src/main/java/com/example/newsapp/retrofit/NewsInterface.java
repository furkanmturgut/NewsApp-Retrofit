package com.example.newsapp.retrofit;

import com.example.newsapp.source.Haberler;
import com.example.newsapp.source.MagazinHaberler;
import com.example.newsapp.source.SaglikHaberleri;
import com.example.newsapp.source.TeknolojiHaberler;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsInterface {
    @GET("v2/top-headlines?country=tr&category=sports&apiKey=31c95fa0a11f43b08661e86acf475bb1")
    Call<Haberler> tumHaberler();

    @GET("v2/top-headlines?country=tr&category=health&apiKey=31c95fa0a11f43b08661e86acf475bb1")
    Call<SaglikHaberleri> saglikHaberler();

    @GET("v2/top-headlines?country=tr&category=entertainment&apiKey=31c95fa0a11f43b08661e86acf475bb1")
    Call<MagazinHaberler> magazinHaberler();

    @GET("v2/top-headlines?country=tr&category=technology&apiKey=31c95fa0a11f43b08661e86acf475bb1")
    Call<TeknolojiHaberler> teknolojiHaberler();
}
