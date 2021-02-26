package digital.sarana.taniku.network.produk

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class ProdukData(
    @Json(name="id") val id: String? = null,
    @Json(name="user_id") val userId: String? = null,
    @Json(name="user_name") val userName: String? = null,
    @Json(name="user_phone") val userPhone: String? = null,
    @Json(name="user_email") val userEmail: String? = null,
    @Json(name="user_role") val userRole: String? = null,
    @Json(name="user_status") val userStatus: String? = null,
    @Json(name="kode") val kode: String? = null,
    @Json(name="nama") val nama: String? = null,
    @Json(name="harga") val harga: String? = null,
    @Json(name="deskripsi") val deskripsi: String? = null,
    @Json(name="created_at") val createdAt: String? = null,
    @Json(name="updated_at") val updatedAt: String? = null,
): Parcelable