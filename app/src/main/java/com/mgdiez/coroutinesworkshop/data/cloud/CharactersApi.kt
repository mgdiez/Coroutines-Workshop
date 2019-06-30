package com.mgdiez.coroutinesworkshop.data.cloud

import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharacterDto
import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharactersDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {

    @GET("character/")
    fun getCharacters(@Query("page") page: Int): Single<CharactersDto>

    @GET("character/{id}")
    fun getCharacterById(@Path("id") id: Int): Single<CharacterDto>
}
