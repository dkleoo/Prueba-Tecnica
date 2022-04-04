package com.example.myappformulario.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappformulario.database.entities.CustomersPhoneEntity


@Dao
interface CustomerPhoneDao {

    @Query("SELECT * FROM CustomersPhoneEntity WHERE cpId like:id")
    suspend fun getAllCustomers(id:Int): CustomersPhoneEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(listCustomers:CustomersPhoneEntity)
}