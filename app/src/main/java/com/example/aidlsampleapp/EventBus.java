package com.example.aidlsampleapp;

import com.squareup.otto.Bus;

/**
 * Created by Ajeena on 30-10-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
public class EventBus {
    private static Bus sBus;
    public static Bus getBus() {
        if (sBus == null)
            sBus = new Bus();
        return sBus;
    }

}
