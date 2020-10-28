package com.dam2david.simon_dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import javax.*




class MainActivity : AppCompatActivity() {

    lateinit var cargaImagen: ImageView
    val text = " hola toast!"
    val duracion = Toast.LENGTH_SHORT
    var rondas = 5
    var rondajugador = 5
    var lista: ArrayList<Int> = ArrayList()
    var listajugador: ArrayList<Int> = ArrayList()
    var puntos = 1
    var rondaspuntos = 0
    var z = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toast = Toast.makeText(applicationContext, text, duracion)

        val starboton: Button = findViewById(R.id.mi_boton)
        starboton.setOnClickListener {

            davidDice()
            toast.show()

        }
        val resetboton: Button = findViewById(R.id.mi_boton2)
        resetboton.setOnClickListener {


        }





    }


    private fun davidDice() {


        val randomInt = Random()


        do {
            for (i in 0 until rondas) {
                lista.add(randomInt.nextInt(3) + 1)
            }
            val mio = IntArray(lista.size)
            var ind = 0
            for (value in lista) {
                mio[ind++] = value
            }
            for (i in mio.indices) {
                if (mio[i] == 1) {

                    cargaImagen = findViewById(R.id.verde)

                } else if (mio[i] == 2) {

                    cargaImagen = findViewById(R.id.azul)

                } else if(mio[i]===3){
                    cargaImagen = findViewById(R.id.amarillo)
                }else{

                    cargaImagen = findViewById(R.id.rojo)


                }
            }
            println(lista)
            for (i in 0 until rondajugador) {
                val a: String = JOptionPane.showInputDialog("Introduce numero").toInt()
                val b = java.lang.Int.parseInt(a)
                listajugador.add(b)
            }
            println(listajugador)
            if (lista == listajugador) {
                println("Hacertaste")
                puntos++
                rondas++
                rondajugador++
                rondaspuntos++
                lista.clear()
                listajugador.clear()
            } else {
                println("Fallaste")
                z = true
                val puntostotal: Int = rondaspuntos * 10 * puntos
                println("puntos = $puntostotal")
            }
        } while (z === false)


    }
}


