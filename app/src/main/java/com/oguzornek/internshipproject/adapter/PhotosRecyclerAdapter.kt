package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.util.gorselView
import com.oguzornek.internshipproject.util.makePlaceHolder
import com.oguzornek.internshipproject.databinding.UserPhotosRecyclerRowBinding
import com.oguzornek.internshipproject.model.Photos


class PhotosRecyclerAdapter( var photoList : List<Photos>) : RecyclerView.Adapter<PhotosRecyclerAdapter.PhotosVH>() {
    class PhotosVH(val view : UserPhotosRecyclerRowBinding) : RecyclerView.ViewHolder(view.root){

        fun bind(item : Photos){
            view.imageView.gorselView(item.url, makePlaceHolder(itemView.context))
            view.titlePhotoText.text = item.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosVH {

        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<UserPhotosRecyclerRowBinding>(inflater,R.layout.user_photos_recycler_row,parent,false)
        return PhotosVH(binding)
    }

    override fun onBindViewHolder(holder: PhotosVH, position: Int) {
        holder.bind(photoList.get(position))

    }

    override fun getItemCount(): Int {
       return photoList.size
    }



}

