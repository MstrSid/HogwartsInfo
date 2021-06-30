package by.kos.hogwartsinfo.ui.scenes.hat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.hogwartsinfo.domain.repositories.HatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HatViewModel : ViewModel() {
    private lateinit var hatRepository: HatRepository
    private var _isLoading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    private var _facultyName: MutableLiveData<String> =
        MutableLiveData<String>().apply { value = "" }

    val facultyName: LiveData<String> = _facultyName
    val isLoading: LiveData<Boolean> = _isLoading

    fun getFacultyName(name: String, surname: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO) {
                delay(2000)
                if (name == "Harry" && surname == "Potter") {
                    _facultyName.postValue("Griffindor")
                } else _facultyName.postValue("Slytherin")
                _isLoading.postValue(false)
            }
        }
    }
}