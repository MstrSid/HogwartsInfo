package by.kos.hogwartsinfo.ui.scenes.stuff.data

import by.kos.hogwartsinfo.domain.models.StuffModel

data class StuffCellModel(val name: String, val house: String, val ancestry: String, val image: String)

fun StuffModel.mapToUI(): StuffCellModel {
    return StuffCellModel(
        name = this.name,
        house = this.house,
        ancestry = this.ancestry,
        image = this.image
    )
}