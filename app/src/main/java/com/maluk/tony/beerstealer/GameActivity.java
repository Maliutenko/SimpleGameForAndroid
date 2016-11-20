package com.maluk.tony.beerstealer;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tony on 09.09.2016.
 */
public class GameActivity extends StartActivity {

    ImageButton ibtnCupLU;
    ImageButton ibtnCupLD;
    ImageButton ibtnCupRU;
    ImageButton ibtnCupRD;
    TextView tvWin;
    TextView tvLose;
    ImageView ivArrowLU;
    ImageView ivArrowLD;
    ImageView ivArrowRU;
    ImageView ivArrowRD;
    int countWin;
    int countLose;
    int flagLU;
    int flagLD;
    int flagRU;
    int flagRD;
    int damageLU;
    int damageLD;
    int damageRU;
    int damageRD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ibtnCupLU = (ImageButton)findViewById(R.id.cup_left_up);
        ibtnCupLD = (ImageButton)findViewById(R.id.cup_left_down);
        ibtnCupRU = (ImageButton)findViewById(R.id.cup_right_up);
        ibtnCupRD = (ImageButton)findViewById(R.id.cup_right_down);
        tvWin = (TextView)findViewById(R.id.score_win);
        tvLose = (TextView)findViewById(R.id.score_lose);
        ivArrowLU = (ImageView)findViewById(R.id.arrow_left_up);
        ivArrowLD = (ImageView)findViewById(R.id.arrow_left_down);
        ivArrowRU = (ImageView)findViewById(R.id.arrow_right_up);
        ivArrowRD = (ImageView)findViewById(R.id.arrow_right_down);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/comicrazy.ttf");
        tvWin.setTypeface(typeface);
        tvLose.setTypeface(typeface);

        final Animation animationArrow = AnimationUtils.loadAnimation(this, R.anim.animation_arrow);

        ImageView[] arrArrow = {ivArrowLU, ivArrowLD, ivArrowRU, ivArrowRD};
        for(int i = 0; i < arrArrow.length; i++){
            arrArrow[i].startAnimation(animationArrow);
        }
    }

    //action after tap on cup
    public void onTouchCup(int a){
        countWin++;
        tvWin.setText(getString(R.string.Stolen) + ":" + countWin);
        if(a == DAMAGE_POSITIVE){
            Intent intent = new Intent(this,EndActivity.class);
            intent.putExtra("resultscore",tvWin.getText().toString());
            startActivity(intent);finish();
        }
    }

    public void onMyButtonClick(View view) {

        final Animation animationLU = AnimationUtils.loadAnimation(this, R.anim.transfer_left_up);
        final Animation animationLD = AnimationUtils.loadAnimation(this, R.anim.transfer_left_down);
        final Animation animationRU = AnimationUtils.loadAnimation(this, R.anim.transfer_right_up);
        final Animation animationRD = AnimationUtils.loadAnimation(this, R.anim.transfer_right_down);
        final Animation animLL = AnimationUtils.loadAnimation(this, R.anim.anim_lose_left);
        final Animation animLR = AnimationUtils.loadAnimation(this, R.anim.anim_lose_right);
        final Animation animLLD = AnimationUtils.loadAnimation(this, R.anim.anim_lose_left_down);
        final Animation animLRD = AnimationUtils.loadAnimation(this, R.anim.anim_lose_right_down);

        animationLU.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagLU % 3 == 0){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_dark);
                    damageLU = DAMAGE_POSITIVE;
                }
                if(flagLU % 3 == 1){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_light);
                    damageLU = DAMAGE_NEGATIVE;
                }
                ibtnCupLU.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupLU.startAnimation(animLL);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLL.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ibtnCupLU.setEnabled(true);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagLU % 3 == 0){
                    ibtnCupLU.setImageResource(R.drawable.ic_cup_light);
                    flagLU++;
                }
                else countLose++;tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupLU.startAnimation(animationLU);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animationLD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagLD % 2 == 0){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_dark);
                    damageLD = DAMAGE_POSITIVE;
                }
                if(flagLD % 2 == 1){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_light);
                    damageLD = DAMAGE_NEGATIVE;
                }
                ibtnCupLD.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupLD.startAnimation(animLLD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLLD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ibtnCupLD.setEnabled(true);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagLD % 2 == 0){
                    ibtnCupLD.setImageResource(R.drawable.ic_cup_light);
                    flagLD++;
                }
                else countLose++;tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupLD.startAnimation(animationLD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animationRU.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagRU % 4 == 0){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_dark);
                    damageRU = DAMAGE_POSITIVE;
                }
                if(flagRU % 4 == 1){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_light);
                    damageRU = DAMAGE_NEGATIVE;
                }
                ibtnCupRU.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupRU.startAnimation(animLR);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLR.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ibtnCupRU.setEnabled(true);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagRU %4==0){
                    ibtnCupRU.setImageResource(R.drawable.ic_cup_light);
                    flagRU++;
                }
                else countLose++; tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupRU.startAnimation(animationRU);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animationRD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if(flagRD % 3 == 0){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_dark);
                    damageRD = DAMAGE_POSITIVE;
                }
                if(flagRD % 3 == 1){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_light);
                    damageRD = DAMAGE_NEGATIVE;
                }
                ibtnCupRD.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ibtnCupRD.startAnimation(animLRD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animLRD.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                ibtnCupRD.setEnabled(true);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(flagRD %3==0){
                    ibtnCupRD.setImageResource(R.drawable.ic_cup_light);
                    flagRD++;
                }
                else countLose++; tvLose.setText(getString(R.string.Lost)+":"+countLose);
                ibtnCupRD.startAnimation(animationRD);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        switch (view.getId()) {
            case R.id.cup_left_up:
                onTouchCup(damageLU);
                flagLU++;
                ibtnCupLU.startAnimation(animationLU);
                break;
            case R.id.cup_left_down:
                onTouchCup(damageLD);
                flagLD++;
                ibtnCupLD.startAnimation(animationLD);
                break;
            case R.id.cup_right_up:
                onTouchCup(damageRU);
                flagRU++;
                ibtnCupRU.startAnimation(animationRU);
                break;
            case R.id.cup_right_down:
                onTouchCup(damageRD);
                flagRD++;
                ibtnCupRD.startAnimation(animationRD);
                break;
        }

        GameSpeed speed = new GameSpeed();
        speed.gameSpeed(countWin, animationLU, animLL, animationLD, animLLD, animationRU, animLR, animationRD, animLRD);

        if(countLose>=5){
            Intent intent = new Intent(this,EndActivity.class);
            intent.putExtra("resultscore",tvWin.getText().toString());
            startActivity(intent);finish();
        }
    }
}
