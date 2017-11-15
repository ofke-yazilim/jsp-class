<%-- 
    Document   : mysql sınıfı kullanımı.
    Created on : 30.Eyl.2017, 22:19:04
    Author     : ofke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.mysql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Java web projesi</title>
</head>
<body>
    <h1>Mysql Bağlantı işlemleri</h1>
    <%
        mysql sql = new mysql();//Mysql sınıfımı çağırdım.
        sql.mysqlConnect();//Mysql bağlantısı gerçekleşiyor.
        
        //Aşağıda insert işlmelerini gerçekleştiriyorum.
        sql.mysqlInsert("INSERT INTO user (name,surname,password,email,username) VALUES ('omer','kesmez','1213456','info@ofkeyazilim.com','ofke')");
        sql.mysqlInsert("INSERT INTO user (name,surname,password,email,username) VALUES ('abdullah','Gunes','1213456','info@agunes.com','agunes')");
        sql.mysqlInsert("INSERT INTO user (name,surname,password,email,username) VALUES ('mustafa','kemal','1213456','mk@amk.com','mkemal')");
        sql.mysqlInsert("INSERT INTO user (name,surname,password,email,username) VALUES ('Halim','Aslan','1213456','info@agunes.com','aslan')");
        sql.mysqlInsert("INSERT INTO user (name,surname,password,email,username) VALUES ('Nurullah','GULEK','1213456','info@agunes.com','ngulek')");
        out.println(sql.getMessage());
        out.println("<br>-------------------------------------------<br>");
        //İnsert işlmleri son
        
        //Mysql array select sorgusu test ediliyor.
        out.println("<table border='1px' style='background-color:green;color:#000000'>");
        String[][] result = sql.mysqlSelect("name,surname,email","user","id>2","",3,3);
        for(int i=0;i<3;i++){
            out.println("<tr>");
            for(int j=0;j<3;j++){
                out.println("<td style='padding:5px;'>");
                out.println(result[i][j]);
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println(sql.getMessage());
        out.println("</table>");
        out.println("<br>-------------------------------------------<br>");
        //mysql array sorgusu gerçekleşti.
        
        //Mysql delete işlemi gerçekleşiyor.
        sql.mysqlDelete("DELETE FROM `user` where id=1");
        out.println(sql.getMessage());
        out.println("<br>-------------------------------------------<br>");
        //Mysql delete işlmleri son
        
    %>
    <em><% out.println(sql.getMessage());%></em>
</body>
</html>
