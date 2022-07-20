package com.solulab.example.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.solulab.example.model.CoinApiResponse
import retrofit2.Response

class HomeViewModel (application: Application) : AndroidViewModel(application)  {
    val coinResponse: LiveData<Response<CoinApiResponse?>>


    private val repository = HomeRepository()
    init {
        coinResponse = repository.coinResponse
    }

    fun getReponse(){
        repository.getCoinReponse()
    }

}