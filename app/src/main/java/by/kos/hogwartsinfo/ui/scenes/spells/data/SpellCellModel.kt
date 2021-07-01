package by.kos.hogwartsinfo.ui.scenes.spells.data

import by.kos.hogwartsinfo.domain.models.SpellModel

data class SpellCellModel(val name: String, val type: String?)

fun SpellModel.mapToUI(): SpellCellModel{
    return SpellCellModel(
        name = this.name,
        type = this.type
    )
}