import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import main.kotlin.classes.App
import main.kotlin.classes.Movie

fun main(args: Array<String>) {

    // Clase calendario
    val app = App()
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    runBlocking {
        app.loadMovies()
    }

    app.showMenu()





}



