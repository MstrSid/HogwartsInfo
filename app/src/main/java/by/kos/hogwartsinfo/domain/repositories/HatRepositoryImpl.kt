package by.kos.hogwartsinfo.domain.repositories

import android.widget.Toast
import by.kos.hogwartsinfo.domain.models.FacultyModel

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(userName: String): FacultyModel {
            return if (userName.lowercase().trim() == "harry potter") {
                FacultyModel(name = "Griffindor")
            } else FacultyModel(name = "Slytherin")
        }
}