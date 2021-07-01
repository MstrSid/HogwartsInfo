package by.kos.hogwartsinfo.data.network

import by.kos.hogwartsinfo.data.services.CharactersStaffsService
import by.kos.hogwartsinfo.data.services.CharactersStudentsService
import by.kos.hogwartsinfo.data.services.SpellsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitFactory {

    companion object {
        val instance = RetrofitFactory()
    }

    private fun okHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(okHttpInterceptor())
        .build()

    private val retrofitClientCharactersStudents: Retrofit = Retrofit.Builder()
        .baseUrl("https://hp-api.herokuapp.com/api/characters/")
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitClientCharactersStaffs: Retrofit = Retrofit.Builder()
        .baseUrl("https://hp-api.herokuapp.com/api/characters/")
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitClientSpells: Retrofit = Retrofit.Builder()
        .baseUrl("https://the-harry-potter-database.herokuapp.com/api/1/spells/")
        .client(okHttpClient)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    val charactersStudentsService: CharactersStudentsService =
        retrofitClientCharactersStudents.create(CharactersStudentsService::class.java)
    val charactersStaffsService: CharactersStaffsService =
        retrofitClientCharactersStaffs.create(CharactersStaffsService::class.java)
    val spellsService: SpellsService = retrofitClientSpells.create(SpellsService::class.java)
}