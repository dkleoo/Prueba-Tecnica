package com.example.myappformulario.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappformulario.database.entities.logEntity

@Dao
interface LogDao {

    @Query("SELECT * FROM logEntity")
    suspend fun getAllCustomers():List<logEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(listCustomers:logEntity)

}