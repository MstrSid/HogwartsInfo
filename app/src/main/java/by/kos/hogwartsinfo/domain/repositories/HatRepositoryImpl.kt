package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.data.network.RetrofitFactory
import by.kos.hogwartsinfo.domain.models.FacultyModel
import kotlinx.coroutines.delay

class HatRepositoryImpl : HatRepository {
    override suspend fun generateFaculty(userName: String): FacultyModel {
        return FacultyModel(name = RetrofitFactory.instance.retrofitHatService.getHouse())
    }
}