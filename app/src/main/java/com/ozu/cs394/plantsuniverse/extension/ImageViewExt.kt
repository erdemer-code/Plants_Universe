package com.ozu.cs394.plantsuniverse.extension

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ozu.cs394.plantsuniverse.R

fun ImageView.downloadUrl(url:String?){
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher_round)


    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}
