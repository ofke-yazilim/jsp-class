/*
 * mysql() => Mysql sunucu bilgileri.
 * mysqlConnect() => Mysql bağlantısı sağlanır.
 * mysqlInsert(String query) => Mysql insert işlemi.
 * mysqlSelect(..) => Çekilen veri 2 boyutlu array döndürür.
 * mysqlSelectArrayList(...) => Çekilen veriyi Arraylist olarak döndürür.
 * mysqlDelete(String query) => Silme işlemi yapar
 * mysqlDisconnect() => Mysql bağlantısını kapartır.
 * setMessage(String message) => Sınıf içerisinde oluşan hata mesajlarını taşır.
 * getMessage(String message) => Sınıf içerisinde oluşan hata mesajları almamızı sağlar.
 */

package classes;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ofke
 */
public class mysql {
    
    public String host = "";//Mysql sunucu ip adresi
    public String user = "";//Mysql sunucusu kullanıcı ismi
    public String password = "";//Mysql kullanıcı şifresi.
    public String port = "";//Mysql sunucu portu
    public String database = "";//Mysql veritabanı ismi.
    
    public String message  = "Mesaj Yok";//Hata ya da Başarı mesajı taşır.
    
    public Connection connection = null;//Mysql suncumuza bağlantı yapmamızı sağlayacak nesnemizi tanımladık.
    public Statement statement = null;//Mysql için yazdığımız kodları derlemeye yarayan nesnemiz.
    public ResultSet resultset = null;//Mysql select sorgularında derleme işlemi tamamlandıktan sonra oluşan sonuç verilerini tutar.

    //Yapıcı method -> mysql sınıfı ilk import edildiğinde çalışır.
    public mysql(){
        //Mysql bağlantı bilgileri tanımlnadı.
        this.host = "localhost";
        this.user = "root";
        this.password = "";
        this.port = "3306";
        this.database = "demo";
    }
    
    //Mysql driver yükleniyor -> Mysql bağlantısı sağlanıyor.
    public Connection mysqlConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");//Mysql sürücü yüklendi
        }catch(ClassNotFoundException e){
            setMessage("Mysql Driver Yüklenirken hata : " + e.getMessage());
        }
        
        try{
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.database,this.user,this.password);
            statement  = (Statement) connection.createStatement();//Kodlarımızı derleyecek nesne oluşturuldu.
            setMessage("Bağlantı başarılı");
        }catch(SQLException e){
            setMessage("Mysql bağlantısı sırasında hata : " + e.getMessage());
        }
        return connection;
    }
    
    //Mysql ekleme işlmleri yapılacak. => mysqlInsert("INSERT INTO user (name,surneme..) VALUES ('omer','kesmez',...)")
    public boolean mysqlInsert(String query){
        try{
            statement.executeUpdate(query);//Statement nesnesini kullanarak sql sorgumuzu derledik.
            setMessage("İnsert İşlemleri Başarılı.");
            return true;
        }catch(SQLException e){
            setMessage("Mysql İnsert İşlemi Sırasında Hata : "+ e.getMessage());
            return false;
        }
    }
    
    /*
    * Mysql select işlmleri -> Sütun sayısı ve limiti belli sorgular için.
    * Kullanımı => mysqlSelect("name,surname","user","id=1","order by id desc",10,2);
    * Dönecek veri array türünde olduğundan dolayı limit ve süttun sayısı değerleri mutlaka belirtilmeli.
    * Önemli : where değeri gönderilirken eğer kullanılmak istenmiyorsa 1=1 şeklinde gönderilmeli.
    */
    public String[][] mysqlSelect(String rows,String table,String where,String other,int limit,int rowNumber) throws SQLException{
        //Aşağıda iki boyutlu dizi tanımlanıyor.
        String[][] result = new String[limit][rowNumber];//Dizimizin boyutunu belirtiyoruz.
        try{
            //Aşağıda select sql sorgusu hazırlanıyor.
            String query = "SELECT "+rows+" FROM "+table+" WHERE "+where+" "+other+" LIMIT "+limit;
            this.resultset = statement.executeQuery(query);
            int row = 0;//Limit sayımızı temsil edecek ve matrisimizin satır sayısını her defasında 1 arttırmamızı sağlayacak.
            //While döngüsü kullanılarak sql sorgusu ile alınan veriler array içerisine aktarılacak.
            while(this.resultset.next()){
                for(int i=0;i<rowNumber;i++){
                    result[row][i] = resultset.getString(i+1);//Sql sorgusu ile Çekilen sutunları ilgili satırdaki ilgili sutuna atar. 
                }
                row = row + 1;
            }
            setMessage("Mysql Array Select İşlemleri Başarılı.");
            return result;
        }catch(SQLException e){
            setMessage("Array Türünde Select İşlemi Sırasında Hata :" +e.getMessage());
            return result;
        }
    }
    
    /*
    * Mysql select ->Sutun sayısı ve limiti belli olmayan sorgular için.
    * Kullanımı : mysqlSelectArrayList("name,surname","`user`","order by id desc limit 10");
    * Önemli : other(String) değeri gönderilirken eğer kullanılmak istenmiyorsa 1=1 şeklinde gönderilmeli.
    */
    public ArrayList mysqlSelectArrayList(String rows,String table,String other) throws SQLException{
        ArrayList result = new ArrayList();
        //Gönderilen sutun isimleri array olarak alınıyor.
        String[] rowsNumber = rows.split(","); 
        try{
            String query = "SELECT "+rows+" FROM "+table+" WHERE "+other;
            this.resultset = statement.executeQuery(query);
            while(resultset.next()){
                for(int i=1;i<rowsNumber.length+1;i++){
                    result.add(resultset.getString(i));
                }
            }
            setMessage("Mysql ArrayList Select İşlemleri Başarılı.");
        }catch(SQLException e){
            setMessage("Arraylist Select İşlemleri sırasında Hata : "+e.getMessage());
        }
        return result;
    }
    
    /*
    * Mysql delete işlemleri
    * Kullanımı => mysqlDelete("DELETE FROM `user` where id=1")
    */
    public boolean mysqlDelete(String query){
        try{
            statement.executeUpdate(query);//Sorgusu gönderilen verinin silinmesini sağlar.
            setMessage("Mysql delete İşlemleri Başarılı.");
        }catch(SQLException e){
            setMessage("Mysql Delete işlemleri sırasında hata ile karşılaşıldı.");
        }
        return false;
    }
    
    //Mysql bağlantısı sonlandırılır.
    public void mysqlDisconnect() throws SQLException{
        connection.close();//Mysql bağlantısı sonlandırıldı.
    }
    
    //Mesaj verimizi set ediyoruz.
    public void setMessage(String message){
        this.message = message;
    }
    
    //Mesaj değişkrnimizi alıyoruz.
    public String getMessage(){
        return this.message;
    }
    
}
