package digital.sarana.taniku.produk.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import digital.sarana.taniku.R
import digital.sarana.taniku.Utils.loadToken
import digital.sarana.taniku.databinding.DetailProdukFragmentBinding

class DetailProdukFragment : Fragment() {

    private lateinit var viewModel: DetailProdukViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailProdukFragmentBinding.inflate(inflater)
        val authtoken = loadToken(getString(R.string.auth_token), getString(R.string.token_type), getString(R.string.access_token), activity)
        val viewModelFactory = DetailProdukViewModelFactory(authtoken)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailProdukViewModel::class.java)
        val itemProduk = DetailProdukFragmentArgs.fromBundle(requireArguments()).produkData
        binding.produkData = itemProduk
//        Toast.makeText(activity, itemProduk.nama, Toast.LENGTH_SHORT).show()
        //hapus produk
        binding.editBtn.setOnClickListener {
            findNavController().navigate(DetailProdukFragmentDirections.actionDetailProdukFragmentToEditProdukFragment(itemProduk))
        }
        binding.deleteBtn.setOnClickListener {
            viewModel.onDeleteProduk(itemProduk.id.toString())
        }
        // delete status
        viewModel.deleteStatus.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(DetailProdukFragmentDirections.actionDetailProdukFragmentToIndexProdukFragment())
            }
        })
        return inflater.inflate(R.layout.detail_produk_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailProdukViewModel::class.java)
        // TODO: Use the ViewModel
    }

}