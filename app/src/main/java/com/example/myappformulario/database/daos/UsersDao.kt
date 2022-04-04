package com.example.myappformulario.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myappformulario.database.entities.UserEntity


@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user:UserEntity)

    @Query("SELECT * FROM UserEntity WHERE UserName LIKE :NameUser")
    suspend fun getUserName( NameUser:String):List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE UserName LIKE :NameUser AND UserPassword LIKE :UserPassword")
    suspend fun getUserNameRegister( NameUser:String,UserPassword:String):UserEntity

}