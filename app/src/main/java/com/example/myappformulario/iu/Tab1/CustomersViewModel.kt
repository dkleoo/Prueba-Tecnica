package com.example.myappformulario.iu.Tab1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappformulario.database.entities.CustomersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(private val repositori: CustomerRepositori) :
    ViewModel() {

    val listCustomers = MutableLiveData<List<CustomersEntity>>()
    val customerDocument = MutableLiveData<CustomersEntity>()
    val succesInsert = MutableLiveData<Boolean>()

    fun getListcustomers(id: String) {
        viewModelScope.launch {
            val list = repositori.getListCustomers(id)
            listCustomers.postValue(list)
        }
    }

    fun InsertCustomer(
        date: String,
        document: String,
        name: String,
        name2: String,
        apellido: String,
        apellido2: String
    ) {
        viewModelScope.launch {
            val sucess = repositori.insertCustomers(date, document, name, name2, apellido, apellido2)
            succesInsert.postValue(sucess)
        }
    }

    fun getCustomerDocument(document: String) {
        viewModelScope.launch {
            val documentCustomer = repositori.getDocumentCustomer(document)
            customerDocument.postValue(documentCustomer)
        }
    }

    fun insertLog(descripcion:String){
        viewModelScope.launch {
            repositori.inertLog(descripcion)
        }
    }
}