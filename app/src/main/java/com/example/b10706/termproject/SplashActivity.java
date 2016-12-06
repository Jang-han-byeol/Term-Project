package com.example.b10706.termproject;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class SplashActivity extends AppCompatActivity {

    final String TAG = "TermProject";
    FrameLayout mFrame;
    ImageView mBear;
    int mScreenHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mFrame = (FrameLayout)findViewById(R.id.activity_splash);
        mBear = (ImageView) findViewById(R.id.bear);

    }

    protected void onResume() {
        super.onResume();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;

        startBearValuePropertyAnimation();
    }
    private void startBearValuePropertyAnimation() {
        Animation bear_anim = AnimationUtils.loadAnimation(this, R.anim.bear);
        mBear.startAnimation(bear_anim);
        bear_anim.setAnimationListener(animationListener);

        ValueAnimator scaleAnimator= ValueAnimator.ofFloat(1.0f,1.0f);


        scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                mBear.setScaleX(value);
                mBear.setScaleY(value);
            }
        });


        scaleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleAnimator.setStartDelay(200);
        scaleAnimator.setDuration(2000);
        scaleAnimator.start();
        scaleAnimator.addListener(animatorListener);


    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Log.i(TAG, "onAnimationEnd");
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };

    Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animator) {
            Log.i(TAG, "onAnimationStart");
        }

        @Override
        public void onAnimationEnd(Animator animator) {
            Log.i(TAG, "onAnimationEnd");
        }

        @Override
        public void onAnimationCancel(Animator animator) {
            Log.i(TAG, "onAnimationCancel");
        }

        @Override
        public void onAnimationRepeat(Animator animator) {
            Log.i(TAG, "onAnimationRepeat");
        }
    };

}
