package com.example.aidlsampleapp.di

import com.example.aidlsampleapp.MainActivity
import dagger.Component

/**
 * Created by Ajeena on 02-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
@Component
interface AppComponent {
    fun inject (mainActivity: MainActivity)
}