package com.example.fakestore.di.modules

import android.content.Context
import androidx.room.Room
import com.example.fakestore.data.db.database.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    const val DATABASE_NAME = "fakeStore"

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DataBase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration(false)
            .build()
    @Provides
    @Singleton
    fun provideProductDao(db: DataBase) = db.productDao()


}