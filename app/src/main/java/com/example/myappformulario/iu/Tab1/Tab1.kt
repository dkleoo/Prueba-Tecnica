package com.example.myappformulario.iu.Tab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappformulario.adapter.ItemLIstCustomers
import com.example.myappformulario.databinding.ActivityTab1Binding
import com.example.myappformulario.iu.Tab1.Tab2.Tab2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Tab1 : AppCompatActivity() {

    private lateinit var binding:ActivityTab1Binding
    private val viewModel:CustomersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTab1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()
        inicialite()
    }

    override fun onPause() {
        finish()
        super.onPause()
    }


    private fun inicialite() {
        var date = intent.extras?.get("id").toString()
        System.out.println(date)
        viewModel.getListcustomers(date)

        binding.btnNewCustomers.setOnClickListener {
            val i = Intent(this, Tab2::class.java)
            i.putExtra("id",date)
            startActivity(i)
        }
    }


    fun observers(){
        viewModel.listCustomers.observe(this){
            if(it.isEmpty()){
                binding.ListCustomers.visibility = View.GONE
                binding.txtList.visibility = View.VISIBLE
            }else{
                binding.ListCustomers.visibility = View.VISIBLE
                binding.txtList.visibility = View.GONE
                binding.ListCustomers.layoutManager = LinearLayoutManager(this)
                val adapter = ItemLIstCustomers()
                binding.ListCustomers.adapter = adapter
                adapter.submitList(it)
            }
        }
    }


}