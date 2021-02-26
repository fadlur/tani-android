package digital.sarana.taniku.network.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterErrors(
    val email: List<String>
)