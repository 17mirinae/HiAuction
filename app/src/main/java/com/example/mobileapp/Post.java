package com.example.mobileapp;

import java.util.HashMap;
import java.util.Map;

public class Post {
    private int PostNumber; // 글의 번호
    private String PostTitle; // 글의 제목
    private String Author; // 글의 작성자
    private String PostCreatedTime; // 글의 작성 시간
    private String PostContent; // 글의 내용

    public Post(String PostTitle, String Author, String PostCreatedTime, String PostContent) {
        this.PostTitle = PostTitle;
        this.Author = Author;
        this.PostCreatedTime = PostCreatedTime;
        this.PostContent = PostContent;
    }

    public Map<String, Object> objectToMap() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("PostNumber", PostNumber);
        res.put("PostTitle", PostTitle);
        res.put("Author", Author);
        res.put("PostCreatedTime", PostCreatedTime);
        res.put("PostContent", PostContent);

        return res;
    }

}
