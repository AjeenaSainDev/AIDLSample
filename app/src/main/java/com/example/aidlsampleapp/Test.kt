package com.example.aidlsampleapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button

/**
 * Created by Ajeena on 03-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
class Test : Activity() {
      lateinit var mButton: Button
     var onClickListener: View.OnClickListener = View.OnClickListener { }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton = findViewById(R.id.test)
        mButton.setOnClickListener(onClickListener)

    }
}
