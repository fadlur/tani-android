package digital.sarana.taniku.transaksi.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import digital.sarana.taniku.R

class DetailTransaksiFragment : Fragment() {

    companion object {
        fun newInstance() = DetailTransaksiFragment()
    }

    private lateinit var viewModel: DetailTransaksiViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_transaksi_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailTransaksiViewModel::class.java)
        // TODO: Use the ViewModel
    }

}