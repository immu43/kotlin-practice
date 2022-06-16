package com.example.myapplication

import retrofit2.*
import retrofit2.http.*

interface QuoteApi {
    @GET("/quotes")
    suspend fun getQuotes(): Response<QuoteList>
}