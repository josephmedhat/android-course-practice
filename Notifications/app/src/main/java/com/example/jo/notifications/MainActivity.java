package com.example.jo.notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String channelId = "some_channel_id";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.button);
        Button b1 = findViewById(R.id.button2);
        Button b2 = findViewById(R.id.button3);
        createChanelGroup();
        createChanel();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChanelGroup() {
        String groupId = "some_group_id";
        CharSequence groupName = "test group";
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannelGroup group = new NotificationChannelGroup(groupId, groupName);
        notificationManager.createNotificationChannelGroup(group);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createChanel() {

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "some_channel_id";
        String channelName = "Some Channel";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, importance);
        notificationChannel.setGroup("some_group_id");
        notificationManager.createNotificationChannel(notificationChannel);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(View view) {
       /* Intent intent = new Intent(this, Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
*/
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyId = 1;

        Notification notification = new Notification.Builder(MainActivity.this)
                .setContentTitle("Some Message")
                .setContentText("You've received new messages!")
                .setSmallIcon(R.drawable.ic_warning_black_24dp)
                .setChannelId(channelId)
                .setPriority(Notification.PRIORITY_MAX)
                /*.setContentIntent(pendingIntent)*/
                .build();
        notificationManager.notify(notifyId, notification);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void exNotification(View view) {
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yup_logo);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyId = 2;
        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("Some Message")
                .setContentText("You've received new messages!")
                .setSmallIcon(R.drawable.ic_warning_black_24dp)
                .setChannelId(channelId)
                .setPriority(Notification.PRIORITY_MAX)
                /*.setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("jhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhk"))
                */
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(myBitmap)
                ).build();
        notificationManager.notify(notifyId, notification);
    }

    public void exText(View view) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        int notifyId = 3;
        Notification notification = new NotificationCompat.Builder(MainActivity.this)
                .setContentTitle("Some Message")
                .setContentText("You've received new messages!")
                .setSmallIcon(R.drawable.ic_warning_black_24dp)
                .setChannelId(channelId)
                .setPriority(Notification.PRIORITY_MAX)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("jhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhkjhjhkjhjkkhjhkhjkhk"))
                .build();
        notificationManager.notify(notifyId, notification);
    }
}
