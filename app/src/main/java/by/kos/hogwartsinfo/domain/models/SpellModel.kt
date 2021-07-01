package by.kos.hogwartsinfo.domain.models

import by.kos.hogwartsinfo.data.models.SpellRemote

data class SpellModel(val name: String, val type: String?)

fun SpellRemote.toMapModel(): SpellModel{
    return SpellModel(
        name = this.name,
        type = this.spell_type
    )
}