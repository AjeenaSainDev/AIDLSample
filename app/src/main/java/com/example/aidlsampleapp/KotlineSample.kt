package com.example.aidlsampleapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import java.util.*

/**
 * Created by Ajeena on 26-11-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class KotlineSample : Activity() {
    var num1: Int = 5
    val num2: Int = 6
    var name: String? = "abc"  // can nullable using ?
    val list = ArrayList<String>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dowhile()
        whilesample()
       /* var input = intent.getStringExtra("inputExtra")
        num1 = 7;
        name = null
        Toast.makeText(applicationContext, "num", Toast.LENGTH_SHORT).show()*/

    }

    fun getSum(name1: String, name2: String): Int {
        var day = 5
        when (day) {
            1 -> println("sunday")
            2 -> println("monday")
            5 -> println("tusday")
            else -> {
                println("not matching")
            }
        }
        var max = if (num1 > num2) num1 else num2
        return 0
    }

    fun whencondition() {
        when {
            num1 == 1 -> print("x is odd")
            num1 == 4 -> print("x is even")
            else -> print("x is funny")
        }

        /**can combine multiple conditions in simple case **/
        var dayOfWeek = 6
        when(dayOfWeek) {
            1, 2, 3, 4, 5 -> println("Weekday")
            6, 7 -> println("Weekend")
            else -> println("Invalid Day")
        }
    }
    fun dowhile(){
        var x = 6
        do {
            println("dowhile"+"$x ")
            x++
        } while(x <= 5)

    }
    fun whilesample(){
        var x =6
        while(x <= 5) {
            println("while"+"$x ")
            x++
        }
    }
}