package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.Util.gorselView
import com.oguzornek.internshipproject.Util.makePlaceHolder
import com.oguzornek.internshipproject.model.Photos
import kotlinx.android.synthetic.main.user_album_recycler_row.view.*


class PhotosRecyclerAdapter( var photoList : List<Photos>) : RecyclerView.Adapter<PhotosRecyclerAdapter.PhotosVH>() {
    class PhotosVH(itemview : View) : RecyclerView.ViewHolder(itemview){

        fun bind(item : Photos){
            itemView.imageView.gorselView(item.url, makePlaceHolder(itemView.context))
            itemView.titlePhotoText.text = item.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosVH {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_album_recycler_row,parent,false)
        return PhotosVH(view)
    }

    override fun onBindViewHolder(holder: PhotosVH, position: Int) {
        holder.bind(photoList.get(position))

    }

    override fun getItemCount(): Int {
       return photoList.size
    }



}

