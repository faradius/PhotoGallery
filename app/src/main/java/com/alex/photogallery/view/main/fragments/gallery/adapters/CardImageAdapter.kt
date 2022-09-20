package com.alex.photogallery.view.main.fragments.gallery.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.alex.photogallery.R
import com.alex.photogallery.databinding.ItemCardImageBinding
import com.alex.photogallery.persistence.entities.FavoriteImageData
import com.alex.photogallery.persistence.entities.ImageData
import com.alex.photogallery.persistence.sqllite.FavoriteImagesDbManager
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
                var status = data.hasUserLike

                if (status){
                    binding.likeButton.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark))

                }else{
                    binding.likeButton.setColorFilter(ContextCompat.getColor(context, R.color.grey_40))

                }

                binding.shareButton.setOnClickListener {
                    var intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, "${data.imageUrl} Puedes encontrar mas fotos como estas en esta aplicación...")
                    intent.type = "text/plain"
                    try {
                        context.startActivity(Intent.createChooser(intent,"Compartir con "))
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }


                binding.likeButton.setOnClickListener {
                    FavoriteImagesDbManager.saveFavoriteImage(context, FavoriteImageData(data)){
                        Log.d("TAG", "Base de datos terminado")
                        if (!status){
                            binding.likeButton.setColorFilter(ContextCompat.getColor(context, R.color.colorPrimaryDark))
                            status = true
                        }else{
                            binding.likeButton.setColorFilter(ContextCompat.getColor(context, R.color.grey_40))
                            status = false
                        }
                    }
                }

                Glide.with(context).load(data.imageUrl).into(binding.imageHolderView)
        }
    }
}