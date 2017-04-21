package com.amaysim.sample.amaysim;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Hamid on 21/04/2017.
 */

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_SHOW_TIME = 2500; // 3000 milliseconds
    private static Handler splashHandler = new Handler();
    private Runnable splashTask = new SplashTask(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashHandler.removeCallbacks(splashTask);
    }

    @Override
    public void onResume() {
        super.onResume();
        splashHandler.postDelayed(splashTask, SPLASH_SHOW_TIME);
    }


    @Override
    public void onPause() {
        super.onPause();
        splashHandler.removeCallbacks(null);
    }

    private static class SplashTask implements Runnable {

        private WeakReference<SplashActivity> myActivity = null;

        public SplashTask(SplashActivity activity) {
            myActivity = new WeakReference<SplashActivity>(activity);
        }

        @Override
        public void run() {
            if (myActivity.get().getApplicationContext() != null) {
                Intent intent = new Intent(myActivity.get().getApplicationContext(), LoginActivity.class);

                myActivity.get().startActivity(intent);

                myActivity.get().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                myActivity.get().finish();
            }
        }
    }
}