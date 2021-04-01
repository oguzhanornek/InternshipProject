package com.oguzornek.internshipproject.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.oguzornek.internshipproject.R

fun ImageView.gorselView(url : String?, placeholder : CircularProgressDrawable ){
    val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)
    val mUrl = GlideUrl(
            url,LazyHeaders.Builder().addHeader("User-Agent","your-user-agent").build()
    )
        Glide.with(this.context).setDefaultRequestOptions(options).load(mUrl).into(this)

}

fun makePlaceHolder(context: Context):CircularProgressDrawable{

    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}