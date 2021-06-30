package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.StudentModel

interface StudentRepository {
    suspend fun fetchStudents():List<StudentModel>
}