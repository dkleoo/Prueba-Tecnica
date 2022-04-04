package com.example.myappformulario.iu.Tab2.PhoneCustomer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.myappformulario.databinding.FragmentPhoneCustomersBinding
import com.example.myappformulario.iu.Tab2.Tab2Edit
import com.example.myappformulario.iu.Tab2.tab2ViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhoneCustomers @Inject constructor(private val tab2:Tab2Edit) : DialogFragment() {

    private lateinit var binding:FragmentPhoneCustomersBinding

    private val viewModel:tab2ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observer()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhoneCustomersBinding.inflate(layoutInflater)
        inicialite()
        return binding.root
    }

    private fun inicialite() {

        binding.btnPhone.setOnClickListener {
            viewModel.getPhone(tab2.id)
            val phone1 = binding.phone1.text.toString()
            val phone2 = binding.phone2.text.toString()
            val phone3 = binding.phone3.text.toString()
            System.out.println(tab2.id)
            System.out.println(tab2.document)
            if(!phone1.isEmpty()){
                viewModel.inserPhone(phone1,tab2.id.toInt())
                Toast.makeText(context,"El telefono $phone1 fue agregado al cliente ${tab2.document}",Toast.LENGTH_SHORT).show()
                viewModel.inertLog("El telefono $phone1 fue agregado al cliente ${tab2.document}")
                dismiss()
            }
            if(!phone2.isEmpty()){
                viewModel.inserPhone(phone2, tab2.id.toInt())
                Toast.makeText(context,"El telefono $phone2 fue agregado al cliente ${tab2.document}",Toast.LENGTH_SHORT).show()
                viewModel.inertLog("El telefono $phone1 fue agregado al cliente ${tab2.document}")
                dismiss()
            }
            if(!phone3.isEmpty()){
                viewModel.inserPhone(phone3, tab2.id.toInt())
                Toast.makeText(context,"El telefono $phone3 fue agregado al cliente ${tab2.document}",Toast.LENGTH_SHORT).show()
                viewModel.inertLog("El telefono $phone1 fue agregado al cliente ${tab2.document}")
                dismiss()
            }
        }
    }

    fun observer(){
        viewModel.listPhone.observe(this){
            if(it != null){
                binding.phone1.setText(it.cpPhone)
            }
        }
    }


}