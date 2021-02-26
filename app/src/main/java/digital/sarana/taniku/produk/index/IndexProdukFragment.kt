package digital.sarana.taniku.produk.index

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import digital.sarana.taniku.R
import digital.sarana.taniku.Utils.loadToken
import digital.sarana.taniku.databinding.IndexProdukFragmentBinding

class IndexProdukFragment : Fragment() {

    private lateinit var viewModel: IndexProdukViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = IndexProdukFragmentBinding.inflate(inflater)
        val adapter = ProdukAdapter(ProdukAdapter.OnClickListener {

            findNavController().navigate(IndexProdukFragmentDirections.actionIndexProdukFragmentToDetailProdukFragment(it))
        })
        binding.produkRv.adapter = adapter
        val authtoken = loadToken(getString(R.string.auth_token), getString(R.string.token_type), getString(R.string.access_token), activity)
        val viewModelFactory = IndexProdukViewModelFactory(authtoken)
        viewModel = ViewModelProvider(this, viewModelFactory).get(IndexProdukViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //cek ambil data produk
        viewModel.responseData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                adapter.submitList(it.content?.data)
            }
        })
        //navigate ke create
        binding.addFab.setOnClickListener {
            viewModel.onNavigateToCreate()
        }
        viewModel.navigateToCreate.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(IndexProdukFragmentDirections.actionIndexProdukFragmentToCreateProdukFragment())
                viewModel.onNavigateToCreateComplete()
            }
        })
        //navigate ke detail
        viewModel.navigateToDetail.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                findNavController().navigate(IndexProdukFragmentDirections.actionIndexProdukFragmentToDetailProdukFragment(it))
            }
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(IndexProdukViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onPause() {
        super.onPause()
        Log.d("cycle", "Pause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("cycle", "Resume")
    }

}