/*
 * getLength() => String ifademizin karakter sayısını öğreniriz. 
 * getChar(int number) => String ifademizin verilen sıradaki harf karakteri alınır.
 * getsubString(int first,int count) => String ifademizin kaçıncı karakterden başladığını bulmak için kullanırız
 * getIndexOf(String text) => Double,Float veya int türünde tanımlanan değerleri string ifadaye çevirir.
 * getToString(int type) => Double,Float veya int türünde tanımlanan değerleri string ifadaye çevirir.
 * getEquals(int type , String text) => String değerin başka bir string değer ile karşılaştırılmasını sağlar.
 * getCase(int type) => Class içerisine tanımlanan String ifadeyi büyük ya da küçük harfe çevirir.
 * getTrim() => Class içerisinde tanımlanmış olan string ifadenin sağ ve solunda bulunan boşlukları siler oertasında bulunan boşluklara dokunmaz.
 * getSplit(String mask) => Class içerisinde tanımlanan String ifadeyi belirtilen karakterden itibaren bölerek array içerisine atar.
 * String , double , float , integer türünde girilen ifadelerin işlenmesini sağlar.
 */

package classes;

/**
 *
 * @author o.kesmez
 */
public class string {
    public String string = "";
    public int integer   = 0;
    public double doubleNumber = 0;
    public float floatNumber   = 0;
    
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
    
    /*String Fonksiyonları Başlangıcı*/
    
    /*
    * String ifademizin karakter sayısını öğreniriz.
    * Kullanımı : setString("Text"); şeklinde tanıtılan string değeri getLength(); şeklinde çağrılarak boyutu öğrenilir.
    * Sonuçta integer değer döner.
    */
    public int getLength(){
        return string.length();
    }
    
    
    /*
    * String ifademizin verilen sıradaki harf karakteri alınır.
    * Kullanımı : setString("Text"); şeklinde tanıtılan string için 3. sıradaki harf değeri getChar(2); şeklinde çağrılarak öğrenilir.
    * Sonuçta dönen değer char ifade türündedir.
    * Sonuç Yorumla : getChar(2) ile çağırdığımızda string ifademizdeki 3. karakteri çağırır yani ilk karakteri 0. karakter olarak görür.
    */
    public char getChar(int number){
        return string.charAt(number);
    }
    
    /*
    * String ifademizin belirli bir sıradan sonrasının veya belirli bir sıradan itibaren belirli sayıda karakterin alınmasını sağlar. 
    * Kullanımı-1 : setString("Text Metni"); şeklinde tanıtılan string için 2. sıradan sonrası alınmak isteniyorsa getsubString(2,0); şeklinde çekilerek öğrenilir.ekrana "xt Metni" yazar.
    * Kullanımı-2 : setString("Text Metni"); şeklinde tanıtılan string için 2. sıradan sonra 5 karakteri alınmak isteniyorsa getsubString(2,5); şeklinde çekilerek öğrenilir.ekrana "xt Me" yazar.
    */
    public String getsubString(int first,int count){
       if(first!=0 && count!=0){
           return string.substring(first,count);
       }else{
           return string.substring(first);
       }
    }
    
    /*
    * String ifademizin kaçıncı karakterden başladığını bulmak için kullanırız
    * Kullanımı : setString("Text Metni"); şeklinde tanıtılan string için string içerisinde Me yazısı nereden başlıyor bilinmek isteniyorsa getIndexOf("Me"); şeklinde çağrılarak öğrenilir. 
    * Sonuç Yorumlama : Eğer sonuç -1 gelirse istenen karakter string içerisinde yer almamaktadır.
    */
    public int getIndexOf(String text){
        int baslangic;
        baslangic = this.string.indexOf(text);
        
        return baslangic;
    }
    
