package digital.sarana.taniku.network.produk

data class ProdukListRespon(
        val status: String? = null,
        val msg: String? = null,
        val content: ProdukContent? = null,
        val errors: String? = null
)