package com.slowit.wall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.slowit.model.post.Post

class WallAdapter: ListAdapter<Post, WallAdapter.WallViewHolder>(
    diffCallback
){

    var onPostClickListener: OnPostClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallViewHolder =
        WallViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false))


    override fun onBindViewHolder(holder: WallViewHolder, position: Int) {
        val item = getItem(position)
        holder.title.text = item.title
        item.image?.let {
            holder.image.apply {
                Glide.with(context)
                    .load(it)
                    .into(this)
            }
        }
        holder.itemView.setOnClickListener {
            onPostClickListener?.onPostClick(item)
        }
    }

    inner class WallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.post_image)
        val title: TextView = itemView.findViewById(R.id.post_title)
    }

    fun interface OnPostClickListener {
        fun onPostClick(post: Post)
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.title == newItem.title
            override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem.hashCode() == newItem.hashCode()
        }
    }
}