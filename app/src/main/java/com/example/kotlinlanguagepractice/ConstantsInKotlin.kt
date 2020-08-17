package com.example.kotlinlanguagepractice


/*
It's good to put all constants in one block like below object Copyright
maybe.. Group them. Like e.g object Camera{ //Putting all camera related
constants here in this block }
 */
val CopyrightAuthor = "Aditi"

object Copyright{
    val author = "Aditi Deshpande"
}

fun main(args: Array<String>){
    println(Copyright.author)
    println(CopyrightAuthor)
}