package digital.sarana.taniku.produk.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.sarana.taniku.Utils.StatusLoading
import digital.sarana.taniku.network.produk.ProdukAPI
import digital.sarana.taniku.network.produk.ProdukData
import digital.sarana.taniku.network.produk.ProdukRespon
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailProdukViewModel(authorization: String) : ViewModel() {
    private val _responseProduk = MutableLiveData<ProdukRespon?>()
    private val _response = MutableLiveData<String>()
    private val _statusLoading = MutableLiveData<StatusLoading>()
    private val _token = MutableLiveData<String>()
    private val _deleteStatus = MutableLiveData<Boolean>()
    private val _navigateToEdit = MutableLiveData<ProdukData?>()

    val navigateToEdit: LiveData<ProdukData?>
        get() = _navigateToEdit
    val token: LiveData<String>
        get() = _token
    val statusLoading: LiveData<StatusLoading>
        get() = _statusLoading
    val response: LiveData<String>
        get() = _response
    val responseProduk: LiveData<ProdukRespon?>
        get() = _responseProduk
    val deleteStatus: LiveData<Boolean>
        get() = _deleteStatus

    init {
        _token.value = authorization
    }

    fun onNavigateToEditComplete() {
        _navigateToEdit.value = null
    }

    fun onDeleteProduk(id: String) {
        viewModelScope.launch {
            _statusLoading.value = StatusLoading.LOADING
            try {
                _statusLoading.value = StatusLoading.DONE
                _response.value = ""
                _responseProduk.value = ProdukAPI.produkService.deleteProduk(token.value.toString(), id)
                _deleteStatus.value = true
            } catch (e: Exception) {
                _statusLoading.value = StatusLoading.ERROR
                _response.value = e.message.toString()
                _responseProduk.value = null
                _deleteStatus.value = false
            }
        }
    }
}