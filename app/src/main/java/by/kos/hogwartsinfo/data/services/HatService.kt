package by.kos.hogwartsinfo.data.services

import retrofit2.http.GET

interface HatService {
    @GET("sortingHat")
    suspend fun getHouse():String
}