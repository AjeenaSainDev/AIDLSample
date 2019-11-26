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

import com.example.aidlsampleapp.fragment.UserFragment
import com.squareup.otto.Subscribe

class MainActivity : AppCompatActivity() {
    private var moveiIDLInterface: MoveiIDLInterface? = null
    private var remoteServiceConnection: RemoteServiceConnection? = null
    lateinit var sendMessage: Button
    lateinit var  message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendMessage = findViewById<View>(R.id.sendMessageToFragment) as Button
        message = findViewById<View>(R.id.message) as TextView
        sendMessage.setOnClickListener { sendEvents("aku") }
        addFragment()


        /* add = (Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                  int result =  moveiIDLInterface.addNumbers(2,4);
               System.out.println("result"+result);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

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
               /* Intent i = new Intent("com.androidaidl.androidaidlservice.ProductService");
        i.setPackage("com.androidaidl.androidaidlservice");
        boolean ret = bindService(i, remoteServiceConnection, Context.BIND_AUTO_CREATE);
        System.out.println("bound"+ret);*/
    }

    override fun onStart() {
        super.onStart()
        connectService()
        EventBus.getBus().register(this)
    }

    @Subscribe
    fun getMessage(fragmentActivityMessage: Events.FragmentActivityMessage) {
        message.text = fragmentActivityMessage.message
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


}
