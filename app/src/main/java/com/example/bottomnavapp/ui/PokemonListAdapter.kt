package com.example.bottomnavapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavapp.data.ResultsItem
import com.example.bottomnavapp.databinding.LayoutPokemonListBinding

class PokemonListAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<ResultsItem, PokemonListAdapter.PokemonListViewHolder>(PokemonListComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val binding =
            LayoutPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem, listener)
        }
    }

    class PokemonListViewHolder(private val binding: LayoutPokemonListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: ResultsItem, listener: OnItemClickListener) {
            binding.apply {
                Glide.with(itemView).load("").into(pokemonImageView)
                pokemonTextView.text = items.name
                itemView.setOnClickListener {
                    listener.onItemClickListener(items)
                }
            }
        }
    }

    class PokemonListComparator : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    interface OnItemClickListener {
        fun onItemClickListener(item: ResultsItem)
    }

}