package com.unitec.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        //Primero construirmos una interface de usuario con 3 campos de texto
        //Para poder meter los 3 valores y generar un objeto de tipo usuario
       //PEROOOOOO PRIMERO DEPURAMOS A VER SI CREAMOS EL USUARIO CORRECTAMENTE:

        var boton=  findViewById<Button>(R.id.registrarse)
        boton.setOnClickListener {
            var usuario = Usuario()
            //Capturamos lo valores introducidos en los InputEditTet
            var txtNombre = findViewById<TextInputEditText>(R.id.textoNombre).text.toString()
            var txtEmail = findViewById<TextInputEditText>(R.id.textoEmail).text.toString()
            var txtEdad = findViewById<TextInputEditText>(R.id.textoEdad).text.toString().toInt()

            //asinamos los valores

            usuario.edad = txtEdad
            usuario.email = txtEmail
            usuario.nombre = txtNombre

            //Aqui creamos la corutina de envio o conecion al back end debe estar siempre en un Thread separado
            GlobalScope.launch(Dispatchers.IO){
                //REcuerda que este IO es la corutina unicamente para conectarte al Back End, NO PUEDES
                //EN ESTE BLOQUE CODIGO COMO EL DE LOS RENGLOES DE ARRIBA
                //Aqui ya invocamos al servicio
                var retrofit=Retrofit.Builder()
                    .baseUrl("https://jc-amigos.herokuapp.com/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build()
                var servicioUsuario=retrofit.create(ServicioUsuario::class.java)
                var hacerRequest=servicioUsuario.guardar(usuario)
                //invocamos la respuesta del back end
                var estatus=hacerRequest.execute().body()!!

                //Ese estatus lo ponemos en la pantalla es decir en el Thread MAIN
                launch(Dispatchers.Main){
                    Toast.makeText(applicationContext,"Respuesta: ${estatus.mensaje}" , Toast.LENGTH_LONG)
                        .show()
                }
            }

        }
    }
}