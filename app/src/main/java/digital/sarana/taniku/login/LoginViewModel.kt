package digital.sarana.taniku.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.sarana.taniku.Utils.StatusLoading
import digital.sarana.taniku.network.auth.AuthAPI
import digital.sarana.taniku.network.auth.LoginRespon
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _navigateToRegisterMitra = MutableLiveData<Boolean>()
    private val _navigateToRegisterPembeli = MutableLiveData<Boolean>()
    private val _statusLoading = MutableLiveData<StatusLoading>()
    private val _response = MutableLiveData<String>()
    private val _responLogin = MutableLiveData<LoginRespon?>()
    private val _navigateToProduk = MutableLiveData<Boolean>()

    val navigateToProduk: LiveData<Boolean>
        get() = _navigateToProduk

    val navigateToRegisterMitra: LiveData<Boolean>
        get() = _navigateToRegisterMitra

    val navigateToRegisterPembeli: LiveData<Boolean>
        get() = _navigateToRegisterPembeli

    val statusLoading: LiveData<StatusLoading>
        get() = _statusLoading

    val response: LiveData<String>
        get() = _response

    val responLogin: MutableLiveData<LoginRespon?>
        get() = _responLogin
    init {

    }

    fun onClickNavigateToRegisterMitra() {
        _navigateToRegisterMitra.value = true
    }

    fun onClickNavigateToRegisterPembeli() {
        _navigateToRegisterPembeli.value = true
    }

    fun navigateToRegisterMitraComplete() {
        _navigateToRegisterMitra.value = false
    }

    fun navigateToRegisterPembeliComplete() {
        _navigateToRegisterPembeli.value = false
    }

    fun onClickNavigateToProduk() {
        _navigateToProduk.value = true
    }

    fun navigateToProdukComplete() {
        _navigateToProduk.value = false
    }

    fun handleLogin(email: String, password: String) {
        viewModelScope.launch {
            _statusLoading.value = StatusLoading.LOADING
            try {
                _responLogin.value = AuthAPI.authService.submitLogin(email, password)
                _response.value = "Login successfully"
                _statusLoading.value = StatusLoading.DONE
            } catch (e: Exception) {
                _responLogin.value = null
                _statusLoading.value = StatusLoading.ERROR
                _response.value = e.message.toString()
            }
        }
    }
}