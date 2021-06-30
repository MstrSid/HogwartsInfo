package by.kos.hogwartsinfo.ui.scenes.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.hogwartsinfo.domain.repositories.HatRepository
import by.kos.hogwartsinfo.domain.repositories.HatRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HatViewModel : ViewModel() {
    private var hatRepository: HatRepository = HatRepositoryImpl()
    private var _isLoading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    private var _facultyName: MutableLiveData<String> =
        MutableLiveData<String>().apply { value = "" }
    private var _userName: MutableLiveData<String> = MutableLiveData<String>().apply { value = "" }

    val facultyName: LiveData<String> = _facultyName
    val isLoading: LiveData<Boolean> = _isLoading

    fun applyUserName(name: String){
        _userName.postValue(name)
    }

    fun getFacultyName() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                delay(2000)
                _facultyName.postValue(
                    hatRepository.generateFaculty(
                        userName = _userName.value?:""
                    ).name
                )
                _isLoading.postValue(false)
            }
        }
    }
}