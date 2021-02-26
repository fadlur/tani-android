package digital.sarana.taniku.produk.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailProdukViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailProdukViewModel::class.java)) {
            return DetailProdukViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown view Model")
    }
}