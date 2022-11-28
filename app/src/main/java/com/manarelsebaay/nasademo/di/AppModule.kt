package com.manarelsebaay.nasademo.di

import com.manarelsebaay.nasademo.core.utils.BASE_URL
import com.manarelsebaay.nasademo.core.utils.DefaultDispatcherProvider
import com.manarelsebaay.nasademo.core.utils.DispatcherProvider
import com.manarelsebaay.nasademo.data.remote.NasaApi
import com.manarelsebaay.nasademo.data.repository.NasaRepositoryImpl
import com.manarelsebaay.nasademo.domain.repository.NasaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNasaApi(): NasaApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarsPhotosRepository(api: NasaApi): NasaRepository {
        return NasaRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()
}