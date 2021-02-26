package digital.sarana.taniku.login

import android.content.Context
import android.content.Intent
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
import digital.sarana.taniku.ProdukActivity
import digital.sarana.taniku.R
import digital.sarana.taniku.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = LoginFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        // navigasi ke register mitra fragment
        binding.mitraRegBtn.setOnClickListener {
            viewModel.onClickNavigateToRegisterMitra()
        }
        viewModel.navigateToRegisterMitra.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment("mitra"));
                viewModel.navigateToRegisterMitraComplete()
            }
        })
        // navigasi ke register pembeli fragment
        binding.pembeliRegBtn.setOnClickListener {
            viewModel.onClickNavigateToRegisterPembeli()
        }
        viewModel.navigateToRegisterPembeli.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment("pembeli"))
                viewModel.navigateToRegisterPembeliComplete()
            }
        })
        // navigasi ke produk
        viewModel.navigateToProduk.observe(viewLifecycleOwner, Observer {
            if (it) {
                activity.let {
                    val intent = Intent(it, ProdukActivity::class.java)
                    startActivity(intent)
                    viewModel.navigateToProdukComplete()
                }
            }
        })
        // handling login
        binding.loginBtn.setOnClickListener {
            viewModel.handleLogin(binding.emailEt.text.toString(), binding.passwordEt.text.toString())
        }
        // set token ke sharedpref
        viewModel.responLogin.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Log.d("response", it.toString())
                if (it.content != null) {
//                    val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                    val sharedPref = activity?.getSharedPreferences(getString(R.string.auth_token), Context.MODE_PRIVATE)
                    with (sharedPref?.edit()) {
                        this?.putString(getString(R.string.access_token), it.content.accessToken)
                        this?.putString(getString(R.string.token_type), it.content.tokenType)
                        this?.apply()
                    }
                    viewModel.onClickNavigateToProduk()
                }
            } else {
                Log.d("response", "null")
            }
        })
        viewModel.response.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_LONG).show()
        })
        viewModel.statusLoading.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_LONG).show()
        })
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}