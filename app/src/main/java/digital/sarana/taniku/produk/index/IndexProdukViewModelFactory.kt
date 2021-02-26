package digital.sarana.taniku.produk.index

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class IndexProdukViewModelFactory (private val authorization: String): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IndexProdukViewModel::class.java)) {
            return IndexProdukViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown view Model")
    }
}