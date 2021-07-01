package by.kos.hogwartsinfo.domain.repositories


import by.kos.hogwartsinfo.domain.models.SpellModel
import kotlinx.coroutines.delay

class SpellRepositoryImpl: SpellRepository {
    override suspend fun getAllSpells(): List<SpellModel> {
        delay(500)
        return listOf(
            SpellModel(name = "Diffindo", type = "Charm"),
            SpellModel(name = "Vingardio Leviosa", type = "Spell"),
            SpellModel(name = "Avada Kedavra", type = "Curse"),
            SpellModel(name = "Oblivios", type = "Jinx"),
            SpellModel(name = "Leoso", type = "Charm"),
            SpellModel(name = "Vingardio Maina", type = "Spell"),
            SpellModel(name = "Avada Feeria", type = "Curse"),
            SpellModel(name = "Obliviatte", type = "Jinx")
        )
    }
    }
