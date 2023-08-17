package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnSumListener  {



    FrameLayout frameLayoutContainer;
    HomeFragment homeFragment;
    BlankFragment blankFragment;
    SecondFragment secondFragment;
    Button buttonOne, buttonTwo,buttonThree;

    NewFragment newFragment;

    @Override
    public void onSum(int num1, int num2) {
        int sum = num1 + num2;
        Bundle args = new Bundle();
        args.putInt("sum", sum);
        SecondFragment secondFragment1 = new SecondFragment();
        secondFragment1.setArguments(args);

        FragmentManager fragmentManage = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManage.beginTransaction();
        fragmentTransaction.replace(R.id.flContainer, secondFragment1);
        fragmentTransaction.commit();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)  {




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
                blankFragment = (BlankFragment) getSupportFragmentManager().findFragmentById(R.id.flContainer);
                if (secondFragment != null) {
                    EditText editTextNumberOne = blankFragment.getView().findViewById(R.id.etNumberOne);
                    EditText editTextNumberTwo = blankFragment.getView().findViewById(R.id.etNumberTwo);
                    int num1 = Integer.parseInt(editTextNumberOne.getText().toString());
                    int num2 = Integer.parseInt(editTextNumberTwo.getText().toString());
                    onSum(num1, num2);

                }
                //getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, secondFragment).commit();
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