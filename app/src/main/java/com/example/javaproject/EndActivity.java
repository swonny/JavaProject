package com.example.javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_main);

        Intent intent = getIntent();

        ImageView deadImageView = (ImageView) findViewById(R.id.deadImageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.end); // 애니메이션 추가
        deadImageView.startAnimation(animation);

        Button restartButton = (Button) findViewById(R.id.restartButton); // 화면전환 이벤트
        restartButton.setOnClickListener(new View.OnClickListener() { // 시작 버튼 화면전환
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });
    }
}


