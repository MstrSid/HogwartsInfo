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

    inner class StudentViewHolder(private val binding: CellStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cellModel: StudentCellModel) {
            binding.txtStudentName.text = cellModel.name
            binding.txtStudentFaculty.text = cellModel.facultyName
            binding.imgStudentPhoto.setImageURI(Uri.parse(cellModel.image))
        }
    }

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
        holder.bind(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.count()
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
                    it.facultyName.contains(query, true)
        })
        notifyDataSetChanged()
    }
}