package com.alex.photogallery.persistence.webapi

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceBuilder {
    private var apiUrl = "https://gallery-a1027-default-rtdb.firebaseio.com/"

    private val okHttp = OkHttpClient.Builder()

    var gson = GsonBuilder()
        .create()

    private val builder = Retrofit.Builder().baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(serviceType:Class<T>):T{
        return retrofit.create(serviceType)
    }
}