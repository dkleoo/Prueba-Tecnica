package com.example.myappformulario.iu.Tab1

import android.util.Log
import com.example.myappformulario.database.CustomersDatabase
import com.example.myappformulario.database.entities.CustomersEntity
import com.example.myappformulario.database.entities.logEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CustomerRepositori @Inject constructor(private val db: CustomersDatabase) {


    suspend fun getListCustomers(id: String): List<CustomersEntity> {
        return withContext(Dispatchers.IO) {
            val list = db.getCustomerDao().getAllCustomers(id)
            Log.i("listado",list.toString())
            list
        }
    }

    suspend fun insertCustomers(
        date: String,
        document: String,
        name: String,
        name2: String,
        apellido: String,
        apellido2: String
    ) {
         withContext(Dispatchers.IO) {
            val customer = db.getCustomerDao().insertAll(CustomersEntity(0, date.toInt(), document.toInt(), name, name2, apellido, apellido2, 0))
            customer
        }
    }

    suspend fun getDocumentCustomer(document: String):CustomersEntity {
        return withContext(Dispatchers.IO) {
            val listDocument = db.getCustomerDao().getDocuentCustomer(document.toInt())
            listDocument
        }
    }

    suspend fun inertLog(descripcion:String){
        withContext(Dispatchers.IO){
            db.getLogDao().insertAll(logEntity(
                0,
                descripcion,
                ""
            ))
        }
    }
}