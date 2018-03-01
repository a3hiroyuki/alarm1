package com.example.hiroy.alarmtest1;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hiroy on 2018/03/02.
 */

public class AlarmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 毎回Alarmを設定する
        setNextAlarmService(getApplicationContext());

        return START_NOT_STICKY;
    }

    // 次のアラームの設定
    private void setNextAlarmService(Context context){

        Log.v("abe", "bbbbb");

        long repeatPeriod = 30*1000;

        Intent intent = new Intent(context, AlarmService.class);

        long startMillis = System.currentTimeMillis() + repeatPeriod;

        PendingIntent pendingIntent
                = PendingIntent.getService(context, 0, intent, 0);
        AlarmManager alarmManager
                = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if(alarmManager != null){
            // Android Oreo 以上を想定
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                    startMillis, pendingIntent);
        }
    }
}
