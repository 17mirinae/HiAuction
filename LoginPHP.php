<?php
    $link = mysql_connect("localhost" "chungmj1767", "mschungmj1767M") or die("DB Connection Failed");
    mysql_select_db("chungmj1767", $link);
    
    session.start();
    
    $userId = $_POST['userID'];
    $userPwd = $_POST['userPwd'];
    
    $query = "SELECT FROM mobile_members WHERE userId='$userId'";
    $res = mysql_query($query, $link) or die("Insert Member Fail");
?>