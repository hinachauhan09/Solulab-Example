
import com.solulab.example.model.CoinApiResponse
import retrofit2.Call
import retrofit2.http.*

@JvmSuppressWildcards
interface RetrofitApi {


    @GET("coinlist")
    fun getData(): Call<CoinApiResponse?>?

    companion object {
        const val BASE_URL = "https://demo3231717.mockable.io/"
    }
}