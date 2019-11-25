package com.example.mobileapp;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class SignUpRequest extends StringRequest {
    final static private String URL = "http://cslin.skuniv.ac.kr/~chungmj1767/HiAuction/SignUpPHP.php";
    private Map<String, String> params;

    public SignUpRequest(String userId, String userPwd, String userAddr, String userPhone, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();

        System.out.println("This is Log");
        System.out.println(userId);
        System.out.println(userPwd);
        System.out.println(userAddr);
        System.out.println(userPhone);

        params.put("userId", userId);
        params.put("userPwd", userPwd);
        params.put("userAddr", userAddr);
        params.put("userPhone", userPhone);
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
