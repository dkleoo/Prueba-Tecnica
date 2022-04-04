package com.example.myappformulario.iu.login.FormularioUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myappformulario.databinding.ActivityFormularioUsuarioBinding
import com.example.myappformulario.iu.login.LoginActivity
import com.example.myappformulario.iu.login.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FormularioUsuario : AppCompatActivity() {

    private lateinit var binding:ActivityFormularioUsuarioBinding
    private val viewModelUser:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()
        inicialite()
    }

    private fun inicialite() {

        binding.btnRegistrado.setOnClickListener {

            if(binding.txtName.text.isNullOrEmpty() || binding.txtPaswword.text.isNullOrEmpty()){
                Toast.makeText(applicationContext,"Debes registrar un Usuario y contraseña",Toast.LENGTH_SHORT).show()
            }else{
                val name = binding.txtName.text.toString()
                viewModelUser.getUser(name)
                binding.btnRegistrado.isEnabled = true
            }

        }
    }

    fun observers(){

        viewModelUser.User.observe(this){

            if(it.isNullOrEmpty()){
                viewModelUser.insertUser(binding.txtName.text.toString(),binding.txtPaswword.text.toString())
                Toast.makeText(applicationContext,"Usuario Creado Correctamente",Toast.LENGTH_SHORT).show()
                val i = Intent(this,LoginActivity::class.java)
                startActivity(i)
            }else{
                Toast.makeText(applicationContext,"Este usuario Ya se encuentra en nuestra base de datos",Toast.LENGTH_SHORT).show()
            }

        }
    }
}