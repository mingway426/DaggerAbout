package com.example.myapplication.mingwaysimple.kotlin
import kotlin.io.println

fun main() {
    println("hello");
    val strs:Array<String> = arrayOf("hello","mingway"," my lord")
    strs.forEach(::println)

}