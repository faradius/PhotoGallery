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
import com.alex.photogallery.persistence.sqllite.SqlLiteDatabaseManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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
                        GlobalScope.launch(Dispatchers.IO) {
                            for (i in 0 until responseImages.images.size) {
                                var dbManager =
                                    SqlLiteDatabaseManager.getDatabase(galleryPresenter.getContext())
                                var favoriteImage = dbManager.getFavoriteImageDAO()
                                    .getFavoriteImage(responseImages.images[i].imageId)
                                if (favoriteImage != null) {
                                    responseImages.images[i].hasUserLike = true
                                }

                            }
                            withContext(Dispatchers.Main){
                                galleryPresenter.onServerResponse(responseImages.images as ArrayList<ImageData>)
                            }

                        }
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