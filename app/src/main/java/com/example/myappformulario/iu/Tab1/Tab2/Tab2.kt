package com.example.myappformulario.iu.Tab1.Tab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myappformulario.databinding.ActivityTab2Binding
import com.example.myappformulario.iu.Tab1.CustomersViewModel
import com.example.myappformulario.iu.Tab1.Tab1
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Tab2 : AppCompatActivity() {

    private lateinit var binding:ActivityTab2Binding
    private val viewModel:CustomersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTab2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        oberver()
        inicialite()
    }
    override fun onPause() {
        finish()
        super.onPause()
    }

    private fun inicialite() {

        binding.back.setOnClickListener {
            val i = Intent(this,Tab1::class.java)
            val date = intent.extras?.get("id").toString()
            i.putExtra("id",date)
            startActivity(i)
        }

        binding.btnNewCustomer.setOnClickListener {

            if(!binding.cDocument.text.isNullOrEmpty()){
                if(!binding.cName.text.isNullOrEmpty() || !binding.cLastName.text.isNullOrEmpty()){
                    val document = binding.cDocument.text.toString()
                    viewModel.getCustomerDocument(document)
                }else{
                    Toast.makeText(applicationContext,"Debes escribir por lo menos el nombre y el apellido del cliente",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext,"Debes digitar el Numero de documento del cliente",Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun oberver(){


        viewModel.customerDocument.observe(this){
            val date = intent.extras?.get("id").toString()
            if(it == null){

                val document = binding.cDocument.text.toString()
                val name = binding.cName.text.toString()
                val name2 = binding.cNameLast.text.toString()
                val apellido = binding.cLastName.text.toString()
                val apellido2 = binding.cLastName2.text.toString()

                viewModel.InsertCustomer(date,document,name,name2,apellido,apellido2)
                Toast.makeText(applicationContext,"El cliente con el numero de documento ${document} Registrado Correctamente",Toast.LENGTH_SHORT).show()
                viewModel.insertLog("El cliente con el numero de documento ${document} Registrado Correctamente")
            }else{
                Toast.makeText(applicationContext,"El cliente con el numero de documento ${it.cDocument} ya se encuentra registrado",Toast.LENGTH_SHORT).show()
            }
        }
    }
}