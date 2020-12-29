package id.febridk.spaceinvasion.data.repository

import id.febridk.spaceinvasion.data.model.ActionState
import id.febridk.spaceinvasion.data.model.Corona
import id.febridk.spaceinvasion.data.remote.CoronaService
import id.febridk.spaceinvasion.data.remote.RetrofitApi
import retrofit2.await

class CoronaRepository {
    private val coronaService: CoronaService by lazy { RetrofitApi.coronaService() }

    suspend fun listCorona() : ActionState<List<Corona>> {
        return try {
            val list = coronaService.listCorona().await()
            ActionState(list.data)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailCorona(url: String) : ActionState<Corona>{
        return try {
            val list = coronaService.detailCorona(url).await()
            ActionState(list.data.first())
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchCorona(query: String) : ActionState<List<Corona>>{
        return try {
            val list = coronaService.searchCorona(query).await()
            ActionState(list.data)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }
}