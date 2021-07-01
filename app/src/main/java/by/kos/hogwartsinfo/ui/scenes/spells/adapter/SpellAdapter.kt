package by.kos.hogwartsinfo.ui.scenes.spells.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import by.kos.hogwartsinfo.databinding.CellSpellBinding
import by.kos.hogwartsinfo.ui.scenes.spells.data.SpellCellModel

class SpellAdapter : RecyclerView.Adapter<SpellAdapter.SpellViewHolder>() {

    private val mDataList = ArrayList<SpellCellModel>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SpellAdapter.SpellViewHolder {
        return SpellViewHolder(
            CellSpellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpellAdapter.SpellViewHolder, position: Int) {
        holder.bind(mDataList[position])
    }

    override fun getItemCount(): Int =  mDataList.count()

    inner class SpellViewHolder(private val binding: CellSpellBinding) :
        RecyclerView.ViewHolder(binding.root) {


        private val txtName = binding.txtSpellName
        private val txtType = binding.txtSpellType

        fun bind(cellModel: SpellCellModel) {
            txtName.text = cellModel.name
            txtType.text = cellModel.type
        }
    }
    fun setData(newData: List<SpellCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        notifyDataSetChanged()
    }
}