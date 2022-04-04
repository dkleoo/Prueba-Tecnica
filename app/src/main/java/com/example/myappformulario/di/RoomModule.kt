package com.example.myappformulario.di

import android.content.Context
import androidx.room.Room
import com.example.myappformulario.database.CustomersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun providerRom(@ApplicationContext context: Context) = Room.databaseBuilder(context, CustomersDatabase::class.java, "CustomersDb").build()

}