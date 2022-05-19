package com.example.testapifull.Servicios

import android.util.Log
import android.widget.TextView
import com.example.testapifull.model.Genero
import com.example.testapifull.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL

open class CRUD(var url: String, var nameClass: String) {
    fun Get(): String {
        var cadena: String = ""

        var oClass = Class.forName(nameClass)
        var a = oClass.newInstance()
        oClass.declaredFields.forEach {
            Log.e("->", it.name)
            cadena += it.name + "\n"
        }
        CoroutineScope(Dispatchers.IO).launch {
            var client = URL(url).openConnection() as HttpURLConnection
            try {
                var i = ""
                val data = client.inputStream.bufferedReader().use {
                    i = it.readText()
                }
                Log.e("getInfo: ", i.toString())
                var list = arrayListOf(a)
                val array = JSONArray(i)
                for (i in 0 until array.length()) {
                    val temp = array.getJSONObject(i)
                    oClass.declaredFields.forEach {
                        it.isAccessible= true

                        it.set(a, temp.get(it.name))
                        Log.e(
                            "Field",
                            "Get: " + it.name + " -> " + temp.get(it.name).toString()
                        )
                    }
                    list.add(a)
                    Log.e("field _> ", (a as Genero).id )
                    Log.e("Cantidad", list.size.toString() )
                    Log.e("->", "__________________________")
                }
                cadena += i
            } catch (e: Exception) {
                client.disconnect()
                e.printStackTrace()
            }
        }

        return cadena
    }
}