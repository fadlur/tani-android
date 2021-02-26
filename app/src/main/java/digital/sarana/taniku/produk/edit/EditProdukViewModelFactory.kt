package digital.sarana.taniku.produk.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import java.lang.IllegalArgumentException

class EditProdukViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditProdukViewModel::class.java)) {
            return EditProdukViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}