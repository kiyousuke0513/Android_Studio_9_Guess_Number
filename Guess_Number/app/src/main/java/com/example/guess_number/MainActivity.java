package com.example.guess_number;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int Spend = 0;//花費次數
    int User_Input = 0;//User選的數字
    int Answer = 0;//答案

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Answer = (int)(Math.random()*9) + 1;
    }

    public void BTN1_TRIG(View view) {
        To_Answer_Activity(1);
    }

    public void BTN2_TRIG(View view) {
        To_Answer_Activity(2);
    }

    public void BTN3_TRIG(View view) {
        To_Answer_Activity(3);
    }

    public void BTN4_TRIG(View view) {
        To_Answer_Activity(4);
    }

    public void BTN5_TRIG(View view) {
        To_Answer_Activity(5);
    }

    public void BTN6_TRIG(View view) {
        To_Answer_Activity(6);
    }

    public void BTN7_TRIG(View view) {
        To_Answer_Activity(7);
    }

    public void BTN8_TRIG(View view) {
        To_Answer_Activity(8);
    }

    public void BTN9_TRIG(View view) {
        To_Answer_Activity(9);
    }

    public void BTN_RST_TRIG(View view) {
        Restart();
    }

    @SuppressLint("SetTextI18n")
    public void To_Answer_Activity(int User_Input) {
        TextView textView_Spend = findViewById(R.id.textView_Spend);
        TextView textView_Prev_Input = findViewById(R.id.textView_Prev_Input);

        this.User_Input = User_Input;
        Spend++;

        if(User_Input != 0)
            textView_Prev_Input.setText("上次選的數字 : " + User_Input);
        else
            textView_Prev_Input.setText("");

        if(Spend != 0)
            textView_Spend.setText("花費的次數 : " + Spend);
        else
            textView_Spend.setText("");

        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Activity_Answer.class);

        Bundle bundle = new Bundle();//建立Bundle以傳送資料
        bundle.putInt("User_Input", User_Input);
        bundle.putInt("Answer", Answer);
        bundle.putInt("Spend", Spend);
        intent.putExtras(bundle);//將Bundle物件put給intent

        startActivity(intent);

        if(User_Input == Answer)
            MainActivity.this.finish();//結束目前 Activity
    }

    public void Restart() {
        TextView textView_Spend = findViewById(R.id.textView_Spend);
        TextView textView_Prev_Input = findViewById(R.id.textView_Prev_Input);

        Spend = 0;//花費次數
        User_Input = 0;//User選的數字
        Answer = (int)(Math.random()*9) + 1;
        textView_Prev_Input.setText("");
        textView_Spend.setText("");
    }
}