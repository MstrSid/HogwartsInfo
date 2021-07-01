package by.kos.hogwartsinfo.domain.models

import by.kos.hogwartsinfo.data.models.CharacterStudentRemote

data class StudentModel(val name: String, val house: String, val ancestry: String, val image: String)


fun CharacterStudentRemote.mapToModel(): StudentModel{
    return StudentModel(
        name = this.name,
        house = this.house,
        ancestry = this.ancestry,
        image = this.image
    )
}