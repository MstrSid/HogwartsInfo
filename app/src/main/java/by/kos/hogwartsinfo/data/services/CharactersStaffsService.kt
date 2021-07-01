package by.kos.hogwartsinfo.data.services

import by.kos.hogwartsinfo.data.models.CharacterStaffsRemote
import retrofit2.http.GET

interface CharactersStaffsService {
    @GET("staff")
    suspend fun getAllCharacters(): List<CharacterStaffsRemote>
}