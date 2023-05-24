package com.example.kotlinflowdemo.utils

import com.example.kotlinflowdemo.network.ApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConfig {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // create retrofit service
    fun ApiService(): ApiService =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)
}