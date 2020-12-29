package id.febridk.spaceinvasion.ui.corona

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.febridk.spaceinvasion.data.model.ActionState
import id.febridk.spaceinvasion.data.model.Corona
import id.febridk.spaceinvasion.data.repository.CoronaRepository
import kotlinx.coroutines.launch

class CoronaViewModel : ViewModel() {
    private val repo: CoronaRepository by lazy { CoronaRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Corona>>()
    val detailResp = MutableLiveData<Corona>()
    val searchResp = MutableLiveData<List<Corona>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listCorona(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listCorona()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailCorona(url: String? = this.url.value){
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailCorona(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchCorona(query: String? = this.query.value){
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchCorona(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }

}