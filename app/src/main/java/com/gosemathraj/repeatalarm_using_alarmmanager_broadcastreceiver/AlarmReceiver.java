package com.gosemathraj.repeatalarm_using_alarmmanager_broadcastreceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationClickedIntent = new Intent(context,MainActivity.class);
        notificationClickedIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,1,notificationClickedIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                                            .setContentIntent(pendingIntent)
                                            .setContentTitle("Notification Title")
                                            .setSmallIcon(R.mipmap.ic_launcher)
                                            .setContentText("Notification Text")
                                            .setAutoCancel(true);
        notificationManager.notify(100,builder.build());
    }
}
