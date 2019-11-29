package com.example.aidlsampleapp.model

/**
 * Created by Ajeena on 28-11-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class SavingAccount  (accountNumber: String, accountName: String, val interestRate: Double) :
        BankAccount(accountNumber, accountName) {
    fun depositInterest() {
        val interest = balance * interestRate / 100
        this.depositeMoney(interest);
    }
    fun withDraw(){
        this.withDraw()
    }
}