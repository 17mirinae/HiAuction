<?php
    $link = mysql_connect("localhost" "chungmj1767", "mschungmj1767M") or die("DB Connection Failed");
    mysql_select_db("chungmj1767", $link);
    
    session.start();
    
    $userId = $_POST['userID'];
    $userPwd = $_POST['userPwd'];
    $userAddr = $_POST['userAddr'];
    $userPhone = $_POST['userPhone'];
    
    $query = "INSERT INTO 'chungmj1767'.'mobile_member'('userId', 'userPwd', 'userAddr', 'userPhone') VALUES('$userId', '$userPwd', '$userAddr', '$userPhone')";
    $res = mysql_query($query, $link) or die("Insert Member Fail");
?>