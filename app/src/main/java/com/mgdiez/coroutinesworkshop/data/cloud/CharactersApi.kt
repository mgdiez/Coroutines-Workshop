package com.mgdiez.coroutinesworkshop.data.cloud

import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharacterDto
import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {

    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterDto
}
