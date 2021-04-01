package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.databinding.UserPostRecyclerRowBinding
import com.oguzornek.internshipproject.model.Post


class PostRecyclerAdapter (var postList : List<Post>): RecyclerView.Adapter<PostRecyclerAdapter.PostVH>(){
    class PostVH(val view : UserPostRecyclerRowBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(item : Post){
            view.post = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<UserPostRecyclerRowBinding>(inflater,R.layout.user_post_recycler_row,parent,false)
        return PostVH(binding)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
      holder.bind(postList.get(position))
    }

    override fun getItemCount(): Int {
      return postList.size
    }

}