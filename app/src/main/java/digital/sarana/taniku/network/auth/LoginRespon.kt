package digital.sarana.taniku.network.auth

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRespon(
    val status: String,
    val msg: String,
    val content: TokenData? = null,
    val errors: RegisterErrors? = null
)