package com.example.aidlsampleapp.di

import com.example.aidlsampleapp.MainActivity
import com.example.aidlsampleapp.ViewModel.PostViewModel
import com.example.aidlsampleapp.di.module.NetworkModule
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
    fun inject(postListViewModel: PostViewModel)


    // to build the Appcomponent we use this line
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
    }
}