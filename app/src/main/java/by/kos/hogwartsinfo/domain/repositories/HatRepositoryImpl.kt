package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.FacultyModel

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(name: String, surname: String): FacultyModel {
        return if (name == "Harry" && surname == "Potter") {
            FacultyModel(name = "Griffindor")
        } else FacultyModel(name = "Slytherin")
    }
}