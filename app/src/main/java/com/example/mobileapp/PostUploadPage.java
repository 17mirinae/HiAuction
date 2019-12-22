package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostUploadPage extends AppCompatActivity {
    private EditText titleEdit, contentEdit;
    private TextView writerText;
    private ImageView imageView;
    private Button postUploadBtn;

    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    String title, content, writer, createdTime, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_post);

        Intent intent = getIntent();

        imageView = (ImageView) findViewById(R.id.imageView);
        titleEdit = (EditText) findViewById(R.id.titleEdit);
        contentEdit = (EditText) findViewById(R.id.contentEdit);
        writerText = (TextView) findViewById(R.id.writerText);
        postUploadBtn = (Button) findViewById(R.id.postUploadBtn);

        writerText.setText(intent.getStringExtra("Id"));
        writer = writerText.getText().toString();
        writerText.setText("작성자: " + intent.getStringExtra("Id"));

        postUploadBtn.setOnClickListener(new View.OnClickListener() {
            // 글 올리기 버튼 이벤트
            @Override
            public void onClick(View view) {
                long now = System.currentTimeMillis();
                Date date = new Date(now);

                title = titleEdit.getText().toString();
                content = contentEdit.getText().toString();
                createdTime = sdfNow.format(date);
//                image = imageView.getDrawable().toString();
//                System.out.println("ImageView to String : " + image);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            Toast.makeText(getApplicationContext(), "Post Upload Clear", Toast.LENGTH_SHORT).show();
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }; // Response.Listener<String> End

                PostUploadRequest postUploadRequest = new PostUploadRequest(title, writer, content, createdTime, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostUploadPage.this);
                queue.add(postUploadRequest);
            }
        });
    }
}