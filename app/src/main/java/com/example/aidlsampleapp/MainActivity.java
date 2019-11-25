package com.example.aidlsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aidlsampleapp.fragment.UserFragment;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
 private MoveiIDLInterface moveiIDLInterface;
 private RemoteServiceConnection remoteServiceConnection;
 Button sendMessage;
 TextView message;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage = (Button)findViewById(R.id.sendMessageToFragment);
        message = (TextView)findViewById(R.id.message);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEvents("aku");
            }
        });
        addFragment();


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

    private class RemoteServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            moveiIDLInterface = MoveiIDLInterface.Stub.asInterface(iBinder);
            try {
                int result =  moveiIDLInterface.addNumbers(2,4);
              System.out.println("result"+result);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            moveiIDLInterface = null;

        }
    }


    private void connectService() {
        remoteServiceConnection = new RemoteServiceConnection();
        Intent it = new Intent( );
        it.setClassName("com.example.aidlsampleapp",
                "com.example.aidlsampleapp.AdditionService");
        //optional
        it.setAction("com.example.aidlsampleapp.CALCULATOR");
        //binding to remote service
        boolean bRet = bindService(it, remoteServiceConnection, Service.BIND_AUTO_CREATE);
        Log.d("IRemote", "Service.BIND_AUTO_CREATE");
        System.out.println("bound"+bRet);

       /* Intent i = new Intent("com.androidaidl.androidaidlservice.ProductService");
        i.setPackage("com.androidaidl.androidaidlservice");
        boolean ret = bindService(i, remoteServiceConnection, Context.BIND_AUTO_CREATE);
        System.out.println("bound"+ret);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        connectService();
        EventBus.getBus().register(this);
    }
    @Subscribe
    public void getMessage(Events.FragmentActivityMessage fragmentActivityMessage){
       message.setText(fragmentActivityMessage.getMessage());
        Toast.makeText(this,fragmentActivityMessage.getMessage(),Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getBus().unregister(this);
    }

    public void sendEvents(String message){
        Events.Initalize activityFragmentMessageEvent =
                new Events.Initalize(message);
        EventBus.getBus().post(activityFragmentMessageEvent);

    }
    private void addFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, new UserFragment()).commit();
    }


}
