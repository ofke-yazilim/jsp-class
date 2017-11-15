/*
 * getCompareTo(int type, Object number) => Aynı tür sayısal verileri karşılaştırır. 
 * getIntValueOf(String value) => String veriyi int yapar valeof kullanır nesne türünde.
 * getDoubleValueOf(String value) => String veriyi double yapar valeof kullanır nesne türünde.
 * getFloatValueOf(String value) => String veriyi float yapar valeof kullanır nesne türünde.
 * getCeil() => Sayıyı bir üsteki sayıya yuvarlar double.
 * getRandom(int max,int min) => Verilen aralıkta rasgele sayı üretir.
 * numberFormat() => Para türünde 13.13 şeklinde double değer döner.
 * getNowDate() => Şuanki tarihi alır
 * getDate(int type) => Tarihi istenilen şekilde döndürür.
 * String , double , float , integer türünde girilen ifadelerin işlenmesini sağlar.
 */
package classes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import org.eclipse.jdt.internal.compiler.lookup.TypeIds;

/**
 *
 * @author o.kesmez
 */
public class numeric {
    public String string = "";
    public int integer   = 0;
    public double doubleNumber = 0;
    public float floatNumber   = 0;
    Random random = new Random();
    Date now = new Date();
    
    public void setString(String string){
        this.string = string;
    }
    
    public void setInt(int integer){
        this.integer = integer;
    }
    
    public void setDouble(double doubleNumber){
        this.doubleNumber = doubleNumber;
    }
    
    public void setFloat(float floatNumber){
        this.floatNumber = floatNumber;
    }
    
    /*Numerik Fonksiyonları Başlangıcı*/
    
    /*
    * Tanımlaması yapılmış olan float , int ya da double türündeki iki numerik ifade için kotrol sağlar.
    * Kullanım int : setInt(12) şeklinde int değerimiz tanımlanır, ardından type değeri 1 olacak şekilde getCompareTo(1,10); ile fonksiyon çalıştırılır. 12 sayısı ile 10 sayısını karşılaştırır.
    * Kullanım double : setDouble(12,2) şeklinde double değerimiz tanımlanır, ardından type değeri 2 olacak şekilde getCompareTo(2,10); ile fonksiyon çalıştırılır.
    * Kullanım float  : setFloat(12,3f) şeklinde float değerimiz tanımlanır, ardından type değeri 3 olacak şekilde getCompareTo(3,10); ile fonksiyon çalıştırılır.
    * Sonuç Yorumla   : integer türünde 0 döner ise sayılar eşit, eğer -1 ise getCompareTo(1,10) ile gönderilen değer sisteme tanımlanandan büyük  , 
    * Sonuç Yorumla - 2 :eğer 1 ise getCompareTo(1,10) ile gönderilen değer sisteme tanımlanandan küçüktür.  
    * UYARI : Bu fonksiyon ile int değer int değer ile , double değer double değer ile ,float değer float değer ile karşılaştırılabilir.
    */
    public int getCompareTo(int type, Object number){
        int result = 0;
        if(type==1){
            result = ((Integer) integer).compareTo((Integer) number) ; 
        }else if(type==2){
            result = ((Double) doubleNumber).compareTo((Double) number) ;
        }else if(type==3){
            result = ((Float) floatNumber).compareTo((Float) number) ;
        }
        
        return result;
    }
    
    /*
    * String türünde gönderilen değerleri valueOf methodunu kullanarak istediğimiz türe çevirdik.
    * getIntValueOf(String value) => integer türüne çevirir.
    * getDoubleValueOf(String value)=> double türüne çevirir.
    * getFloatValueOf(String value) => float türüne çevirir.
    * Önemli : valueOf fonksiyonu tüm tiplerdeki değişkenleri istenilen tipe dönüştürür. toDouble,toInteger... vb. methodlar sadece string türleri değiştirir
    */
    public int getIntValueOf(String value){
        integer = Integer.valueOf(value);
        return integer;
    }
    
    public double getDoubleValueOf(String value){
        doubleNumber = Double.valueOf(value);
        return doubleNumber;
    }
    
    public double getFloatValueOf(String value){
        floatNumber = Float.valueOf(value);
        return floatNumber;
    }
    
    /* Gönderilen double türünde veriyi üst rakama yuvarlar.
     * getCeil() fonksiyonunu Kullanmak için öncelikle class içerisine setDouble(double doubleNumber) ile değer tanımlanır.
     * double değer tanımlandıktan sonra getCeil() fonsiyonunu çağırırız sonuç olarak bize double türünde bir değer döner
     */
    public double getCeil(){
        return Math.ceil(this.doubleNumber);
    }
    
    /*
     * int türünde almış oladuğu min ve max değerler arasında rastgele sayı üretir.
     * max => Dönecek değerin max sınırını belirtir.
     * min => Dönecek değerin min sınırını belirler.
     */
    public int getRandom(int max,int min){
        int value = random.nextInt(max) + min; 
        return value;
    }
    
    /*
     * Verilen double değeri istenilen formatta geri gönderiri.
     * Öncelikle class içerisine setDouble(double doubleNumber) ile değer tanımlanır.
     * numberFormat(int mask) çalıştırılır ve double değer döner.
    */
    public String numberFormat() throws ParseException{
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(this.doubleNumber);
    }
    
        /*
     * Şuan bulunan Tarihi Y-m-d h:i:s formatında döndürür.
     */
    public String getNowDate(){
      SimpleDateFormat date = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
      return date.format(now);
    }
    
    /*
     * type=> 1 gün ismini getirir.
     * type=> 2 ay ismini getirir.
     * type=> 3 yıl sayısını getirir
     * type=> 4 gün, ay yıl getirir.
     * String ifade döner
     */
    public String getDate(int type){
        String months[] = {"Ocak", "Şub", "Mar", "Nis", "May", "Haz", "Tem", "Ağu", "Eyl", "Ekm", "Kas", "Arl"};
        String days[] = {"Pzt","Salı","Çar","Per","Cuma","Cmt","Pz"};
        
        SimpleDateFormat _date = new SimpleDateFormat ("a");
        GregorianCalendar gcalendar = new GregorianCalendar();
        
        String month = months[gcalendar.get(Calendar.MONTH)];
        String day   = _date.format(now);
        int year     = gcalendar.get(Calendar.YEAR);
        
        String full = day.concat(", "+month+" "+Integer.toString(year));
        
        String date = "";
        if(type==1){
            date = day;
        } else if(type==2){
            date = month;
        } else if(type==3){
            date = Integer.toString(year);
        } else{
            date = full;
        }
        
        return date;
    }
    
    
    
}
