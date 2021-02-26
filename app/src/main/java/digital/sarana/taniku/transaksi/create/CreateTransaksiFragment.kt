package digital.sarana.taniku.transaksi.create

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import digital.sarana.taniku.R

class CreateTransaksiFragment : Fragment() {

    companion object {
        fun newInstance() = CreateTransaksiFragment()
    }

    private lateinit var viewModel: CreateTransaksiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_transaksi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateTransaksiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}