package com.ozu.cs394.plantsuniverse.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.ozu.cs394.plantsuniverse.extension.downloadUrl

@BindingAdapter("android:showImage")
fun downloadImage(view: ImageView, url:String?){
    view.downloadUrl(url)
}