package digital.sarana.taniku.network.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginErrors(
    val email: List<String>,
    val password: List<String>
)