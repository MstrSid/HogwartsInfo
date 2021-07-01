package by.kos.hogwartsinfo.ui.scenes.students.data

import by.kos.hogwartsinfo.domain.models.StudentModel

data class StudentCellModel(val name: String, val house: String, val ancestry: String, val image: String)

fun StudentModel.mapToUI(): StudentCellModel {
    return StudentCellModel(
        name = this.name,
        house = this.house,
        ancestry = this.ancestry,
        image = this.image
    )
}