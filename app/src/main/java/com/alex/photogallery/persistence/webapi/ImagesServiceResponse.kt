package com.alex.photogallery.persistence.webapi

import com.alex.photogallery.persistence.entities.ImageData

class ImagesServiceResponse {
    var description:String = ""
    var images = mutableListOf<ImageData>()
}