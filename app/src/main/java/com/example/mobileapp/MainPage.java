package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainPage extends AppCompatActivity {
    // 로그인 후의 메인 페이지
    private static String userId, userPwd;
    FloatingActionButton addPostBtn;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerLayoutManager;

    ArrayAdapter<Post> postArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        Intent intent = getIntent();

        userId = intent.getStringExtra("Id"); // 넘겨받은 사용자 아이디
        userPwd = intent.getStringExtra("Pwd"); // 넘겨받은 사용자 비밀번호

        addPostBtn = (FloatingActionButton) findViewById(R.id.addPostBtn);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(recyclerLayoutManager);

        recyclerAdapter = new MyAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        recyclerView.addOnItemTouchListener(onItemTouchListener); // 리사이클러뷰의 아이템 터치 이벤트

        addPostBtn.setOnClickListener(new View.OnClickListener() {
            // 글 쓰기 버튼을 누를 때 실행
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostUploadPage.class);

                intent.putExtra("Id", userId);

                startActivity(intent);
            }
        });
    }

    RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            // 리스트 아이템을 터치했을 때 실행되는 이벤트
            Intent intent = new Intent(getApplicationContext(), PostDetailPage.class);
            startActivity(intent);
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    };
}
