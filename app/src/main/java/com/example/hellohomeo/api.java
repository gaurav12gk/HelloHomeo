package com.example.hellohomeo;

import com.example.hellohomeo.Modal.Modal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {
    @GET("crew")
    Call<List<Modal>> getmodel();
}
