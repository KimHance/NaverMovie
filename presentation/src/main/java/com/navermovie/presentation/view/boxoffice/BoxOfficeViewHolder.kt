package com.navermovie.presentation.view.boxoffice

import androidx.recyclerview.widget.RecyclerView
import com.navermovie.entity.Movie
import com.navermovie.presentation.databinding.ItemBoxOfficeMovieBinding

class BoxOfficeViewHolder(
    private val binding: ItemBoxOfficeMovieBinding,
    private val itemClickListener: (Movie) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) {
        binding.apply {
            movie = item
            executePendingBindings()
            itemView.setOnClickListener {
                itemClickListener(item)
            }
        }
    }
}