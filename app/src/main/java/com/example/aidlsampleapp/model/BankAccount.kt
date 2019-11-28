package com.example.aidlsampleapp.model

/**
 * Created by Ajeena on 28-11-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */

/***************
 *  By default, all the classes in Kotlin are final (non-inheritable).

To allow a class to be inherited by others, you must mark it with the open modifier.
 */
open  class BankAccount (val accountNumber: String, val accountName: String) {
    var balance : Double = 0.0

    fun depositeMoney(amount: Double): Boolean {
        if(amount > 0) {
            balance += amount
            return true
        } else {
            return false
        }
    }

    fun withdrawMoney(amount: Double): Boolean {
        if(amount > balance) {
            return false
        } else {
            balance -= amount
            return true
        }
    }

}