package org.techtown.mandk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by LG on 2017-11-25.
 */

public class CheckAppQuit extends Service {

    //Firebase連動
    FirebaseAuth mAuth;
    @Nullable
    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onTaskRemoved(Intent rooIntent) {
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() != null)
        {
            mAuth.signOut();
        }
        stopSelf();
    }
}