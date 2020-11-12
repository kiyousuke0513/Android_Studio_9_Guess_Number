package com.example.guess_number;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Answer extends AppCompatActivity {
    int User_Input;
    int Answer;
    int Spend;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textView_Result = findViewById(R.id.textView_Result);
        TextView textView_DBG = findViewById(R.id.textView_DBG);

        //檢查Intent是否有Extra
        if (this.getIntent().hasExtra("User_Input")
        &&  this.getIntent().hasExtra("Answer")
        &&  this.getIntent().hasExtra("Spend"))
        {
            Bundle bundle = this.getIntent().getExtras();
            User_Input = bundle.getInt("User_Input");
            Answer = bundle.getInt("Answer");
            Spend = bundle.getInt("Spend");

            if(User_Input == Answer) {
                imageView.setImageResource(R.mipmap.bingle);
                textView_Result.setText("答對了,你好棒喔!\n共猜了" + Spend + "次");
            }
            else if(User_Input > Answer) {
                imageView.setImageResource(R.mipmap.fail);
                textView_Result.setText("太大了");
            }
            else if(User_Input < Answer) {
                imageView.setImageResource(R.mipmap.fail);
                textView_Result.setText("太小了");
            }
            textView_DBG.setText("");//Debug監視用
            //textView_DBG.setText("User:" + User_Input + "   " + "Ans:" +  Answer);//Debug監視用
        }
    }

    public void BTN_Continue_TRIG(View view) {
        if (User_Input == Answer) {
            Intent intent = new Intent();
            intent.setClass(Activity_Answer.this, MainActivity.class);
            startActivity(intent);
        }
        Activity_Answer.this.finish();//結束目前 Activity
    }
}
