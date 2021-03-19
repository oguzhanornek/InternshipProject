package com.oguzornek.internshipproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oguzornek.internshipproject.R
import com.oguzornek.internshipproject.model.Post
import kotlinx.android.synthetic.main.user_post_recycler_row.view.*

class PostRecyclerAdapter (var postList : List<Post>): RecyclerView.Adapter<PostRecyclerAdapter.PostVH>(){
    class PostVH(itemview : View) : RecyclerView.ViewHolder(itemview) {

        fun bind(item : Post){
            itemView.titleText.text = item.title.toString()
            itemView.bodyText.text = item.body.toString()
            itemView.postId.text = item.id.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_post_recycler_row,parent,false)
        return PostVH(view)
    }

    override fun onBindViewHolder(holder: PostVH, position: Int) {
      holder.bind(postList.get(position))
    }

    override fun getItemCount(): Int {
      return postList.size
    }

}