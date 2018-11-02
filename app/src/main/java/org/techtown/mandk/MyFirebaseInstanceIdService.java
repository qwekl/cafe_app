package org.techtown.mandk;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by LG on 2017-12-16.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    public static final String TOKEN_BROADCAST = "myfcmtokenbroadcast";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("myfirebaseid", "Refreshed token: " + refreshedToken);

        storeToken(refreshedToken);
        getApplicationContext().sendBroadcast(new Intent(TOKEN_BROADCAST));
    }

    private void storeToken(String token){
        SharedPrefManager.getInstance(getApplicationContext()).storeToken(token);
    }
}
