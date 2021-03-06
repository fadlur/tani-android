package digital.sarana.taniku.transaksi.index

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import digital.sarana.taniku.R

class IndexTransaksiFragment : Fragment() {

    companion object {
        fun newInstance() = IndexTransaksiFragment()
    }

    private lateinit var viewModel: IndexTransaksiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.index_transaksi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(IndexTransaksiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}