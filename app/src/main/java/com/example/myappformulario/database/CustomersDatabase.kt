package com.example.myappformulario.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myappformulario.database.daos.CustomerPhoneDao
import com.example.myappformulario.database.daos.CustomersDao
import com.example.myappformulario.database.daos.LogDao
import com.example.myappformulario.database.daos.UsersDao
import com.example.myappformulario.database.entities.CustomersEntity
import com.example.myappformulario.database.entities.CustomersPhoneEntity
import com.example.myappformulario.database.entities.UserEntity
import com.example.myappformulario.database.entities.logEntity


@Database(
    entities = [
        CustomersEntity::class,
        CustomersPhoneEntity::class,
        logEntity::class,
        UserEntity::class
    ], version = 1
)
abstract class CustomersDatabase: RoomDatabase() {

    abstract fun getCustomerDao():CustomersDao
    abstract fun getCustomerPhoneDao():CustomerPhoneDao
    abstract fun getLogDao():LogDao
    abstract fun getUser():UsersDao
}