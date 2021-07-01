package by.kos.hogwartsinfo.domain.models

import by.kos.hogwartsinfo.data.models.CharacterStaffsRemote

data class StuffModel(val name: String, val house: String, val ancestry: String, val image: String)

fun CharacterStaffsRemote.toMapModel(): StuffModel{
    return StuffModel(
        name = this.name,
        house = this.house,
        ancestry = this.ancestry,
        image = this.image
    )
}