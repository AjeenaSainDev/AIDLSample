package com.example.aidlsampleapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.RemoteException

/**
 * Created by Ajeena on 24-10-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
class AdditionService : Service() {
    override fun onBind(intent: Intent): IBinder? {
        return object : MoveiIDLInterface.Stub() {
            override fun addNumbers(num1: Int, num2: Int): Int {
                return num1 + num2
            }
        }
    }
}
