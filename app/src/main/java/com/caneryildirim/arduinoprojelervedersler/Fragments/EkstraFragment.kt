package com.caneryildirim.arduinoprojelervedersler.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.caneryildirim.arduinoprojelervedersler.Activity.EkstraDetayActivity
import com.caneryildirim.arduinoprojelervedersler.Adaptors.DersViewAdaptor
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText3
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.imageED1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.imageED2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.mInterstitialAd
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.FragmentEkstraBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback




class EkstraFragment : Fragment(),DersViewAdaptor.Listener {
    private var _binding: FragmentEkstraBinding? = null
    private val binding get() = _binding!!

    var ekstraNoList=ArrayList<String>()
    var imageEkstraList=ArrayList<Int>()
    var ekstraKonuList=ArrayList<String>()
    var ekstraDetayTextList1=ArrayList<String>()
    var ekstraDetayTextList2=ArrayList<String>()
    var ekstraDetayTextList3=ArrayList<String>()
    var ekstraDetayImageList1=ArrayList<List<Int>>()
    var ekstraDetayImageList2=ArrayList<List<Int>>()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentEkstraBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Listeler()

        val layoutManagerEkstra= LinearLayoutManager(this.context)
        binding.recyclerViewEkstra.layoutManager=layoutManagerEkstra

