package by.kos.hogwartsinfo.domain.repositories

interface HatRepository {
    suspend fun generateFaculty(name: String, surname: String): String
}