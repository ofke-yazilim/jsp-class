<%-- 
    Document   : String Class kullanımı
    Created on : 23.Eki.2017, 13:57:18
    Author     : o.kesmez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="classes.string"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>String Class Kullanımı</title>
</head>
<body>
     <%
       string str = new string();
       String text = "Ömer Faruk KESMEZ";
       
       /* getLength() kullanımı*/
       str.setString("Ömer Faruk KESMEZ");
       out.println(str.getLength()+"<br>");
       /* getLength() kullanımı son */
       
       /* getChar(int number) kullanımı*/
       str.setString("Ömer Faruk KESMEZ");
       out.println(str.getChar(3)+"<br>");
       /* getChar(int number) kullanımı son */
              
       /*getIndexOf(String text) kullanımı*/
       str.setString("Ömer Faruk KESMEZ");
       out.println(str.getIndexOf("Faruk")+"<br>");
       /*getIndexOf(String text) kullanımı son*/
       
       /*getToString(int type) kullanımı*/
       str.setInt(12);
       str.setDouble(12.1213);
       str.setFloat(4.5f);
       out.println(str.getToString(1));
       out.println(str.getToString(2));
       out.println(str.getToString(3)+"<br>");
       /*getToString(int type) kullanımı son*/
       
       /*getEquals(int type , String text) kullanımı*/
       str.setString("Ömer Faruk KESMEZ");
       out.println(str.getEquals(1 ,"Ömer Faruk Kesmez"));//Büyük küçük harfe duyarlı olduğu için "Kesmez" kısmını küçük harfle yazmama rağmen true döner
       out.println(str.getEquals(2 ,"Ömer Faruk Kesmez")+"<br>");//Büyük küçük harfe duyarlı olmadığı için "Kesmez" kısmını küçük harfle yazdığım için false döner yazının birebir aynı olmasına bakar
       /*getEquals(int type , String text) kullanımı son*/
       
       /* getCase(int type) kullanımı */
       str.setString("Ömer Faruk KESMEZ");
       out.println(str.getCase(1));
       out.println(str.getCase(2)+"<br>");
       /* getCase(int type) kullanımı son*/
       
       /* getTrim() kullanımı*/
       str.setString("          -Ömer Faruk KESMEZ-              ");
       out.println(str.getTrim()+"<br>");
       /* getTrim() kullanımı son */
       
       /*str.getConcat(String[] stringArray) kullanımı*/
       String[] stringArray = {"ömer","faruk","KESMEZ"};
       out.println(str.getConcat(stringArray));
       /*str.getConcat(String[] stringArray) kullanımı son*/
       
    %>
</body>
</html>
