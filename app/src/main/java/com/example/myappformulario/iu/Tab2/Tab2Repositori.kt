package com.example.myappformulario.iu.Tab2

import com.example.myappformulario.database.CustomersDatabase
import com.example.myappformulario.database.entities.CustomersEntity
import com.example.myappformulario.database.entities.CustomersPhoneEntity
import com.example.myappformulario.database.entities.logEntity
import com.example.myappformulario.iu.Tab2.PhoneCustomer.PhoneCustomers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Tab2Repositori @Inject constructor(private val db: CustomersDatabase) {


    suspend fun getCustomers(document: String): CustomersEntity {
        return withContext(Dispatchers.IO) {
            val customers = db.getCustomerDao().getDocuentCustomer(document.toInt())
            customers
        }
    }

    suspend fun deleteCustomer(document: Int) {
        withContext(Dispatchers.IO) {
            db.getCustomerDao().deleteCustomers(document)
        }
    }

    suspend fun updateCustomer(name: String, cid: Int): Boolean {
        db.getCustomerDao().updateNameCustomer(name, cid)
        return true
    }

    suspend fun updateName2Customer(name2: String, cid: Int): Boolean {

        db.getCustomerDao().updateName2Customer(name2, cid)
        return true
    }

    suspend fun updateApellidoCustomer(apellido1: String, cid: Int): Boolean {
        db.getCustomerDao().updateApellido1Customer(apellido1, cid)
        return true
    }

    suspend fun updateApellido2Customer(apellido2: String, cid: Int): Boolean {
        db.getCustomerDao().updateApellido2Customer(apellido2, cid)
        return true
    }

    suspend fun customerPhone(phone1: String, id: Int) {
        withContext(Dispatchers.IO) {
            db.getCustomerPhoneDao().insertAll(
                CustomersPhoneEntity(
                    0,
                    id,
                    phone1
                )
            )
        }
    }

    suspend fun getPhone(id: String): CustomersPhoneEntity {
        return withContext(Dispatchers.IO) {
            val listPhone = db.getCustomerPhoneDao().getAllCustomers(id.toInt())
            listPhone
        }
    }

    suspend fun inertLog(descriocion: String) {
        withContext(Dispatchers.IO) {
            db.getLogDao().insertAll(
                logEntity(
                    0,
                    descriocion,
                    ""
                )
            )
        }
    }

}