    /*
    * Double,Float veya int türünde tanımlanan değerleri string ifadaye çevirir.
    * Kullanımı : Öncelikle String Yapılmak istenen değer sisteme tanıtılır. int değer : setInt(12) , double değer : setDouble(123.2324) , float değer : setFloat(12.12) şeklinde tanımlanır.
    * Kullanımı-devamı : Yukarıda istenilen tanımlamalar yapıldıktan sonra int değeri string yapmak için type = 1 , double değeri string yapmak için type = 2 ve float değeri string yapmak için type = 3 getToString(int type) fonksiyonuna gönderilir.
    */
    public String getToString(int type){
        if(type==1){
            string = Integer.toString(this.integer);
        }else if(type==2){
            string = Double.toString(this.doubleNumber);
        }else if(type==3){
            string = Float.toString(this.floatNumber);
        }
        
        return string;
    }
    
    /*
    * String değerin başka bir string değer ile karşılaştırılmasını sağlar
    * Tanım : Bu işlemi java da yaparken iki method kullanılır bunlardan "equalsIgnoreCase" karşılaştırılacak metni küçük harfe çevirerek büyük küçük harf problemini çözer,
    * Tanım - 2 : "equals" ise büyük küçük ayrımı yapar.
    * Kullanım Başlangıç : setString("Text Metni"); şeklinde işlem yapıloacak string class içerisine tanıtılır
    * Kullanımı - 1 : Büyük - Küçük Harfe Duyarlı yani "equalsIgnoreCase" kullanılarak yapılmak isteniyorsa ,
    * Kullanımı - 1 - Devam : type 1 olacak şekilde getEquals(1,"Karşılaştırılmak istenen metin"); kullanılarak sonuç alınır.
    * Kullanımı - 2 : Büyük - Küçük Harfe Duyarlı yani "equalsIgnoreCase" kullanılarak yapılmak isteniyorsa ,
    * Kullanımı - 2 - Devam : type 2 olacak şekilde getEquals(2,"Karşılaştırılmak istenen metin"); kullanılarak sonuç alınır.
    * Sonuç Yorumlama : Sonuç boolen "true" ya da "false" olarak döner
    */
    public boolean getEquals(int type , String text){
        boolean result /*= false*/;
        if(type==1){
            result = string.equalsIgnoreCase(text);
        }else{
            result = string.equals(text);
        }
        
        return result;
    }
    
    /*
    * Class içerisine tanımlanan String ifadeyi büyük ya da küçük harfe çevirir.
    * Kullanım Başlangıç : setString("Text Metni"); şeklinde işlem yapıloacak string class içerisine tanıtılır
    * Kullanım - 1 : Metnin tamamı Küçük harfe çevrilmek isteniyorsa getCase(1); olarak çağrılır ve kullanılır
    * Kullanım - 2 : Metnin tamamı Büyük harfe çevrilmek isteniyorsa getCase(2); olarak çağrılır ve kullanılır
    */
    public String getCase(int type){
        if(type==1){
            string = string.toLowerCase();
        }else{
            string = string.toUpperCase();
        }
        
        return string;
    }
    
    /*
    * Class içerisinde tanımlanmış olan string ifadenin sağ ve solunda bulunan boşlukları siler oertasında bulunan boşluklara dokunmaz
    * Kullanım : setString("Text Metni"); şeklinde tanıtılan string, getTrim() fonksiyonu çağrılarak sağ ve solunda bulunan boşluklar  silinir
    */
    public String getTrim(){
        return string.trim();
    }
    
    /* 
    * Class içerisinde tanımlanan String ifadeyi belirtilen karakterden itibaren bölerek array içerisine atar.
    * Kullanım : setString("Text Metni Bölme işlemi"); şeklinde tanıtılan string, getSplit(String mask) fonksiyonu çağrılarak mask ile tanıtılan değişkene göre bölünür.
    * Örnek Kullanım : getSplit(" "); Boşluklardan bölme işlemini gerçekler
    */
    public String[] getSplit(String mask){
        return string.split(mask);
    }
    
    /*
    * Array içerisinde gönderilen String değerleri birleştiri. concat methodu kullanılır
    * Kullanımı : String[] stringArray = {"ömer","faruk","KESMEZ"}; şeklinde tanımlı array getConcat(stringArray); şeklinde fonksiyona gönderilir ve sonuç olarak string alınır.
    */
    public String getConcat(String[] stringArray){
        for (String value : stringArray){
            string = string.concat(value+" ");
        }
        
        return this.getTrim();
    }
}
