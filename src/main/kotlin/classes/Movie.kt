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


) {
    // Agregar a tu lista

    // Eliminar de tu lista
}