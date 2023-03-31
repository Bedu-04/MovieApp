package main.kotlin.classes

import java.util.Date


enum class Category {
    Comedia, Drama, Suspenso, Terror
}

enum class Language {
    Español, Inglés, Francés, Coreano
}

class Movie(
    val id: Int,
   val name: String,
    val actors: List<String>,
    val duration: Double,
    val directors: List<String>,
    val date: String,
    val rating: Double,
    val language: Language,
    val category: Category
) {
    // Agregar a tu lista

    // Eliminar de tu lista

    fun printInfo(showAllInfo: Boolean = false) {
        if (showAllInfo) {
            println("${id} - ${name} - ${language} - ${rating}☆ - ${duration}m")
        } else {
            println("${id} - ${name}")
        }
    }

    fun addMovie(myMovieList: MutableList<Movie>) = myMovieList.add(this)

}