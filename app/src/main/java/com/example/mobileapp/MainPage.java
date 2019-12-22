package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    private static String userId, userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Intent intent = getIntent();

        userId = intent.getStringExtra("Id");
        userPwd = intent.getStringExtra("Pwd");

        System.out.println("userID!!! " + userId);
        System.out.println("userPwd!!! " + userPwd);
    }
}
