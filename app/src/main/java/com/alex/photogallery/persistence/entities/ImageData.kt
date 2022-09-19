package com.alex.photogallery.persistence.entities

import com.google.gson.annotations.SerializedName

class ImageData {
    var imageId: Int = 0

    var imageResId:Int=0
    var imageUrl = ""
    var imageName = ""


    //var hasUserLike = false

    /*
    constructor(imageId: Int, imageResId: Int, imageName: String) {
        this.imageId = imageId
        this.imageResId = imageResId
        this.imageName = imageName
    }*/

}
