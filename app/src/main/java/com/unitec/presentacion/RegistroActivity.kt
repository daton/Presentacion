package com.unitec.presentacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

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
            //Lo imprimios en el log cat
            Log.i(
                "XX",
                " el usuario es ${usuario.nombre} su edad es ${usuario.edad} y su email ${usuario.email}"
            )
        }
    }
}