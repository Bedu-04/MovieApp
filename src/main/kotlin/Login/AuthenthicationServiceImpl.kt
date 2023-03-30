package main.kotlin.Login
// implementing interface
class AuthenthicationServiceImpl: AuthService {
    private val users = mutableMapOf<String, String>()

    override fun login(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        val storedPassword = users[username]
        if (storedPassword == null) {
            onError("User not found")
        } else if (storedPassword != password) {
            onError("Incorrect password")
        } else {
            onSuccess()
        }
    }

    override fun register(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        if (users.containsKey(username)) {
            onError("Username already taken")
        } else {
            users[username] = password
            onSuccess()
        }
    }

    //private functions
    private fun validateUsername(username: String): Boolean {
        // This is an example of a private function that can be used internally by the AuthServiceImpl class, but not accessed from outside.
        return username.isNotBlank() && username.length >= 4
    }
}