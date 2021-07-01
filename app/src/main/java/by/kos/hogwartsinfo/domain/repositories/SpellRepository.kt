package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.SpellModel

interface SpellRepository {
    suspend fun getAllSpells():List<SpellModel>?
}