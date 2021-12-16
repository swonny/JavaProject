package com.example.javaproject;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
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
    TextView tamaName;
    Timer mTimer = new Timer();
    TimerTask mTimerTask;

    public void controlButton(Button eatButton, Button playButton, Button sleepButton, boolean b) { // 버튼 활성화 또는 비활성화
        eatButton.setEnabled(b); // 밥먹기 버튼
        playButton.setEnabled(b); // 놀아주기 버튼
        sleepButton.setEnabled(b); // 잠자기 버튼
    }

    public void setToast(String time) {
        Toast toast = Toast.makeText(getApplicationContext(), "energy가 "+time+" 되었습니다!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 200);
        toast.show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);

        Intent intent = getIntent();

        characterName = (TextView) findViewById(R.id.characterName);
        tamaName = (TextView) findViewById(R.id.tamaName);
        myCharacter = (Tama) intent.getSerializableExtra("myTama"); // 객체 불러오기

        tamaName.setText(myCharacter.name+ " 키우기!");
        characterName.setText("레벨      :   " + myCharacter.getLevel() + "\n에너지  :   "+ myCharacter.getEnergy());

        ImageView imageView = (ImageView) findViewById(R.id.imageView); // 그리드판 이미지뷰 불러오기
        imageView.setImageResource(R.drawable.usual);

        TextView sleepTimerView = (TextView) findViewById(R.id.sleepTimer); // 자는 시간 타이머 뷰

        Button eatButton = (Button) findViewById(R.id.eatButton); // 먹기 버튼
        Button playButton = (Button) findViewById(R.id.playButton); // 놀아주기 버튼
        Button sleepButton = (Button) findViewById(R.id.sleepButton); // 잠자기 버튼

        ImageView level2image = (ImageView) findViewById(R.id.level2); // level2 귀

        sleepButton.setOnClickListener(new View.OnClickListener() { // 잠자기 버튼 클릭시 타이머 시작
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) { // 3초에 한번씩 이미지뷰 바꿔 연속적으로 보이도록 설정
                        controlButton(eatButton, playButton, sleepButton, false); // 버튼 비활성화
                        int num = (int) (millisUntilFinished / 1000);
                        characterName.setVisibility(characterName.GONE); // info 글  잠시 지우기
                        sleepTimerView.setText(Integer.toString(num + 1) + "초 뒤에 일어날게요!😴"); // 타이머 설정
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
                        characterName.setVisibility(characterName.VISIBLE);
                        setInfoTextview();
                        sleepTimerView.setText("");
                        setToast("+5"); // toast 메시지 띄우기
                        controlButton(eatButton, playButton, sleepButton, true); // 버튼 활성화
                        imageView.setImageResource(R.drawable.usual);
                        if(myCharacter.getLevel()>=2) {
                            level2image.setVisibility(View.VISIBLE);
                        }
                    }
                }.start();
            }
        });

        eatButton.setOnClickListener(new View.OnClickListener() { // 먹기 버튼 클릭시 타이머 시작
            @Override
            public void onClick(View view) {
                CountDownTimer countDownTimer = new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) { // 1초마다 먹는 이미지 번갈아가면서 바꾸기
                        controlButton(eatButton, playButton, sleepButton, false);
                        int num = (int) (millisUntilFinished / 1000);
                        if((num+1)%2 == 0) {
                            imageView.setImageResource(R.drawable.eat);
                        } else if ((num+1)%2 == 1) {
                            imageView.setImageResource(R.drawable.eat2);
                        }
                    }

                    @Override
                    public void onFinish() {
                        myCharacter.eat();
                        setInfoTextview();
                        sleepTimerView.setText("");
                        controlButton(eatButton, playButton, sleepButton, true);
                        setToast("+2"); // toast 메시지 띄우기
                        imageView.setImageResource(R.drawable.usual);
                        if(myCharacter.getLevel()>=2) {
                            level2image.setVisibility(View.VISIBLE);
                        }
                    }
                }.start();
            }
        });

       playButton.setOnClickListener(new View.OnClickListener() { // play 버튼 클릭 이벤트리스너 생성
           @Override
           public void onClick(View view) {
               imageView.setImageResource(R.drawable.background);
               ImageView playImageView;
               if(myCharacter.getLevel()>= 2) {
                   playImageView = (ImageView) findViewById(R.id.playImage2); // play 이미지뷰 불러오기
                   level2image.setVisibility(View.INVISIBLE);
                   playImageView.setVisibility(playImageView.VISIBLE); // play 이미지뷰 GONE -> VISIBLE로
                   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move); // 애니메이션 추가
                   playImageView.startAnimation(animation);
               } else {
                   playImageView = (ImageView) findViewById(R.id.playImage); // play 이미지뷰 불러오기
                   playImageView.setVisibility(playImageView.VISIBLE); // play 이미지뷰 GONE -> VISIBLE로
                   Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move); // 애니메이션 추가
                   playImageView.startAnimation(animation);
               }

               CountDownTimer countDownTimer = new CountDownTimer(5000,1000) { // 5초 동안 애니메이션 실행
                   @Override
                   public void onTick(long millisUntilFinished) {
                       controlButton(eatButton, playButton, sleepButton, false);
                   }

                   @Override
                   public void onFinish() {
                       myCharacter.play(); // play -> energy + 2

                       if(myCharacter.getEnergy() <= 0) {
                           setToast("-8"); // toast 메시지 띄우기
                           Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                           startActivity(intent);
                       } else {
                           setToast("+5"); // toast 메시지 띄우기
                           setInfoTextview(); // 에너지, 레벨 정보 업데이트
                           playImageView.getAnimation().cancel(); // 애니메이션 종료
                           playImageView.setVisibility(playImageView.GONE); // play 이미지 없애기
                           imageView.setImageResource(R.drawable.usual); // 이미지 돌려놓기
                           controlButton(eatButton, playButton, sleepButton, true);
                           if(myCharacter.getLevel()>=2) {
                               level2image.setVisibility(View.VISIBLE);
                           }
                       }
                   }
               }.start();
           }
       });
    }

    public void setInfoTextview() {
        characterName.setText("레벨      : " + myCharacter.getLevel() + "\n에너지  : "+ myCharacter.getEnergy());
    }

//    public void eat(View v) {
//        Toast eatToast = Toast.makeText(getApplicationContext(), "점심시간!", Toast.LENGTH_SHORT);
//        eatToast.show();
//        myCharacter.eat();
//        setInfoTextview();
//    }

//    public void play(View v) {
//        Toast.makeText(getApplicationContext(), "뭐하고 놀까?", Toast.LENGTH_SHORT).show();
//        myCharacter.play();
//        setInfoTextview();
//
//        ImageView imageView = (ImageView) findViewById(R.id.imageView); // 배경 변
//        imageView.setImageResource(R.drawable.background);
//        ImageView playImageView = (ImageView) findViewById(R.id.playImage);
//        playImageView.setVisibility(playImageView.VISIBLE);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
//        playImageView.startAnimation(animation);
//    }

}
