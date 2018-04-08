package com.lifeistech.android.ken.count2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        text.setText("0");
    }

    public void plus(View v) {
        number = number + 1;
        text.setText(String.valueOf(number));
    }

    public void minus(View v) {
        number = number - 1;
        text.setText(String.valueOf(number));
    }

    public void clear(View v) {
        number = 0;
        text.setText(String.valueOf(number));
    }
    public void kakeru(View v) {
        number = number * 2;
        text.setText(String.valueOf(number));
    }
    public void waru(View v) {
        number = number / 2;
        text.setText(String.valueOf(number));
    }

}
