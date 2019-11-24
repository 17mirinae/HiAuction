// 회원가입 DB를 연동해서 진행한다.
package com.example.mobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

public class SignUpPage extends AppCompatActivity {
    final static private String URL = "http://cslin.skuniv.ac.kr/~chungmj1767/Mobile/SignUpPHP.php";

    Button signUpBtn;
    EditText userIdEdit, userPwdEdit, userAddrEdit, userPhoneEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);
        setTitle("회원가입");

        Button signUpBtn = (Button) findViewById(R.id.signUpBtn);

        userIdEdit = (EditText) findViewById(R.id.userIdEdit);
        userPwdEdit = (EditText) findViewById(R.id.userPwdEdit);
        userAddrEdit = (EditText) findViewById(R.id.userAddrEdit);
        userPhoneEdit = (EditText) findViewById(R.id.userPhoneEdit);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            } // onClick End
        }); // signUpBtn.setOnClickListener End
    }

    private void SignUp() {
        final String userId = this.userIdEdit.getText().toString().trim();
        final String userPwd = this.userPwdEdit.getText().toString().trim();
        final String userAddr = this.userAddrEdit.getText().toString().trim();
        final String userPhone = this.userPhoneEdit.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
    }
}
//    Response.Listener<String> responseListener = new Response.Listener<String>() {
//        @Override
//        public void onResponse(String response) {
//            try {
//                JSONObject jsonResponse = new JSONObject(response);
//                boolean success = jsonResponse.getBoolean("success");
//
//                if (success) {
//                    Toast.makeText(getApplicationContext(), "SignUp Success", Toast.LENGTH_SHORT);
//                    finish();
//                } else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUpPage.this);
//                    builder.setMessage("Check Your ID")
//                            .setNegativeButton("Retry", null)
//                            .create()
//                            .show();
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }; // Response.Listener<String> End
//
//    RequestQueue queue = Volley.newRequestQueue(SignUpPage.this);
//        queue.add(registerRequest);
