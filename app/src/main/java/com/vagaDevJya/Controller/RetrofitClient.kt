package com.vagaDevJya.Controller

import android.widget.Toast
import com.vagaDevJya.Models.Example
import com.vagaDevJya.Util.ListExample
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RetrofitClient{

    private const val BASE_URL = "https://api.github.com/repos/JetBrains/kotlin/"

    val instace: EndPoints by lazy {
        val retrofitClient = RetrofitConfig.getRetrofitInstance(BASE_URL)
        retrofitClient.create(EndPoints::class.java)
    }
}