package com.techpalle.karan.broadcastreceiverdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ADMIN on 10/23/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("title goes here")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("body text goes here");


        // Define the action on click of notification
        Intent intent1 = new Intent(context, MainActivity.class);

        // Wrap the intent inside a pending intent and send it to the notification bar
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                0, intent1, 0);


        // Set the pending intent to the builder
        builder.setContentIntent(pendingIntent);

        // Create a notification object
        Notification notification = builder.build();

        // Get an instance of Notification manager
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Call the notify method on the manager object to create a notification
        manager.notify(1, notification);
    }
}
