package com.unitec.presentacion

import retrofit2.Call
import retrofit2.http.GET

interface ServicioUsuario {
    //Aqui se ponen o agregan los paths o rutas de los servicio REST

    //Vamos a agregar los dos mas basicos, el POST y el GET
    @GET("api/usuario")
    fun buscarTodos():Call<ArrayList<Usuario>>

    @
}