package by.kos.hogwartsinfo.domain.repositories

import android.net.Uri
import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.domain.models.StudentModel
import kotlinx.coroutines.delay

class StudentRepositoryImpl: StudentRepository {
    override suspend fun fetchStudents(): List<StudentModel> {
        delay(2000)
        return listOf(
            StudentModel(
                id = 0,
                name = "Drako Malfoy",
                facultyName = "Slytherin",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            ),
            StudentModel(
                id = 1,
                name = "Hermione Granjer",
                facultyName = "Griffindor",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            ),
            StudentModel(
                id = 2,
                name = "Sedric Diggery",
                facultyName = "Ravenclaw",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            )
        )
    }
}