package digital.sarana.taniku.network.produk

data class ProdukRespon(
        val status: String? = null,
        val msg: String? = null,
        val content: ProdukData? = null,
        val errors: String? = null
)