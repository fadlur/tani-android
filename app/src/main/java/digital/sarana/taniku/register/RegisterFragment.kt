package digital.sarana.taniku.register

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
import digital.sarana.taniku.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = RegisterFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        val role = RegisterFragmentArgs.fromBundle(requireArguments()).role
        binding.registerBtn.setOnClickListener {
            viewModel.handleRegister(binding.emailEt.text.toString(), binding.namaEt.text.toString(), binding.passwordEt.text.toString(), binding.phoneEt.text.toString(), role)
            Log.d("email", binding.emailEt.text.toString())
            Log.d("nama", binding.namaEt.text.toString())
            Log.d("password", binding.passwordEt.text.toString())
            Log.d("phone", binding.phoneEt.text.toString())
            Log.d("role" , role)
        }

        //navigate to login fragment
        viewModel.navigateToLogin.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.loginFragment)
                viewModel.navigateToLoginComplete()
            }
        })
        // register respon
        viewModel.registerRespon.observe(viewLifecycleOwner, Observer {
            Log.d("respon", it.toString())
        })
        // status loading
        viewModel.statusLoading.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.toString(), Toast.LENGTH_SHORT).show()
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}