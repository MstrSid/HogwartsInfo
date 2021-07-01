package by.kos.hogwartsinfo.data.models

import kotlinx.serialization.*
import kotlinx.serialization.json.JsonElement

@Serializable
data class CharacterRemote(
    val name: String = "",
    val species: String = "",
    val gender: String = "",
    val house: String = "",
    val dateOfBirth: String = "",
    val yearOfBirth: JsonElement,
    val ancestry: String = "",
    val eyeColour: String = "",
    val hairColour: String = "",
    val wand :Wand? = null,
    val patronus: String = "",
    val hogwartsStudent: Boolean = false,
    val hogwartsStaff: Boolean = false,
    val actor: String = "",
    val alive: Boolean = false,
    val image: String = ""
)

@Serializable
data class Wand(
    val wood: String,
    val core: String,
    val length: JsonElement
)