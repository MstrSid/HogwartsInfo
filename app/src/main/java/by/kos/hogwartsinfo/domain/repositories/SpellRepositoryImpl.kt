package by.kos.hogwartsinfo.domain.repositories


import by.kos.hogwartsinfo.data.network.RetrofitFactory
import by.kos.hogwartsinfo.domain.models.SpellModel
import by.kos.hogwartsinfo.domain.models.toMapModel

class SpellRepositoryImpl : SpellRepository {
    override suspend fun getAllSpells(): List<SpellModel>? {
        return try {
            RetrofitFactory.instance.spellsService.getAllSpells().map {
                it.toMapModel()
            }
        } catch (e: Exception) {
            null
        }
    }
}
