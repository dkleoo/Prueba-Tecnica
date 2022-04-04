package com.example.myappformulario.iu.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myappformulario.database.entities.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repositori: UserRepositori) :
    ViewModel() {

    val User = MutableLiveData<List<UserEntity>>()
    val UserRegist = MutableLiveData<UserEntity>()

    fun getUser(name: String) {
        viewModelScope.launch {
            val user = repositori.getUser(name)
            User.postValue(user)
        }
    }


    fun insertUser(name: String, passWord: String) {
        viewModelScope.launch {
            repositori.setUser(name,passWord)
        }
    }

    fun getUserRegist(name:String,passWord:String){
        viewModelScope.launch {
            val userRegist = repositori.getUserRegist(name,passWord)
            UserRegist.postValue(userRegist)
        }
    }

}

