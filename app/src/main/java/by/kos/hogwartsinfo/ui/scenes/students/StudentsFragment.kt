package by.kos.hogwartsinfo.ui.scenes.students

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kos.hogwartsinfo.databinding.FragmentStudentsBinding
import by.kos.hogwartsinfo.ui.scenes.students.adapter.StudentAdapter

class StudentsFragment : Fragment() {

    private lateinit var studentsViewModel: StudentsViewModel
    private var _binding: FragmentStudentsBinding? = null
    private val mAdapter = StudentAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        studentsViewModel =
            ViewModelProvider(this).get(StudentsViewModel::class.java)

        _binding = FragmentStudentsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
            context?.let {
                binding.recyclerStudents.adapter = mAdapter
                binding.recyclerStudents.layoutManager =
                    LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }
        binding.editStudentsSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })

        studentsViewModel.fetchStudents()

    }

    private fun setupData() {
        studentsViewModel.students.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                mAdapter.setData(newData = it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}