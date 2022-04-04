package com.example.myappformulario.database.daos

import androidx.room.*
import com.example.myappformulario.database.entities.CustomersEntity

@Dao
interface CustomersDao {

    @Query("SELECT * FROM CustomersEntity WHERE id like :id ORDER BY cName1 DESC")
    suspend fun getAllCustomers(id: String): List<CustomersEntity>

    @Query("SELECT * FROM CustomersEntity WHERE cDocument like :document")
    suspend fun getDocuentCustomer(document: Int): CustomersEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(listCustomers: CustomersEntity)

    @Query("DELETE FROM CustomersEntity WHERE cDocument like:document")
    suspend fun deleteCustomers(document: Int)

    @Query("UPDATE CustomersEntity SET cName1 =:name WHERE cId=:cid")
    suspend fun updateNameCustomer(name: String, cid: Int)

    @Query("UPDATE CustomersEntity SET cNmae2 =:name2 WHERE cId=:cid")
    suspend fun updateName2Customer(name2: String, cid: Int)

    @Query("UPDATE CustomersEntity SET cLastName1 =:apellido1 WHERE cId=:cid")
    suspend fun updateApellido1Customer(apellido1: String, cid: Int)

    @Query("UPDATE CustomersEntity SET cLastName2 =:apellido2 WHERE cId=:cid")
    suspend fun updateApellido2Customer(apellido2: String, cid: Int)

}