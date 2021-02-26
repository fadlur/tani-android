package digital.sarana.taniku.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaRespon(
    @Json(name="current_page") val currentPage: Int? = null,
    @Json(name="first_item") val firstItem: Int? = null,
    @Json(name="last_item") val lastItem: Int? = null,
    @Json(name="next_page_url") val nextPageUrl: String? = null,
    @Json(name="prev_page_url") val prevPageUrl: String? = null,
    @Json(name="current_page_url") val currentPageUrl: String? = null,
    @Json(name="last_page") val lastPage: Int? = null,
    @Json(name="per_page") val perPage: Int? = null,
    @Json(name="total") val total: Int? = null,
)