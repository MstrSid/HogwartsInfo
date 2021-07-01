package by.kos.hogwartsinfo.ui.scenes.students.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.kos.hogwartsinfo.databinding.CellStudentBinding
import by.kos.hogwartsinfo.ui.scenes.students.data.StudentCellModel

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private val mDataList = ArrayList<StudentCellModel>()
    private val mDisplayList = ArrayList<StudentCellModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return StudentViewHolder(
            CellStudentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(mDisplayList[position])
    }

    override fun getItemCount(): Int = mDisplayList.count()

    inner class StudentViewHolder(private val binding: CellStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val txtName = binding.txtStudentName
        private val txtFaculty =  binding.txtStudentFaculty
        private val txtAncenstry = binding.txtStudentAncestry
        private val image = binding.imgStudentPhoto

        fun bind(cellModel: StudentCellModel) {
            txtName.text = cellModel.name
            txtFaculty.text = cellModel.house
            txtAncenstry.text = cellModel.ancestry
            image.setImageURI(Uri.parse(cellModel.image))
        }
    }

    fun setData(newData: List<StudentCellModel>) {
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