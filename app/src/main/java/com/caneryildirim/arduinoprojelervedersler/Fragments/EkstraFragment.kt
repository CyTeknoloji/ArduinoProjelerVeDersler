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
        ekstraNoList.add("Diren?? ve Led")
        ekstraNoList.add("Buton ve Anahtar")
        ekstraNoList.add("Buzzer")
        ekstraNoList.add("LCD 2x16")
        ekstraNoList.add("RFID Mod??l??")
        ekstraNoList.add("Servo Motor")
        ekstraNoList.add("Kumanda Mod??l??")
        ekstraNoList.add("Keypad")
        ekstraNoList.add("Joystick Mod??l??")
        ekstraNoList.add("Step Motor")
        ekstraNoList.add("DC Motor ve L298N")
        ekstraNoList.add("Ultrasonik Sens??r")
        ekstraNoList.add("LCD i2C Mod??l??")
        ekstraNoList.add("Protoshield")
        ekstraNoList.add("RGB Led")
        //ekstraNoList.add("Nokia 5110 LCD")
        ekstraNoList.add("PIR Sens??r")
        //ekstraNoList.add("TFT Ekran")
        ekstraNoList.add("DHT11 Sens??r??")
        //ekstraNoList.add("Ethernet Shield")
        ekstraNoList.add("R??le Mod??l??")
        ekstraNoList.add("IR Al??c?? -Verici Mod??l")
        //ekstraNoList.add("Bluetooth Mod??l??")
        //ekstraNoList.add("Saat Mod??l??")
        //ekstraNoList.add("Sens??r Shield")

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


        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")
        //ekstraKonuList.add("Nas??l Kullan??l??r")

        ekstraDetayTextList1.add("Breadboard elektronik devreleri lehimleme yapmadan kurmam??za yarar.\n" +
                "??zerinde devre elemanlar??n?? ve jumper kablolar?? ba??layabilmek i??in delikler bulunur. Bu hatlar asl??nd belirli bir d??zen i??inde birbirleri ile ba??lant??l??d??r.\n" +
                "\n" +
                "Bu ba??lant??lar a??a????daki gibidir;")
        ekstraDetayTextList1.add("Diren??ler elektronik devrelerde ak??m?? s??n??rlamak amac??yla kullan??l??rlar.\n" +
                "\n" +
                "Birimi ohm dur. Direncin de??erini bulabilmek i??in ??zerindeki renklere bakmam??z gerekir. Renk kodu tablosu a??a????da verilmi??tir.")
        ekstraDetayTextList1.add("Butonlar ve anahtarlar dijital giri?? elemanlar??d??r.Butonlar normalde a????k yap??dad??r, ??zerine bas??lmad?????? s??rece ??zerinden ak??m ge??irmez. ??zerine bas??ld?????? zaman kapal?? konuma ge??erek\n" +
                "??zerinden ak??m ge??irir. \n" +
                "\n" +
                "Butonlar?? arduino ile kullan??rken pull-down ya da pull up direnci kullanmak gerekmektedir.\n" +
                "\n" +
                "Butona bas??nca arduino ya 5v sinyal g??ndermek istiyorsak pull-down direnci kullan??lmal??d??r.\n" +
                "\n" +
                "Butona bas??nca arduino ya 0v sinyal g??ndermek istiyorsak pull-up direnci kullan??lmal??d??r.\n" +
                "\n" +
                "Bu diren?? 10k ohm de??erindedir.\n" +
                "\n" +
                "Buton ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("Buzzer lar \"bip\" leme seslerini ????karan devre elemanlar??d??r.\n" +
                "\n" +
                "Projelerde uyar?? seslerine ihtiya?? duyuldu??u zaman buzzerlar kullan??l??r.\n" +
                "\n" +
                "Buzzerlar uyar?? sesleri ????kartt?????? gibi melodiler de ????karabilir.\n" +
                "\n" +
                "Buzzerlar??n \"+\" ve \"-\" baca???? bulunur.\n" +
                "\n" +
                "Devre ba??lant??s?? a??a????daki gibidir;\n")
        ekstraDetayTextList1.add("LCD ler istedi??imiz verileri g??r??nt??leyebilmek i??in kulland??????m??z ekranlard??r. LCD lerde sat??r ve s??tun bulunur. \n" +
                "2x16 LCD de 2 tane sat??r ve her sat??rda 16 tane s??tun bulunur.\n" +
                "\n" +
                "LCD ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("RFID Radyo frekans?? ile tan??mlamad??r.\n" +
                "Akbiller,Turnike giri?? kartlar?? RFID kartlara ??rnektir.\n" +
                "\n" +
                "Her RFID kart??n bir ID si bulunur.\n" +
                "RFID mod??l?? ile bu ID leri tan??yarak ona g??re i??lemlerimizi ger??ekle??tiririz.\n" +
                "\n" +
                "RFID mod??l??n??n devre ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("Servo motorlar a????sal hareket eden motorlard??r. istedi??imiz a????sal de??ere hareket ederek orada sabit kal??r.\n" +
                "\n" +
                "Servo motorlar??n 3 adet baca???? vard??r.\n" +
                "Bunlardan 2 tanesi besleme bacaklar??d??r.\n" +
                "Di??er bacak ise data baca????d??r.\n" +
                "\n" +
                "Servo motorlar?? arduino ile kullan??rken arduino nun ak??m de??eri s??n??rl?? oldu??u i??in harici bir g???? kayna???? ile beslemeyi tercih edece??iz.\n" +
                "SG90 servo motorlar?? 5v ile beslenir.\n" +
                "\n" +
                "Servo motorlar??n arduinoya ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("Kumanda mod??lleri k??z??l??tesi sinyallerle ??al????an mod??llerdir.Kumanda k??sm??nda IR verici sens??r??, al??c?? k??sm??nda ise IR al??c?? sens??r?? vard??r.\n" +
                "Kumandadan her tu??un bir seri numaras?? vard??r ve bu tu??lara bas??ld??????nda kumanda al??c??ya bu seri numaralar?? g??nderir.\n" +
                "Bu seri numaralar?? if komutlar?? ile kontrol ederek istedi??imiz cihazlar??n kontrol??n?? sa??layabiliriz.\n" +
                "\n" +
                "Kumanda mood??l??n??n devre kurulumu a??a????daki gibidir;")
        ekstraDetayTextList1.add("Keypad ler ??zerinde rakam ve harflerin bulundu??u toplu tu?? sistemidir.\n" +
                "Bizim kullanaca????m??z keypad 4 sat??r ve 4 s??tundan olu??makta. ba??lant??m??z?? ve kodlar??m??z?? bu detaya g??re olu??turuyoruz.\n" +
                "\n" +
                "Keypad in arduino ya ba??lant??s?? a??a????daki gibidir;\n")
        ekstraDetayTextList1.add("Joystickler potansiyometreye benzer bir mant??kla ??al??????rlar. Yatay ve Dikey olarak iki ????k?????? vard??r. Bu ????k????lar analog sinyal ??retirler.\n" +
                "Joytick in ??zerine bas??nca ????k???? veren bir de butonu bulunmaktad??r.\n" +
                "\n" +
                "Joystick mod??l??n??n Arduino ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("Step motorlar ad??m ad??m hareket ettirebildi??imiz motorlard??r.\n" +
                "Her bir step motorun her bir ad??mda alaca???? yol de??i??iklik g??sterebilir.\n" +
                "Bu sebeple step motorlar??n bilgi ka????tlar??n?? incelemek ??nemlidir.\n" +
                "\n" +
                "Biz 28byj-48 model step motorun ??al????mas??n?? inceleyece??iz ve buton ile nas??l kontrol edildi??ini g??rece??iz.\n" +
                "\n" +
                "Step motorlar step motor s??r??c?? ile birlikte kullan??l??r. Biz uln2003 s??r??c?? kullanaca????z.\n" +
                "\n" +
                "Step motor ve s??r??c?? devre ba??lant??s?? a??a????daki gibi yap??l??r;")
        ekstraDetayTextList1.add("DC motorlar ad?? ??zerinde DC gerilimle ??al????an motorlard??r. Motorlar y??ksek ak??m ??ektikleri i??in Ardunio ya do??rudan ba??lanamazar. Bu sebeple L298N Motor s??r??c??leri kullan??labilir.\n" +
                "\n" +
                "L298N s??r??c??ye motor i??in ayr?? bir g???? kayna???? ba??lan??r. Arduino dan ald??????a sinyalleri y??kselterek motora iletir.\n" +
                "\n" +
                "L298N ile iki ayr?? motor kullan??labilir ve bu motorlar??n h??zlar?? da kontrol edilebilir.\n" +
                "\n" +
                "DC motor ve L298N ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("HC-SR04 Ultrasonik sens??r mesafe ??l????mleri yapabilmek i??in kullan??lan sens??r ??e??ididir. Ultrasonik seslerin h??z??n?? ??l??erek mesafeyi bulmam??z?? sa??lar.\n" +
                "\n" +
                "??zerinde Ultrasonik ses dalgas?? g??nderen bir hoparl??r ve bu dalgay?? yakalayan mikrofon ile ??al??????r.\n" +
                "\n" +
                "Trig pinine sinyal verdi??imizde hoparl??r ses dalgas?? g??nderir ve bu dalga kar???? tarafa yans??y??p geri d??nd??????nde mikrofon dalgay?? yakalar. Arada ge??en s??reyi bularak mesafemizi bulmu?? oluruz.")
        ekstraDetayTextList1.add("LCD ler i2C mod??l?? ile ??ok daha az pin ba??lant??s?? yaparak kullan??labilir.\n" +
                "\n" +
                "LCD ler kendinden i2C mod??ll?? olarak sat??labiliyor, al??rken buna dikkat edilebilir.\n" +
                "\n" +
                "i2C mod??ll?? LCD ba??lant??s?? a??a????daki gibidir;\n" +
                "\n")
        ekstraDetayTextList1.add("Protoshield lar i??inde breadboard bulunan, bu sayede devre elemanlar??n?? ??zerine kurabildi??imiz cihazlard??r.\n" +
                "\n" +
                "Protoshiled ??zerinde ayr??ca delikli bak??r plaket mevcuttur. ??zerindeki Breadboard ?? ????kartarak devre elemanlar??n?? lehimleyebilirsiniz.")
        ekstraDetayTextList1.add("RGB ledler istedi??imiz her renkte ??????k yayabilen led ??e??ididir.\n" +
                "4 ader baca???? vard??r. Bunlardan ?????? renk bacaklar??, biri ise ortak bacakt??r.\n" +
                "\n" +
                "Ortak Anotlu ve Ortat Katotlu olmak ??zere iki ??e??idi vard??r.\n" +
                "Ortak Anotlu olanda ortak uca \"+\" sinyal verilir ve renk u??lar??na \"-\" sinyal verilir.\n" +
                "\n" +
                "Ortak Katotlu olanda ise ortak uca \"-\" sinyal verilir ve renk u??lar??na \"+\" sinyal verilir.\n" +
                "\n" +
                "RGB Ledler ve ba??lant??lar?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("PIR sens??r?? ortamdaki k??z??l??tesi ??s?? de??i??imini alg??layarak o ortamdaki hareketi tespit edebilen sens??rd??r.\n" +
                "\n" +
                "Sens??r ??zerinde 2 adet pot vard??r.\n" +
                "Potlardan birisi hareket alan??n?? 3 ile 5 metre aras??nda ayarlamaktad??r.\n" +
                "\n" +
                "Di??er pot ile de hareket al????land??????nda sens??r??n ka?? saniye s??reyle ????k???? verece??i ayarlanmaktad??r.\n" +
                "\n" +
                "PIR sens??r??n??n Arduino ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("DHT11 ortamdaki s??cakl??k ve nem de??erlerini alabilen dijital bir sens??rd??r. ??zerinde 4 adet pin vard??r,ancak 3 tanesini kullanmak yeterli olmaktad??r.\n" +
                "\n" +
                "DHT11 sens??r??n ba??lant??s?? a??a????daki gibidir;")
        ekstraDetayTextList1.add("R??leler k??????k gerilimler ile b??y??k gerilimleri kontrol etmek i??in kullan??lan devre elemanlar??d??r.\n" +
                "\n" +
                "Yani r??leler sayesinde Arduinodan gelen 5V luk ????k???? sinyali ile 220V luk bir cihaz?? kontrol edebiliriz.\n" +
                "\n" +
                "R??leler elektrom??knat??s ??zelli??i ile ??al??????r. bobin u??lar??na sinyal verildi??i zaman i??indeki anahtar konum de??i??tirir.\n" +
                "\n" +
                "NOT=220V y??ksek gerilim oldu??u i??in ??al????madan ??nce her t??rl?? g??venlik ??nlemi al??nmal??d??r. 220V Elektrik devreleri hakk??nda bir bilginiz ya da yeterlili??iniz yoksa 220v ile devre kurmamal??s??n??z.\n" +
                "\n" +
                "R??le ba??lant??s?? a??a????daki gibi yap??l??r;")
        ekstraDetayTextList1.add("IR al??c?? verici sens??r?? sens??r u??lar??nda bir cisim alg??lad?????? zaman 5V sinyal veren sens??rd??r. Sens??r??n ??zerinde trimpot bulunur ve bu trimpotu ayarlayarak sens??r??n alg??lama mesafesini ayarlayabiliriz.")






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




        ekstraDetayTextList2.add("Breadboard un i?? yap??s??na g??re devre elemanlar??n??n ba??lant??lar?? yap??labilir. Devre elemanlar?? aras??nda ba??lant??y?? sa??lamak i??in jumper kablolar kullan??l??r.\n" +
                "\n" +
                "Bir devrenin ??emas?? ile breadboard ??zerine kurulum ??rnekleri a??a????daki gibidir;")
        ekstraDetayTextList2.add("Ledler ??????k yayan diyot ??e??ididir.\n" +
                "2 adet baca???? vard??r. Bu bacaklardan birisi Anot \"+\", di??eri Katot \"-\" baca????d??r. Do??ru bacaklara gerilim verildi??i zaman ??????k yaymaktad??r.\n" +
                "\n" +
                "Ledler y??ksek gerilime maruz kald?????? zaman bozulmaktad??rlar. Bu durumun ??n??ne ge??mek i??in ledlerin ??n??ne koruma direnci ba??lanmal??d??r.\n" +
                "\n" +
                "Ledler ortalama 3.2V ile ve 20mA ak??m ile ??al??????r diye d??????nerek direncin de??erini buna g??re bulabiliriz.\n" +
                "\n" +
                "Arduino pinlerinden 5v ????k???? geldi??i i??in ledlerin ??n??ne 220 ohm diren?? koymak yeterli olacakt??r")
        ekstraDetayTextList2.add("Anahtarlar da buton gibi pull-up ve pull-down direncine ihtiya?? duyar.")
        ekstraDetayTextList2.add("Buzzerlar?? ??al????t??rmak i??in a??a????daki kodlar?? kullanabiliriz;\n")
        ekstraDetayTextList2.add("LCD yi kontrol etmek i??in LiquidCrystal k??t??phanesini kullan??yoruz.\n" +
                "Bu k??t??phane sayesinde ??ok basit komutlar ile LCD ye istedi??imiz ??eyleri yazd??rabiliriz.")
        ekstraDetayTextList2.add("RFID Mod??l?? 3.3V ile ??al????t?????? i??in Arduino 3.3V pinine ba??layarak beslememiz gerekiyor.\n" +
                "\n" +
                "IRQ pinini ba??lamam??za gerek olmad?????? i??in ba??lant??s??n?? yapm??yoruz.\n" +
                "\n" +
                "RFID yi kullan??rken RFID k??t??phanesini kullanaca????z.\n" +
                "\n")
        ekstraDetayTextList2.add("Servolar?? Servo.h isimli k??t??phane i??indeki kodlar yard??m??yla kodluyoruz.\n" +
                "Bu k??t??phane Arduino nun i??inde haz??rda bulundu??u i??in indirmemize\n" +
                "gerek bulunmaz.\n" +
                "\n" +
                "Servoyu a??a????daki kodlarla kontrol edebiliriz.")
        ekstraDetayTextList2.add("Kumanda mod??l??n?? kullanmak i??in IRremote.h isimli k??t??phaneyi kullan??r??z.\n" +
                "\n" +
                "Kumanda mod??l??n?? a??a????daki kodlarla kullanabiliriz.")
        ekstraDetayTextList2.add("Keydap in soldan ilk 4 pini sat??r,son 4 pini ise s??tun pinleridir.\n" +
                "\n" +
                "Bu detaya ??zellikle kodlama k??sm??nda dikkat edilmesi gerekmektedir.\n" +
                "\n" +
                "Keypad a??a????daki kodlarla kullan??labilir;")
        ekstraDetayTextList2.add("Joystick mod??l??n?? a??a????daki kodlarla kullanabiliriz;")
        ekstraDetayTextList2.add("28byj-48 Step motoru devir ba????na 28 ad??m ilerler. Bu bilgi kodlamada ??nemli olacakt??r. Siz ba??ka bir\n" +
                "Step motor denerseniz bile sadece kod k??sm??nda bu de??eri de??i??tirerek step motorunuzu ??al????t??rabilirsiniz.\n" +
                "\n" +
                "Step motorlar?? a??a????daki gibi kullanabiliriz.")
        ekstraDetayTextList2.add("Burada ??nemli olan nokta e??er motorlarda h??z kontrol?? yapmayacaksak, EnA ve EnB pinlerini do??rudan 5V a ba??lamam??z gerek.\n" +
                "Bu ??ekilde motorlar normal h??z??nda ??al????acakt??r. EnA ve EnB pinlerinin hemen ??stlerinde 5V pinleri vard??r.\n" +
                "Bu pinlere k??sa devre headerleri ile ba??lanabilirler.\n" +
                "\n" +
                "Motorlarda h??z kontrol?? yap??lacaksa EnA ve EnB pinlerinin Arduino nun PWM sinyal ??reten pinlerine ba??lanmalar?? gerekiyor.")
        ekstraDetayTextList2.add("HC-SR04 Ultrasonik sens??r?? istersek kendimiz matematiksel kodlar kullanarak mesafe ??l????m?? yapabiliriz. Ancak k??t??phane yard??m??yla da kolay ??ekilde mesafe alabiliriz.\n" +
                "\n" +
                "Biz burada k??t??phane ile kolay bir ??ekilde kullan??m??n?? yapaca????z.\n")
        ekstraDetayTextList2.add("i2C mod??ll?? lcd nin kullan??m?? normal lcd den ??ok farkl?? de??ildir. sadece farkl?? bir k??t??phane kullan??p bir ka?? farkl?? kod yaz??l??r. lcd i??lem kodlar?? ayn??d??r.\n" +
                "\n" +
                "LCD nin kontras ayar?? ldr nin arkas??ndaki trimpot ile yap??l??r.")
        ekstraDetayTextList2.add("Protoshield ??zerine devre elemanlar??n?? a??a????daki gibi ba??layabilirsiniz;")
        ekstraDetayTextList2.add("RGB lerin Ortak anotlu ve Ortak katotlu modelleri a??a????daki kodlarla kullan??labilir;")
        ekstraDetayTextList2.add("PIR sens??r??n?? a??a????daki kodlar ile kullanabiliriz;")
        ekstraDetayTextList2.add("DHT11 sens??r??n?? k??t??phane ile kullanarak kolay kodlarla s??cakl??k ve nem de??erini alabiliriz;")
        ekstraDetayTextList2.add("R??leler a??a????daki gibi kodlanarak kullan??labilirler;")
        ekstraDetayTextList2.add("Sens??r?? a??a????daki gibi kodlayarak kullanabilirsiniz;")






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