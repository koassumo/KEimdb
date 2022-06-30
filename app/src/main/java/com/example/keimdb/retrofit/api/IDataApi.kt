package com.example.keimdb.retrofit.api

import com.example.keimdb.BuildConfig
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface IDataApi {

    // тут то, что в запросе api после слэша
    //val apiKey: String
    //    get() = BuildConfig.IMDB_API_KEY

    @GET( "/en/API/Top250Movies/k_k0anb310")
    fun getApiTop250(): Single<ObjectListDTO>

}