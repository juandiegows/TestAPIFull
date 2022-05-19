package com.example.testapifull.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapifull.Servicios.CRUD
import com.example.testapifull.Servicios.GeneroDAO
import com.example.testapifull.Servicios.UserDAO
import com.example.testapifull.model.Genero
import com.example.testapifull.model.User

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun Init(opc:Int){
      if(opc==1){
          _text.value= UserDAO().Get()

      }else{
          _text.value= GeneroDAO().Get()
      }
    }
}