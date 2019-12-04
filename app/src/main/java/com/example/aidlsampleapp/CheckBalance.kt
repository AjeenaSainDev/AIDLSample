package com.example.aidlsampleapp

import com.example.aidlsampleapp.model.Engine

/**
 * Created by Ajeena on 03-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
interface CheckBalance {
    val engine : Engine
    fun start (){
     engine.enginStart()
    }
}