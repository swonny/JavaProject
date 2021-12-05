package com.example.javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SubActivity extends AppCompatActivity {

    Tama myCharacter;
    TextView characterName;
    Timer mTimer = new Timer();
    TimerTask mTimerTask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);

        Intent intent = getIntent();

        characterName = (TextView) findViewById(R.id.characterName);
        myCharacter = (Tama) intent.getSerializableExtra("myTama"); // 객체 불러오기

        characterName.setText("이름 : "+ myCharacter.name + "\n레벨 : " + myCharacter.getLevel() + "\n에너지 : "+ myCharacter.getEnergy());

        //카운트다운 타이머 시작
        TextView sleepTimerView = (TextView) findViewById(R.id.sleepTimer);
        Button sleepButton = (Button) findViewById(R.id.sleepButton);
        sleepButton.setOnClickListener(new View.OnClickListener() { // 잠자기 버튼 클릭시 타이머 시작
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(30000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int num = (int) (millisUntilFinished / 1000);
                        sleepTimerView.setText(Integer.toString(num+1) + "초 뒤에 일어날게요!😴");
                    }

                    @Override
                    public void onFinish() {
                        myCharacter.sleep();
                        setInfoTextview();
                        sleepTimerView.setText("상태 : 잠에서 깨어났어요!");
                    }
                }.start();
            }
        });

    }

    public void setInfoTextview() {
        characterName.setText("이름 : "+ myCharacter.name + "\n레벨 : " + myCharacter.getLevel() + "\n에너지 : "+ myCharacter.getEnergy());
    }

    public void eat(View v) {
        Toast eatToast = Toast.makeText(getApplicationContext(), "점심시간!", Toast.LENGTH_SHORT);
        eatToast.show();
        myCharacter.eat();
        setInfoTextview();
    }

    public void play(View v) {
        Toast.makeText(getApplicationContext(), "뭐하고 놀까?", Toast.LENGTH_SHORT).show();
        myCharacter.play();
        setInfoTextview();
    }

}
