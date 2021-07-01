package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.data.network.RetrofitFactory
import by.kos.hogwartsinfo.domain.models.StudentModel
import by.kos.hogwartsinfo.domain.models.mapToModel

class StudentRepositoryImpl: StudentRepository {
    override suspend fun fetchStudents(): List<StudentModel> {
       return RetrofitFactory.instance.charactersStudentsService.getAllCharacters().map {
           it.mapToModel()
       }
    }
}