package by.kos.hogwartsinfo.ui.scenes.stuff

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.hogwartsinfo.domain.models.StuffModel
import by.kos.hogwartsinfo.domain.repositories.StuffRepository
import by.kos.hogwartsinfo.domain.repositories.StuffRepositoryImpl
import by.kos.hogwartsinfo.ui.scenes.stuff.data.StuffCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StuffViewModel : ViewModel() {

    private val stuffRepository: StuffRepository = StuffRepositoryImpl()

    private val _stuffs = MutableLiveData<List<StuffCellModel>>().apply {
        value = ArrayList()
    }
    private var _isLoading =
        MutableLiveData<Boolean>().apply { value = false }

    val stuffs: LiveData<List<StuffCellModel>> = _stuffs
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchStuffs(){
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO){
                val stuffs =  stuffRepository.fetchStuffs()
                _isLoading.postValue(false)
                _stuffs.postValue(stuffs.map {
                    StuffCellModel(
                        id = it.id,
                        name = it.name,
                        facultyName = it.facultyName,
                        image = it.image
                    )
                })
            }
        }
    }
}