package com.example.bottomnavapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bottomnavapp.R
import com.example.bottomnavapp.data.PokemonApi
import com.example.bottomnavapp.data.ResultsItem
import com.example.bottomnavapp.databinding.ActivityListBinding
import kotlinx.coroutines.CoroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity(), PokemonListAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)


//
//        getPokemonData()
//
//
//
//        binding.apply {
//            listRecyclerView.layoutManager = GridLayoutManager(this@ListActivity, 2)
//            listRecyclerView.adapter = adapter
//            adapter.submitList()
//
//
//            val call
//        }

    }

    override fun onItemClickListener(item: ResultsItem) {
        Toast.makeText(this, "berhasil diklik!", Toast.LENGTH_SHORT).show()
    }

    suspend fun getPokemonData() {


        val adapter = PokemonListAdapter(this@ListActivity)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PokemonApi::class.java)
        val response = api.getPokemonList()

        adapter.submitList(response.results)

//        if (response.isSuccessful) {
//            pokemonList = response.body() ?: emptyList()
//            adapter.notifyDataSetChanged()
//        } else {
//            Log.e("ListActivity", "Error getting pokemon data: ${response.code()}")
//        }
    }
}