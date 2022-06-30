package com.example.kexamplerecycleview.model.repo.retrofit


import com.example.keimdb.retrofit.api.IDataApi
import com.example.kexamplerecycleview.model.repo.IRetrofitRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


data class RetrofitRepo(val api: IDataApi) : IRetrofitRepo {
    override fun getRepoApi() = api.getApiTop250()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}