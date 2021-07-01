package by.kos.hogwartsinfo.data.models

import kotlinx.serialization.Serializable

@Serializable
data class SpellRemote(
    val id: Int,
    val name: String = "",
    val other_name: String = "",
    val pronunciation: String = "",
    val spell_type: String = "",
    val description: String = "",
    val mention: String = "",
    val etymology: String = "",
    val note: String? = ""
)