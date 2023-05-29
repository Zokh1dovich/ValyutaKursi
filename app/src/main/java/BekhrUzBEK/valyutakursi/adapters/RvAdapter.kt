package BekhrUzBEK.valyutakursi
import BekhrUzBEK.valyutakursi.databinding.ItemRvBinding
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(var list: List<MyValyuta>) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(myValyuta: MyValyuta) {
            itemRvBinding.itemName.text = myValyuta.CcyNm_UZ
            itemRvBinding.itemDate.text = myValyuta.Date
            itemRvBinding.itemNumber.text = myValyuta.Rate + " So'm"

            itemRvBinding.itemDifOnn.visibility = View.VISIBLE
            itemRvBinding.itemDifOnn.text = myValyuta.Diff

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


}