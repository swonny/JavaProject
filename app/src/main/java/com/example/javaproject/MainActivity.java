package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

Button eatBtn, playBtn, sleepBtn;
TextView tamaName;

class Tama {
    private String name;
    private int level;
    private int energy;

    public Tama(String name){ // init
        this.name = name;
        this.level = 1;
        this.energy = 15;
    }

    public void eat() {
        energy += 2;
    }

    public void play() {

    }

    public void sleep() {

    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eatBtn =
    }

    public void eat(View v) {
        Toast.makeText(getApplicationContext(), "점심시간!", Toast.LENGTH_SHORT).show();
    }

    public void play(View v) {
        Toast.makeText(getApplicationContext(), "뭐하고 놀까?", Toast.LENGTH_SHORT).show();
    }

    public void sleep(View v) {
        Toast.makeText(getApplicationContext(), "z Z z z Z ..", Toast.LENGTH_SHORT).show();
    }

//            // 레이아웃 생성
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout .setOrientation(LinearLayout.VERTICAL);
//
//        // 레이아웃 파라미터 생성
//        LinearLayout.LayoutParams linearLayoutParams =
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                );
//
//        // 텍스트뷰를 생성한 후 파라미터 설정
//        TextView textView = new TextView(this);
//        textView.setText("Text View");
//        textView.setLayoutParams(linearLayoutParams);
//
//        // 생성한 TextView 를 linearLayout 에 추가
//        linearLayout .addView(textView);
//
//        // 화면에 표시되도록 setContentView 실
//        setContentView(linearLayout);

//    @Override
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // 레이아웃 생성
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout .setOrientation(LinearLayout.VERTICAL);
//
//        // 레이아웃 파라미터 생성
//        LinearLayout.LayoutParams linearLayoutParams =
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                );
//
//        // 텍스트뷰를 생성한 후 파라미터 설정
//        TextView textView = new TextView(this);
//        textView.setText("Text View");
//        textView.setLayoutParams(linearLayoutParams);
//
//        // 생성한 TextView 를 linearLayout 에 추가
//        linearLayout .addView(textView);
//
//        // 화면에 표시되도록 setContentView 실
//        setContentView(linearLayout);
//    }


}

