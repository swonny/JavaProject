package com.example.javaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

class Tama {
    private String name;
    private int level;
    private int energy;

    public Tama(String name){
        this.name = name;
        this.level = 1;
        this.energy = 10;
    }

    public void eat() {

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
    }

    public void on1(View v) {
        Toast.makeText(getApplicationContext(), "버튼 클릭 테스트", Toast.LENGTH_SHORT).show();
    }
}