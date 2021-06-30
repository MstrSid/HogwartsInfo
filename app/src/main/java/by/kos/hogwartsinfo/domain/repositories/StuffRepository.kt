package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.domain.models.StuffModel

interface StuffRepository {
    suspend fun fetchStuffs():List<StuffModel>
}