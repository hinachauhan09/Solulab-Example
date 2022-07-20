package com.solulab.example.ui.home
import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.solulab.example.Config
import com.solulab.example.model.CoinApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Hina Chauhan on 20-07-2022.
 */
class HomeRepository() {
    val coinResponse  = MutableLiveData<Response<CoinApiResponse?>>()
    fun getCoinReponse() {
        Config.getRetroFitApi()!!
            .getData()!!
            .enqueue(object : Callback<CoinApiResponse?> {
                override fun onResponse(call: Call<CoinApiResponse?>, response: Response<CoinApiResponse?>) {
                    Log.e("Reponse","true")
                    coinResponse.value = response
                }

                override fun onFailure(call: Call<CoinApiResponse?>, t: Throwable) {
                    //coinResponse.value = null
                    Log.e("Reponse","fasel")

                }
            })
    }
}