package digital.sarana.taniku.transaksi.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailTransaksiViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailTransaksiViewModel::class.java)) {
            return DetailTransaksiViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}