package digital.sarana.taniku.produk.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.sarana.taniku.Utils.StatusLoading
import digital.sarana.taniku.network.produk.ProdukAPI
import digital.sarana.taniku.network.produk.ProdukRespon
import kotlinx.coroutines.launch
import java.lang.Exception

class CreateProdukViewModel(authorization: String) : ViewModel() {
    private val _responseProduk = MutableLiveData<ProdukRespon?>()
    private val _response = MutableLiveData<String>()
    private val _statusLoading = MutableLiveData<StatusLoading>()
    private val _token = MutableLiveData<String>()

    val token: LiveData<String>
        get() = _token
    val statusLoading: LiveData<StatusLoading>
        get() = _statusLoading
    val response: LiveData<String>
        get() = _response
    val responseProduk: LiveData<ProdukRespon?>
        get() = _responseProduk

    init {
        _token.value = authorization

    }

    fun onClickSubmit(kode: String, nama: String, harga: String, deskripsi: String) {
        viewModelScope.launch {
            _statusLoading.value = StatusLoading.LOADING
            try {
                _responseProduk.value = ProdukAPI.produkService.simpanProduk(token.value.toString(), kode, nama, harga, deskripsi)
                _response.value = ""
                _statusLoading.value = StatusLoading.DONE
            } catch (e: Exception) {
                _response.value = e.message.toString()
                _responseProduk.value = null
                _statusLoading.value = StatusLoading.ERROR
            }
        }
    }

}