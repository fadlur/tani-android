package digital.sarana.taniku.produk.index

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.sarana.taniku.Utils.StatusLoading
import digital.sarana.taniku.network.produk.ProdukAPI
import digital.sarana.taniku.network.produk.ProdukData
import digital.sarana.taniku.network.produk.ProdukListRespon
import kotlinx.coroutines.launch
import java.lang.Exception

class IndexProdukViewModel(authorization: String) : ViewModel() {
    private val _response = MutableLiveData<String>()
    private val _responseData = MutableLiveData<ProdukListRespon?>()
    private val _responseListData = MutableLiveData<List<ProdukData>>()
    private val _statusLoading = MutableLiveData<StatusLoading>()
    private val _token = MutableLiveData<String>()
    private val _navigateToCreate = MutableLiveData<Boolean>()
    private val _navigateToDetail = MutableLiveData<ProdukData?>()

    val response:LiveData<String>
        get() = _response
    val responseData: MutableLiveData<ProdukListRespon?>
        get() = _responseData
    val responseListData: LiveData<List<ProdukData>>
        get() = _responseListData
    val statusLoading: LiveData<StatusLoading>
        get() = _statusLoading
    val token: LiveData<String>
        get() = _token
    val navigateToCreate: LiveData<Boolean>
        get() = _navigateToCreate
    val navigateToDetail: MutableLiveData<ProdukData?>
        get() = _navigateToDetail
    init {
        _token.value = authorization
        getListProduk()
    }

    fun getListProduk() {
        viewModelScope.launch {
            _statusLoading.value = StatusLoading.LOADING
            try {
                val respon = ProdukAPI.produkService.loadProduk(token.value.toString())
                _responseData.value = respon
                _responseListData.value = respon.content?.data
                _response.value = ""
                _statusLoading.value = StatusLoading.LOADING
            } catch (e: Exception) {
                _responseData.value = null
                _responseListData.value = ArrayList()
                _response.value = e.message.toString()
                _statusLoading.value = StatusLoading.ERROR
            }
        }
    }

    fun onNavigateToCreate() {
        _navigateToCreate.value = true
    }

    fun onNavigateToCreateComplete() {
        _navigateToCreate.value = false
    }

    fun onNavigateToDetail(produkData: ProdukData) {
        _navigateToDetail.value = produkData
    }

    fun onNavigateToDetailComplete() {
        _navigateToDetail.value = null
    }
}