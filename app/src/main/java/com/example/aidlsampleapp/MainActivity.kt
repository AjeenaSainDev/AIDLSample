package com.example.aidlsampleapp

import androidx.appcompat.app.AppCompatActivity

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.RemoteException
import android.util.Log
import android.util.Log.println
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.aidlsampleapp.databinding.ActivityMainBinding

import com.example.aidlsampleapp.fragment.UserFragment
import com.example.aidlsampleapp.model.Post
import com.example.aidlsampleapp.model.ProfileArray
import com.squareup.otto.Subscribe
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private var moveiIDLInterface: MoveiIDLInterface? = null
   // private var remoteServiceConnection: RemoteServiceConnection? = null
    lateinit var sendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val post = Post(1,2,"achu","music")
        data.setVariable(BR.post,post)
        data.executePendingBindings()
       /* sendMessage = findViewById<View>(R.id.sendMessageToFragment) as Button
        sendMessage.setOnClickListener {
            val nums = listOf(1,2,3,4,5)
          var name =  nums.joinToString(
                    separator = ", ",
                    prefix = "{",
                    postfix = "}",
                    limit = 4,
                    truncated = "there’s more ..."
            )
        println("joinToString Sample"+name)

            val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

            val myString = """This is my string
            which I want to be
            on multiple lines."""
            println(myString)

        }*/
      //  addFragment()

    }

/*

    private inner class RemoteServiceConnection : ServiceConnection {
        override fun onServiceConnected(componentName: ComponentName, iBinder: IBinder) {
            moveiIDLInterface = MoveiIDLInterface.Stub.asInterface(iBinder)
            try {
                val result = moveiIDLInterface!!.addNumbers(2, 4)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }

        }

        override fun onServiceDisconnected(componentName: ComponentName) {
            moveiIDLInterface = null

        }
    }


    private fun connectService() {
        remoteServiceConnection = RemoteServiceConnection()
        val it = Intent()
        it.setClassName("com.example.aidlsampleapp",
                "com.example.aidlsampleapp.AdditionService")
        //optional
        it.action = "com.example.aidlsampleapp.CALCULATOR"
        //binding to remote service
        var bRet = bindService(it, remoteServiceConnection!!, Service.BIND_AUTO_CREATE)
        Log.d("IRemote", "Service.BIND_AUTO_CREATE")
        */
/* Intent i = new Intent("com.androidaidl.androidaidlservice.ProductService");
 i.setPackage("com.androidaidl.androidaidlservice");
 boolean ret = bindService(i, remoteServiceConnection, Context.BIND_AUTO_CREATE);
 System.out.println("bound"+ret);*//*

    }

    override fun onStart() {
        super.onStart()
        connectService()
        EventBus.getBus().register(this)
    }

    @Subscribe
    fun getMessage(fragmentActivityMessage: Events.FragmentActivityMessage) {
      //  message.text = fragmentActivityMessage.message
        Toast.makeText(this, fragmentActivityMessage.message, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        EventBus.getBus().unregister(this)
    }

    fun sendEvents(message: String) {
        val activityFragmentMessageEvent = Events.Initalize(message)
        EventBus.getBus().post(activityFragmentMessageEvent)

    }

    private fun addFragment() {
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, UserFragment()).commit()
    }

    fun fetchJsonAsset() : String {
        var json_data: String = ""
        var input_stream: InputStream
        val charset: Charset = Charsets.UTF_8
        try {
            input_stream = this.getAssets().open("mock.json")
            val size = `input_stream`.available()
            val buffer = ByteArray(size)
            `input_stream`.read(buffer)
            `input_stream`.close()
            json_data = String(buffer, charset)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
       return json_data
    }
*/

}
