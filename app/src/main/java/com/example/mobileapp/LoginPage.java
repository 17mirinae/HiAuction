package com.example.mobileapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {

    EditText userIdEdit, userPwdEdit;
    Button loginBtn, signUpBtn;
    String userId, userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("HiAuc");

        int SDK_INT = android.os.Build.VERSION.SDK_INT;

        if (SDK_INT > 8)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        userIdEdit = (EditText) findViewById(R.id.userIdEdit);
        userPwdEdit = (EditText) findViewById(R.id.userPwdEdit);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 로그인 버튼 클릭 시에 수행
                userId = userIdEdit.getText().toString();
                userPwd = userPwdEdit.getText().toString();

                System.out.println("loginBtn Clicked...");

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            System.out.println("Boolean success equals: " + success);
                            if (success) {
                                userId = jsonResponse.getString("userId");
                                userPwd = jsonResponse.getString("userPwd");

                                Toast.makeText(getApplicationContext(), "Login Clear", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), MainPage.class);
                                intent.putExtra("Id", userId);
                                intent.putExtra("Pwd", userPwd);
                                startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
                                builder.setMessage("Try Again")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }; // Response.Listener<String> End
                LoginRequest loginRequest = new LoginRequest(userId, userPwd, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginPage.this);
                queue.add(loginRequest);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() { // 회원가입 버튼 클릭 시에 수행
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpPage.class);
                startActivity(intent);
            }
        });
    }
}
