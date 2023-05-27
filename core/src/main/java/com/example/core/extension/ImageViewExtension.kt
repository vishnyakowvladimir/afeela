package com.example.core.extension

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

@SuppressLint("CheckResult")
fun ImageView.setImage(type: Any?, placeholder: Int) {
    val requestOptions = RequestOptions().apply {
        placeholder(placeholder)
        error(placeholder)
    }
    Glide
        .with(context)
        .load(type)
        .apply(requestOptions)
        .into(this)
}

@SuppressLint("CheckResult")
fun ImageView.setImageWithRoundCorners(type: Any?, placeholder: Int, radius: Int) {
    val requestOptions = RequestOptions().apply {
        placeholder(placeholder)
        transform(CenterCrop(), RoundedCorners(radius))
        error(placeholder)
    }
    Glide
        .with(context)
        .load(type)
        .apply(requestOptions)
        .into(this)
}

@SuppressLint("CheckResult")
fun ImageView.setImageWithRoundCorners(type: Any?, placeholder: Drawable?, radius: Int) {
    val requestOptions = RequestOptions().apply {
        placeholder(placeholder)
        transform(CenterCrop(), RoundedCorners(radius))
        error(placeholder)
    }
    Glide
        .with(context)
        .load(type)
        .apply(requestOptions)
        .into(this)
}

@SuppressLint("CheckResult")
fun ImageView.setCircleImageView(type: Any?, placeholder: Int) {
    val requestOptions = RequestOptions()
    requestOptions.apply {
        placeholder(placeholder)
        error(placeholder)
        transform(
            MultiTransformation(
                FitCenter(),
                CenterCrop(), CircleCrop()
            )
        )
    }
    Glide
        .with(context)
        .load(type)
        .apply(requestOptions)
        .into(this)
}