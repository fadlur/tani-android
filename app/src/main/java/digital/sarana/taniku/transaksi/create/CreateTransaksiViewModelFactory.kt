package digital.sarana.taniku.transaksi.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateTransaksiViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateTransaksiViewModel::class.java)) {
            return CreateTransaksiViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}