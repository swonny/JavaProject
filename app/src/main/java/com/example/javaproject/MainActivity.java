package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


class Tama implements Serializable { // 캐릭터 클래스
    private static final long serialVersionUID = 1L; // SubActivity와 공유하기 위한 설정
    final String name; // 캐릭터 이름
    private int level; // 캐릭터 레벨
    private int energy; // 캐릭터 에너지

    public Tama(String name){ // 초기설정
        this.name = name; // 이름
        this.level = 1; // 기본 레벨
        this.energy = 8; // 기본 에너지
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void levelUp() {
        if(this.level < 5) {
            this.level += 1;
        } else if (this.level == 5) {
            System.out.printf("game over");
        }
    }

    public void energyUp(int energy) {
        if(getEnergy() + energy < 0) {
            System.out.printf("game over");
        }
        if(this.energy + energy < 20) {
            this.energy += energy;
        } else {
            this.energy = 8;
            levelUp();

        }
    }

    public void eat() {
        energyUp(2);
    }

    public void play() {
        if(this.energy < 10) {
            energyUp(-8);
        } else {
            energyUp(5);
        }
    }

    public void sleep() {
        energyUp(5);
    }
}

public class MainActivity extends AppCompatActivity {

    Tama myCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton infoButton = (ToggleButton) findViewById(R.id.infoButton);
        ImageView gameRulesImage = (ImageView) findViewById(R.id.rule1);
        TextView gameRulesText = (TextView) findViewById(R.id.rule2);
        LinearLayout mainall = (LinearLayout) findViewById(R.id.mainall);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton) view).isChecked();

                if(on) {
                    mainall.setVisibility(mainall.INVISIBLE);
                    gameRulesImage.setVisibility(gameRulesImage.VISIBLE);
                    gameRulesText.setVisibility(gameRulesText.VISIBLE);
                } else {
                    mainall.setVisibility(mainall.VISIBLE);
                    gameRulesImage.setVisibility(gameRulesImage.INVISIBLE);
                    gameRulesText.setVisibility(gameRulesText.INVISIBLE);
                }
            }
        });

        Button startButton = (Button) findViewById(R.id.startBtn); // 화면전환 이벤트
        TextView characterName = (TextView) findViewById(R.id.characterName);
        EditText scanName = (EditText) findViewById(R.id.scanName);
        startButton.setOnClickListener(new View.OnClickListener() { // 시작 버튼 화면전환
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                 intent.putExtra("myTama", myCharacter);

                 startActivity(intent);
            }
        });

        Button sendNameButton = (Button) findViewById(R.id.sendName);
        sendNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tName = new String(String.valueOf(scanName.getText()));
                Toast.makeText(getApplicationContext(), tName+" 생성!", Toast.LENGTH_SHORT).show();
                myCharacter = new Tama(tName);

                System.out.println(myCharacter.name);
            }
        });

    }
}

