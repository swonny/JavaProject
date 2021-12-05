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
import android.widget.TextView;
import android.widget.Toast;


class Tama implements Serializable {
    private static final long serialVersionUID = 1L;
    final String name;
    private int level;
    private int energy;

    public Tama(String name){ // init
        this.name = name;
        this.level = 1;
        this.energy = 10;
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
            System.out.printf("game end");
        }
    }

    public void energyUp(int energy) {
        if(getEnergy() + energy < 0) {
            System.out.printf("game end");
        }
        if(this.energy + energy < 30) {
            this.energy += energy;
        } else {
            this.energy = 0;
            levelUp();
        }
    }

    public void eat() {
        energyUp(2);
    }

    public void play() {
        if(this.energy < 10) {
            energyUp(-3);
        } else {
            energyUp(2);
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
    Scanner scan = new Scanner(System.in);

}

