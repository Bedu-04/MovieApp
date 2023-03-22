import main.kotlin.classes.Movie

fun main(args: Array<String>) {
    //println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")
    // Menu (listado de peliculas en cine, agregar para que la veas mas tarde, eliminarla de tu lista)

    // Clase pelicula
    println("Bienvenido a beduMoviesApp")
    println("Selecciona tu pelicula")



    println("Ingresa nombre de la película y presiona enter: ")
    val movie = readln()

        val mensaje = when (movie) {
            "Scary Movie" -> "Scary Movie, Comedia, 88.27 min"
            "Scream 6" -> "Scream 6, Suspenso, 120 min"
            "Shazam" -> "Shazam, Accion, 145 min"
            "La Ballena" -> "La Ballena, Drama, 117 min"
            "Creed" -> "Creed, Accion, 109 min"
            else-> "No se ecnuentra dentro del catalogo"
        }
        println(mensaje)

    val Pelis: List<String> = listOf(
        "Scary Movie",
        "Scream 6",
        "Shazam",
        "La Ballena",
        "Creed"
    )

    //Mostrar catalogo
    //for (Peliculas in Pelis) {
    //    println(Pelis)
    // }

    //Agrega elementos
    val pelis = mutableListOf<String>()
    println("Mi lista: $pelis")
    println("Agrega Peli: ${pelis.add("Scary Movie")}")
    println("Agrega Peli: ${pelis.add("Scream 6")}")
    println("Agrega Peli: ${pelis.add("Shazam")}")
    println("Agrega Peli: ${pelis.add("La Ballena")}")
    println("Agrega Peli: ${pelis.add("Creed")}")
    println("Peliculas agregadas a Mi Lista: $pelis")

    //Quitar elementos
    println("Remover Peli: ${pelis.remove("Shazam")}")
    println("Shazam fue eliminada con exito")
    println("Contenido en Mi Lista: $pelis")

    //indicando el que quieres eleminiar
    println("Remover Peli : ${pelis.removeAt(2)}")
    println("Contenido en Mi Lista: $pelis")

    //Eliminar lista
    println("Eliminar mi lista")
    pelis.clear()
    println("Mi Lista: $pelis")

    //verificando si la lista esta vacia
    println("Mi lista esta vacia? ${pelis.isEmpty()}")

    //quitando uno que no existe
    println("Eliminar Top Gun Maverick")
    println("La pelicula se encuentra fuera del catalogo")
    println("Agregue la pelicula a su lista para poder eliminarla")
    println("Se pudo eliminar la pelicula fuera de mi lista?: ${pelis.remove("Top Gun Maverick")}")
    println("Contenido en Mi Lista: $pelis")


    // test pelicula
    //val scaryMovie = Movie("Scary Movie", listOf("Pedro Guzman"), 106.55, "Comedy", listOf("Joaquin Lopez Doriga"), "Miercoles", 9.8, "Spanish")

    // Clase calendario


}



