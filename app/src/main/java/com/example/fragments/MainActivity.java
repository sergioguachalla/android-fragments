package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayoutContainer;
    HomeFragment homeFragment;
    BlankFragment blankFragment;
    SecondFragment secondFragment;
    Button buttonOne, buttonTwo,buttonThree;

    NewFragment newFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment = new HomeFragment();
        blankFragment = new BlankFragment();
        secondFragment = new SecondFragment();
        newFragment = new NewFragment();
        buttonOne = findViewById(R.id.btOne);
        buttonTwo = findViewById(R.id.btTwo);
        buttonThree = findViewById(R.id.btThree);
        getSupportFragmentManager().beginTransaction().add(R.id.flContainer, homeFragment).commit();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, blankFragment).commit();
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, secondFragment).commit();
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer ,newFragment).commit();
            }
        });

    }
}