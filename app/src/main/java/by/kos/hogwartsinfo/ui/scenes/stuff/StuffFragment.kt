package by.kos.hogwartsinfo.ui.scenes.stuff

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
import by.kos.hogwartsinfo.databinding.FragmentStuffBinding
import by.kos.hogwartsinfo.ui.scenes.stuff.adapter.StuffAdapter

class StuffFragment : Fragment() {

    private lateinit var stuffViewModel: StuffViewModel
    private var _binding: FragmentStuffBinding? = null
    private val mAdapter = StuffAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        stuffViewModel =
            ViewModelProvider(this).get(StuffViewModel::class.java)

        _binding = FragmentStuffBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        setupLoading()

        context?.let {
            binding.recyclerStuff.adapter = mAdapter
            binding.recyclerStuff.layoutManager =
                LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }

        binding.editStuffSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                mAdapter.filter(query = s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        stuffViewModel.fetchStuffs()
    }
    private fun setupLoading(){
        stuffViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = if (it) {
                View.VISIBLE
            } else View.GONE

            binding.recyclerStuff.visibility = if (it) {
            View.GONE
        } else View.VISIBLE

            binding.tiStuffSearch.visibility = if (it) {
                View.GONE
            } else View.VISIBLE
        })
    }

    private fun setupData(){
        stuffViewModel.stuffs.observe(viewLifecycleOwner, Observer {
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