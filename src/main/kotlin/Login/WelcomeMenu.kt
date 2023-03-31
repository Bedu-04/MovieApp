package main.kotlin.Login

import kotlinx.coroutines.runBlocking
import main.kotlin.classes.App

class WelcomeMenu {
    var authService = AuthenthicationServiceImpl()
    fun showMenu() {
        authService.createAdminAccount()
        var option: Int? = null
        while (option == null) {
            try {
                menuText()
                print("Ingrese una opción: ")
                option = readLine()?.toInt()
            } catch (e: NumberFormatException) {
                println("Esto no es un numero valido, intenta de nuevo")
            }
        }
        when (option) {
            1 -> {
                println("Por favor ingrese su usuario")
                val inputUserName = readLine()!!
                println("Por favor ingrese su contraseña")
                val inputpassword = readLine()!!
                // lambda used as parameter for onSuccess and onError
                authService.login(username = inputUserName, password = inputpassword, onSuccess = {
                    println("********* Bienvenido $inputUserName *********")
                    val app = App()

                    runBlocking {
                        app.loadMovies()
                    }
                    app.showMenu()
                }, onError = {
                    println(it)
                    showMenu()
                }
                )
            }

            2 -> {
                println("cual seria su usuario")
                val inputUserName = readLine()!!
                println("cual seria su contraseña?")
                val inputpassword = readLine()!!
                authService.register(username = inputUserName, password = inputpassword, onSuccess = {
                    println("********* Usuario Registrado con el nombre de: $inputUserName *********")
                    showMenu()
                }, onError = {
                    println(it)
                    showMenu()
                })
            }

            3 -> {
                println("Gracias por usar MovieApp")
            }

            else -> {
                println("Opción inválida")
                showMenu()
            }
        }
    }

    fun menuText() {
        println("********* Bienvenido a MovieApp *********")
        println("1. Iniciar sesión")
        println("2. Registrarse")
        println("3. Salir")

    }
}