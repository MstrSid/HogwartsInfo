package by.kos.hogwartsinfo.data.services

import by.kos.hogwartsinfo.data.models.CharacterStudentRemote
import retrofit2.http.GET

interface CharactersStudentsService {
    @GET("students")
    suspend fun getAllCharacters(): List<CharacterStudentRemote>
}