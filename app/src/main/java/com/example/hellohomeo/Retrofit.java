package com.example.hellohomeo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    private static String url = "https://api.spacexdata.com/v4/";
    static Gson gson = new GsonBuilder().setLenient().create();
    public static retrofit2.Retrofit retro;

    public static retrofit2.Retrofit getRetro() {
        if (retro == null) {
            retro = new retrofit2.Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create(gson)).build();

        }
        return  retro;
    }
}
