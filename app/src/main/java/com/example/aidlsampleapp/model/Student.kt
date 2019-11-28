package com.example.aidlsampleapp.model

/**
 * Created by Ajeena on 28-11-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class Student {
    var first_name: String = "Guest"
    var last_name: String = "Ghost"

    constructor(_first_name: String, _last_name: String) {// Secondary Constructor
        this.first_name = _first_name
        this.last_name = _last_name

    }


    class Student(_first_name: String, _last_name: String) {
        // Primary constructor
        var first_name  = _first_name
           /* get() = field
            set(value) {
                field = value
            }*/

        var last_name = _last_name
            get() = field
            set(value) {
                field = value
            }


    }


}