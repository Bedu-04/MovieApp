import main.kotlin.classes.Movie

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    // Menu (listado de peliculas en cine, agregar para que la veas mas tarde, eliminarla de tu lista)

    // Clase pelicula
    println("Bienvenido a beduMoviesApp")
    println("Selecciona tu pelicula")

    // test pelicula
    val scaryMovie = Movie("Scary Movie", listOf("Pedro Guzman"), 106.55, "Comedy", listOf("Joaquin Lopez Doriga"), "Miercoles", 9.8, "Spanish")

    // Clase calendario

}