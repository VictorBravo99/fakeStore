package com.example.fakestore.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fakestore.data.db.converter.Converter
import com.example.fakestore.data.db.dao.ProductDao
import com.example.fakestore.data.db.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class DataBase: RoomDatabase()  {
    abstract fun productDao(): ProductDao

}