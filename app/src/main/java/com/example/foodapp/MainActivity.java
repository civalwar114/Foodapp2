package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

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
        text_Food.setText(food_algorithm(textView.getText().toString())); //대답
        
    }

    //음식 알고리즘
    public String food_algorithm(String t) {
        //결과
        String result = "";
        //데이더 배열
        String[][] data = new String[100][3];

        //데이터 배열 초기값을 ""로 만들기
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                data[i][j] = "";
            }
        }
        try {      //배달 음식 데이터 불러오기
            InputStreamReader is = new InputStreamReader(getResources().openRawResource(R.raw.food));
            BufferedReader reader = new BufferedReader(is);
            String line = "";
            int row =0 ,i;
            while ((line = reader.readLine()) != null) {
                // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
                String[] token = line.split(",", -1);
                for(i=0;i<3;i++) {
                    data[row][i] = token[i];
                }
                row++;
            }
            reader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //인사 알고리즘
        String result_hello = "";
        String[] hello = new String[]{"안녕"};

        for (int i = 0; i < hello.length; i++) {
            if (t.contains(hello[i])) {
                result_hello = hello[i];
            }
        }

        //음식 종류 알고리즘
        String result_korfood = "";            //한식
        String[] korfood = new String[]{"한식"};
        String result_chinafood = "";         //중식
        String[] chinafood = new String[]{"중식"};
        String result_jpfood = "";            //일식
        String[] jpfood = new String[]{"일식"};
        String result_snackbar = "";         //분식
        String[] snackbar = new String[]{"분식"};
        String result_chicken = "";            //치킨
        String[] chicken = new String[]{"치킨"};
        String result_pizza = "";            //피자
        String[] pizza = new String[]{"피자"};
        String result_porkfeet = "";         //족발
        String[] porkfeet = new String[]{"족발"};
        String result_bossam = "";            //보쌈
        String[] bossam = new String[]{"보쌈"};

        for (int i = 0; i < korfood.length; i++) {
            if (t.contains(korfood[i])) {
                result_korfood = "한식";
            }
            if (t.contains(chinafood[i])) {
                result_chinafood = "중식";
            }
            if (t.contains(jpfood[i])) {
                result_jpfood = "일식";
            }
            if (t.contains(snackbar[i])) {
                result_snackbar = "분식";
            }
            if (t.contains(chicken[i])) {
                result_chicken = "치킨";
            }
            if (t.contains(pizza[i])) {
                result_pizza = "피자";
            }
            if (t.contains(porkfeet[i])) {
                result_porkfeet = "족발";
            }
            if (t.contains(bossam[i])) {
                result_bossam = "보쌈";
            }
        }

        //맛 종류 알고리즘
        String result_sweet = "";            //단맛
        String[] sweet = new String[]{"단맛"};
        String result_salty = "";            //짠맛
        String[] salty = new String[]{"짠맛"};
        String result_sour = "";            //신맛
        String[] sour = new String[]{"신맛"};
        String result_bitter = "";            //쓴맛
        String[] bitter = new String[]{"쓴맛"};
        String result_umami = "";            //감칠맛
        String[] umami = new String[]{"감칠맛"};
        String result_fat = "";               //지방맛
        String[] fat = new String[]{"지방맛"};
        String result_spicy = "";            //매운맛
        String[] spicy = new String[]{"매운맛"};

        for (int i = 0; i < sweet.length; i++) {
            if (t.contains(sweet[i])) {
                result_sweet = "단맛";
            }
            if (t.contains(salty[i])) {
                result_salty = "짠맛";
            }
            if (t.contains(sour[i])) {
                result_sour = "신맛";
            }
            if (t.contains(bitter[i])) {
                result_bitter = "쓴맛";
            }
            if (t.contains(umami[i])) {
                result_umami = "감칠맛";
            }
            if (t.contains(fat[i])) {
                result_fat = "지방맛";
            }
            if (t.contains(spicy[i])) {
                result_spicy = "매운맛";
            }
        }

        //추천 알고리즘
        String[] result_recommend = new String[data.length];
        int[] recommend = new int[data.length];
        int[] max_recommend = new int[data.length];

        for(int i=0; i<data.length; i++) {      //음식 종류
            if (result_korfood != "") {
                if(data[i][1].contains(result_korfood))
                    recommend[i] += 1;
            }
            if (result_chinafood != "") {
                if(data[i][1].contains(result_chinafood))
                    recommend[i] += 1;
            }
            if (result_jpfood != "") {
                if(data[i][1].contains(result_jpfood))
                    recommend[i] += 1;
            }
            if (result_snackbar != "") {
                if(data[i][1].contains(result_snackbar))
                    recommend[i] += 1;
            }
            if (result_chicken != "") {
                if(data[i][1].contains(result_chicken))
                    recommend[i] += 1;
            }
            if (result_pizza != "") {
                if(data[i][1].contains(result_pizza))
                    recommend[i] += 1;
            }
            if (result_porkfeet != "") {
                if(data[i][1].contains(result_porkfeet))
                    recommend[i] += 1;
            }
            if (result_bossam != "") {
                if(data[i][1].contains(result_bossam))
                    recommend[i] += 1;
            }
        }

        for(int i=0; i<data.length; i++) {      //맛 종류
            if (result_sweet != "") {
                if(data[i][2].contains(result_sweet))
                    recommend[i] += 1;
            }
            if (result_salty != "") {
                if(data[i][2].contains(result_salty))
                    recommend[i] += 1;
            }
            if (result_sour != "") {
                if(data[i][2].contains(result_sour))
                    recommend[i] += 1;
            }
            if (result_bitter != "") {
                if(data[i][2].contains(result_bitter))
                    recommend[i] += 1;
            }
            if (result_umami != "") {
                if(data[i][2].contains(result_umami))
                    recommend[i] += 1;
            }
            if (result_fat != "") {
                if(data[i][2].contains(result_fat))
                    recommend[i] += 1;
            }
            if (result_spicy != "") {
                if(data[i][2].contains(result_spicy))
                    recommend[i] += 1;
            }
        }

        int j=0;
        for(int i=0; i<data.length; i++) {
            if(max_recommend[i] < recommend[i]) {
                max_recommend[i] = recommend[i];
                result_recommend[j] = data[i][0];
                j++;
            }
        }

        //결과 알고리즘
        for(int i=0; i<j; i++) {
            if(i != 0)
                result += ", ";
            result += result_recommend[i];
        }

        return result;  //결과 출력
    }

}