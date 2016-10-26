package com.techpalle.karan.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ADMIN on 10/23/2016.
 */

public class AirplaneModeBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean state = intent.getBooleanExtra("state", false);
        Toast.makeText(context, "Airplane mode: "+state, Toast.LENGTH_LONG).show();
    }
}
