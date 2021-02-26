package digital.sarana.taniku.transaksi.form

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import digital.sarana.taniku.R

class FormTransaksiFragment : Fragment() {

    companion object {
        fun newInstance() = FormTransaksiFragment()
    }

    private lateinit var viewModel: FormTransaksiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_transaksi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FormTransaksiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}