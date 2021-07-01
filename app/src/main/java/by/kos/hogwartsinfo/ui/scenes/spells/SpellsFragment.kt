package by.kos.hogwartsinfo.ui.scenes.spells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.kos.hogwartsinfo.databinding.FragmentSpellsBinding
import by.kos.hogwartsinfo.ui.scenes.spells.adapter.SpellAdapter

class SpellsFragment : Fragment() {

    private lateinit var spellsViewModel: SpellsViewModel
    private var _binding: FragmentSpellsBinding? = null
    private val mAdapter = SpellAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        spellsViewModel =
            ViewModelProvider(this).get(SpellsViewModel::class.java)

        _binding = FragmentSpellsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecycler()
        configureDataDisplay()

        binding.btnSpellsCharm.setOnClickListener {
            binding.btnSpellsCharm.isSelected = !binding.btnSpellsCharm.isSelected
            spellsViewModel.pressFilter(type = "Charm", isSelected = binding.btnSpellsCharm.isSelected)
        }
        binding.btnSpellsSpell.setOnClickListener {
            binding.btnSpellsSpell.isSelected = !binding.btnSpellsSpell.isSelected
            spellsViewModel.pressFilter(type = "Spell", isSelected = binding.btnSpellsSpell.isSelected)
        }
        binding.btnSpellsJinx.setOnClickListener {
            binding.btnSpellsJinx.isSelected = !binding.btnSpellsJinx.isSelected
            spellsViewModel.pressFilter(type = "Jinx", isSelected = binding.btnSpellsJinx.isSelected)
        }
        binding.btnSpellsCurse.setOnClickListener {
            binding.btnSpellsCurse.isSelected = !binding.btnSpellsCurse.isSelected
            spellsViewModel.pressFilter(type = "Curse", isSelected = binding.btnSpellsCurse.isSelected)
        }
    }

    private fun configureDataDisplay() {
        spellsViewModel.spellsDisplay.observe(viewLifecycleOwner, Observer { data ->
            mAdapter.setData(newData = data)
        })
    }

    private fun configureRecycler() {
        context?.let {
            binding.recyclerSpells.adapter = mAdapter
            binding.recyclerSpells.layoutManager =
                LinearLayoutManager(it, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}