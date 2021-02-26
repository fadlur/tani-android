package digital.sarana.taniku.network.produk

import digital.sarana.taniku.network.MetaRespon

data class ProdukContent(
        val data: List<ProdukData>,
        val meta: MetaRespon
)