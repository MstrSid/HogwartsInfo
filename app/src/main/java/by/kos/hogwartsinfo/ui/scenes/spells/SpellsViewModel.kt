package by.kos.hogwartsinfo.ui.scenes.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.kos.hogwartsinfo.ui.scenes.spells.data.SpellCellModel

class SpellsViewModel : ViewModel() {

    private val _spells = MutableLiveData<MutableList<SpellCellModel>>().apply {
        value = mutableListOf<SpellCellModel>(
            SpellCellModel(name = "Diffindo", type = "Charm"),
            SpellCellModel(name = "Vingardio Leviosa", type = "Spell"),
            SpellCellModel(name = "Avada Kedavra", type = "Curse"),
            SpellCellModel(name = "Oblivios", type = "Jinx"),
            SpellCellModel(name = "Leoso", type = "Charm"),
            SpellCellModel(name = "Vingardio Maina", type = "Spell"),
            SpellCellModel(name = "Avada Feeria", type = "Curse"),
            SpellCellModel(name = "Obliviatte", type = "Jinx")
        )
    }

    private val _filters = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
    private val _spellsDisplay = MutableLiveData<MutableList<SpellCellModel>>().apply {
        value = ArrayList()
    }

    val spellsDisplay: LiveData<MutableList<SpellCellModel>> = _spellsDisplay

    init {
        _spellsDisplay.postValue(_spells.value)
    }

    fun pressFilter(type: String, isSelected: Boolean) {
        if (isSelected) {
            _filters.value?.add(type)
        } else {
            _filters.value?.remove(type)
        }

        if (_filters.value?.isEmpty() == true) {
            _spellsDisplay.postValue(_spells.value)
            return
        }
        _spellsDisplay.postValue(_spells.value?.filter {
            _filters.value?.contains(it.type) ?: false
        }?.toMutableList())
    }

}