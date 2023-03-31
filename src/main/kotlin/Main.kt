import kotlinx.coroutines.runBlocking
import main.kotlin.Login.WelcomeMenu
import main.kotlin.classes.App
import main.kotlin.classes.Movie

fun main(args: Array<String>) {

    // Clase calendario
    val welcomeMenu = WelcomeMenu()
    welcomeMenu.showMenu()
    val app = App()

    runBlocking {
        app.loadMovies()
    }

    app.showMenu()





}



