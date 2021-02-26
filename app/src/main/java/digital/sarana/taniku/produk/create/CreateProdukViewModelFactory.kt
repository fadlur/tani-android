package digital.sarana.taniku.produk.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CreateProdukViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateProdukViewModel::class.java)) {
            return CreateProdukViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}