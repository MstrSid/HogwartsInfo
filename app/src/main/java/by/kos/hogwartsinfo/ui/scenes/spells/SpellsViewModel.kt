package by.kos.hogwartsinfo.ui.scenes.spells

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.hogwartsinfo.domain.repositories.SpellRepositoryImpl
import by.kos.hogwartsinfo.ui.scenes.spells.data.SpellCellModel
import by.kos.hogwartsinfo.ui.scenes.spells.data.mapToUI
import by.kos.hogwartsinfo.ui.scenes.stuff.data.mapToUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpellsViewModel : ViewModel() {

    private val spellRepository = SpellRepositoryImpl()

    private val _spells = MutableLiveData<MutableList<SpellCellModel>>().apply {
        value = mutableListOf()
    }

    private val _filters = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf()
    }
    private val _spellsDisplay = MutableLiveData<MutableList<SpellCellModel>>().apply {
        value = ArrayList()
    }

    private var _isLoading =
        MutableLiveData<Boolean>().apply { value = false }

    val isLoading: LiveData<Boolean> = _isLoading

    val spellsDisplay: LiveData<MutableList<SpellCellModel>> = _spellsDisplay
    init {
        fetchSpells()
    }

    private fun fetchSpells() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.Default){
                val spells =  spellRepository.getAllSpells()
                _isLoading.postValue(false)
                    _spells.postValue(spells.map { it.mapToUI() }.toMutableList())
                }
                _spellsDisplay.postValue(_spells.value?:ArrayList())
        }
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