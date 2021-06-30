package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.FacultyModel

interface HatRepository {
    suspend fun generateFaculty(userName: String): FacultyModel
}