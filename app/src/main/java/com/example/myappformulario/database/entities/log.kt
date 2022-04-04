package com.example.myappformulario.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "logEntity")
data class logEntity(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "LogId") val LogId:Int,
        @ColumnInfo(name = "LogDate") val LogDate:String,
        @ColumnInfo(name = "LogDescripcion") val LogDescripcion:String,

)