package org.techtown.mandk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by LG on 2017-12-17.
 */

public class Alret extends AppCompatActivity{

        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alret);
        }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Alret.this, MainActivity.class);
        startActivity(intent);
    }
}
