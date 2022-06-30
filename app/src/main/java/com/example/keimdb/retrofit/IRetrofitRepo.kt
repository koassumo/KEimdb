package com.example.kexamplerecycleview.model.repo

import com.example.keimdb.retrofit.api.ObjectListDTO
import io.reactivex.rxjava3.core.Single

interface IRetrofitRepo {
    fun getRepoApi(): Single<ObjectListDTO>
}