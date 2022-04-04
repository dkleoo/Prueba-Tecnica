package com.example.myappformulario.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "CustomersEntity")
data class CustomersEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cId") val cid:Int,
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "cDocument")val cDocument:Int,
    @ColumnInfo(name = "cName1")val cName1:String,
    @ColumnInfo(name = "cNmae2")val cNmae2:String,
    @ColumnInfo(name = "cLastName1")val cLastName1:String,
    @ColumnInfo(name = "cLastName2")val cLastName2:String,
    @ColumnInfo(name = "isSync")val isSync:Int
)
