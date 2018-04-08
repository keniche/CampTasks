package com.lifeistech.android.ken.techdragon;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int power;
    private TextView powerTextView;
    private int hp;
    private TextView hpTextView;
    private ImageView dragonImageView;
    private TextView damageTextView;
    private ProgressBar hpBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerTextView = (TextView)findViewById(R.id.powerTextView);
            /*hpTextView = (TextView)findViewById(R.id.hpTextView);*/
        dragonImageView = (ImageView)findViewById(R.id.dragonImageView);
        damageTextView = (TextView)findViewById(R.id.damageTextView);
        hpBar = (ProgressBar)findViewById(R.id.hpBar);

        hp = 100;
        hpBar.setProgress(hp);

    }
    public  void attack(View v){
        hp = hp - power;
            /* hpTextView.setText(String.valueOf(hp)); */
        damageAnimation();
        hpBar.setProgress(hp);
        if (hp <= 0){
            clearAnimation();
        }
    }

    public void powerUp(View v){
        power = power + 3;
        powerTextView.setText(String.valueOf(power));
    }
    public void damageAnimation(){
        if (power > 0){
            damageTextView.setText(String.valueOf(power));
        }else{
            damageTextView.setText("miss！");
        }
    }
    //TODO: アタックのアニメーション！
    /*
       public void killAnimation(){
           AttackAnimation attackAnim = new AttackAnimation(
               this.getApplicationContext(),
               dragonImageView, damageTextView);
       dragonImageView.startAnimation(attackAnim);
       }
       */

    public void clearAnimation(){
        AlphaAnimation alphaAnim = new AlphaAnimation(1.0f, 0.0f);
        alphaAnim.setDuration(1500);
        alphaAnim.setStartOffset(1500);
        alphaAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dragonImageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        dragonImageView.startAnimation(alphaAnim);
    }
    public void retry(View v){
        hp = 100;
        power = 0;
        dragonImageView.setVisibility(View.VISIBLE);
        powerTextView.setTextColor(Color.WHITE);
        powerTextView.setText(String.valueOf(power));
        hpBar.setProgress(hp);
            /*hpTextView.setText(String.valueOf(hp)); */
        damageTextView.setText(" ");
    }
    public void info(View v){
        Intent intent = new Intent(this,infoActivity.class);
        startActivity(intent);
    }




}
