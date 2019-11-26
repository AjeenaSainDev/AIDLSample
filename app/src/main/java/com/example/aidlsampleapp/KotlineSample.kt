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
    var num1 : Int = 5
    val num2 : Int = 6
    var name : String? = "abc"  // can nullable using ?
    val list = ArrayList<String>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var input = intent.getStringExtra("inputExtra")
        num1 = 7;
        name = null
        Toast.makeText(applicationContext,"num",Toast.LENGTH_SHORT).show()

    }
    fun getSum(name1: String, name2: String) : Int {
     return  0
    }
    }