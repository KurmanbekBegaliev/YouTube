package com.example.youtube.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.databinding.ItemDetailsBinding
import com.example.youtube.model.Item
import com.example.youtube.utils.loadImage

class DetailsAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {

    private val detailsData = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(
            ItemDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = detailsData.size


    fun addData(items: List<Item>) {
        detailsData.clear()
        detailsData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(detailsData[position])
        holder.itemView.setOnClickListener {
            onClick()
        }
    }

    inner class DetailsViewHolder(private val binding: ItemDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.tvDetailsTitle.text = item.snippet?.title
            binding.tvDetailsVideoDuration.text = item.snippet?.publishedAt.toString()
            binding.ivDetailsVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
        }

    }
}