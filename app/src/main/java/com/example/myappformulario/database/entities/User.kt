package com.example.myappformulario.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserEntity")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "UserName") val userName:String,
    @ColumnInfo(name = "UserPassword") val userPassword:String,

)
