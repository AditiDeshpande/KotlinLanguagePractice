package com.example.kotlinlanguagepractice

import java.io.BufferedReader
import java.io.FileReader
import java.lang.IndexOutOfBoundsException

class NotANumberException(message: String): Throwable(message){
}

fun checkIsNumber(obj: Any){
    when(obj) {
        !is Int, Float, Double, Long ->
            throw NotANumberException("It was not a number!!")
    }
}

fun main() {
/*
We can have catch with try or finally or both
 */
//    try {
//        checkIsNumber("A")
//    }catch (e: IllegalAccessException){
//        println("Do Nothing!!")
//    }
//    catch (e: NotANumberException) {
//        // println("It was not a number!")
//        println("${e.message}")
//    }

    //foll. is Java code
    //Manually copied txt file to the root of directory
    //means project name's folder through file explorer
    val buffer = BufferedReader(FileReader("input.txt"))
    val result = try{
        val chars = CharArray(30)
        buffer.read(chars , 0 , 40)
        //exception coz in above line we are accessing more chars than
        //buffer size
    } catch (e: IndexOutOfBoundsException){
println("Exception has been handled!!")
        -1
    }
    finally {
        println("Closing")
        buffer.close()
        -2
    }
    println(result)
}
/*
Output of first try catch block related to Number is as follows

It was not a number!!

 */

/*
File reading try catch block's output is as follows

Exception in thread "main" java.lang.IndexOutOfBoundsException
 */
/*
Output with result

Exception has been handled!!
Closing
kotlin.Unit

shown Unit coz we r returning result but it is undefined somewhere String
somewhere nothing so that's why cast to Any and showing Unit
 */
/*
Exception has been handled!!
Closing
-1
output will be same as above though we add -2 for finally
 */