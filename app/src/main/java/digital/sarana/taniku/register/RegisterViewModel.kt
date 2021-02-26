package digital.sarana.taniku.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.sarana.taniku.Utils.StatusLoading
import digital.sarana.taniku.network.auth.AuthAPI
import digital.sarana.taniku.network.auth.RegisterRespon
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel : ViewModel() {
    private val _navigateToLogin = MutableLiveData<Boolean>()
    private val _responRegister = MutableLiveData<RegisterRespon?>()
    private val _statusLoading = MutableLiveData<StatusLoading>()
    private val _response = MutableLiveData<String>()
    val navigateToLogin: LiveData<Boolean>
        get() = _navigateToLogin

    val registerRespon: MutableLiveData<RegisterRespon?>
        get() = _responRegister

    val statusLoading: LiveData<StatusLoading>
        get() = _statusLoading

    val response: LiveData<String>
        get() = _response

    init {
        _navigateToLogin.value = false
    }

    fun onClickNavigateToLogin() {
        _navigateToLogin.value = true
    }

    fun navigateToLoginComplete() {
        _navigateToLogin.value = false
    }

    fun handleRegister(email:String, name: String, password: String, phone: String, role: String) {
        viewModelScope.launch {
            _statusLoading.value = StatusLoading.LOADING
            try {
                _responRegister.value = AuthAPI.authService.submitRegister(email, name, password, role, phone)
                _statusLoading.value = StatusLoading.DONE
                _response.value="Register Successfully"
                _navigateToLogin.value = true
            } catch (e: Exception) {
                _statusLoading.value = StatusLoading.ERROR
                _responRegister.value = null
                _response.value=e.message.toString()
            }
        }
    }
}