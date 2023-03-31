package main.kotlin.utils

val getConsoleLine = {text: String? ->
    if (text != null) println(text)
    readLine()!!
}