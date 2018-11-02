package org.techtown.mandk;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by LG on 2017-12-16.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    private static final String TAG = "fcmexamplemessage";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        Intent intent = new Intent(MyFirebaseMessagingService.this, Alret.class);
        startActivity(intent);


        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // メッセージにデータ ペイロードが含まれているかどうかを確認します.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // メッセージにデータ ペイロードが含まれているかどうかを確認します.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            notifyUser(remoteMessage.getFrom(), remoteMessage.getNotification().getBody());
        }

        // また,受信した FCM の結果として独自の通知を生成することもできます.
        // メッセージが表示されます. 以下の sendNotification メソッドを参照してください.
    }

    public void notifyUser(String from, String notification) {
        MyNotificationManager myNotificationManager = new MyNotificationManager(getApplicationContext());
        myNotificationManager.showNotification(from,notification,new Intent(getApplicationContext(),MainActivity.class));
    }
}
