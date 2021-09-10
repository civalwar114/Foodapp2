package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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
        //데이더 배열
        String[][] data = new String[18][4];       //food.csv 열, 줄 개수 맞추기

        //데이터 배열 초기값을 ""로 만들기
        for(int i=0; i<data.length; i++) {
            for(int j=0; j<data[0].length; j++) {
                data[i][j] = "";
            }
        }

        //배달 음식 데이터 불러오기 (food.csv)
        try {
            InputStreamReader is = new InputStreamReader(getResources().openRawResource(R.raw.food));
            BufferedReader reader = new BufferedReader(is);
            String line = "";
            int row =0 ,i;
            while ((line = reader.readLine()) != null) {
                // -1 옵션은 마지막 "," 이후 빈 공백도 읽기 위한 옵션
                String[] token = line.split(",", -1);
                for(i=0;i<4;i++) {  //데이터 줄 갯수 맞추기
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

        //변수
        int i;   //반복문에 사용
        String result = ""; //결과 내용!

        //인사 알고리즘
        String result_hello = "";
        String[] hello = new String[]{"안녕", "하이", "ㅎㅇ", "반가", "반갑", "방가"};

        for (i = 0; i < hello.length; i++) {
            if (t.contains(hello[i])) {
                result_hello = "안녕하세요 ";
            }
        }

        //음식 종류 알고리즘
        String result_korfood = "";				//한식
        String[] korfood = new String[]{"한식", "한국"};
        String result_chinafood = "";			//중식
        String[] chinafood = new String[]{"중식", "중국"};
        String result_jpfood = "";				//일식
        String[] jpfood = new String[]{"일식", "일본"};
        String result_snackbar = "";			//분식
        String[] snackbar = new String[]{"분식", "간식"};
        String result_chicken = "";				//치킨
        String[] chicken = new String[]{"치킨", "통닭"};
        String result_pizza = "";				//피자
        String[] pizza = new String[]{"피자", "파파존스"};
        String result_porkfeet = "";			//족발
        String[] porkfeet = new String[]{"족발", "고기"};
        String result_bossam = "";				//보쌈
        String[] bossam = new String[]{"보쌈", "수육"};

        for (i = 0; i < korfood.length; i++) {
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

        //음식 유형 알고리즘
        String result_noodle = "";				//면
        String[] noodle = new String[]{"면류", "면", "국수"};
        String result_soup = "";				//국
        String[] soup = new String[]{"국물", "국", "탕"};
        String result_fried = "";				//튀김
        String[] fried = new String[]{"튀김", "프라이드", "후라이드"};
        String result_rice = "";				//밥
        String[] rice = new String[]{"밥", "곡류", "곡물"};
        String result_bread = "";				//빵
        String[] bread = new String[]{"빵", "밀", "제과"};
        String result_meat = "";				//고기
        String[] meat = new String[]{"고기", "육류", "육"};
        String result_fish = "";				//생선
        String[] fish = new String[]{"생선", "어류", "물고기"};
        String result_snack = "";			    //간식
        String[] snack = new String[]{"간식", "간단", "디저트"};

        for (i = 0; i < noodle.length; i++) {
            if (t.contains(noodle[i])) {
                result_noodle = "면";
            }
            if (t.contains(soup[i])) {
                result_soup = "국";
            }
            if (t.contains(fried[i])) {
                result_fried = "튀김";
            }
            if (t.contains(rice[i])) {
                result_rice = "밥";
            }
            if (t.contains(bread[i])) {
                result_bread = "빵";
            }
            if (t.contains(meat[i])) {
                result_meat = "고기";
            }
            if (t.contains(fish[i])) {
                result_fish = "생선";
            }
            if (t.contains(snack[i])) {
                result_snack = "간식";
            }
        }

        //맛 유형 알고리즘
        String result_sweet = "";				//단맛
        String[] sweet = new String[]{"단맛", "달달", "단"};
        String result_salty = "";				//짠맛
        String[] salty = new String[]{"짠맛", "짜", "짠"};
        String result_sour = "";				//신맛
        String[] sour = new String[]{"신맛", "신", "셔"};
        String result_bitter = "";				//쓴맛
        String[] bitter = new String[]{"쓴맛", "쓴", "써"};
        String result_umami = "";				//감칠맛
        String[] umami = new String[]{"감칠맛", "msg", "미원"};
        String result_fat = "";					//지방맛
        String[] fat = new String[]{"지방맛", "기름", "느끼"};
        String result_spicy = "";				//매운맛
        String[] spicy = new String[]{"매운맛", "맵", "매운"};

        for (i = 0; i < sweet.length; i++) {
            if (t.contains(sweet[i])) {
                if (t.indexOf(sweet[i]) > 0 && t.substring(t.indexOf(sweet[i]) - 1, t.indexOf(sweet[i])).contains("안"))
                    result_sweet = "안단맛";   //단어 앞에 "안" 이 있을경우 부정!!
                else
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
        String[] result_recommend = new String[data.length];    //추천 결과
        int[] recommend = new int[data.length];     //가중치 구하기
        int max_recommend = 0;  //가중치 최댓값
        int num_recommend = 0;  //가중치 갯수 (추천 갯수)

        for(i=1; i<data.length; i++) {		//음식 종류 가중치 +2
            if (result_korfood != "") {
                if(data[i][1].contains(result_korfood))
                    recommend[i] += 2;
            }
            if (result_chinafood != "") {
                if(data[i][1].contains(result_chinafood))
                    recommend[i] += 2;
            }
            if (result_jpfood != "") {
                if(data[i][1].contains(result_jpfood))
                    recommend[i] += 2;
            }
            if (result_snackbar != "") {
                if(data[i][1].contains(result_snackbar))
                    recommend[i] += 2;
            }
            if (result_chicken != "") {
                if(data[i][1].contains(result_chicken))
                    recommend[i] += 2;
            }
            if (result_pizza != "") {
                if(data[i][1].contains(result_pizza))
                    recommend[i] += 2;
            }
            if (result_porkfeet != "") {
                if(data[i][1].contains(result_porkfeet))
                    recommend[i] += 2;
            }
            if (result_bossam != "") {
                if(data[i][1].contains(result_bossam))
                    recommend[i] += 2;
            }
        }

        for(i=1; i<data.length; i++) {		//음식 유형 가중치 +1
            if (result_noodle != "") {
                if(data[i][2].contains(result_noodle))
                    recommend[i] += 1;
            }
            if (result_soup != "") {
                if(data[i][2].contains(result_soup))
                    recommend[i] += 1;
            }
            if (result_fried != "") {
                if(data[i][2].contains(result_fried))
                    recommend[i] += 1;
            }
            if (result_rice != "") {
                if(data[i][2].contains(result_rice))
                    recommend[i] += 1;
            }
            if (result_bread != "") {
                if(data[i][2].contains(result_bread))
                    recommend[i] += 1;
            }
            if (result_meat != "") {
                if(data[i][2].contains(result_meat))
                    recommend[i] += 1;
            }
            if (result_fish != "") {
                if(data[i][2].contains(result_fish))
                    recommend[i] += 1;
            }
            if (result_snack != "") {
                if(data[i][2].contains(result_snack))
                    recommend[i] += 1;
            }
        }

        for(i=1; i<data.length; i++) {		//맛 유형 가중치 +1
            if (result_sweet != "") {
                if (result_sweet.contains("안") && data[i][3].contains(result_sweet.substring(1,3)))
                    recommend[i] -= 1;
                if(data[i][3].contains(result_sweet))
                    recommend[i] += 1;
            }
            if (result_salty != "") {
                if(data[i][3].contains(result_salty))
                    recommend[i] += 1;
            }
            if (result_sour != "") {
                if(data[i][3].contains(result_sour))
                    recommend[i] += 1;
            }
            if (result_bitter != "") {
                if(data[i][3].contains(result_bitter))
                    recommend[i] += 1;
            }
            if (result_umami != "") {
                if(data[i][3].contains(result_umami))
                    recommend[i] += 1;
            }
            if (result_fat != "") {
                if(data[i][3].contains(result_fat))
                    recommend[i] += 1;
            }
            if (result_spicy != "") {
                if(data[i][3].contains(result_spicy))
                    recommend[i] += 1;
            }
        }

        for(i=1; i<data.length; i++) {      //가중치 최댓값 구하기
            if(max_recommend < recommend[i]) {
                max_recommend = recommend[i];
            }
        }

        for(i=1; i<data.length; i++) {      //가중치가 젤 높은것들 result_recommend에 저장
            if(recommend[i] == max_recommend){
                result_recommend[num_recommend] = data[i][0];
                num_recommend++;
            }
        }

        //결과 알고리즘
        Random random = new Random();   //랜덤함수

        if(result_hello != "")          //인사 결과
            result += result_hello;

        result += result_recommend[random.nextInt(num_recommend)];   //음식 추천 결과 (가중치가 같은것들은 랜덤으로 하나 출력)

        //결과 출력
        return result;
    }

}