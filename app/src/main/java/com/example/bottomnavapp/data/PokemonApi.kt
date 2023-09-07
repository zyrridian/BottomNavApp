package com.example.bottomnavapp.data

import retrofit2.http.GET

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("pokemon/{pokemon_id}")
    suspend fun getPokemonDetail()

}