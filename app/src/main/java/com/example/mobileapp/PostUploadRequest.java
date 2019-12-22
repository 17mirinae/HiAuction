package com.example.mobileapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PostUploadRequest extends StringRequest {
    static private String URL = "http://cslin.skuniv.ac.kr/~chungmj1767/HiAuction/PostUploadPHP.php";
    private Map<String, String> params;

    public PostUploadRequest(String Title, String Writer, String Content, String CreatedTime, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "[" + error.getMessage() + "]");
            }
        });
        params = new HashMap<>();

        params.put("Title", Title);
        params.put("Writer", Writer);
        params.put("Content", Content);
        params.put("CreatedTime", CreatedTime);
        // params.put("Image", Image);

        System.out.println(getParams());
    }

    @Override
    protected Map<String, String> getParams() {
        return params;
    }
}
