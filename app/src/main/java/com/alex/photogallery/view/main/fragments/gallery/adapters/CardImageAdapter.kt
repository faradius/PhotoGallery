package com.alex.photogallery.view.main.fragments.gallery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alex.photogallery.R
import com.alex.photogallery.databinding.ItemCardImageBinding
import com.alex.photogallery.persistence.entities.ImageData
import com.bumptech.glide.Glide

class CardImageAdapter(val context: Context, val data:ArrayList<ImageData>):BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(index: Int): ImageData {
        return data[index]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(index: Int, container: View?, parent: ViewGroup?): View {
        var view=container
        var holder:DataViewHolder
        if (container == null){
            view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_card_image,parent,false)
            holder = DataViewHolder(view)
            view?.tag= holder

        }else{
            holder = view?.tag as DataViewHolder
        }
        holder.binData(context,getItem(index))

        return view!!
    }

    class DataViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = ItemCardImageBinding.bind(view)

        internal fun binData(context: Context,data: ImageData){
                binding.imageNameTextView.text = data.imageName
                Glide.with(context).load(data.imageUrl).into(binding.imageHolderView)
        }
    }
}