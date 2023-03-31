package main.kotlin.classes

import netscape.javascript.JSObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.StringWriter
import java.io.Writer
import java.sql.RowId
import javax.naming.Context


class App () {

    val myMovieList: MutableList<Movie> = arrayListOf()
    val cinemaListings: MutableList<Movie> = arrayListOf()

    init {
        println("Cargando cartelera....")
        cinemaListings.add(Movie(1,"Scary Movie", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(2,"Scary Movie2", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(3,"Scary Movie3", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(45,"Scary Movie4", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        println("Catetelera cargada exitosamente....")
    }

    fun showMenu(){
        try {
            println("Menu")
            println("1) Ver cartelera")
            println("2) Ver Mi Lista")
            println("3) Agregar a Mi Lista")
            println("4) Eliminar de Mi Lista")
            println("5) Salir")
            val menuOption = getMenuOption("\"Ingresa la opcion deseada: \"").toInt()

            when (menuOption) {
                1 -> initCinema()
                2 -> showMovieList()
                3 -> addMovie()
                4 -> deleteMovie()
                5 -> println("Gracias por usar MovieApp")
                else-> {
                    println("No se encuentra dentro del catalogo")
                    showMenu()
                }
            }
        } catch(e:NumberFormatException) {
            println("No se pudo convertir, hubo un error: $e")
            showMenu()
        }


    }
    fun getMenuOption(text: String): String {
        println(text)
        val menuOption = readln()

        return menuOption
    }

    fun initCinema () {
        showCinemaListings()
        do {
            var menuOption = getMenuOption("Ver mas detalles de las peliculas? (si / no)").toString().lowercase()

            if (menuOption == "si") {
                showCinemaListings(true)
                menuOption = "no"
            }

            if (menuOption == "no") showMenu()


        } while (menuOption != "si" || menuOption != "no")
        // showMenu()
    }

    fun showCinemaListings (showAllInfo: Boolean = false) {

        println("********* Cartelera ********")
        cinemaListings.forEach{Movie ->
            if (showAllInfo) {
                println("${Movie.id}.- ${Movie.name} - ${Movie.language} - ${Movie.rating}☆ - ${Movie.duration}m")
            } else {
                println("${Movie.id}.- ${Movie.name}")
            }
        }
    }

    fun showMovieList () {
        if(myMovieList.isNotEmpty()) {

            println("Esta es tu lista de peliculas:")
            myMovieList.forEach { Movie ->
                println("${Movie.id}.- ${Movie.name}")
            }

        } else {
            println("No tienes películas en tu lista.")
            println("")
            showMenu()
        }
        println("")
        showMenu()
    }

    fun getIdMovie(): Int {
        println("Ingresa la película deseada y presiona enter: ")
        val movieId = readln().toInt()

        return movieId
    }

    fun addMovie() {
        val movieId = getIdMovie()
        val existMovie= verifyMovie(movieId)
        if (existMovie == true) {
            println("Esa película ya esta en tu lista, selecciona otra opción.")
            return showMenu()

        }
        val myMovie = cinemaListings.find { it.id == movieId }
        if (myMovie == null) {
            println("No se encontró la película solicitada")
            return showMenu()
        }

        println("${myMovie.id}.- ${myMovie.name}")
        myMovieList.add(myMovie)

        //showMovieList()
        showMenu()
    }

    fun deleteMovie() {
        val notEmpty = myMovieList.isNotEmpty()

        if (notEmpty) {
            val movieId = getIdMovie()
            val existMovie = verifyMovie(movieId)
            val myMovie = cinemaListings.find { it.id == movieId }

            if (existMovie) {

                myMovieList.remove(myMovie)

                println("Película eliminada: ")
                println("${myMovie?.id}.- ${myMovie?.name}")
                println("")

                return showMenu()

            } else {
                println("La opción ingresada no existe dentro de tu lista.")
                println("")
                showMenu()

                return
            }
        } else {
            println("No hay películas en tu lista por eliminar.")
            println("")
            showMenu()

            return
        }
                //println("")
                //showMenu()
    }

    fun verifyMovie(movieId: Int): Boolean{
        val existMovie = myMovieList.find { it.id == movieId }
        if (existMovie == null) {
            return false
        }
        return true
    }


}
