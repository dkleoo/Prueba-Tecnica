package com.example.myappformulario.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CustomersPhoneEntity")
data class CustomersPhoneEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cId") val cId:Int,
    @ColumnInfo(name = "cpId") val cpId:Int,
    @ColumnInfo(name = "cpPhone") val cpPhone:String,
)
