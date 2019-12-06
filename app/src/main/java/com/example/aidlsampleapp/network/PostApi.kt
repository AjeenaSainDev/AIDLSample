package com.example.aidlsampleapp.network

import com.example.aidlsampleapp.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Ajeena on 06-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
interface PostApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}