        val recycleViewEkstraAdapter=DersViewAdaptor(this,imageEkstraList,ekstraNoList,ekstraKonuList)
        binding.recyclerViewEkstra.adapter=recycleViewEkstraAdapter

    }

    override fun onItemClick(position: Int) {


        val intent= Intent(this.context, EkstraDetayActivity::class.java)
        intent.putExtra("toolbar",ekstraNoList[position])
        intent.putExtra("position",position)

        ekstraDetayText1=ekstraDetayTextList1[position]
        ekstraDetayText2=ekstraDetayTextList2[position]
        ekstraDetayText3=ekstraDetayTextList3[position]

        imageED1=ekstraDetayImageList1[position]
        imageED2=ekstraDetayImageList2[position]

        startActivity(intent)



    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun Listeler(){
        ekstraNoList.add("Breadboard ve Jumper Kablo")
        ekstraNoList.add("Direnç ve Led")
        ekstraNoList.add("Buton ve Anahtar")
        ekstraNoList.add("Buzzer")
        ekstraNoList.add("LCD 2x16")
        ekstraNoList.add("RFID Modülü")
        ekstraNoList.add("Servo Motor")
        ekstraNoList.add("Kumanda Modülü")
        ekstraNoList.add("Keypad")
        ekstraNoList.add("Joystick Modülü")
        ekstraNoList.add("Step Motor")
        ekstraNoList.add("DC Motor ve L298N")
        ekstraNoList.add("Ultrasonik Sensör")
        ekstraNoList.add("LCD i2C Modülü")
        ekstraNoList.add("Protoshield")
        ekstraNoList.add("RGB Led")
        //ekstraNoList.add("Nokia 5110 LCD")
        ekstraNoList.add("PIR Sensör")
        //ekstraNoList.add("TFT Ekran")
        ekstraNoList.add("DHT11 Sensörü")
        //ekstraNoList.add("Ethernet Shield")
        ekstraNoList.add("Röle Modülü")
        ekstraNoList.add("IR Alıcı -Verici Modül")
        //ekstraNoList.add("Bluetooth Modülü")
        //ekstraNoList.add("Saat Modülü")
        //ekstraNoList.add("Sensör Shield")

        imageEkstraList.add(R.drawable.ekstra1)
        imageEkstraList.add(R.drawable.ekstra2)
        imageEkstraList.add(R.drawable.ekstra3)
        imageEkstraList.add(R.drawable.ekstra4)
        imageEkstraList.add(R.drawable.ekstra5)
        imageEkstraList.add(R.drawable.ekstra6)
        imageEkstraList.add(R.drawable.ekstra7)
        imageEkstraList.add(R.drawable.ekstra8)
        imageEkstraList.add(R.drawable.ekstra9)
        imageEkstraList.add(R.drawable.ekstra10)
        imageEkstraList.add(R.drawable.ekstra11)
        imageEkstraList.add(R.drawable.ekstra12)
        imageEkstraList.add(R.drawable.ekstra13)
        imageEkstraList.add(R.drawable.ekstra14)
        imageEkstraList.add(R.drawable.ekstra15)
        imageEkstraList.add(R.drawable.ekstra16)
        //imageEkstraList.add(R.drawable.ekstra17)
        imageEkstraList.add(R.drawable.ekstra18)
        //imageEkstraList.add(R.drawable.ekstra19)
        imageEkstraList.add(R.drawable.ekstra20)
        //imageEkstraList.add(R.drawable.ekstra21)
        imageEkstraList.add(R.drawable.ekstra22)
        imageEkstraList.add(R.drawable.ekstra23)
        //imageEkstraList.add(R.drawable.ekstra24)
        //imageEkstraList.add(R.drawable.ekstra25)
        //imageEkstraList.add(R.drawable.ekstra26)


        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")
        //ekstraKonuList.add("Nasıl Kullanılır")

        ekstraDetayTextList1.add("Breadboard elektronik devreleri\n" +
                "lehimleme yapmadan kurmamıza yarar.\n" +
                "Üzerinde devre elemanlarını ve \n" +
                "jumper kabloları bağlayabilmek için\n" +
                "delikler bulunur. Bu hatlar aslında\n" +
                "belirli bir düzen içinde birbirleri\n" +
                "ile bağlantılıdır.\n" +
                "\n" +
                "Bu bağlantılar aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Dirençler elektronik devrelerde\n" +
                "akımı sınırlamak amacıyla kullanılırlar.\n" +
                "\n" +
                "Birimi ohm dur. Direncin değerini\n" +
                "bulabilmek için üzerindeki renklere\n" +
                "bakmamız gerekir. Renk kodu tablosu\n" +
                "aşağıda verilmiştir.")
        ekstraDetayTextList1.add("Butonlar ve anahtarlar dijital giriş\n" +
                "elemanlarıdır.Butonlar normalde açık\n" +
                "yapıdadır, üzerine basılmadığı sürece\n" +
                "üzerinden akım geçirmez. Üzerine \n" +
                "basıldığı zaman kapalı konuma geçerek\n" +
                "üzerinden akım geçirir. \n" +
                "\n" +
                "Butonları arduino ile kullanırken\n" +
                "pull-down ya da pull up direnci\n" +
                "kullanmak gerekmektedir.\n" +
                "\n" +
                "Butona basınca arduino ya 5v sinyal\n" +
                "göndermek istiyorsak pull-down direnci\n" +
                "kullanılmalıdır.\n" +
                "\n" +
                "Butona basınca arduino ya 0v sinyal\n" +
                "göndermek istiyorsak pull-up direnci\n" +
                "kullanılmalıdır.\n" +
                "\n" +
                "Bu direnç 10k ohm değerindedir.\n" +
                "\n" +
                "Buton bağlantısı aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Buzzer lar \"bip\" leme seslerini\n" +
                "çıkaran devre elemanlarıdır.\n" +
                "\n" +
                "Projelerde uyarı seslerine ihtiyaç\n" +
                "duyulduğu zaman buzzerlar kullanılır.\n" +
                "\n" +
                "Buzzerlar uyarı sesleri çıkarttığı gibi\n" +
                "melodiler de çıkarabilir.\n" +
                "\n" +
                "Buzzerların \"+\" ve \"-\" bacağı bulunur.\n" +
                "\n" +
                "Devre bağlantısı aşağıdaki gibidir;\n")
        ekstraDetayTextList1.add("LCD ler istediğimiz verileri\n" +
                "görüntüleyebilmek için kullandığımız\n" +
                "ekranlardır. LCD lerde satır ve sütun\n" +
                "bulunur. \n" +
                "2x16 LCD de 2 tane satır ve her satırda\n" +
                "16 tane sütun bulunur.\n" +
                "\n" +
                "LCD bağlantısı aşağıdaki gibidir;")
        ekstraDetayTextList1.add("RFID Radyo frekansı ile tanımlamadır.\n" +
                "Akbiller,Turnike giriş kartları\n" +
                "RFID kartlara örnektir.\n" +
                "\n" +
                "Her RFID kartın bir ID si bulunur.\n" +
                "RFID modülü ile bu ID leri tanıyarak\n" +
                "ona göre işlemlerimizi gerçekleştiririz.\n" +
                "\n" +
                "RFID modülünün devre bağlantısı\n" +
                "aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Servo motorlar açısal hareket eden\n" +
                "motorlardır. istediğimiz açısal \n" +
                "değere hareket ederek orada sabit kalır.\n" +
                "\n" +
                "Servo motorların 3 adet bacağı vardır.\n" +
                "Bunlardan 2 tanesi besleme bacaklarıdır.\n" +
                "Diğer bacak ise data bacağıdır.\n" +
                "\n" +
                "Servo motorları arduino ile kullanırken\n" +
                "arduino nun akım değeri sınırlı olduğu\n" +
                "için harici bir güç kaynağı ile \n" +
                "beslemeyi tercih edeceğiz.\n" +
                "SG90 servo motorları 5v ile beslenir.\n" +
                "\n" +
                "Servo motorların arduinoya bağlantısı\n" +
                "aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Kumanda modülleri kızılötesi sinyallerle\n" +
                "çalışan modüllerdir.Kumanda kısmında\n" +
                "IR verici sensörü, alıcı kısmında ise\n" +
                "IR alıcı sensörü vardır.\n" +
                "Kumandadan her tuşun bir seri numarası\n" +
                "vardır ve bu tuşlara basıldığında\n" +
                "kumanda alıcıya bu seri numaraları \n" +
                "gönderir.\n" +
                "Bu seri numaraları if komutları ile\n" +
                "kontrol ederek istediğimiz cihazların\n" +
                "kontrolünü sağlayabiliriz.\n" +
                "\n" +
                "Kumanda moodülünün devre kurulumu\n" +
                "aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Keypad ler üzerinde rakam ve\n" +
                "harflerin bulunduğu toplu tuş sistemidir.\n" +
                "Bizim kullanacağımız keypad 4 satır ve\n" +
                "4 sütundan oluşmakta. bağlantımızı ve \n" +
                "kodlarımızı bu detaya göre oluşturuyoruz.\n" +
                "\n" +
                "Keypad in arduino ya bağlantısı \n" +
                "aşağıdaki gibidir;\n")
        ekstraDetayTextList1.add("Joystickler potansiyometreye benzer bir\n" +
                "mantıkla çalışırlar. Yatay ve Dikey \n" +
                "olarak iki çıkışı vardır. Bu çıkışlar\n" +
                "analog sinyal üretirler.\n" +
                "Joytick in üzerine basınca çıkış veren\n" +
                "bir de butonu bulunmaktadır.\n" +
                "\n" +
                "Joystick modülünün Arduino bağlantısı\n" +
                "aşağıdaki gibidir;")
        ekstraDetayTextList1.add("Step motorlar adım adım hareket\n" +
                "ettirebildiğimiz motorlardır.\n" +
                "Her bir step motorun her bir adımda\n" +
                "alacağı yol değişiklik gösterebilir.\n" +
                "Bu sebeple step motorların bilgi \n" +
                "kağıtlarını incelemek önemlidir.\n" +
                "\n" +
                "Biz 28byj-48 model step motorun\n" +
                "çalışmasını inceleyeceğiz ve buton\n" +
                "ile nasıl kontrol edildiğini göreceğiz.\n" +
                "\n" +
                "Step motorlar step motor sürücü ile \n" +
                "birlikte kullanılır. Biz uln2003 sürücü\n" +
                "kullanacağız.\n" +
                "\n" +
                "Step motor ve sürücü devre bağlantısı\n" +
                "aşağıdaki gibi yapılır;")
        ekstraDetayTextList1.add("DC motorlar adı üzerinde DC gerilimle\n" +
                "çalışan motorlardır. Motorlar yüksek\n" +
                "akım çektikleri için Ardunio ya doğrudan\n" +
                "bağlanamazar. Bu sebeple L298N Motor\n" +
                "sürücüleri kullanılabilir.\n" +
                "\n" +
                "L298N sürücüye motor için ayrı bir\n" +
                "güç kaynağı bağlanır. Arduino dan aldığıa\n" +
                "sinyalleri yükselterek motora iletir.\n" +
                "\n" +
                "L298N ile iki ayrı motor kullanılabilir\n" +
                "ve bu motorların hızları da kontrol\n" +
                "edilebilir.\n" +
                "\n" +
                "DC motor ve L298N bağlantısı aşağıdaki\n" +
                "gibidir;")
        ekstraDetayTextList1.add("HC-SR04 Ultrasonik sensör mesafe\n" +
                "ölçümleri yapabilmek için kullanılan \n" +
                "sensör çeşididir. Ultrasonik seslerin\n" +
                "hızını ölçerek mesafeyi bulmamızı\n" +
                "sağlar.\n" +
                "\n" +
                "Üzerinde Ultrasonik ses dalgası gönderen\n" +
                "bir hoparlör ve bu dalgayı yakalayan\n" +
                "mikrofon ile çalışır.\n" +
                "\n" +
                "Trig pinine sinyal verdiğimizde hoparlör\n" +
                "ses dalgası gönderir ve bu dalga karşı\n" +
                "tarafa yansıyıp geri döndüğünde mikrofon\n" +
                "dalgayı yakalar. Arada geçen süreyi\n" +
                "bularak mesafemizi bulmuş oluruz.")
        ekstraDetayTextList1.add("LCD ler i2C modülü ile çok daha az \n" +
                "pin bağlantısı yaparak kullanılabilir.\n" +
                "\n" +
                "LCD ler kendinden i2C modüllü olarak \n" +
                "satılabiliyor, alırken buna dikkat \n" +
                "edilebilir.\n" +
                "\n" +
                "i2C modüllü LCD bağlantısı aşağıdaki\n" +
                "gibidir;\n" +
                "\n")
        ekstraDetayTextList1.add("Protoshield lar içinde breadboard\n" +
                "bulunan, bu sayede devre elemanlarını\n" +
                "üzerine kurabildiğimiz cihazlardır.\n" +
                "\n" +
                "Protoshiled üzerinde ayrıca delikli\n" +
                "bakır plaket mevcuttur. Üzerindeki\n" +
                "Breadboard ı çıkartarak devre\n" +
                "elemanlarını lehimleyebilirsiniz.")
        ekstraDetayTextList1.add("RGB ledler istediğimiz her renkte\n" +
                "ışık yayabilen led çeşididir.\n" +
                "4 ader bacağı vardır. Bunlardan üçü\n" +
                "renk bacakları, biri ise ortak bacaktır.\n" +
                "\n" +
                "Ortak Anotlu ve Ortat Katotlu olmak\n" +
                "üzere iki çeşidi vardır.\n" +
                "Ortak Anotlu olanda ortak uca \"+\"\n" +
                "sinyal verilir ve renk uçlarına\n" +
                "\"-\" sinyal verilir.\n" +
                "\n" +
                "Ortak Katotlu olanda ise ortak uca \"-\"\n" +
                "sinyal verilir ve renk uçlarına \"+\"\n" +
                "sinyal verilir.\n" +
                "\n" +
                "RGB Ledler ve bağlantıları aşağıdaki\n" +
                "gibidir;")
        ekstraDetayTextList1.add("PIR sensörü ortamdaki kızılötesi ısı\n" +
                "değişimini algılayarak o ortamdaki\n" +
                "hareketi tespit edebilen sensördür.\n" +
                "\n" +
                "Sensör üzerinde 2 adet pot vardır.\n" +
                "Potlardan birisi hareket alanını 3 ile\n" +
                "5 metre arasında ayarlamaktadır.\n" +
                "\n" +
                "Diğer pot ile de hareket alğılandığında\n" +
                "sensörün kaç saniye süreyle çıkış \n" +
                "vereceği ayarlanmaktadır.\n" +
                "\n" +
                "PIR sensörünün Arduino bağlantısı\n" +
                "aşağıdaki gibidir;")
        ekstraDetayTextList1.add("DHT11 ortamdaki sıcaklık ve nem \n" +
                "değerlerini alabilen dijital bir\n" +
                "sensördür. Üzerinde 4 adet pin vardır,\n" +
                "ancak 3 tanesini kullanmak yeterli\n" +
                "olmaktadır.\n" +
                "\n" +
                "DHT11 sensörün bağlantısı aşağıdaki\n" +
                "gibidir;")
        ekstraDetayTextList1.add("Röleler küçük gerilimler ile büyük\n" +
                "gerilimleri kontrol etmek için \n" +
                "kullanılan devre elemanlarıdır.\n" +
                "\n" +
                "Yani röleler sayesinde Arduinodan gelen\n" +
                "5V luk çıkış sinyali ile 220V luk bir\n" +
                "cihazı kontrol edebiliriz.\n" +
                "\n" +
                "Röleler elektromıknatıs özelliği ile \n" +
                "çalışır. bobin uçlarına sinyal verildiği\n" +
                "zaman içindeki anahtar konum değiştirir.\n" +
                "\n" +
                "NOT=220V yüksek gerilim olduğu için \n" +
                "çalışmadan önce her türlü güvenlik \n" +
                "önlemi alınmalıdır. 220V Elektrik \n" +
                "devreleri hakkında bir bilginiz ya da \n" +
                "yeterliliğiniz yoksa 220v ile devre \n" +
                "kurmamalısınız.\n" +
                "\n" +
                "Röle bağlantısı aşağıdaki yapılır;")
        ekstraDetayTextList1.add("IR alıcı verici sensörü sensör\n" +
                "uçlarında bir cisim algıladığı zaman\n" +
                "5V sinyal veren sensördür. Sensörün\n" +
                "üzerinde trimpot bulunur ve bu trimpotu\n" +
                "ayarlayarak sensörün algılama mesafesini\n" +
                "ayarlayabiliriz.")






        var ekstra1ImageList1= listOf<Int>(R.drawable.ekstra1a,R.drawable.ekstra1b,R.drawable.ekstra1c)
        ekstraDetayImageList1.add(ekstra1ImageList1)
        var ekstra2ImageList1= listOf<Int>(R.drawable.ekstra2a1,R.drawable.ekstra2a2,R.drawable.ekstra2a3)
        ekstraDetayImageList1.add(ekstra2ImageList1)
        var ekstra3ImageList1= listOf<Int>(R.drawable.ekstra3a1,R.drawable.ekstra3a2,R.drawable.ekstra3a3,R.drawable.ekstra3a4)
        ekstraDetayImageList1.add(ekstra3ImageList1)
        var ekstra4ImageList1= listOf<Int>(R.drawable.ekstra4a1)
        ekstraDetayImageList1.add(ekstra4ImageList1)
        var ekstra5ImageList1= listOf<Int>(R.drawable.ekstra5a1,R.drawable.ekstra5a2,R.drawable.ekstra5a3,R.drawable.ekstra5a4,R.drawable.ekstra5a5,R.drawable.ekstra5a6,R.drawable.ekstra5a7)
        ekstraDetayImageList1.add(ekstra5ImageList1)
        var ekstra6ImageList1= listOf<Int>(R.drawable.ekstra6a1,R.drawable.ekstra6a2,R.drawable.ekstra6a3,R.drawable.ekstra6a4,R.drawable.ekstra6a5,R.drawable.ekstra6a6,R.drawable.ekstra6a7,R.drawable.ekstra6a8)
        ekstraDetayImageList1.add(ekstra6ImageList1)
        var ekstra7ImageList1= listOf<Int>(R.drawable.ekstra7a1,R.drawable.ekstra7a2,R.drawable.ekstra7a3,R.drawable.ekstra7a4)
        ekstraDetayImageList1.add(ekstra7ImageList1)
        var ekstra8ImageList1= listOf<Int>(R.drawable.ekstra8a1,R.drawable.ekstra8a2,R.drawable.ekstra8a3)
        ekstraDetayImageList1.add(ekstra8ImageList1)
        var ekstra9ImageList1= listOf<Int>(R.drawable.ekstra9a1,R.drawable.ekstra9a2,R.drawable.ekstra9a3,R.drawable.ekstra9a4)
        ekstraDetayImageList1.add(ekstra9ImageList1)
        var ekstra10ImageList1= listOf<Int>(R.drawable.ekstra10a1,R.drawable.ekstra10a2,R.drawable.ekstra10a3)
        ekstraDetayImageList1.add(ekstra10ImageList1)
        var ekstra11ImageList1= listOf<Int>(R.drawable.ekstra11a1,R.drawable.ekstra11a2,R.drawable.ekstra11a3,R.drawable.ekstra11a4,R.drawable.ekstra11a5,R.drawable.ekstra11a6,R.drawable.ekstra11a7,R.drawable.ekstra11a8)
        ekstraDetayImageList1.add(ekstra11ImageList1)
        var ekstra12ImageList1= listOf<Int>(R.drawable.ekstra12a1,R.drawable.ekstra12a2,R.drawable.ekstra12a3,R.drawable.ekstra12a4,R.drawable.ekstra12a5,R.drawable.ekstra12a6,R.drawable.ekstra12a7,R.drawable.ekstra12a8)
        ekstraDetayImageList1.add(ekstra12ImageList1)
        var ekstra13ImageList1= listOf<Int>(R.drawable.ekstra13a1,R.drawable.ekstra13a2,R.drawable.ekstra13a3)
        ekstraDetayImageList1.add(ekstra13ImageList1)
        var ekstra14ImageList1= listOf<Int>(R.drawable.ekstra14a1,R.drawable.ekstra14a2,R.drawable.ekstra14a3)
        ekstraDetayImageList1.add(ekstra14ImageList1)
        var ekstra15ImageList1= listOf<Int>(R.drawable.ekstra15a1,R.drawable.ekstra15a2,R.drawable.ekstra15a3)
        ekstraDetayImageList1.add(ekstra15ImageList1)
        var ekstra16ImageList1= listOf<Int>(R.drawable.ekstra16a1,R.drawable.ekstra16a2,R.drawable.ekstra16a3,R.drawable.ekstra16a4,R.drawable.ekstra16a5,R.drawable.ekstra16a6,R.drawable.ekstra16a7)
        ekstraDetayImageList1.add(ekstra16ImageList1)
        var ekstra17ImageList1= listOf<Int>(R.drawable.ekstra17a1,R.drawable.ekstra17a2)
        ekstraDetayImageList1.add(ekstra17ImageList1)
        var ekstra18ImageList1= listOf<Int>(R.drawable.ekstra18a1,R.drawable.ekstra18a2)
        ekstraDetayImageList1.add(ekstra18ImageList1)
        var ekstra19ImageList1= listOf<Int>(R.drawable.ekstra19a1,R.drawable.ekstra19a2,R.drawable.ekstra19a3,R.drawable.ekstra19a4,R.drawable.ekstra19a5,R.drawable.ekstra19a6,R.drawable.ekstra19a7)
        ekstraDetayImageList1.add(ekstra19ImageList1)
        var ekstra20ImageList1= listOf<Int>(R.drawable.ekstra20a1)
        ekstraDetayImageList1.add(ekstra20ImageList1)




        ekstraDetayTextList2.add("Breadboard un iç yapısına göre \n" +
                "devre elemanlarının bağlantıları\n" +
                "yapılabilir. Devre elemanları arasında\n" +
                "bağlantıyı sağlamak için jumper kablolar\n" +
                "kullanılır.\n" +
                "\n" +
                "Bir devrenin şeması ile breadboard\n" +
                "üzerine kurulum örnekleri aşağıdaki\n" +
                "gibidir;")
        ekstraDetayTextList2.add("Ledler ışık yayan diyot çeşididir.\n" +
                "2 adet bacağı vardır. Bu bacaklardan \n" +
                "birisi Anot \"+\", diğeri Katot \"-\" \n" +
                "bacağıdır. Doğru bacaklara gerilim \n" +
                "verildiği zaman ışık yaymaktadır.\n" +
                "\n" +
                "Ledler yüksek gerilime maruz kaldığı\n" +
                "zaman bozulmaktadırlar. Bu durumun \n" +
                "önüne geçmek için ledlerin önüne\n" +
                "koruma direnci bağlanmalıdır.\n" +
                "\n" +
                "Ledler ortalama 3.2V ile ve 20mA akım\n" +
                "ile çalışır diye düşünerek direncin\n" +
                "değerini buna göre bulabiliriz.\n" +
                "\n" +
                "Arduino pinlerinden 5v çıkış geldiği\n" +
                "için ledlerin önüne 220 ohm direnç\n" +
                "koymak yeterli olacaktır")
        ekstraDetayTextList2.add("Anahtarlar da buton gibi pull-up ve \n" +
                "pull-down direncine ihtiyaç duyar.")
        ekstraDetayTextList2.add("Buzzerları çalıştırmak için aşağıdaki\n" +
                "kodları kullanabiliriz;\n")
        ekstraDetayTextList2.add("LCD yi kontrol etmek için LiquidCrystal\n" +
                "kütüphanesini kullanıyoruz.\n" +
                "Bu kütüphane sayesinde çok basit \n" +
                "komutlar ile LCD ye istediğimiz \n" +
                "şeyleri yazdırabiliriz.")
        ekstraDetayTextList2.add("RFID Modülü 3.3V ile çalıştığı için\n" +
                "Arduino 3.3V pinine bağlayarak\n" +
                "beslememiz gerekiyor.\n" +
                "\n" +
                "IRQ pinini bağlamamıza gerek olmadığı\n" +
                "için bağlantısını yapmıyoruz.\n" +
                "\n" +
                "RFID yi kullanırken RFID kütüphanesini\n" +
                "kullanacağız.\n" +
                "\n")
        ekstraDetayTextList2.add("Servoları Servo.h isimli kütüphane\n" +
                "içindeki kodlar yardımıyla kodluyoruz.\n" +
                "Bu kütüphane Arduino nun içinde \n" +
                "hazırda bulunduğu için indirmemize\n" +
                "gerek bulunmaz.\n" +
                "\n" +
                "Servoyu aşağıdaki kodlarla kontrol\n" +
                "edebiliriz.")
        ekstraDetayTextList2.add("Kumanda modülünü kullanmak için\n" +
                "IRremote.h isimli kütüphaneyi kullanırız.\n" +
                "\n" +
                "Kumanda modülünü aşağıdaki kodlarla\n" +
                "kullanabiliriz.")
        ekstraDetayTextList2.add("Keydap in soldan ilk 4 pini satır,\n" +
                "son 4 pini ise sütun pinleridir.\n" +
                "\n" +
                "Bu detaya özellikle kodlama kısmında\n" +
                "dikkat edilmesi gerekmektedir.\n" +
                "\n" +
                "Keypad aşağıdaki kodlarla kullanılabilir;")
        ekstraDetayTextList2.add("Joystick modülünü aşağıdaki kodlarla\n" +
                "kullanabiliriz;")
        ekstraDetayTextList2.add("28byj-48 Step motoru devir başına\n" +
                "28 adım ilerler. Bu bilgi kodlamada\n" +
                "önemli olacaktır. Siz başka bir\n" +
                "Step motor denerseniz bile sadece\n" +
                "kod kısmında bu değeri değiştirerek\n" +
                "step motorunuzu çalıştırabilirsiniz.\n" +
                "\n" +
                "Step motorları aşağıdaki gibi\n" +
                "kullanabiliriz.")
        ekstraDetayTextList2.add("Burada önemli olan nokta eğer motorlarda\n" +
                "hız kontrolü yapmayacaksak, EnA ve EnB\n" +
                "pinlerini doğrudan 5V a bağlamamız gerek.\n" +
                "Bu şekilde motorlar normal hızında \n" +
                "çalışacaktır. EnA ve EnB pinlerinin \n" +
                "hemen üstlerinde 5V pinleri vardır.\n" +
                "Bu pinlere kısa devre headerleri \n" +
                "ile bağlanabilirler.\n" +
                "\n" +
                "Motorlarda hız kontrolü yapılacaksa\n" +
                "EnA ve EnB pinlerinin Arduino nun PWM\n" +
                "sinyal üreten pinlerine bağlanmaları\n" +
                "gerekiyor.")
        ekstraDetayTextList2.add("HC-SR04 Ultrasonik sensörü istersek\n" +
                "kendimiz matematiksel kodlar kullanarak\n" +
                "mesafe ölçümü yapabiliriz. Ancak\n" +
                "kütüphane yardımıyla da kolay şekilde\n" +
                "mesafe alabiliriz.\n" +
                "\n" +
                "Biz burada kütüphane ile kolay bir \n" +
                "şekilde kullanımını yapacağız.\n")
        ekstraDetayTextList2.add("i2C modüllü lcd nin kullanımı normal\n" +
                "lcd den çok farklı değildir. sadece\n" +
                "farklı bir kütüphane kullanıp bir kaç\n" +
                "farklı kod yazılır. lcd işlem kodları\n" +
                "aynıdır.\n" +
                "\n" +
                "LCD nin kontras ayarı ldr nin \n" +
                "arkasındaki trimpot ile yapılır.")
        ekstraDetayTextList2.add("Protoshield üzerine devre elemanlarını\n" +
                "aşağıdaki gibi bağlayabilirsiniz;")
        ekstraDetayTextList2.add("RGB lerin Ortak anotlu ve Ortak katotlu\n" +
                "modelleri aşağıdaki kodlarla \n" +
                "kullanılabilir;")
        ekstraDetayTextList2.add("PIR sensörünü aşağıdaki kodlar ile\n" +
                "kullanabiliriz;")
        ekstraDetayTextList2.add("DHT11 sensörünü kütüphane ile kullanarak\n" +
                "kolay kodlarla sıcaklık ve nem değerini\n" +
                "alabiliriz;")
        ekstraDetayTextList2.add("Röleler aşağıdaki gibi kodlanarak\n" +
                "kullanılabilirler;")
        ekstraDetayTextList2.add("Sensörü aşağıdaki gibi kodlayarak\n" +
                "kullanabilirsiniz;")






        var ekstra1ImageList2= listOf<Int>(R.drawable.ekstra1d,R.drawable.ekstra1e,R.drawable.ekstra1f,R.drawable.ekstra1g)
        ekstraDetayImageList2.add(ekstra1ImageList2)
        var ekstra2ImageList2= listOf<Int>(R.drawable.ekstra2b1,R.drawable.ekstra2b2,R.drawable.ekstra2b3,R.drawable.ekstra2b4,R.drawable.ekstra2b5,R.drawable.ekstra2b6,R.drawable.ekstra2b7)
        ekstraDetayImageList2.add(ekstra2ImageList2)
        var ekstra3ImageList2= listOf<Int>(R.drawable.ekstra3b1,R.drawable.ekstra3b2,R.drawable.ekstra3b3,R.drawable.ekstra3b4,R.drawable.ekstra3b5,R.drawable.ekstra3b6)
        ekstraDetayImageList2.add(ekstra3ImageList2)
        var ekstra4ImageList2= listOf<Int>(R.drawable.ekstra4b1,R.drawable.ekstra4b2,R.drawable.ekstra4b3,R.drawable.ekstra4b4)
        ekstraDetayImageList2.add(ekstra4ImageList2)
        var ekstra5ImageList2= listOf<Int>(R.drawable.ekstra5b1,R.drawable.ekstra5b2,R.drawable.ekstra5b3,R.drawable.ekstra5b4,R.drawable.ekstra5b5,R.drawable.ekstra5b6,R.drawable.ekstra5b7,R.drawable.ekstra5b8)
        ekstraDetayImageList2.add(ekstra5ImageList2)
        var ekstra6ImageList2= listOf<Int>(R.drawable.ekstra6b1,R.drawable.ekstra6b2,R.drawable.ekstra6b3,R.drawable.ekstra6b4,
            R.drawable.ekstra6b5,R.drawable.ekstra6b6,R.drawable.ekstra6b7,R.drawable.ekstra6b8,R.drawable.ekstra6b9,R.drawable.ekstra6b10)
        ekstraDetayImageList2.add(ekstra6ImageList2)
        var ekstra7ImageList2= listOf<Int>(R.drawable.ekstra7b1,R.drawable.ekstra7b2,R.drawable.ekstra7b3,R.drawable.ekstra7b4)
        ekstraDetayImageList2.add(ekstra7ImageList2)
        var ekstra8ImageList2= listOf<Int>(R.drawable.ekstra8b1,R.drawable.ekstra8b2,R.drawable.ekstra8b3,R.drawable.ekstra8b4,R.drawable.ekstra8b5,R.drawable.ekstra8b6,R.drawable.ekstra8b7,R.drawable.ekstra8b8)
        ekstraDetayImageList2.add(ekstra8ImageList2)
        var ekstra9ImageList2= listOf<Int>(R.drawable.ekstra9b1,R.drawable.ekstra9b2,R.drawable.ekstra9b3,R.drawable.ekstra9b4,R.drawable.ekstra9b5,
            R.drawable.ekstra9b6,R.drawable.ekstra9b7,R.drawable.ekstra9b8,R.drawable.ekstra9b9,R.drawable.ekstra9b10,R.drawable.ekstra9b11)
        ekstraDetayImageList2.add(ekstra9ImageList2)
        var ekstra10ImageList2= listOf<Int>(R.drawable.ekstra10b1,R.drawable.ekstra10b2,R.drawable.ekstra10b3,R.drawable.ekstra10b4,R.drawable.ekstra10b5,R.drawable.ekstra10b6,R.drawable.ekstra10b7,R.drawable.ekstra10b8)
        ekstraDetayImageList2.add(ekstra10ImageList2)
        var ekstra11ImageList2= listOf<Int>(R.drawable.ekstra11b1,R.drawable.ekstra11b2,R.drawable.ekstra11b3,R.drawable.ekstra11b4,R.drawable.ekstra11b5,R.drawable.ekstra11b6,R.drawable.ekstra11b7)
        ekstraDetayImageList2.add(ekstra11ImageList2)
        var ekstra12ImageList2= listOf<Int>(R.drawable.ekstra12b1,R.drawable.ekstra12b2,R.drawable.ekstra12b3,R.drawable.ekstra12b4,R.drawable.ekstra12b5,R.drawable.ekstra12b6,R.drawable.ekstra12b7,R.drawable.ekstra12b8)
        ekstraDetayImageList2.add(ekstra12ImageList2)
        var ekstra13ImageList2= listOf<Int>(R.drawable.ekstra13b1,R.drawable.ekstra13b2,R.drawable.ekstra13b3,R.drawable.ekstra13b4,R.drawable.ekstra13b5,R.drawable.ekstra13b6)
        ekstraDetayImageList2.add(ekstra13ImageList2)
        var ekstra14ImageList2= listOf<Int>(R.drawable.ekstra14b1,R.drawable.ekstra14b2,R.drawable.ekstra14b3,R.drawable.ekstra14b4,R.drawable.ekstra14b5,R.drawable.ekstra14b6,R.drawable.ekstra14b7)
        ekstraDetayImageList2.add(ekstra14ImageList2)
        var ekstra15ImageList2= listOf<Int>(R.drawable.ekstra15b1)
        ekstraDetayImageList2.add(ekstra15ImageList2)
        var ekstra16ImageList2= listOf<Int>(R.drawable.ekstra16b1,R.drawable.ekstra16b2,R.drawable.ekstra16b3,R.drawable.ekstra16b4,R.drawable.ekstra16b5)
        ekstraDetayImageList2.add(ekstra16ImageList2)
        var ekstra17ImageList2= listOf<Int>(R.drawable.ekstra17b1,R.drawable.ekstra17b2,R.drawable.ekstra17b3,R.drawable.ekstra17b4,R.drawable.ekstra17b5)
        ekstraDetayImageList2.add(ekstra17ImageList2)
        var ekstra18ImageList2= listOf<Int>(R.drawable.ekstra18b1,R.drawable.ekstra18b2,R.drawable.ekstra18b3,R.drawable.ekstra18b4,R.drawable.ekstra18b5,R.drawable.ekstra18b6,R.drawable.ekstra18b7,R.drawable.ekstra18b8,R.drawable.ekstra18b9)
        ekstraDetayImageList2.add(ekstra18ImageList2)
        var ekstra19ImageList2= listOf<Int>(R.drawable.ekstra19b1,R.drawable.ekstra19b2,R.drawable.ekstra19b3,R.drawable.ekstra19b4)
        ekstraDetayImageList2.add(ekstra19ImageList2)
        var ekstra20ImageList2= listOf<Int>(R.drawable.ekstra20b1,R.drawable.ekstra20b2,R.drawable.ekstra20b3,R.drawable.ekstra20b4,R.drawable.ekstra20b5)
        ekstraDetayImageList2.add(ekstra20ImageList2)



        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")
        ekstraDetayTextList3.add("")

    }

}