package main.kotlin.classes

import netscape.javascript.JSObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.StringWriter
import java.io.Writer
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

    fun showCinemaListings () {
        println("Bienvenido a beduMoviesApp")
        println("Selecciona tu pelicula")
        cinemaListings.forEach{Movie ->
            println("${Movie.id}.- ${Movie.name}")
        }
    }

    fun showMovieList () {
        println("Esta es tu lista de peliculas")

        myMovieList.forEach{Movie ->
            println("${Movie.id}.- ${Movie.name}")
        }
    }

    fun getIdMovie(): Int {
        println("Ingresa nombre de la película y presiona enter: ")
        val movieId = readln().toInt()

        return movieId
    }


    fun addMovie() {
        val movieId = getIdMovie()
        val myMovie = cinemaListings.find { it.id == movieId }
        if (myMovie == null) {
            println("No se encontro la pelicula solicitada")
            return
        }

        println("${myMovie.id}.- ${myMovie.name}")
        myMovieList.add(myMovie)

        showMovieList()
    }

}
