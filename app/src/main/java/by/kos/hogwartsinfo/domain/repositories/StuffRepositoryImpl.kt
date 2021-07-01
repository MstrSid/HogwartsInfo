package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.data.network.RetrofitFactory
import by.kos.hogwartsinfo.domain.models.StuffModel
import by.kos.hogwartsinfo.domain.models.toMapModel

class StuffRepositoryImpl: StuffRepository {
    override suspend fun fetchStuffs(): List<StuffModel>? {
       return try {
           RetrofitFactory.instance.charactersStaffsService.getAllCharacters().map {
               it.toMapModel()
           }
       } catch (e: Exception){
           null
       }
    }
}