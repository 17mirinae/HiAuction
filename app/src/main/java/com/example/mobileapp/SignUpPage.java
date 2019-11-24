// 회원가입 DB를 연동해서 진행한다.
package com.example.mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SignUpPage extends AppCompatActivity {
    Button signUpBtn;
    EditText userIdEdit, userPwdEdit, userAddrEdit, userPhoneEdit;
    String userId, userPwd, userAddr, userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);
        setTitle("회원가입");

        signUpBtn = (Button) findViewById(R.id.signUpBtn);

        userIdEdit = (EditText) findViewById(R.id.userIdEdit);
        userPwdEdit = (EditText) findViewById(R.id.userPwdEdit);
        userAddrEdit = (EditText) findViewById(R.id.userAddrEdit);
        userPhoneEdit = (EditText) findViewById(R.id.userPhoneEdit);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId = userIdEdit.getText().toString().trim();
                userPwd = userPwdEdit.getText().toString().trim();
                userAddr = userAddrEdit.getText().toString().trim();
                userPhone = userPhoneEdit.getText().toString().trim();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Toast.makeText(getApplicationContext(), "Sign Up Clear", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpPage.this);
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

                SignUpRequest signUpRequest = new SignUpRequest(userId, userPwd, userAddr, userPhone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SignUpPage.this);
                queue.add(signUpRequest);
            } // onClick End
        }); // signUpBtn.setOnClickListener End
    }
}