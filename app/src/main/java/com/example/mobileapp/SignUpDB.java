package com.example.mobileapp;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class SignUpDB extends AsyncTask<Void, Integer, Void> {
    private String userId, userPwd, userAddr, userPhone;

    @Override
    protected Void doInBackground(Void... voids) {
        JSONObject json;
        try {
            // Connect To Server
            URL url = new URL("http://cslin.skuniv.ac.kr/~chungmj1767/Mobile/SignUpPHP.php");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.connect();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
