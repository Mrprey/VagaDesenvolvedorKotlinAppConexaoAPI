package com.vagaDevJya.Controller

import android.bluetooth.le.AdvertisingSetParameters
import com.vagaDevJya.Models.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface EndPoints {
    @GET("issues")
    fun getProfile(): Call<List<Example>>
}