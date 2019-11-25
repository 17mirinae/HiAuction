package com.example.mobileapp;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userId; // 아이디
    private String userPwd; // 비밀번호
    private String userAddr; // 주소
    private String userPhone; // 전화번호

    // 사용자 추가를 위한 User 생성자
    User(String userId, String userPwd, String userAddr, String userPhone) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userAddr = userAddr;
        this.userPhone = userPhone;
    }

    // Firebase에 추가하기 위한 objectToMap 메소드
    public Map<String, Object> objectToMap() {
        HashMap<String, Object> res = new HashMap<>();
        res.put("userId", userId);
        res.put("userPwd", userPwd);
        res.put("userAddr", userAddr);
        res.put("userPhone", userPhone);

        return res;
    }
}
