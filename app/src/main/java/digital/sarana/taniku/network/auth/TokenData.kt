package digital.sarana.taniku.network.auth

import com.squareup.moshi.Json

data class TokenData(
    @Json(name="status_code") val statusCode: Int,
    @Json(name="access_token") val accessToken: String,
    @Json(name="token_type") val tokenType: String
)