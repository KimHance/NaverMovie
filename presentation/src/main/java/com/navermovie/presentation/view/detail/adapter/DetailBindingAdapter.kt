package com.navermovie.presentation.view.detail.adapter

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.navermovie.presentation.R
import java.text.SimpleDateFormat

@BindingAdapter("bindDate")
fun TextView.bindDate(date: String) {
    val year = date.subSequence(0, 4)
    text = year
}

@BindingAdapter("bindShowTime")
fun TextView.bindShowTime(time: String) {
    val hours = time.toInt() / 60
    val minutes = time.toInt() % 60
    text = "${hours}h ${minutes}m"
}

@BindingAdapter("bindRating")
fun RatingBar.bindRating(rating: String) {
    val rate = rating.toFloat() / 2
    this.rating = rate
}

@BindingAdapter("bindOpenDate")
fun TextView.bindOpenDate(date: String) {
    val dateFormatter = SimpleDateFormat("yyyyMMdd")
    val date = dateFormatter.parse(date)
    text = SimpleDateFormat(context.getString(R.string.open_data_format)).format(date)
}

@BindingAdapter("bindImage")
fun ImageView.bindImage(imageUrl: String?) {
    imageUrl?.let {
        if (imageUrl.isNotBlank()) {
            Glide.with(this).load(imageUrl).into(this)
        }
    }
}

@BindingAdapter("bindDirector")
fun TextView.bindDirector(directorList: List<String>?) {
    var tmpDirectorText = ""
    directorList?.let { list ->
        for (director in list) {
            tmpDirectorText += "($director) "
        }
    }
    text = tmpDirectorText
}

@BindingAdapter("bindHtml")
fun TextView.bindHtml(html: String?) {
    html?.let {
        text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}