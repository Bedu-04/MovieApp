package main.kotlin.classes

import java.util.Date


enum class Category {
    Comedia, Drama, Suspenso, Terror
}

enum class Language {
    Español, Inglés, Francés, Coreano
}

class Movie(
    name: String,
    actors: List<String>,
    duration: Double,
    directors: List<String>,
    date: String,
    rating: Double,
    language: Language,
    category: Category,

    val pelis: List<String> = listOf(
        "Scary Movie",
        "Scream 6",
        "Shazam",
        "La Ballena",
        "Creed"
    )

) {
    // Agregar a tu lista

    fun main() {
        for (peliculas in pelis) {
            println(pelis)
        }
    }



    // Eliminar de tu lista
}

