package org.techtown.mandk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by LG on 2017-12-08.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();
    }
}
