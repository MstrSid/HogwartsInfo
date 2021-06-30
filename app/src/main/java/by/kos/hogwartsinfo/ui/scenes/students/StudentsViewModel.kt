package by.kos.hogwartsinfo.ui.scenes.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.kos.hogwartsinfo.domain.repositories.StudentRepository
import by.kos.hogwartsinfo.domain.repositories.StudentRepositoryImpl
import by.kos.hogwartsinfo.ui.scenes.students.data.StudentCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel : ViewModel() {

    private val studentRepository: StudentRepository = StudentRepositoryImpl()

    private val _students =
        MutableLiveData<List<StudentCellModel>>().apply {
        value = ArrayList()
    }
    private var _isLoading =
        MutableLiveData<Boolean>().apply { value = false }

    val students: LiveData<List<StudentCellModel>> = _students
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.IO){
                val students = studentRepository.fetchStudents()
                _isLoading.postValue(false)
                _students.postValue(students.map {
                    StudentCellModel(
                        id = it.id,
                        name = it.name,
                        facultyName =  it.facultyName,
                        image = it.image
                    )
                })
            }
        }
    }
}