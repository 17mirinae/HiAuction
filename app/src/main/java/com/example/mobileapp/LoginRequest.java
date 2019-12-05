package com.example.mobileapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    static private String URL = "http://cslin.skuniv.ac.kr/~chungmj1767/HiAuction/LoginPHP.php";
    private Map<String, String> params;

    public LoginRequest(String userId, String userPwd, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();

        params.put("userId", userId);
        params.put("userPwd", userPwd);

        Log.d("userId: ", userId);
        Log.d("userPwd: ", userPwd);
        System.out.println(getParams());
    };

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}