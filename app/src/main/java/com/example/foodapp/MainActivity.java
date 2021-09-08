package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

        editText.addTextChangedListener(new TextWatcher() //대답창
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //입력전 이벤트

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //변화가 있을시 이벤트
                // Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void afterTextChanged(Editable s) {
                //입력후 이벤트
                //Toast.makeText(getApplicationContext(),"rjdrhd",Toast.LENGTH_SHORT).show();
                // text_Food.setText("테스트"); 입력을 누르기도 전에 바뀜;;
                // 여기가 텍스트 변화 감지 하는곳임 여기서 그 알고리즘 쓰면 될듯?
            }
        });



    }




}