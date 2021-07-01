package by.kos.hogwartsinfo.data.services

import by.kos.hogwartsinfo.data.models.SpellRemote
import retrofit2.http.GET

interface SpellsService {
    @GET("./all")
    suspend fun getAllSpells(): List<SpellRemote>
}