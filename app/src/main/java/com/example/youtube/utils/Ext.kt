package com.example.youtube.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).into(this)
}

fun Fragment.showToast(str: String) {
    Toast.makeText(requireContext(), str, Toast.LENGTH_SHORT).show()
}