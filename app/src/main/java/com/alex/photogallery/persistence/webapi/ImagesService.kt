package com.alex.photogallery.persistence.webapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ImagesService {

    @GET("gallery.json")
    fun getImages(): Call<ImagesServiceResponse>
}