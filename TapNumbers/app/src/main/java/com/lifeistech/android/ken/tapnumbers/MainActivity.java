package com.lifeistech.android.ken.tapnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] hairetsu;
    String mondai;
    int seikai;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        start();
    }

    public void start() {
        hairetsu = new int[4];
        Random rand = new Random();
        hairetsu[0] = rand.nextInt(4) + 1;
        hairetsu[1] = rand.nextInt(4) + 1;
        hairetsu[2] = rand.nextInt(4) + 1;
        hairetsu[3] = rand.nextInt(4) + 1;

        mondai =
                Integer.toString(hairetsu[0])
                        + Integer.toString(hairetsu[1])
                        + Integer.toString(hairetsu[2])
                        + Integer.toString(hairetsu[3]);
        textView.setText(mondai);
        seikai = 0;
    }

    public void number1(View v) {
        if (hairetsu[seikai] == 1) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if (seikai == 4) {
                start();
            }
        } else {
            Toast.makeText(this, "数字が違うよ！", Toast.LENGTH_SHORT).show();
          }
    }

    public void number2(View v) {
        if (hairetsu[seikai] == 2) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if (seikai == 4) {
                start();
            }
        } else {
            Toast.makeText(this, "数字が違うよ！", Toast.LENGTH_SHORT).show();
        }
    }
    public void number3(View v) {
        if (hairetsu[seikai] == 3) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if (seikai == 4) {
                start();
            }
        } else {
            Toast.makeText(this, "数字が違うよ！", Toast.LENGTH_SHORT).show();
        }
    }
    public void number4(View v) {
        if (hairetsu[seikai] == 4) {
            mondai = mondai.substring(1);
            textView.setText(mondai);
            seikai = seikai + 1;
            if (seikai == 4) {
                start();
            }
        } else {
            Toast.makeText(this, "数字が違うよ！", Toast.LENGTH_SHORT).show();
        }
    }

}
