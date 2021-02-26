package digital.sarana.taniku.transaksi.index

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IndexTransaksiViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IndexTransaksiViewModel::class.java)) {
            return IndexTransaksiViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown view Model")
    }
}