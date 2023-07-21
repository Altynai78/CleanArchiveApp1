package com.example.cleanarchiveapp1.presentation.ui.music.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchiveapp1.domain.models.Music

class MusicAdapter(var onItemClick: ((Music) -> Unit)? = null
) : Adapter<MusicAdapter.MusicViewHolder>() {

    private val musicList = arrayListOf<Music>()

    @SuppressLint("NotifyDataSetChanged")
    fun addMusicList(list: List<Music>) {
        musicList.clear()
        musicList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        return MusicViewHolder(
            ItemMusicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = musicList.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.onBind(musicList[position])
    }

    inner class MusicViewHolder(private val binding: ItemMusicBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(music: Music) {
            with(binding){
                tvName.text = music.name
                tvPerfomer.text = music.perfomer
                tvDuration.text = music.duration
            }
            itemView.setOnClickListener {
                onItemClick?.invoke(music)
            }
        }
    }
}