package com.alex.photogallery.model.main.fragments.gallery

import android.util.Log
import com.alex.photogallery.persistence.entities.ImageData
import com.alex.photogallery.persistence.webapi.ImagesService
import com.alex.photogallery.persistence.webapi.ImagesServiceResponse
import com.alex.photogallery.persistence.webapi.ServiceBuilder
import com.alex.photogallery.presenter.main.fragments.gallery.GalleryPresenter
import retrofit2.Call
import retrofit2.Response
import android.os.Handler
import com.alex.photogallery.R


class GalleryModelImpl(private var galleryPresenter: GalleryPresenter):GalleryModel {
    override fun getImagesFromServer() {

        val webApi = ServiceBuilder.buildService(ImagesService::class.java)

        val requestCall = webApi.getImages()

        requestCall.enqueue(object: retrofit2.Callback<ImagesServiceResponse>{
            override fun onResponse(
                call: Call<ImagesServiceResponse>,
                httpResponse: Response<ImagesServiceResponse>
            ) {
                var responseImages=httpResponse.body()

                if (responseImages!=null){
                    galleryPresenter.onServerResponse(responseImages.images as ArrayList<ImageData>)
                }

            }

            override fun onFailure(call: Call<ImagesServiceResponse>, t: Throwable) {

            }

        })



        /*Handler().postDelayed({
            val images = mutableListOf<ImageData>()
            images.add(ImageData(0, R.drawable.image_1, "Katy"))
            images.add(ImageData(1, R.drawable.image_2, "Gio"))
            images.add(ImageData(2, R.drawable.image_1,"Hello"))

            galleryPresenter.onServerResponse(images as ArrayList<ImageData>)
        },2000)*/
    }
}