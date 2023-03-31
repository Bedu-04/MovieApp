package main.kotlin.Login

//Interface
interface AuthService {
    fun login(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit)
    fun register(username: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit)
}