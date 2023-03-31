package main.kotlin.classes

import kotlinx.coroutines.delay
import main.kotlin.utils.getConsoleLine
import kotlin.system.exitProcess


class App() {

    val myMovieList: MutableList<Movie> = arrayListOf()
    val cinemaListings: MutableList<Movie> = arrayListOf()

    // LoadMovies function
    suspend fun loadMovies() {
        println("Iniciando...")
        delay(1000)
        println("Actualizando las ultimas peliculas del momento")
        delay(1000)
        println("Empezando a cargar la cartelera")
        delay(1500)
        cinemaListings.add(
            Movie(
                1,
                "Scream 6",
                listOf("Pedro Guzman"),
                123.0,
                listOf("Joaquin Lopez Doriga"),
                "9-03-2023",
                7.2,
                Language.Español,
                Category.Suspenso
            )
        )
        cinemaListings.add(
            Movie(
                2,
                "Shazam",
                listOf("Pedro Guzman"),
                131.0,
                listOf("Joaquin Lopez Doriga"),
                "1-1-2023",
                6.6,
                Language.Español,
                Category.Acción
            )
        )
        cinemaListings.add(
            Movie(
                3,
                "La Ballena",
                listOf("Pedro Guzman"),
                177.0,
                listOf("Joaquin Lopez Doriga"),
                "27-1-2023",
                7.8,
                Language.Español,
                Category.Drama
            )
        )
        cinemaListings.add(
            Movie(
                4,
                "Creed 3",
                listOf("Pedro Guzman"),
                116.0,
                listOf("Joaquin Lopez Doriga"),
                "1-1-2023",
                7.3,
                Language.Español,
                Category.Drama
            )
        )
        cinemaListings.add(
            Movie(
                5,
                "Ant Man y la Avispa: Quantumnaía",
                listOf("Pedro Guzman"),
                124.0,
                listOf("Joaquin Lopez Doriga"),
                "17-2-2023",
                6.4,
                Language.Español,
                Category.CienciaFicción
            )
        )
        cinemaListings.add(
            Movie(
                6,
                "Calabozos y Dragones",
                listOf("Pedro Guzman"),
                134.0,
                listOf("Joaquin Lopez Doriga"),
                "30-3-2023",
                8.0,
                Language.Español,
                Category.Fantasía
            )
        )
        cinemaListings.add(
            Movie(
                7,
                "Mario Bros",
                listOf("Pedro Guzman"),
                92.0,
                listOf("Joaquin Lopez Doriga"),
                "7-4-2023",
                9.2,
                Language.Español,
                Category.Animación
            )
        )
        cinemaListings.add(
            Movie(
                8,
                "¡Que Viva México!",
                listOf("Pedro Guzman"),
                191.0,
                listOf("Joaquin Lopez Doriga"),
                "23-3-2023",
                5.8,
                Language.Español,
                Category.Comedia
            )
        )
        println("Catetelera cargada exitosamente....")
    }

    fun showMenu() {
        try {
            println("Menu")
            println("1) Ver cartelera")
            println("2) Ver mi Lista")
            println("3) Agregar a mi Lista")
            println("4) Eliminar de mi Lista")
            println("5) Salir")
            val menuOption = getConsoleLine("\"Ingresa la opcion deseada: \"").toInt()

            when (menuOption) {
                1 -> initCinema()
                2 -> showMovieList()
                3 -> addMovie()
                4 -> deleteMovie()
                5 -> {
                    println("Gracias por usar MovieApp")
                    exitProcess(0)
                }

                else -> {
                    println("No se encuentra dentro del catalogo")
                    showMenu()
                }
            }
        } catch (e: NumberFormatException) {
            println("No se pudo convertir, hubo un error: $e")
            showMenu()
        }


    }

    // Shows movies info
    fun initCinema() {
        showCinemaListings()
        do {
            var menuOption = getConsoleLine("Ver mas detalles de las peliculas? (si / no)")
            println(menuOption)
            if (menuOption == "si") {
                showCinemaListings(true)
                menuOption = "no"
            }

            if (menuOption == "no") showMenu()


        } while (menuOption != "si" || menuOption != "no")
    }

    fun showCinemaListings(showAllInfo: Boolean = false) {
        println("********* Cartelera ********")
        cinemaListings.forEach { Movie ->
            if (showAllInfo) Movie.printInfo(true)
            else Movie.printInfo()
        }
    }

    // shows user movie list and verify if not empty
    fun showMovieList() {
        if (myMovieList.isNotEmpty()) {
            println("-> Esta es tu lista de peliculas:")
            myMovieList.forEach { Movie -> Movie.printInfo(true) }

        } else {
            println("No tienes películas en tu lista.")
            println("")
            showMenu()
        }
        println("")
        showMenu()
    }
    // Adds movie in user movie list
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
    // Deletes movie in users movie list
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
    // Verify if exist movie
    fun verifyMovie(movieId: Int): Movie? {
        return myMovieList.find { it.id == movieId }
    }
}
