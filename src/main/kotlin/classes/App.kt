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
        println("Menu")
        println("1) Ver cartelera")
        println("2) Ver Mi Lista")
        println("3) Agregar a Mi Lista")
        println("4) Eliminar de Mi Lista")
        val menuOption = getMenuOption("\"Ingresa la opcion deseada: \"").toInt()

        when (menuOption) {
            1 -> showCinemaListings()
            2 -> showMovieList()
            3 -> addMovie()
            4 -> deleteMovie()
            else-> "No se encuentra dentro del catalogo"
        }

    }
    fun getMenuOption(text: String): String {
        println(text)
        val menuOption = readln()

        return menuOption
    }

    fun showCinemaListings () {
        // - ${Movie.language} - ${Movie.rating}☆ - ${Movie.duration}m
        println("********* Cartelera ********")
        println("Selecciona tu pelicula: ")
        cinemaListings.forEach{Movie ->
            println("${Movie.id}.- ${Movie.name}")
        }

        do {
            var menuOption = getMenuOption("Ver mas detalles de una pelicula? (si / no)").toString().lowercase()

            if (menuOption == "si") {
                val option = getMenuOption("Ingresa el id de la pelicula:").toInt()

                val movie = cinemaListings.find { it.id == option }
                if (movie == null){
                    println("La pelicula no existe")
                    return
                }
                println("${movie.id}.- ${movie.name} - ${movie.language} - ${movie.rating}☆ - ${movie.duration}m")
            }

            if (menuOption == "no") showMenu()


        } while (menuOption != "si" || menuOption != "no")
        // showMenu()
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
