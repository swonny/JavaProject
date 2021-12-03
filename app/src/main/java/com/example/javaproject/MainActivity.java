package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


class Tama {
    final String name;
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

        Button startButton = (Button) findViewById(R.id.startBtn); // 화면전환 이벤트
        TextView characterName = (TextView) findViewById(R.id.characterName);
        EditText scanName = (EditText) findViewById(R.id.scanName);
        startButton.setOnClickListener(new View.OnClickListener() { // 시작 버튼 화면전환
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
                 characterName.setText(scanName.getText());

//                String tName = new String(scanName.getText());
//                Tama myChar = new Tama();
            }
        });

        Button sendNameButton = (Button) findViewById(R.id.sendName);
        sendNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tName = new String(String.valueOf(scanName.getText()));
                Toast.makeText(getApplicationContext(), tName+" 생성!", Toast.LENGTH_SHORT).show();
                Tama myCharacter = new Tama(tName);

                System.out.println(myCharacter.name);
            }
        });

    }
    Scanner scan = new Scanner(System.in);

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

