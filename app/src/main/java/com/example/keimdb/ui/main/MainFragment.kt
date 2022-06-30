package com.example.keimdb.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.keimdb.HolderApi
import com.example.keimdb.R
import com.example.keimdb.retrofit.api.ObjectListDTO
import com.example.kexamplerecycleview.model.repo.retrofit.RetrofitRepo
import io.reactivex.rxjava3.core.Single

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    // 1. ADAPTER создаем
    private val adapter: RvAdapter by lazy { RvAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // 2. На "rv в xml" накладываем layout ( можно Grid или любой)
        view.findViewById<RecyclerView>(R.id.rv_movies).layoutManager = LinearLayoutManager (context)
        // 3. На "rv в xml" накладываем созданный в п.1 адаптер
        view.findViewById<RecyclerView>(R.id.rv_movies).adapter = adapter


        // [2]
        viewModel.anySingle.subscribe({
            // [4]
            //displayData(it)

            println(it.errorMessage + "8888888888")
            println(it.items)
            adapter.notes = it.items!!
        }, {
            println("onError: ${it.message}-----------------------------------------------")
        })

    }
}