package com.example.keimdb.ui.main

import androidx.lifecycle.ViewModel
import com.example.keimdb.HolderApi
import com.example.keimdb.retrofit.api.ObjectListDTO
import com.example.kexamplerecycleview.model.repo.retrofit.RetrofitRepo
import io.reactivex.rxjava3.core.Single

class MainViewModel : ViewModel() {

    // [1]
    val anySingle: Single<ObjectListDTO> = RetrofitRepo(HolderApi().dataApi).getRepoApi()

}