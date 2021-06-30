package by.kos.hogwartsinfo.domain.repositories

import by.kos.hogwartsinfo.R
import by.kos.hogwartsinfo.domain.models.StuffModel
import kotlinx.coroutines.delay

class StuffRepositoryImpl: StuffRepository {
    override suspend fun fetchStuffs(): List<StuffModel> {
        delay(500)
        return listOf(
            StuffModel(
                id = 0,
                name = "Albus Domblledore",
                facultyName = "Griffindor",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            ),
            StuffModel(
                id = 1,
                name = "Silverus Snape",
                facultyName = "Slytherin",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            ),
            StuffModel(
                id = 2,
                name = "Filius Flitwick",
                facultyName = "Ravenclaw",
                image = "android.resource://by.kos.hogwartsinfo/"+ R.drawable.person
            )
        )
    }
}