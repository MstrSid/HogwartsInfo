package by.kos.hogwartsinfo.data.services

import by.kos.hogwartsinfo.data.models.CharacterRemote
import retrofit2.http.GET

interface CharactersStudentsService {
    @GET("students")
    suspend fun getAllCharacters(): List<CharacterRemote>
}