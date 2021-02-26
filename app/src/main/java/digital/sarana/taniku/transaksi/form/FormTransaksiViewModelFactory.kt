package digital.sarana.taniku.transaksi.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FormTransaksiViewModelFactory(private val authorization: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FormTransaksiViewModel::class.java)) {
            return FormTransaksiViewModel(authorization) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}