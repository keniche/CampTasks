package com.lifeistech.android.ken.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int answer = 0;
    public int number = 0;
    public int operation = 0;

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        textView.setText("0");
    }

    public void zero(View v){
        number = number * 10 + 0;
        textView.setText(String.valueOf(number));
    }
    public void one(View v){
        number = number * 10 + 1;
        textView.setText(String.valueOf(number));
    }
    public void two(View v){
        number = number * 10 + 2;
        textView.setText(String.valueOf(number));
    }
    public void three(View v){
        number = number * 10 + 3;
        textView.setText(String.valueOf(number));
    }
    public void four(View v){
        number = number * 10 + 4;
        textView.setText(String.valueOf(number));
    }
    public void five(View v){
        number = number * 10 + 5;
        textView.setText(String.valueOf(number));
    }
    public void six(View v){
        number = number * 10 + 6;
        textView.setText(String.valueOf(number));
    }
    public void seven(View v){
        number = number * 10 + 7;
        textView.setText(String.valueOf(number));
    }
    public void eight(View v){
        number = number * 10 + 8;
        textView.setText(String.valueOf(number));
    }
    public void nine(View v){
        number = number * 10 + 9;
        textView.setText(String.valueOf(number));
    }

    public void plus(View V){
        caluculate();
        operation = 1;
        textView.setText("+");
    }
    public void minus(View V){
        caluculate();
        operation = 2;
        textView.setText("-");
    }
    public void multiplication(View V){
        caluculate();
        operation = 3;
        textView.setText("×");
    }
    public void division(View V){
        caluculate();
        operation = 4;
        textView.setText("÷");
    }

    public void allClear(){
        answer = 0;
        number = 0;
        operation = 0;
    }


    public void equal(View v){
        caluculate();
        textView.setText(String.valueOf(answer));
        allClear();
    }

    public void clear(View v){
        allClear();
        textView.setText(String.valueOf(answer));
    }



    public void caluculate(){
        switch (operation){
            case 0:
                answer = number;
                break;
            case 1:
                answer = answer + number;
                break;
            case 2:
                answer = answer - number;
                break;
            case 3:
                answer = answer * number;
                break;
            case 4:
                answer = answer / number;
                break;
        }
        number = 0;
    }



}
