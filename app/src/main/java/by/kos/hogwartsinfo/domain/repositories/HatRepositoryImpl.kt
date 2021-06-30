package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(userName: String): FacultyModel {
        delay(2000)
            return if (userName.lowercase().trim() == "harry potter") {
                FacultyModel(name = "Griffindor")
            } else FacultyModel(name = "Slytherin")
        }
}