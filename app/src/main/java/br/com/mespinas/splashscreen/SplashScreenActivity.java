package br.com.mespinas.splashscreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        load();
    }

    private void load() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        anim.reset();

        //Creating layout
        ImageView iv = (ImageView) findViewById(R.id.ivSplashLogo);

        if(iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Next activity to be shown after wait time
                Intent intent = new Intent(SplashScreenActivity.this, MenuActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                startActivity(intent);

                SplashScreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
