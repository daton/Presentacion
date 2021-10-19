package com.unitec.presentacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.widget.Button
import android.widget.Toast

import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //Vamos a quitar la barrita superior porque no se recomienda en la pantalla inicial
        supportActionBar?.hide()

        //En android  podemos interaccionar con servicios de hardware como por ejemplo el sistema de vibracion
      var vibrador= getSystemService(VIBRATOR_SERVICE) as Vibrator
        var x:Int
        var y:Float
        var z:String 
        // Invocamos el metodo vibrate
        vibrador.vibrate(4000)

        // Vamos a invocar aqui en el Presenter(MainActivity)  nuestro boton por medio
        //del id
        var btnIngresar=     findViewById<Button>(R.id.ingresar)

        //El manejo de eventos en kotlin se da por medio de un nuevo elemento
        // de programacion que se conoce como lambdas o programacion funcional
        //Una lambda no es otra cosa que una funcion o metodo sin nombre.
        btnIngresar.setOnClickListener {
          //Lanzamos un mensajito tipo Toast
         //Estas variables son simplemente para explicar algunas conceptos de kotlin
         //DEclaracion: de variables
            var x:Int
            var y:Float
            var mensaje:String
            //Las siguientes son validas tambien
            var z=23
            var w:Int=43
            //Si queremos declarar un valor constante en lugar de var usamos val
            val a=23
            val b:Int=23
            // Incorrecto reasignar valores: a=12
            //La concatenacion ya no se usa en kotlin, aunque la acepta se usa en su lugar la interpolacion
            var precio=24.5f
            //Concatenacion
            var mensajito= "El precio es "+precio+ " de los chocolates"
            //Interpolacion
            var mensajito2="El precio es $precio de los chocolate"
            /***************************************************************************************
             CONCEPTO IMPORTANTE:(PREGUNTA DE EXAMEN)
             KOTLIN ES UN LENGUAJE FUNCIONAL, ESTO IMPLICA QUE LAS FUNCIONES SON UN TIPO DE DATO
             Y SON TRATADAS COMO TALES, ES DECIR COMO UN TIPO DE DATO O VARIABLE

            ***************************************************************************************/
            fun sumar( primero:Int,segundo:Int ):Int{
                return primero+segundo
            }

            var mensaje3="La suma es ${sumar(4,5)} y ese es el resultado"

          //A continuacion vamos a ver la misma funcion pero con lambdas y aqui se ve que es una vaiable
           var Asumar={a:Int, b:Int->a+b}

            var mensaje4="La suma es ${Asumar(4,5)}  y esa es la suma pero on lambda"


            Toast.makeText(this,mensaje4,Toast.LENGTH_LONG).show()
         //Codio para navegar de una activity a otra
           var i = Intent(this, RegistroActivity::class.java)
           startActivity(i)

        }
        //Aqui estamos fuera del clickeo del boton
        /*****************************************************************************************
         *  En Android es muy importante saber debugear o depurar, como depuracion entendemos analizar
         *  la logica ANTES de que la podamos ver en la pantalla de la app. para asegurarnos de que
         *  estamos haciendo las cosas bien.
         *  En android usamos una clase que se llama Log
         *
         *****************************************************************************************/
        Log.i("HOLA","este es un mensajito de depuracion con la ventana de INFO")

    }
}