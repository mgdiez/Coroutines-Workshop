package com.mgdiez.coroutinesworkshop.data.di

import androidx.room.Room
import com.mgdiez.coroutinesworkshop.data.CharactersDataSource
import com.mgdiez.coroutinesworkshop.data.CharactersLocalSource
import com.mgdiez.coroutinesworkshop.data.cloud.BASE_URL
import com.mgdiez.coroutinesworkshop.data.cloud.CharactersApi
import com.mgdiez.coroutinesworkshop.data.cloud.CharactersCloudDataSource
import com.mgdiez.coroutinesworkshop.data.local.CharactersLocalDataSource
import com.mgdiez.coroutinesworkshop.data.local.database.CHARACTERS_DB
import com.mgdiez.coroutinesworkshop.data.local.database.CharactersDatabase
import com.mgdiez.coroutinesworkshop.data.local.entity.CharactersEntityMapper
import com.mgdiez.coroutinesworkshop.data.mapper.CharactersDtoMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val dataModule = module {
    single<CharactersDataSource> { CharactersCloudDataSource(get(), get()) }
    single<CharactersLocalSource> { CharactersLocalDataSource(get(), get()) }
    single {
        Room.databaseBuilder(
            get(), CharactersDatabase::class.java,
            CHARACTERS_DB
        ).fallbackToDestructiveMigrationFrom(1).build()
    }
    single { CharactersEntityMapper() }
    single { CharactersDtoMapper() }
    single<CharactersApi> { get<Retrofit>().create() }

    single {
        Retrofit.Builder()
            .apply {
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(BASE_URL)
                client(get())
            }
            .build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    factory {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return@factory interceptor
    }
}
