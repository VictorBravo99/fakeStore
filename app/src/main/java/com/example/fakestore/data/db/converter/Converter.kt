package com.example.fakestore.data.db.converter

import androidx.room.TypeConverter
import com.example.fakestore.data.db.entity.ProductEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converter {

    @TypeConverter
    fun toCategory(jsonElement: ProductEntity.Category ): String {
        return Json.encodeToString(jsonElement)
    }

    @TypeConverter
    fun parseStringToCategory(text:String): ProductEntity.Category {
        return Json.decodeFromString<ProductEntity.Category>(text)
    }

    @TypeConverter
    fun toImages(jsonElement: List<String> ): String {
        return Json.encodeToString(jsonElement)
    }

    @TypeConverter
    fun parseStringToImages(text:String): List<String> {
        return Json.decodeFromString<List<String>>(text)
    }
}