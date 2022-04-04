package com.example.myappformulario.iu.Tab2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappformulario.database.entities.CustomersEntity
import com.example.myappformulario.database.entities.CustomersPhoneEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class tab2ViewModel @Inject constructor( private val repositori:Tab2Repositori) :ViewModel() {

    val customerDocument = MutableLiveData<CustomersEntity>()
    val listPhone = MutableLiveData<CustomersPhoneEntity>()

    fun getCustomerDocument(document: String) {
        viewModelScope.launch (Dispatchers.IO){
            val customer = repositori.getCustomers(document)
            customerDocument.postValue(customer)
        }
    }

    fun deleteUserCustomer(cDocument: Int) {
        viewModelScope.launch (Dispatchers.IO){
            repositori.deleteCustomer(cDocument)
        }
    }

    fun updateCustomers(name: String, cid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositori.updateCustomer(name,cid)
        }
    }
    fun updateName2Customers(name2: String, cid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositori.updateName2Customer(name2,cid)
        }
    }
    fun updateApellidoCustomers(apellido: String, cid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositori.updateApellidoCustomer(apellido,cid)
        }
    }
    fun updateApellido2Customers(apellido2:String, cid: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositori.updateApellido2Customer(apellido2,cid)
        }
    }

    fun inserPhone(phone1: String, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repositori.customerPhone(phone1,id)
        }
    }


    fun getPhone(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val phone = repositori.getPhone(id)
            listPhone.postValue(phone)
        }
    }

    fun inertLog(descripcion:String){
        viewModelScope.launch(Dispatchers.IO) {
            repositori.inertLog(descripcion)
        }
    }
}