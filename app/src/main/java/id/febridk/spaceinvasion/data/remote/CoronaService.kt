package id.febridk.spaceinvasion.data.remote

import id.febridk.spaceinvasion.data.model.CoronaList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoronaService {

    @GET("/api/countries")
    fun listCorona(): Call<CoronaList>

    @GET("detail/")
    fun detailCorona(@Query("url") url: String): Call<CoronaList>

    @GET("search/")
    fun searchCorona(@Query("q") query: String): Call<CoronaList>
}