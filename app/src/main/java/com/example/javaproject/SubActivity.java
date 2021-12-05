package com.example.javaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);

        TextView characterName = (TextView) findViewById(R.id.characterName);

        Intent intent = getIntent();

        Tama myCharacter = (Tama) intent.getSerializableExtra("myTama");

        characterName.setText("이름 : "+ myCharacter.name + "\n레벨 : " + myCharacter.getLevel() + "\n에너지 : "+ myCharacter.getEnergy());

    }

    public void eat(View v) {
        Toast eatToast = Toast.makeText(getApplicationContext(), "점심시간!", Toast.LENGTH_SHORT);
        eatToast.show();
        System.out.println("tesss");
    }

    public void play(View v) {
        Toast.makeText(getApplicationContext(), "뭐하고 놀까?", Toast.LENGTH_SHORT).show();
    }

    public void sleep(View v) {
        Toast.makeText(getApplicationContext(), "z Z z z Z ..", Toast.LENGTH_SHORT).show();
    }

    public void gameStart(View v) {
        Tama my = new Tama("hi");
        System.out.printf("%s", my.name);
    }
}
