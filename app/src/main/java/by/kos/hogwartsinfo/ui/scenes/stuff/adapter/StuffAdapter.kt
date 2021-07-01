package by.kos.hogwartsinfo.ui.scenes.stuff.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kos.hogwartsinfo.databinding.CellStuffBinding
import by.kos.hogwartsinfo.databinding.FragmentStuffBinding
import by.kos.hogwartsinfo.ui.scenes.students.data.StudentCellModel
import by.kos.hogwartsinfo.ui.scenes.stuff.data.StuffCellModel
import com.squareup.picasso.Picasso

class StuffAdapter : RecyclerView.Adapter<StuffAdapter.StuffViewHolder>() {

    private val mDataList = ArrayList<StuffCellModel>()
    private val mDisplayList = ArrayList<StuffCellModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StuffViewHolder {
        return StuffViewHolder(
            CellStuffBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StuffViewHolder, position: Int) {
        holder.bind(mDisplayList[position])
    }

    override fun getItemCount(): Int = mDisplayList.count()


    inner class StuffViewHolder(private val binding: CellStuffBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val txtName = binding.txtStuffName
        private val txtFaculty = binding.txtStuffFaculty
        private val txtAncestry = binding.txtStuffAncestry
        private val image = binding.imgStuffPhoto

        fun bind(cellModel: StuffCellModel) {
            txtName.text = cellModel.name
            txtFaculty.text = cellModel.house
            txtAncestry.text = cellModel.ancestry
            Picasso.get().load(cellModel.image).into(image)
        }
    }

    fun setData(newData: List<StuffCellModel>) {
        mDataList.clear()
        mDataList.addAll(newData)
        notifyDataSetChanged()
        filter(query = "")
    }

    fun filter(query: String) {
        mDisplayList.clear()

        if (query.isEmpty()) {
            mDisplayList.addAll(mDataList)
            return
        }

        mDisplayList.addAll(mDataList.filter {
            it.name.contains(query, true) ||
                    it.house.contains(query, true)
        })
        notifyDataSetChanged()
    }
}
