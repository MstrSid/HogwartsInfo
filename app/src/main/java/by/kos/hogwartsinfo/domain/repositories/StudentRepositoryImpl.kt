package by.kos.hogwartsinfo.domain.repositories

import android.net.Uri
import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.data.network.RetrofitFactory
import by.kos.hogwartsinfo.domain.models.StudentModel
import by.kos.hogwartsinfo.domain.models.mapToModel
import kotlinx.coroutines.delay
import retrofit2.Retrofit

class StudentRepositoryImpl: StudentRepository {
    override suspend fun fetchStudents(): List<StudentModel> {
       return RetrofitFactory.instance.charactersService.getAllCharacters().map {
           it.mapToModel()
       }
    }
}