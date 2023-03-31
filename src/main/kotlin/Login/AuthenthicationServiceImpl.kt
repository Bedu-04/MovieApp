package main.kotlin.Login

// implementing interface
class AuthenthicationServiceImpl : AuthService {
    private val users = mutableMapOf<String, String>()

    fun createAdminAccount() {
        users["admin"] = "admin"
    }

    override fun login(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {

        val storedPassword = users[username]
        if (storedPassword == null) {
            onError("Usuario no encontrado")
        } else if (storedPassword != password) {
            onError("Contraseña Incorrecta")
        } else {
            onSuccess()
        }
    }

    override fun register(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        if (users.containsKey(username)) {
            onError("El usuario ya existe favor de ingresar otro")
        } else if (!validateUsername(username)) {
            onError("El usuario debe tener al menos 4 caracteres")
        } else {
            users[username] = password
            onSuccess()
        }
    }

    //private functions used to validate username
    private fun validateUsername(username: String): Boolean {
        return username.isNotBlank() && username.length >= 4
    }
}