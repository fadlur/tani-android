package digital.sarana.taniku.network.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterRespon(
    val status: String,
    val msg: String,
    val content: RegisterData? = null,
    val errors: RegisterErrors? = null
)