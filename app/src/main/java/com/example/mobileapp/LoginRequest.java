package com.example.mobileapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    static private String URL = "http://cslin.skuniv.ac.kr/~chungmj1767/HiAuction/LoginPHP.php";
    private Map<String, String> params;

    public LoginRequest(String userId, String userPwd, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "[" + error.getMessage() + "]");
            }
        });
        params = new HashMap<>();

        params.put("Id", userId);
        params.put("Pwd", userPwd);

        System.out.println(getParams());
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}