package es.iessaladillo.pedrojoya.intents.data.local.model

import java.util.*

// TODO: Define las propiedades de un pokemon
class Pokemon(fuerza:Int,nombre:String,imagen:Int,id:Long) {

    private var fuerza: Int = fuerza
    private var nombre: String = nombre
    private var imagen: Int = imagen
    private var id:Long=id
    fun getImagen():Int{
        return imagen
    }
    fun getFuerza():Int{
        return fuerza
    }
    fun getNombre():String{
        return nombre
    }
    fun getId():Long {
        return id
    }
}