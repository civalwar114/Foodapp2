package com.example.foodapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import algorithm.Food_Algorithm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_click(View view)
    {
        TextView textView = (TextView)findViewById(R.id.text_View);
        EditText editText = (EditText)findViewById(R.id.EDT);
        TextView text_Food =(TextView)findViewById(R.id.text_Food);

        textView.setText(editText.getText()); // 사용자가 입력한 문자로 바꾸기

        //음식 알고리즘 가져오기
        Food_Algorithm f = new Food_Algorithm(this);
        String food = f.Food_Algorithm(textView.getText().toString());
        text_Food.setText(food); // 음식 추천 출력
    }

}