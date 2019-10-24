package com.example.aidlsampleapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

/**
 * Created by Ajeena on 24-10-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
public class AdditionService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MoveiIDLInterface.Stub() {
            @Override
            public int addNumbers(int num1, int num2) throws RemoteException {
                return (num1 + num2);
            }
        };
    }
}
