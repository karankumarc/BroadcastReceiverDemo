package com.techpalle.karan.broadcastreceiverdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class MainActivity extends AppCompatActivity {

    AirplaneModeBroadcastReceiver broadcastReceiver;

    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 13);


        Intent myIntent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent,0);


        AlarmManager alarmManager = (AlarmManager)this.getSystemService(ALARM_SERVICE);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);


        /*
        broadcastReceiver = new AirplaneModeBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        getApplicationContext().registerReceiver(broadcastReceiver, intentFilter);*/
    }

    public void goToSecond(View view) {
        /*Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        finish();*/
    }

    @Override
    protected void onPause() {
        /*super.onPause();
        getApplicationContext().unregisterReceiver(broadcastReceiver);*/
    }
}
