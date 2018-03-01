package com.example.hiroy.alarmtest1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    long alarmTimeMillis = 10000;
    AlarmManager alarmManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BroadcastReceiver receiver0 = new AlarmReceiver();
//        IntentFilter filter0 = new IntentFilter();
//        filter0.addAction("com.example.hiroy.alarmtest1.AlarmReceiver");
//        registerReceiver(receiver0, filter0);

        Button btn = (Button)findViewById(R.id.button);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        final PendingIntent pendingIntent = getPendingIntent();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    Log.v("abe", "atart");
//                    alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), alarmTimeMillis , getPendingIntent());
//                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
//                } else {
//                    alarmManager.set(AlarmManager.RTC_WAKEUP, alarmTimeMillis, pendingIntent);
//                }
                startService(new Intent(MainActivity.this, AlarmService.class));
            }
        });

    }

    private PendingIntent getPendingIntent(){
        Intent indent = new Intent(this, AlarmReceiver.class);
        return PendingIntent.getBroadcast(getApplicationContext(), 1, indent, 0);
    }
}
