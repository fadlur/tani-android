package digital.sarana.taniku.network.produk

import digital.sarana.taniku.network.auth.retrofit
import retrofit2.http.*

interface ProdukService {
    @GET("/api/admin/produk")
    suspend fun loadProduk(@Header("Authorization") authorization: String): ProdukListRespon

    @FormUrlEncoded
    @POST("/api/admin/produk")
    suspend fun simpanProduk(@Header("Authorization") authorization: String,
                               @Field("kode") kode: String,
                               @Field("nama") nama: String,
                               @Field("harga") harga: String,
                               @Field("deskripsi") deskripsi: String): ProdukRespon

    @DELETE("/api/admin/produk/{id}")
    suspend fun deleteProduk(@Header("Authorization") authorization: String,
                               @Path("id") id: String): ProdukRespon

    @FormUrlEncoded
    @PATCH("/api/admin/produk/{id}")
    suspend fun updateProduk(@Header("Authorization") authorization: String,
                               @Path("id") id: String,
                               @Field("kode") kode: String,
                               @Field("nama") nama: String,
                               @Field("harga") harga: String,
                               @Field("deskripsi") deskripsi: String): ProdukRespon
}

object ProdukAPI {
    val produkService: ProdukService by lazy {
        retrofit.create(ProdukService::class.java)
    }
}