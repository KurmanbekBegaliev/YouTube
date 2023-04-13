package com.example.youtube.ui.playlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtube.R
import com.example.youtube.databinding.ItemPlaylistBinding
import com.example.youtube.model.Item
import com.example.youtube.utils.loadImage
import kotlin.contracts.contract

class PlaylistAdapter(private val context: Context, private val onClick: (String) -> Unit) : RecyclerView.Adapter<PlaylistAdapter.PlaylistviewHolder>() {

    private val data = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistviewHolder {
       return PlaylistviewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PlaylistviewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun addData(items: List<Item>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    inner class PlaylistviewHolder(private val binding : ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: Item) {
            binding.tvTitle.text = item.snippet?.title
            binding.tvPlaylistName.text = item.snippet?.channelTitle
            binding.tvVideoCount.text = context.getString(R.string.video_count, item.contentDetails?.itemCount.toString())
            binding.ivVideo.loadImage(item.snippet?.thumbnails?.default?.url.toString())
            binding.root.setOnClickListener {
                onClick(item.id.toString())
            }
        }

    }
}