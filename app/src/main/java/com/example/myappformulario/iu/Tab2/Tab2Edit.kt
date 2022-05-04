package com.example.myappformulario.iu.Tab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import com.example.myappformulario.databinding.ActivityTab2EditBinding
import com.example.myappformulario.iu.Tab1.Tab1
import com.example.myappformulario.iu.Tab1.Tab2.Tab2
import com.example.myappformulario.iu.Tab2.PhoneCustomer.PhoneCustomers
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class Tab2Edit : AppCompatActivity() {

    private lateinit var binding:ActivityTab2EditBinding
    private val viewModel:tab2ViewModel by viewModels()
    private val fragment:PhoneCustomers = PhoneCustomers(this)
    lateinit var id:String
    lateinit var document:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTab2EditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()
        inicialite()
    }

    override fun onPause() {
        finish()
        super.onPause()
    }


    private fun observers() {

        viewModel.editCustomers.observe(this){
            val document = binding.documento.text.toString()
            if(it){
                Toast.makeText(applicationContext,"El Cliente con el numero de Documento $document Editado Correctamente",Toast.LENGTH_SHORT).show()
                val i = Intent(this, Tab1::class.java)
                val date = intent.extras?.get("id").toString()
                i.putExtra("id",date)
                startActivity(i)
            }
        }

        viewModel.customerDocument.observe(this){
            if(it == null){
                Toast.makeText(applicationContext,"El Usuario con el numero de documento ${binding.documento.text.toString()} No existe en la base de datos",Toast.LENGTH_SHORT).show()
            }else{
                viewModel.deleteUserCustomer(it.cDocument)
                Toast.makeText(applicationContext,"El Usuario con el numero de documento ${binding.documento.text.toString()} Se elimino correctamente",Toast.LENGTH_SHORT).show()
                viewModel.inertLog("El Usuario con el numero de documento ${binding.documento.text.toString()} Se elimino correctamente")
                val i = Intent(this, Tab1::class.java)
                val date = intent.extras?.get("id").toString()
                i.putExtra("id",date)
                startActivity(i)
            }
        }

    }

    private fun inicialite() {
        id = intent.extras?.get("id").toString()
        val cid = intent.extras?.get("cid").toString()
        document = intent.extras?.get("document").toString()
        val name1 = intent.extras?.get("name1").toString()
        val name2 = intent.extras?.get("name2").toString()
        val lastLame1 = intent.extras?.get("lastLame1").toString()
        val lastLame2 = intent.extras?.get("lastName2").toString()

        binding.documento.setText(document)
        binding.nombre.setText(name1)
        binding.nombre2.setText(name2)
        binding.apellido.setText(lastLame1)
        binding.apellido2.setText(lastLame2)

        binding.btndelete.setOnClickListener {
            viewModel.getCustomerDocument(document)
        }

        binding.btnEdit.setOnClickListener {

            val name = binding.nombre.text.toString()
            val name2 = binding.nombre2.text.toString()
            val apellido = binding.apellido.text.toString()
            val apellido2 = binding.apellido2.text.toString()

            viewModel.updateCustomers(name,cid.toInt())
            viewModel.updateName2Customers(name2,cid.toInt())
            viewModel.updateApellidoCustomers(apellido,cid.toInt())
            viewModel.updateApellido2Customers(apellido2,cid.toInt())
        }

        binding.back.setOnClickListener {
            val i = Intent(this, Tab1::class.java)
            val date = intent.extras?.get("id").toString()
            i.putExtra("id",date)
            startActivity(i)
        }

        binding.btninserPhone.setOnClickListener {
            fragment.show(supportFragmentManager,"dialogFragment")
        }
    }
}