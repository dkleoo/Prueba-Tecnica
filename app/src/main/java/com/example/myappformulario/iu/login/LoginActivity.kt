package com.example.myappformulario.iu.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.myappformulario.databinding.ActivityLogin2Binding
import com.example.myappformulario.iu.Tab1.Tab1
import com.example.myappformulario.iu.login.FormularioUser.FormularioUsuario
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogin2Binding
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
        inicialite()
    }

    private fun inicialite() {

        binding.btnInit.setOnClickListener {

            if (binding.txtUserName.text.isNullOrEmpty() || binding.txtUserPassword.text.isNullOrEmpty()) {
                Toast.makeText(applicationContext, "Debes escribir tu Usuario y Contraseña", Toast.LENGTH_SHORT).show()
            } else {
                val name = binding.txtUserName.text.toString()
                val passWord = binding.txtUserPassword.text.toString()
                viewModel.getUserRegist(name, passWord)
            }
        }

        binding.btnRegist.setOnClickListener {
            val i: Intent = Intent(this, FormularioUsuario::class.java)
            startActivity(i)
        }
    }

    fun observer() {

        viewModel.UserRegist.observe(this) {

            if (it != null) {
                val i = Intent(this, Tab1::class.java)
                i.putExtra("id",it.id)
                startActivity(i)
            } else {
                Toast.makeText(applicationContext, "Usuario o Contraseña Incorrectas", Toast.LENGTH_SHORT).show()
            }

        }

    }
    override fun onPause() {
        binding.txtUserName.setText("")
        binding.txtUserPassword.setText("")
        super.onPause()
    }

}