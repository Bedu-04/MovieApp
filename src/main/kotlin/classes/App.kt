package main.kotlin.classes

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import main.kotlin.utils.getConsoleLine


class App () {
    val myMovieList: MutableList<Movie> = arrayListOf()
    val cinemaListings: MutableList<Movie> = arrayListOf()

    suspend fun loadMovies() {
        println("Iniciando...")
        delay(1000)
        println("Actualizando las ultimas peliculas del momento")
        delay(1000)
        println("Empezando a cargar la cartelera")
        delay(1500)
        cinemaListings.add(Movie(1,"Scary Movie", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(2,"Scary Movie2", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(3,"Scary Movie3", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        cinemaListings.add(Movie(45,"Scary Movie4", listOf("Pedro Guzman"), 106.55, listOf("Joaquin Lopez Doriga"), "2022-12-16", 5.4, Language.Español, Category.Comedia))
        println("Cartelera cargada exitosamente....")
    }
    fun showMenu(){
        try {
            println("Menu")
            println("1) Ver cartelera")
            println("2) Ver mi Lista")
            println("3) Agregar a mi Lista")
            println("4) Eliminar de mi Lista")
            val menuOption = getConsoleLine("\"Ingresa la opcion deseada: \"").toInt()

            when (menuOption) {
                1 -> initCinema()
                2 -> showMovieList()
                3 -> addMovie()
                4 -> deleteMovie()
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

    fun initCinema () {
        showCinemaListings()
        do {
            var menuOption = getConsoleLine("Ver mas detalles de las peliculas? (si / no)")

            if (menuOption == "si") {
                showCinemaListings(true)
                menuOption = "no"
            }

            if (menuOption == "no") showMenu()


        } while (menuOption != "si" || menuOption != "no")
    }

    fun showCinemaListings (showAllInfo: Boolean = false) {

        println("********* Cartelera ********")
        cinemaListings.forEach{Movie ->
            if (showAllInfo) Movie.printInfo(true)
            else Movie.printInfo()
        }
    }

    fun showMovieList () {
        if(myMovieList.isNotEmpty()) {
            println("-> Esta es tu lista de peliculas:")
            myMovieList.forEach { Movie -> Movie.printInfo(true)}

        } else {
            println("No tienes películas en tu lista.")
            println("")
            showMenu()
        }
        println("")
        showMenu()
    }


    fun addMovie() {
        println("-> Agregar nueva pelicula")
        val movieId = getConsoleLine("\"Ingresa el id la película deseada y presiona enter: \"").toInt()
        val existMovie = verifyMovie(movieId)
        if (existMovie != null) {
            println("Esa película ya esta en tu lista, selecciona otra opción.")
            return showMenu()

        }
        val myMovie = cinemaListings.find { it.id == movieId }
        if (myMovie == null) {
            println("No se encontró la película solicitada")
            return showMenu()
        }

        println("-> Se ha añadido una nueva pelicula a tu lista")
        myMovie.printInfo(true)
        myMovie.addMovie(myMovieList)
        showMenu()
    }

    fun deleteMovie() {
        val notEmpty = myMovieList.isNotEmpty()

        if (notEmpty) {
            val movieId = getConsoleLine("\"Ingresa el id de la pelicula a eliminar y presiona enter: \"").toInt()
            val myMovie = verifyMovie(movieId)

            if (myMovie != null) {

                myMovieList.remove(myMovie)

                println("-> Se ha eliminado la pelicula: ")
                myMovie.printInfo()
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
    }

    fun verifyMovie(movieId: Int): Movie?{
        return myMovieList.find { it.id == movieId }
    }
}
