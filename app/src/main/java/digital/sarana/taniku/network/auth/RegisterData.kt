package digital.sarana.taniku.network.auth

import com.squareup.moshi.Json

data class RegisterData (
    val name: String,
    val email: String,
    val phone: String,
    val role: String,
    val status: String,
    val id: String,
    @Json(name="created_at") val createdAt: String,
    @Json(name="updated_at") val updatedAt: String
        )