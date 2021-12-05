package com.example.javaproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
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

        characterName.setText("이름      : "+ myCharacter.name + "\n레벨      : " + myCharacter.getLevel() + "\n에너지  : "+ myCharacter.getEnergy());

        ImageView imageView = (ImageView) findViewById(R.id.imageView); // 이미지뷰
        imageView.setImageResource(R.drawable.usual);

        TextView sleepTimerView = (TextView) findViewById(R.id.sleepTimer); // 자는 시간 타이머 뷰
        Button sleepButton = (Button) findViewById(R.id.sleepButton);
        sleepButton.setOnClickListener(new View.OnClickListener() { // 잠자기 버튼 클릭시 타이머 시작
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(20000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int num = (int) (millisUntilFinished / 1000);
                        sleepTimerView.setText(Integer.toString(num + 1) + "초 뒤에 일어날게요!😴");
                        if((num+1) <= 1) {
                            sleepTimerView.setText("잠에서 깨어났어요!");
                            imageView.setImageResource(R.drawable.usual);
                        } else if((num+1)%3 == 0) {
                            imageView.setImageResource(R.drawable.sleep);
                        } else if ((num+1)%3 == 2) {
                            imageView.setImageResource(R.drawable.sleep2);
                        } else if ((num+1)%3 == 1) {
                            imageView.setImageResource(R.drawable.sleep3);
                        }
                    }

                    @Override
                    public void onFinish() {
                        myCharacter.sleep();
                        setInfoTextview();
                        sleepTimerView.setText("");
                        imageView.setImageResource(R.drawable.usual);
                    }
                }.start();
            }
        });

        Button eatButton = (Button) findViewById(R.id.eatButton);
        eatButton.setOnClickListener(new View.OnClickListener() { // 잠자기 버튼 클릭시 타이머 시작
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int num = (int) (millisUntilFinished / 1000);
                        if((num+1)%2 == 0) {
                            imageView.setImageResource(R.drawable.eat);
                        } else if ((num+1)%2 == 1) {
                            imageView.setImageResource(R.drawable.eat2);
                        }
                    }

                    @Override
                    public void onFinish() {
                        myCharacter.sleep();
                        setInfoTextview();
                        sleepTimerView.setText("");
                        imageView.setImageResource(R.drawable.usual);
                    }
                }.start();
            }
        });
    }

    public void setInfoTextview() {
        characterName.setText("이름      : "+ myCharacter.name + "\n레벨      : " + myCharacter.getLevel() + "\n에너지  : "+ myCharacter.getEnergy());
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

        ImageView imageView = (ImageView) findViewById(R.id.imageView); // 이미지뷰
        imageView.setImageResource(R.drawable.background);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        imageView.startAnimation(animation);
    }

}
