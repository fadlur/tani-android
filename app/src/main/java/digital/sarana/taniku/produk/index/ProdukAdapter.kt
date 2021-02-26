package digital.sarana.taniku.produk.index

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import digital.sarana.taniku.databinding.ListItemProdukBinding
import digital.sarana.taniku.network.produk.ProdukData

class ProdukAdapter(private val onClickListener: OnClickListener): ListAdapter<ProdukData, ProdukAdapter.ProdukDataViewHolder>(DiffCallback) {
    object DiffCallback: DiffUtil.ItemCallback<ProdukData>() {
        override fun areItemsTheSame(oldItem: ProdukData, newItem: ProdukData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProdukData, newItem: ProdukData): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class OnClickListener(val clickListener: (produkData: ProdukData) -> Unit) {
        fun onClick(produkData: ProdukData) = clickListener(produkData)
    }

    class ProdukDataViewHolder(private val binding: ListItemProdukBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(itemProduk: ProdukData, onClickListener: OnClickListener) {
            binding.itemProduk = itemProduk
            binding.kodeTxt.setOnClickListener {
                onClickListener.onClick(itemProduk)
            }
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ProdukDataViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemProdukBinding.inflate(layoutInflater, parent, false)
                return ProdukDataViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdukDataViewHolder {
        return ProdukDataViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProdukDataViewHolder, position: Int) {
        val itemProduk = getItem(position)
        holder.bind(itemProduk, onClickListener)
    }
}