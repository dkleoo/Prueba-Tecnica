package com.example.myappformulario.iu.login

import android.text.Editable
import android.util.Log
import com.example.myappformulario.database.CustomersDatabase
import com.example.myappformulario.database.entities.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserRepositori @Inject constructor(private val db: CustomersDatabase) {

    suspend fun getUser(name: String): List<UserEntity> {
        return withContext(Dispatchers.IO) {
            val User = db.getUser().getUserName(name)
            User
        }
    }


    suspend fun setUser(name: String, passWord: String) {
        withContext(Dispatchers.IO) {
            db.getUser().insertUser(
                UserEntity(
                    0,
                    name,
                    passWord
                )
            )
        }
    }

    suspend fun getUserRegist(name: String,passWord: String): UserEntity{
        return withContext(Dispatchers.IO) {
            val UserRegist = db.getUser().getUserNameRegister(name,passWord)
            UserRegist
        }
    }
}