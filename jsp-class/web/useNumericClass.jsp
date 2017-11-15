<%-- 
    Document   : numerik class kullanımı
    Created on : 23.Eki.2017, 15:13:18
    Author     : o.kesmez
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.numeric"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Numerik Fonksiyonlar</title>
</head>
<body>
    <%
        numeric num = new numeric();
        num.setString("121,1213");
        
        /* Numerik sayıların karşılaştırılması */
        num.setInt(12);
        num.setDouble(12.13134);
        num.setFloat(12.12f);                  
        out.println(num.getCompareTo(1,11));
        out.println(num.getCompareTo(2,13.12313));
        out.println(num.getCompareTo(3,13.2f)+"<br>");
        /*Numerik sayıların karşılaştırılması son*/
        
        /*Rastgele sayı ürere 10 ile 50 rasında*/
        out.println("Random : "+num.getRandom(50,10)+"<br>");

        /*Gönderilen double sayıyı sonunda 2 karakter olacak şekilde döndürür fiyat düzenlemelerinde kullanılır*/
        out.println("Format : "+num.numberFormat()+"<br>");
        
        /*Şimdiki tarihi getirir*/
        out.println("Şimdiki Tarih : "+num.getNowDate()+"<br>");
        
        String months[] = {"Ocak", "Şub", "Mar", "Nis", "May", "Haz", "Tem", "Ağu", "Eyl", "Ekm", "Kas", "Arl"};
        String days[] = {"Pzt","Salı","Çar","Per","Cuma","Cmt","Pz"};
        
        /*Parça parça tarih getireen fonksiyon*/
        out.println("Gün : "+num.getDate(1)+"<br>");
        out.println("Ay : "+num.getDate(2)+"<br>");
        out.println("Yıl : "+num.getDate(3)+"<br>");
        out.println("Tüm Tarih : "+num.getDate(4)+"<br>");
        
    %>
</body>
</html>
