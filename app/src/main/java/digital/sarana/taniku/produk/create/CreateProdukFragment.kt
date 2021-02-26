package digital.sarana.taniku.produk.create

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
import digital.sarana.taniku.databinding.CreateProdukFragmentBinding

class CreateProdukFragment : Fragment() {

    private lateinit var viewModel: CreateProdukViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = CreateProdukFragmentBinding.inflate(inflater)
        val authtoken = loadToken(getString(R.string.auth_token), getString(R.string.token_type), getString(R.string.access_token), activity)
        val viewModelFactory = CreateProdukViewModelFactory(authtoken)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CreateProdukViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        // simpan
        binding.simpanBtn.setOnClickListener {
            viewModel.onClickSubmit(binding.kodeEt.text.toString(), binding.namaEt.text.toString(), binding.hargaEt.text.toString(), binding.deskripsiEt.text.toString())
        }
        // load respon
        viewModel.responseProduk.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                if (it.status == "success") {
                    findNavController().navigate(CreateProdukFragmentDirections.actionCreateProdukFragmentToIndexProdukFragment())
                }
            }
        })
        // status loading
        viewModel.statusLoading.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateProdukViewModel::class.java)
        // TODO: Use the ViewModel
    }

}