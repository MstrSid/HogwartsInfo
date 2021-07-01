package by.kos.hogwartsinfo.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterRemote(
    val name: String = "",
    val species: String = "",
    val gender: String = "",
    val house: String = "",
    val dateOfBirth: String = "",
    val yearOfBirth: String = "",
    val ancestry: String = "",
    val eyeColour: String = "",
    val hairColour: String = "",
    val wand: Map<String, String> = mapOf(),
    val patronus: String = "",
    val hogwartsStudent: Boolean = false,
    val hogwartsStaff: Boolean = false,
    val actor: String = "",
    val alive: Boolean = false,
    val image: String = ""
)