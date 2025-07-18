package com.example.fakestore.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.example.fakestore.data.db.converter.Converter
import com.example.fakestore.data.db.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
@TypeConverters(Converter::class)
interface ProductDao {
    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<ProductEntity>)

    @Delete
    fun delete(product: ProductEntity)

    @Query("SELECT * FROM products WHERE id == (:id)")
    fun loadOneByIds(id: Int): Flow<ProductEntity>
    
}