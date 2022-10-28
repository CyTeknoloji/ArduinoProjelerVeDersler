   package com.caneryildirim.arduinoprojelervedersler.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.caneryildirim.arduinoprojelervedersler.Activity.DersDetayActivity
import com.caneryildirim.arduinoprojelervedersler.Adaptors.DersViewAdaptor
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText3
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetaybaslik
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersKod
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image1DD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image2DD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.mInterstitialAd

import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.FragmentDersBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback



class DersFragment : Fragment(),DersViewAdaptor.Listener {
    private var _binding: FragmentDersBinding? = null
    private val binding get() = _binding!!

    var dersNoList=ArrayList<String>()
    var imageDersList=ArrayList<Int>()
    var dersKonuList=ArrayList<String>()
    var dersKodList=ArrayList<String>()
    var dersDetayBaslikList=ArrayList<String>()
    var dersDetayTextList1=ArrayList<String>()
    var dersDetayTextList2=ArrayList<String>()
    var dersDetayTextList3=ArrayList<String>()
    var dersDetayImageList1=ArrayList<List<Int>>()
    var dersDetayImageList2=ArrayList<List<Int>>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Listeler()


        val layoutManager=LinearLayoutManager(this.context)
        binding.recyclerViewDers.layoutManager=layoutManager

        val recycleViewDersAdapter=DersViewAdaptor(this,imageDersList,dersNoList,dersKonuList)
        binding.recyclerViewDers.adapter=recycleViewDersAdapter

    }

    override fun onItemClick(position: Int) {


        val intent=Intent(this.context,DersDetayActivity::class.java)
            intent.putExtra("toolbar",dersKonuList[position])
            intent.putExtra("position",position)

            dersDetaybaslik=dersDetayBaslikList[position]
            dersDetayText1=dersDetayTextList1[position]
            dersDetayText2=dersDetayTextList2[position]
            dersDetayText3=dersDetayTextList3[position]

            image1DD=dersDetayImageList1[position]
            image2DD=dersDetayImageList2[position]

            dersKod=dersKodList[position]


            startActivity(intent)




    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun Listeler(){
        var x=0
        while (x<19){
            x++
            dersNoList.add("Ders $x")
        }

        dersKodList.add("ders1.ino")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders2.ino?alt=media&token=1e3d944e-6d42-47c5-82d5-9ff2b5e78fdb")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders3.ino?alt=media&token=52c5a750-7120-4111-bb00-b5ff3954ae65")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders4.ino?alt=media&token=145c87ca-92c6-4584-a9f0-28be8aa2165c")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders5.ino?alt=media&token=a8f44b43-66bb-413b-92e8-94350169c726")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders6.ino?alt=media&token=12cb9585-7161-422f-a936-72bf2dd70c09")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders7.ino?alt=media&token=4295c7f9-1a11-45f2-9b96-b314e3124a2d")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders8.ino?alt=media&token=c19a2d98-99ad-413b-b2e9-f5c53dfbc30a")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders9.ino?alt=media&token=d6526c29-fee9-4361-be52-ca0b58627557")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders10.ino?alt=media&token=62d6fed2-441c-41b2-a982-49a540ca5bef")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders11.ino?alt=media&token=12920bba-f062-4505-b0f9-64778ea2f6a1")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders12.ino?alt=media&token=d8b095b1-cad4-4ce0-8b9e-129d6cf17728")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders13.ino?alt=media&token=fbf3459e-47bc-46ed-83e0-cfefc892d815")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders14.ino?alt=media&token=ecd9e6bd-3b06-4a83-a743-55fbdf547ddd")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders15.ino?alt=media&token=348bec92-bd1b-4f32-bf12-ef834038f68d")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders16.ino?alt=media&token=5fb7302c-e585-4bb2-b2a5-c988d75422df")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders17.ino?alt=media&token=14840b29-132a-4705-aee5-59619ae9120f")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders18.ino?alt=media&token=28b1cb8e-38bc-4fc2-83f2-d870a6415f02")
        dersKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/DerslerKod%2Fders19.ino?alt=media&token=bd9e8174-7134-40a2-990d-5e8b27fcf609")

        dersKonuList.add("Arduino nedir ve nasıl kurulur")
        dersKonuList.add("Arduino İle Led Yakma ve Söndürme (Blink)")
        dersKonuList.add("Buton İle Led Yakma ve Söndürme")
        dersKonuList.add("Analog Değer Okuma ve Seri Haberleşme")
        dersKonuList.add("Potansiyometre ile led kontrolü")
        dersKonuList.add("Ledlerle Karaşimşek")
        dersKonuList.add("LDR İle Led Kontrolü")
        dersKonuList.add("Potansiyometre ve RGB")
        dersKonuList.add("NTC ile Led Kontrolü")
        dersKonuList.add("Park Sensörü Uygulaması")
        dersKonuList.add("Mikrofon ile Motor Kontrolü")
        dersKonuList.add("Joystick İle Servo Motor Kontrolü")
        dersKonuList.add("IR Kumanda İle RGB Kontrolü")
        dersKonuList.add("Dijital Metre Uygulaması")
        dersKonuList.add("PIR Sensörü İle Servo Motor Kontrolü")
        dersKonuList.add("Bluetooth Modülü İle RGB Kontrolü")
        dersKonuList.add("Toprak Nem Alarmı")
        dersKonuList.add("Yağmur Alarmı")
        dersKonuList.add("Gaz Alarmı")

        imageDersList.add(R.drawable.ders1)
        imageDersList.add(R.drawable.ders2)
        imageDersList.add(R.drawable.ders3)
        imageDersList.add(R.drawable.ders4)
        imageDersList.add(R.drawable.ders5)
        imageDersList.add(R.drawable.ders6)
        imageDersList.add(R.drawable.ders7)
        imageDersList.add(R.drawable.ders8)
        imageDersList.add(R.drawable.ders9)
        imageDersList.add(R.drawable.ders10)
        imageDersList.add(R.drawable.ders11)
        imageDersList.add(R.drawable.ders12)
        imageDersList.add(R.drawable.ders13)
        imageDersList.add(R.drawable.ders14)
        imageDersList.add(R.drawable.ders15)
        imageDersList.add(R.drawable.ders16)
        imageDersList.add(R.drawable.ders18)
        imageDersList.add(R.drawable.ders19)
        imageDersList.add(R.drawable.ders20)


        dersDetayBaslikList.add("Arduino Yazılımının İndirilmesi")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")
        dersDetayBaslikList.add("Gerekli Malzemeler")


        var ders1ImageList1= listOf<Int>(R.drawable.ders1a,R.drawable.ders1b,R.drawable.ders1c)
        dersDetayImageList1.add(ders1ImageList1)
        var ders2ImageList1= listOf<Int>(R.drawable.ders2a,R.drawable.ders2b,R.drawable.ders2c)
        dersDetayImageList1.add(ders2ImageList1)
        var ders3ImageList1= listOf<Int>(R.drawable.ders3a,R.drawable.ders3b,R.drawable.ders3c,R.drawable.ders3d,R.drawable.ders3e)
        dersDetayImageList1.add(ders3ImageList1)
        var ders4ImageList1= listOf<Int>(R.drawable.ders4a,R.drawable.ders4b,R.drawable.ders4c,R.drawable.ders4d)
        dersDetayImageList1.add(ders4ImageList1)
        var ders5ImageList1= listOf<Int>(R.drawable.ders5a,R.drawable.ders5b,R.drawable.ders5c,R.drawable.ders5d)
        dersDetayImageList1.add(ders5ImageList1)
        var ders6ImageList1= listOf<Int>(R.drawable.ders6a,R.drawable.ders6b,R.drawable.ders6c,R.drawable.ders6d,R.drawable.ders6e)
        dersDetayImageList1.add(ders6ImageList1)
        var ders7ImageList1= listOf<Int>(R.drawable.ders7a,R.drawable.ders7b,R.drawable.ders7c)
        dersDetayImageList1.add(ders7ImageList1)
        var ders8ImageList1= listOf<Int>(R.drawable.ders8a,R.drawable.ders8b,R.drawable.ders8c,R.drawable.ders8d)
        dersDetayImageList1.add(ders8ImageList1)
        var ders9ImageList1= listOf<Int>(R.drawable.ders9a,R.drawable.ders9b,R.drawable.ders9c)
        dersDetayImageList1.add(ders9ImageList1)
        var ders10ImageList1= listOf<Int>(R.drawable.ders10a,R.drawable.ders10b,R.drawable.ders10c,R.drawable.ders10d)
        dersDetayImageList1.add(ders10ImageList1)
        var ders11ImageList1= listOf<Int>(R.drawable.ders11a,R.drawable.ders11b,R.drawable.ders11c,R.drawable.ders11d,R.drawable.ders11e,R.drawable.ders11f)
        dersDetayImageList1.add(ders11ImageList1)
        var ders12ImageList1= listOf<Int>(R.drawable.ders12a,R.drawable.ders12b,R.drawable.ders12c)
        dersDetayImageList1.add(ders12ImageList1)
        var ders13ImageList1= listOf<Int>(R.drawable.ders13a,R.drawable.ders13b,R.drawable.ders13c,R.drawable.ders13d)
        dersDetayImageList1.add(ders13ImageList1)
        var ders14ImageList1= listOf<Int>(R.drawable.ders14a,R.drawable.ders14b,R.drawable.ders14c,R.drawable.ders14d,R.drawable.ders14e,R.drawable.ders14f,R.drawable.ders14g,R.drawable.ders14h,R.drawable.ders14x,R.drawable.ders14y)
        dersDetayImageList1.add(ders14ImageList1)
        var ders15ImageList1= listOf<Int>(R.drawable.ders15a,R.drawable.ders15b,R.drawable.ders15c,R.drawable.ders15d,R.drawable.ders15e)
        dersDetayImageList1.add(ders15ImageList1)
        var ders16ImageList1= listOf<Int>(R.drawable.ders16a,R.drawable.ders16b,R.drawable.ders16c,R.drawable.ders16d,R.drawable.ders16e)
        dersDetayImageList1.add(ders16ImageList1)
        var ders17ImageList1= listOf<Int>(R.drawable.ders17a,R.drawable.ders17b,R.drawable.ders17c,R.drawable.ders17d)
        dersDetayImageList1.add(ders17ImageList1)
        var ders18ImageList1= listOf<Int>(R.drawable.ders18a,R.drawable.ders18b,R.drawable.ders18c,R.drawable.ders18d)
        dersDetayImageList1.add(ders18ImageList1)
        var ders19ImageList1= listOf<Int>(R.drawable.ders19a,R.drawable.ders19b,R.drawable.ders19c)
        dersDetayImageList1.add(ders19ImageList1)


        dersDetayTextList2.add("Kurulum işlemi bittikten sonra Arduino kartımızı usb kablo ile bilgisayarımıza bağlıyoruz.Yeni donanım bulundu uyarısı çıkıp bir süre sonra geçecek ve sürücüler otomatik olarak yüklenmiş olacaktır. Arduino Kartın Program ile Bağlantısı Arduino programını açtıktan sonra Araçlar>Kart menüsünden Arduino Uno yu seçmeliyiz.")
        dersDetayTextList2.add("Devre kurulduktan sonra Arduino IDE programını açarak, Dosya sekmesine gelip Yeni seçeneğini seçerek yeni bir program dosyası açıyoruz ve Arduino kartımızı bilgisayarımıza bağlıyoruz.// ile başlayan satırlar yorum satırıdır ve silinebilirler.")
        dersDetayTextList2.add("Butonlardan düzgün biçimde veri okuyabilmek için 10k ohm direnç ile kullanılmalıdır. Bu dirence pull-down direnci denir. Butona basmadığımız zaman buton pininden okunan değer 0V olacaktır. Butona bastığımız anda buton pininden okunan değer 5V olacaktır.")
        dersDetayTextList2.add("Kodlarımız aşağıdaki gibidir.")
        dersDetayTextList2.add("Arduino dan analog sinyal alabilmek için(~) işareti olan pinlerden istediğimiz kullanmamız gerekiyor.(3,5,6,9,10,11. pinler). Biz bu devrede 3. pini kullandık.")
        dersDetayTextList2.add("Kodlarımızı aşağıdaki gibi yazıyoruz.")
        dersDetayTextList2.add("Devremize ait Arduino kodları aşağıdaki gibidir.")
        dersDetayTextList2.add("Kod kısmında pin tanımlamalarımızı bu sefer int değişkenleri ile yapacağız. #define komutu ile bunu yapmak arasında her hangi bir fark yoktur. Yani; #define potPin 3 ve int potPin=3 aynı işe yarayan kodlardır.")
        dersDetayTextList2.add("Devremize ait kodlar aşağıdaki gibidir.")
        dersDetayTextList2.add("Devremize ait kodlar aşağıdaki gibidir.")
        dersDetayTextList2.add("Motor sürücü harici bir güç kaynağı ile çalışır. Bu sebeple devremizde pil kullanıyoruz. 6V ile 12V arasında bir gerilim yeterli olacaktır. Devremize ait kodlar aşağıdaki gibidir.")
        dersDetayTextList2.add("Joystick i ileri geri hareket ettirince VRX pini, sağa sola hareket ettirince VRY pini analog sinyal üretir. Servo motorların ise beslemesi ayrı olarak yapılır. data pini ise PWM pinlerden birine bağlanır. Bu sebeple servonun data pinini 3 nolu pine bağlıyoruz. Devremizin kodları aşağıdaki gibidir;")
        dersDetayTextList2.add("IR kumandanın 1,2,3,4 numaralı butonlarını kullanacağız. Diğer butonlar kodlanmayacak. Devreye ait kodlar aşağıdadır;")
        dersDetayTextList2.add("Devremize ait kodlar aşağıdaki gibidir;")
        dersDetayTextList2.add("Devremize ait kodlar aşağıdaki gibidir;")
        dersDetayTextList2.add("Arduino 0. pini RX pinidir ve 1. pini TX pinidir. Bu pinler haberleşme pinleridir. başka cihazlarla haberleşmek için kullanılırlar. Burada bluetooth modülü ile haberleşmeyi sağlamak için bu pinleri kullandık. Buluetoot modülünün vericisini(TX), Arduino alıcısına(rx), Arduino vericisini(tcx), Bluetooth alıcısına(rx) bağlıyoruz. RGB ledimiz ortak anotlu olduğu için, ortak ucunu + hattına bağladık ve renk pinlerini arduino PWM pinlerine bağladık. Devremizin kodları aşağıdaki gibidir;")
        dersDetayTextList2.add("Bu devrede toprağın nemi belli bir değerin altına geldiğinde buzzer ötmeye başlayacak. Devrenin kodları aşağıdadır;")
        dersDetayTextList2.add("Devremizin kodları aşağıdadır;")
        dersDetayTextList2.add("Devremizin kodları aşağıdadır;")


        var ders1ImageList2= listOf<Int>(R.drawable.ders1d,R.drawable.ders1e,R.drawable.ders1f)
        dersDetayImageList2.add(ders1ImageList2)
        var ders2ImageList2= listOf<Int>(R.drawable.ders2d,R.drawable.ders2e,R.drawable.ders2f,R.drawable.ders2g,R.drawable.ders2h)
        dersDetayImageList2.add(ders2ImageList2)
        var ders3ImageList2= listOf<Int>(R.drawable.ders3f,R.drawable.ders3g,R.drawable.ders3h,R.drawable.ders3i,R.drawable.ders3j)
        dersDetayImageList2.add(ders3ImageList2)
        var ders4ImageList2= listOf<Int>(R.drawable.ders4e,R.drawable.ders4f,R.drawable.ders4g,R.drawable.ders4h)
        dersDetayImageList2.add(ders4ImageList2)
        var ders5ImageList2= listOf<Int>(R.drawable.ders5e,R.drawable.ders5f,R.drawable.ders5g,R.drawable.ders5h)
        dersDetayImageList2.add(ders5ImageList2)
        var ders6ImageList2= listOf<Int>(R.drawable.ders6f,R.drawable.ders6g,R.drawable.ders6h,R.drawable.ders6i)
        dersDetayImageList2.add(ders6ImageList2)
        var ders7ImageList2= listOf<Int>(R.drawable.ders7d,R.drawable.ders7e,R.drawable.ders7f,R.drawable.ders7g)
        dersDetayImageList2.add(ders7ImageList2)
        var ders8ImageList2= listOf<Int>(R.drawable.ders8e,R.drawable.ders8f,R.drawable.ders8g,R.drawable.ders8h,R.drawable.ders8i,R.drawable.ders8j)
        dersDetayImageList2.add(ders8ImageList2)
        var ders9ImageList2= listOf<Int>(R.drawable.ders9d,R.drawable.ders9e,R.drawable.ders9f,R.drawable.ders9g,R.drawable.ders9h,R.drawable.ders9i,R.drawable.ders9j,R.drawable.ders9k)
        dersDetayImageList2.add(ders9ImageList2)
        var ders10ImageList2= listOf<Int>(R.drawable.ders10e,R.drawable.ders10f,R.drawable.ders10g,R.drawable.ders10h,R.drawable.ders10i,R.drawable.ders10j,R.drawable.ders10k)
        dersDetayImageList2.add(ders10ImageList2)
        var ders11ImageList2= listOf<Int>(R.drawable.ders11g,R.drawable.ders11h,R.drawable.ders11i,R.drawable.ders11j)
        dersDetayImageList2.add(ders11ImageList2)
        var ders12ImageList2= listOf<Int>(R.drawable.ders12d,R.drawable.ders12e,R.drawable.ders12f,R.drawable.ders12g,R.drawable.ders12h)
        dersDetayImageList2.add(ders12ImageList2)
        var ders13ImageList2= listOf<Int>(R.drawable.ders13e,R.drawable.ders13f,R.drawable.ders13g,R.drawable.ders13h,R.drawable.ders13i,
            R.drawable.ders13j,R.drawable.ders13k,R.drawable.ders13l,R.drawable.ders13m,R.drawable.ders13n,R.drawable.ders13o,
            R.drawable.ders13p,R.drawable.ders13r)
        dersDetayImageList2.add(ders13ImageList2)
        var ders14ImageList2= listOf<Int>(R.drawable.ders14i,R.drawable.ders14j,R.drawable.ders14k,R.drawable.ders14l,R.drawable.ders14m,R.drawable.ders14n,
            R.drawable.ders14p,R.drawable.ders14r,R.drawable.ders14s,R.drawable.ders14t)
        dersDetayImageList2.add(ders14ImageList2)
        var ders15ImageList2= listOf<Int>(R.drawable.ders15f,R.drawable.ders15g,R.drawable.ders15h,R.drawable.ders15i,R.drawable.ders15j)
        dersDetayImageList2.add(ders15ImageList2)
        var ders16ImageList2= listOf<Int>(R.drawable.ders16f,R.drawable.ders16h,R.drawable.ders16h,R.drawable.ders16i,R.drawable.ders16j,
            R.drawable.ders16k,R.drawable.ders16l,R.drawable.ders16m,R.drawable.ders16n,R.drawable.ders16p,R.drawable.ders16r)
        dersDetayImageList2.add(ders16ImageList2)
        var ders17ImageList2= listOf<Int>(R.drawable.ders17e,R.drawable.ders17f,R.drawable.ders17g,R.drawable.ders17h)
        dersDetayImageList2.add(ders17ImageList2)
        var ders18ImageList2= listOf<Int>(R.drawable.ders18e,R.drawable.ders18f,R.drawable.ders18g,R.drawable.ders18h)
        dersDetayImageList2.add(ders18ImageList2)
        var ders19ImageList2= listOf<Int>(R.drawable.ders19d,R.drawable.ders19e,R.drawable.ders19f,R.drawable.ders19g)
        dersDetayImageList2.add(ders19ImageList2)


        dersDetayTextList3.add("Artık Arduino programlanmaya hazır. void setup() kısmına yazılan komutlar sadece 1 kere çalışır. Giriş çıkış pinleri,seri haberleşme gibi ayarlar burada yapılır. void lood() kısmında genel olarak yapılması istenen işe uygun programlama yapılır ve buradaki kodlar sürekli döngü halinde çalışır. Programımızı yazdıktan sonra yüklemeden önce Kontrol Et seçeneği seçilir. Ardından programımızı kaydetmemiz için bir seçenek açılacaktır.Kayıt yerimizi belirledikten sonra Program otomatik olarak derlenir. Programın herhangi bir satırında kodlama hatası varsa bu satır kırmızı bir şekilde bize uyarı olarak gösterilecektir.")
        dersDetayTextList3.add("void setup() kısmında kullanacağımız 8 numaralı pinin dijital çıkış olduğunu söyledik.\n" +
                "void loop() kısmında ilk olarak ledimizi HIGH komutu ile yaktık. Ardından 0.5 saniye hiç bir işlem yapmadan bekledik.\n" +
                "ledimizi LOW komutu ile söndürdük.\n" +
                "Tekrar 0.5 saniye bekledik.\n" +
                "void loop kısmında son satırdaki komut çalıştıktan sonra tekrar ilk komuta geri döner. ve bu şekilde programımız sonsuz döngüde tekrarlanır.\n" +
                "Kodlamamızı bitirdikten sonra Kontrol Et tuşuna basıyoruz. Bir hata çıkmaz ve Derleme tamamlandı yazısını görürsek Yükle butonuna basarak programı arduino muza yüklemiş oluruz.\n" +
                "Kodların tamamı aşağıdadır;\n" +
                "-------------------------------------\n" +
                "void setup() {\n" +
                "  pinMode(8,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  digitalWrite(8,HIGH);\n" +
                "  delay(500);\n" +
                "  digitalWrite(8,LOW);\n" +
                "  delay(500);\n" +
                "}\n" +
                "----------------------------------------")
        dersDetayTextList3.add("#define satırı ile 8 nolu pine buton,10 nolu pine led adını veriyoruz.\n" +
                "Bu durum kod yazarken rahatlık sağlar.\n" +
                "\n" +
                "Kod yazarken verileri kaydetmek için değişkenler kullanılır.\n" +
                "Tam sayı olan verileri kaydetmek için int kodunu kullanırız.\n" +
                "int butonDurum diyerek butonun burumunu bu değişkene kaydederiz.\n" +
                "Butona basılırsa butonDurum 1 olur,\n" +
                "butona basılmazsa butonDurum 0 olur.\n" +
                "\n" +
                "pinMode komutu ile buton pinini giriş, led pinini çıkış olarak tanımladık.\n" +
                "void loop kısmında digitalRead komutu ile butonun durumunu okuyup butonDurum a kaydediyoruz.\n" +
                "if ve else ikilisi şart durumlarında kullanılır. butonDurum 1 olursa if içindeki komut çalışır.\n" +
                "butonDurum un 1 olmadığı durumlarda else içindeki komut çalışır.\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "---------------------------------------\n" +
                "#define buton 8\n" +
                "#define led 10\n" +
                "\n" +
                "int butonDurum=0;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(buton,INPUT);\n" +
                "  pinMode(led,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  butonDurum=digitalRead(buton);\n" +
                "  if(butonDurum==1){\n" +
                "    digitalWrite(led,HIGH);\n" +
                "  }else{\n" +
                "    digitalWrite(led,LOW);\n" +
                "  }\n" +
                "}\n" +
                "----------------------------------------\n")
        dersDetayTextList3.add("En yukarıda define komutu ile A0 pinine potPin ismini verdik ve int komutu ile deger adında değişkenimizi oluşturduk.\n" +
                "setup kısmında pot tan gelen verileri Seri port ekranında görmek istediğimiz için Serial.begin komutunu kullandık ve istediğimiz bir yazı yazdırdık.\n" +
                "loop kısmında ise potansiyometreden gelen değeri analogRead ile okuyarak deger'e kaydettik ve değeri\n" +
                "Serial.println komutu ile seri port a göndermiş olduk.\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "-----------------------------------------\n" +
                "#define potPin A0\n" +
                "int deger=0;\n" +
                "\n" +
                "void setup() {\n" +
                "Serial.begin(9600);\n" +
                "Serial.println(\"Pot değeri=\");\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "deger=analogRead(potPin);\n" +
                "Serial.println(deger);\n" +
                "delay(500);\n" +
                "}\n" +
                "-----------------------------------------\n" +
                "\n")
        dersDetayTextList3.add("setup kısmında genellikle dijital giriş ve çıkışlar tanımlanır.\n" +
                "Bu devrede analog giriş ve analog çıkış kullandığımız için void setup kısmını boş bıraktık.\n" +
                "define komutları ile led için 3,pot için A0 değerlerini tanımladık.\n" +
                "void loop kısmında analogRead ile pot tan gelen değeri okuyarak int deger değişkenimize kaydettik.\n" +
                "Arduino analog okumayı 0 ile 1023 değerleri arasında yaparken,analog yazmayı 0 ile 255 arasında yapıyor.\n" +
                "Bu iki değeri map komutu ile eşitliyoruz.\n" +
                "analogWrite komutu ile lede\"deger\" değişkenindeki veri kadar sinyal gönderiyoruz.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "----------------------------------------\n" +
                "#define led 3\n" +
                "#define pot A0\n" +
                "\n" +
                "int deger=0;\n" +
                "void setup() {\n" +
                "\n" +
                "}\n" +
                "void loop() {\n" +
                "deger=analogRead(pot);\n" +
                "deger=map(deger,0,1023,0,255);\n" +
                "analogWrite(led,deger);\n" +
                "}\n" +
                "------------------------------------------\n" +
                "\n")
        dersDetayTextList3.add("6 adet ledi tanımlarken dizi kullanacağız.\n" +
                "Diziler değişkenlerden oluşan bir kümedir.\n" +
                "int ledler adında bir dizi tanımladık ve her birisinin bağlanacağı pinlerin numaralarını küme içerisine yazdık.\n" +
                "Yani 1. led 2 nolu pine, 2. led 3 nolu pine .... şeklinde bir tanımlama yaptık.\n" +
                "\n" +
                "Dizileri çağırırken ledler[ ] şeklinde çağırıyoruz.\n" +
                "ledler[0] dersek, 0. küme elemanı olan \"2\" değerini getirir.\n" +
                "ledler[5] yazarsak 5. küme elemanı olan \"7\" değerini getirecektir.\n" +
                "\n" +
                "void loop kısmında led pinlerini tanıtırken for döngüsünü kullanıyoruz.\n" +
                "\n" +
                "for (değişken adı,koşulumuz,yapılacak iş) biçiminde parantez içini kodluyoruz.\n" +
                "i değişkenimizin adı\n" +
                "\n" +
                "i<6 şartımız yani i, 6 dan küçük olduğu sürece for içindeki kodlar çalışacak\n" +
                "\n" +
                "i++ yapılacak işimiz. i++ demek\n" +
                "i nin içindeki değeri bir arttırmak demek\n" +
                "yani i içindeki değer 2 ise 3 olur.\n" +
                "\n" +
                "bu şekilde for döngüsü ile bütün ledlerin pinlerini tanımlamış oluruz.\n" +
                "\n" +
                "void loop içerisinde iki tane for döngümüz var. bunlardan ilki ledleri soldan sağa doğru yakıp söndürüyor.\n" +
                "Aşağıdaki for döngüsü ise ledleri sağdan sola doğru yakıp söndürüyor.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "-----------------------------------------\n" +
                "int ledler[]={2,3,4,5,6,7};\n" +
                "\n" +
                "void setup() {\n" +
                "  for(int i=0; i<6; i++){\n" +
                "  pinMode(ledler[i],OUTPUT);\n" +
                "  }\n" +
                "}\n" +
                "void loop() {\n" +
                "  for(int x=0; x<6; x++){\n" +
                "    digitalWrite(ledler[x],HIGH);\n" +
                "    delay(100);\n" +
                "    digitalWrite(ledler[x],LOW);\n" +
                "    delay(100);\n" +
                "  }\n" +
                "  for(int y=5; y>-1; y--){\n" +
                "    digitalWrite(ledler[y],HIGH);\n" +
                "    delay(100);\n" +
                "    digitalWrite(ledler[y],LOW);\n" +
                "    delay(100);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------")
        dersDetayTextList3.add("define komutu ile led pinimizi ve\n" +
                "ldr pinimizi belirliyoruz.\n" +
                "\n" +
                "int ldrVeri adında değişken tanımlıyoruz.\n" +
                "\n" +
                "void setup kısmında led pinimizi çıkış pini olarak tanımlıyoruz. Serial.begin ile seri haberleşmeyi başlatıyoruz.\n" +
                "\n" +
                "analogRead ile ldr nin sinyalini alarak ldrVeri değişkenine aktarıyoruz.\n" +
                "Serial.println komutu ile ldrVeri içindeki değerleri seri port üzerinden göreceğiz.Seri haberleşmenin çok hızlı olmaması için delay ile 50ms lik bir gecikme yapıyoruz.\n" +
                "\n" +
                "if komutu ile ldrVeri>900 ise ledimiz sönecek, değilse else komutu ile ledimiz yanacaktır.\n" +
                "\n" +
                "Kodumuzu yükledikten sonra Seri port ile ldrVeri değerlerine göre if içerisindeki koşul değerini arttırıp azaltabiliriz.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#define led 3\n" +
                "#define ldr A0\n" +
                "\n" +
                "int ldrVeri;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(led,OUTPUT);\n" +
                "  Serial.begin(9600);\n" +
                "}\n" +
                "void loop() {\n" +
                "  ldrVeri=analogRead(ldr);\n" +
                "  delay(50);\n" +
                "  if(ldrVeri>900){\n" +
                "    digitalWrite(led,LOW);\n" +
                "  }else{\n" +
                "    digitalWrite(led,HIGH);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------\n" +
                "\n" +
                "\n")
        dersDetayTextList3.add("Pin tanımlamalarımızı yukarıda yaptıktan sonra void setup kısmında pinlerimizin çıkış pinleri olduğunu belirtiyoruz.\n" +
                "\n" +
                "loop kısmında ise pot tan okuduğumuz değeri potDeger değişkenine kaydediyoruz.\n" +
                "if,ifelse ve else komutları ile koşullara göre ledimizin renklerini ayarlıyoruz.\n" +
                "\n" +
                "potDeger den gelen değerler 0 ile 1023 arasında olduğu için her renk için 3 aralık oluşturmak gerekiyor.\n" +
                "0-341 aralığı,\n" +
                "342-681 aralığı,\n" +
                "682-1023 aralığı.\n" +
                "\n" +
                "if komutunda gelen değer 341 den küçükse if parantezi altındaki işlemler yapılır.\n" +
                "Burada potDeger içindeki değeri 0 ile 255 arasına getirmek için 4 e bölüp 3 ile çarpıyoruz.\n" +
                "\n" +
                "if koşulu sağlanmazsa ifelse kısmına bakılır.buradaki koşul sağlanırsa altındaki komutlar çalışır. yoksa else komutunun altındaki komutlar çalışacaktır.\n" +
                "\n" +
                "koşulların altındaki komutlar renkleri ayarlamak için hazırlanmış matematiksel işlemlerdir.\n" +
                "\n" +
                "Son olarak ta analogWrite komutları ile RGB nin bacaklarına analog sinyaller yollanarak istenilen renk elde edilir.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "int potPin=A0;\n" +
                "int kirmiziPin=9;\n" +
                "int yesilPin=10;\n" +
                "int maviPin=11;\n" +
                "\n" +
                "int potDeger=0;\n" +
                "int kirmiziDeger=0;\n" +
                "int yesilDeger=0;\n" +
                "int maviDeger=0;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(kirmiziPin,OUTPUT);\n" +
                "  pinMode(yesilPin,OUTPUT);\n" +
                "  pinMode(maviPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  potDeger=analogRead(potPin);\n" +
                "  if(potDeger<341){\n" +
                "    potDeger=(potDeger*3)/4;\n" +
                "    kirmiziDeger=255-potDeger;\n" +
                "    yesilDeger=potDeger;\n" +
                "    maviDeger=0;\n" +
                "  }\n" +
                "  else if(potDeger<682){\n" +
                "    potDeger=(potDeger*3)/4;\n" +
                "    yesilDeger=255-potDeger;\n" +
                "    maviDeger=potDeger;\n" +
                "    kirmiziDeger=0;\n" +
                "  }\n" +
                "  else{\n" +
                "    potDeger=(potDeger*3)/4;\n" +
                "    maviDeger=255-potDeger;\n" +
                "    kirmiziDeger=potDeger;\n" +
                "    yesilDeger=0;\n" +
                "  }\n" +
                "  analogWrite(kirmiziPin,255-kirmiziDeger);\n" +
                "  analogWrite(yesilPin,255-yesilDeger);\n" +
                "  analogWrite(maviPin,255-maviDeger);\n" +
                "}\n" +
                "-------------------------------------------\n")
        dersDetayTextList3.add("Kodumuzda matematiksel işlemler yapacağımız için matematik kütüphanesini kodumuza dahil ettik.\n" +
                "\n" +
                "setup kısmında Seri haberleşmeyi başlattık ve ledimize ait pini çıkış olarak tanımladık.\n" +
                "\n" +
                "loop kısmında ise NTC den gelen analog sinyali \"deger\" isimli değişkene kaydettik.\n" +
                "\n" +
                "deger değişkenini Termistor fonksiyonunda matematiksel işlemden geçirip sıcaklığa dönüştürüyoruz.\n" +
                "\n" +
                "Az önce bahsettiğimiz matematiksel işlemler Termistor fonksiyonu içinde gerçekleşiyor.\n" +
                "\n" +
                "if else yapısı ile sıcaklık değeri 30 derece üzerindeyse led yanacak,değilse sönecektir.\n" +
                "\n" +
                "Seri haberleşmeyi yavaşlatmak için kodumuzun sonunda delay komutu ile 250ms gecikme yaratıyoruz.\n" +
                "\n" +
                "Kodumuzu Arduino muza yükledikten sonra Seri port ekranını açarak sıcaklık değerlerimizi görebiliriz.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "-------------------------------------------\n" +
                "#include<math.h>\n" +
                "#define led 2\n" +
                "\n" +
                "double Termistor(int analogVeri){\n" +
                "  double sicaklik;\n" +
                "  sicaklik=log(((10240000/analogVeri)-1000));\n" +
                "  sicaklik=1/(0.001129148+\n" +
                "  (0.000234125+\n" +
                "  (0.0000000876741*sicaklik*sicaklik))\n" +
                "  *sicaklik);\n" +
                "  sicaklik=sicaklik-273.15;\n" +
                "}\n" +
                "void setup() {\n" +
                "  Serial.begin(9600);\n" +
                "  pinMode(led,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  int deger=analogRead(A0);\n" +
                "  double sicaklik=Termistor(deger);\n" +
                "  Serial.println(sicaklik);\n" +
                "  if(sicaklik>30){\n" +
                "    digitalWrite(led,HIGH);\n" +
                "  }else{\n" +
                "    digitalWrite(led,LOW);\n" +
                "  }\n" +
                "}\n" +
                "-------------------------------------------\n")
        dersDetayTextList3.add("Bu kodda işlerimizin büyük kısımı fonksiyon oluşturarak halletmiş olduk.\n" +
                "\n" +
                "HC-SR04 sensörü ile ölçüm yapacağımız mesafe fonksiyonu oluşturduk.\n" +
                "\n" +
                "Gelen ölçüm değerine göre buzzer ın aralıklı çalma hızını ayarlayan melodi fonksiyonu oluşturduk.\n" +
                "\n" +
                "Bu iki fonksiyonu da void loop içinde birer kere kullanarak kodumuzu tamamladık.\n" +
                "\n" +
                "long değişkeni int değişkenine göre daha yüksek tamsayı aralığı alabildiği için long ile duration ve distance değişkenleri oluşturuldu.\n" +
                "\n" +
                "delayMicroseconds komutu ile mikrosaniye cinsinden gecikme oluşturduk.\n" +
                "\n" +
                "pulseIn komutu ile echoPin in kaç saniye sonra tetiklendiğini buluyoruz.\n" +
                "\n" +
                "distance=duration/58.2 komutu ile bulduğumuz süreyi mesafeye çeviriyoruz.\n" +
                "\n" +
                "Kodların Bütün Hali Aşağıdaki Gibidir;\n" +
                "---------------------------------------\n" +
                "#define echoPin 6\n" +
                "#define trigPin 7\n" +
                "#define buzzerPin 8\n" +
                "\n" +
                "int maxRange=50;\n" +
                "int minRange=0;\n" +
                "\n" +
                "int mesafe(int maximumRange,\n" +
                "\t   int minimumRange){\n" +
                "  long duration, distance;\n" +
                "\n" +
                "  digitalWrite(trigPin,LOW);\n" +
                "  delayMicroseconds(2);\n" +
                "  digitalWrite(trigPin,HIGH);\n" +
                "  delayMicroseconds(10);\n" +
                "  digitalWrite(trigPin,LOW);\n" +
                "\n" +
                "  duration=pulseIn(echoPin,HIGH);\n" +
                "  distance=duration/58.2;\n" +
                "  delay(50);\n" +
                "  if(distance>=maximumRange || \t\n" +
                "     distance<=minimumRange)\n" +
                "  return 0;\n" +
                "  return distance;  \n" +
                "}\n" +
                "int melodi(int dly){\n" +
                "  tone(buzzerPin,440);\n" +
                "  delay(dly);\n" +
                "  noTone(buzzerPin);\n" +
                "  delay(dly);\n" +
                "}\n" +
                "\n" +
                "void setup() {\n" +
                " pinMode(trigPin,OUTPUT);\n" +
                " pinMode(echpPin,INPUT);\n" +
                " pinMode(buzzerPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                " int olcum= mesafe(maxRange,minRange);\n" +
                " melodi(olcum*10);\n" +
                "}\n" +
                "-------------------------------------\n" +
                "\n" +
                "\n")
        dersDetayTextList3.add("Motorumuzun çalışmasını  IN3 ve IN4 pinlerine gerilim vererek kontrol ederiz.bu sebeple motorPin1 ve motorPin2 olarak bu girişleri tanımladık.\n" +
                "\n" +
                "Ses sensöründen gelen bilgiyi almak için sensorDurum isimli bir değişken tanımladık. \n" +
                "\n" +
                "Setup kısmında bu pinlerimizi tanıtmış olduk\n" +
                "\n" +
                "Loop kısmında sensör bilgimizi kaydettikten sonra if ve else komutları ile koşul durumu oluşturuyoruz.\n" +
                "\n" +
                "sensorDurum HIGH olarak okunduğu zaman if içerisindeki komutlar çalışacaktır.\n" +
                "Motorun çalışması için herhangi bir pinine 5v verip diğer pinine 0v vermek yeterli olacaktır.\n" +
                "\n" +
                "sensorDurum LOW olarak okunduğu zaman else içerisindeki komutlar çalışacaktır.\n" +
                "Motorun durması için her iki pine de 0v vermek yeterli olacaktır.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "-----------------------------------------\n" +
                "#define sensorPin 3\n" +
                "#define motorPin1 6\n" +
                "#define motorPin2 7\n" +
                "\n" +
                "int sensorDurum;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(sensorPin,INPUT);\n" +
                "  pinMode(motorPin1,OUTPUT);\n" +
                "  pinMode(motorPin2,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  sensorDurum=digitalRead(sensorPin);\n" +
                "  if(sensorDurum==HIGH){\n" +
                "    digitalWrite(motorPin1,HIGH);\n" +
                "    digitalWrite(motorPin2,LOW);\n" +
                "  }else{\n" +
                "    digitalWrite(motorPin1,LOW);\n" +
                "    digitalWrite(motorPin2,LOW);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------\n" +
                "\n" +
                "\n")
        dersDetayTextList3.add("Servo motorumuz 0 ile 180 derece arasında açısal hareket edebilmektedir.\n" +
                "\n" +
                "Joystick modülünden arduino nun A0 pinine giden veri ise 0 ile 1023 arasındadır.\n" +
                "\n" +
                "map komutu ile joystick ten gelen bu değeri servoya uygun dereceye dönüştürdük.\n" +
                "\n" +
                "Projemizde servo kullanacağımız zaman her motora Servo komutu ile isim veriyoruz\n" +
                "\n" +
                "Eğer 2 motorumuz olsaydı bunları motor1 ve motor2 olarak belirleyebilirdik.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#include<Servo.h>\n" +
                "\n" +
                "Servo motor;\n" +
                "int joystick;\n" +
                "int derece;\n" +
                "\n" +
                "void setup() {\n" +
                "  motor.attach(3);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  joystick=analogRead(A0);\n" +
                "  derece=map(joystick,0,1023,0,180);\n" +
                "  motor.write(derece);\n" +
                "}\n" +
                "-------------------------------------------\n")
        dersDetayTextList3.add("define kodları ile biz sadece kullanacağımız butonları tanımladık.\n" +
                "Bütün butonlar için gerekli kodlara internetten ulaşılabilmektedir.\n" +
                "\n" +
                "IR ile ilgili bütün yazdığımız kodları IRremote.h kütüphanesini eklediğimiz için kullanabiliyoruz.\n" +
                "\n" +
                "Kullandığımız RGB ortak anotlu olduğu için ledi söndürmek için diğer uçlara 5v vermek gerekiyor. Bu yüzden Buton0 için yazdığımız else if komutunun altında bütün RGB pinlerini HIGH yaptık.\n" +
                "\n" +
                "Aynı mantıkla ledin tüm renklerini açarak beyaz yanması için ortak anot dışındaki bacaklarımıza 0V vermemiz gerekiyor.\n" +
                "Bu yüzden Buton4 için yazılan else if komutunun altında bütüm RGB pinlerini LOW yaptık.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#include<IRremote.h>\n" +
                "int RECV_PIN=3;\n" +
                "int kirmiziLed=9;\n" +
                "int yesilLed=10;\n" +
                "int maviLed=11;\n" +
                "\n" +
                "decode_results result;\n" +
                "IRrecv irrecv(RECV_PIN);\n" +
                "\n" +
                "#define BUTON0 0XFF6897\n" +
                "#define BUTON1 0XFF30CF\n" +
                "#define BUTON2 0XFF18E7\n" +
                "#define BUTON3 0XFF7A85\n" +
                "#define BUTON4 0XFF10EF\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(kirmiziLed,OUTPUT);\n" +
                "  pinMode(yesilLed,OUTPUT);\n" +
                "  pinMode(maviLed,OUTPUT);\n" +
                "  Serial.begin(9600);\n" +
                "  irrecv.enableIRIn();\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  if(irrecv.decode(&results)){\n" +
                "    if(results.value==BUTON1){\n" +
                "      digitalWrite(kirmiziLed,\n" +
                "      !digitalRead(kirmiziLed));\n" +
                "    }\n" +
                "    else if(results.value==BUTON2){\n" +
                "      digitalWrite(yesilLed,\n" +
                "      !digitalRead(yesilLed));\n" +
                "    }\n" +
                "    else if(results.value==BUTON3){\n" +
                "      digitalWrite(maviLed,\n" +
                "      !digitalRead(maviLed));\n" +
                "    }\n" +
                "    else if(results.value==BUTON4){\n" +
                "      digitalWrite(kirmiziLed,LOW);\n" +
                "      digitalWrite(yesilLed,LOW);\n" +
                "      digitalWrite(maviLed,LOW);\n" +
                "    }\n" +
                "    else if(results.value==BUTON0){\n" +
                "      digitalWrite(kirmiziLed,HIGH);\n" +
                "      digitalWrite(yesilLed,HIGH);\n" +
                "      digitalWrite(maviLed,HIGH);\n" +
                "    }\n" +
                "    irrecv.resume();\n" +
                "  }\n" +
                "}\n" +
                "-------------------------------------------\n")
        dersDetayTextList3.add("loop kısmında önce trig pini LOW yapılarak sensör ölçüme hazırlanır.\n" +
                "Sonra trig pini önce HIGH sonra LOW yapılarak bir ses dalgası gönderilir.\n" +
                "\n" +
                "pulseIn komutu ile ses dalgasının süresi ölçülür. Bu süre 0,0345 ile çarpılıp 2 ye bölünerek mesafe bulunur.\n" +
                "\n" +
                "lcd mize yazı yazdırmak için lcd.print komutunu kullanıyoruz. Eğer parantez içinde kendi istediğimiz bir yazı vs.yazdırmak istersek, yazdıracağımız şeyi tırnak içine alıp öyle yazarız.\n" +
                "Örnek lcd.print(\"DENEME\");\n" +
                "\n" +
                "Eğer bir değişken yazdıracaksak parantez içine değişken adımızı yazmamız yeterli olur.\n" +
                "Örnek lcd.print(uzaklik);\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#include<LiquidCrystal.h>\n" +
                "\n" +
                "int rs=12,en=11,d4=5,d5=4,d6=3,d7=2;\n" +
                "LiquidCrystal lcd(rs,en,d4,d5,d6,d7);\n" +
                "\n" +
                "int trigPin=7;\n" +
                "int echoPin=6;\n" +
                "int sure;\n" +
                "int uzaklik;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(trigPin,OUTPUT);\n" +
                "  pinMode(echoPin,INPUT);\n" +
                "  lcd.begin(16,2);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  digitalWrite(trigPin,LOW);\n" +
                "  delay(5);\n" +
                "  digitalWrite(trigPin,HIGH);\n" +
                "  delay(10);\n" +
                "  digitalWrite(trigPin,LOW);\n" +
                "  sure=pulseIn(echoPin,HIGH,11600);\n" +
                "  uzaklik=sure*0.0345/2;\n" +
                "  delay(250);\n" +
                "  lcd.clear();\n" +
                "  lcd.setCursor(0,0);\n" +
                "  lcd.print(\"Uzaklik=\");\n" +
                "  lcd.setCursor(0,1);\n" +
                "  lcd.print(uzaklik);\n" +
                "  lcd.print(\"cm\");\n" +
                "}\n" +
                "------------------------------------------\n")
        dersDetayTextList3.add("loop kısmında PIR sensöründen gelen bilgileri hareket değişkenine kaydederiz.\n" +
                "\n" +
                "Hareketin HIGH olması durumunda if altında bulunan komutlar çalışır.\n" +
                "Burada servo önce 150 derece hareket eder.\n" +
                "250ms bekler ve sonra 30 derece hareket ederek 250 ms bekler. \n" +
                "\n" +
                "Eğer hareket yoksa motor 90 derece açı ile duracaktır.\n" +
                "\n" +
                "Kodların Tamamı aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#include <Servo.h>\n" +
                "int servoPin=9;\n" +
                "Servo motor;\n" +
                "\n" +
                "int pirPin=8;\n" +
                "int hareket;\n" +
                "\n" +
                "void setup() {\n" +
                "  motor.attach(servoPin);\n" +
                "  pinMode(pirPin,INPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  hareket=digitalRead(pirPin);\n" +
                "\n" +
                "  if (hareket==HIGH){\n" +
                "    motor.write(150);\n" +
                "    delay(250);\n" +
                "    motor.write(30);\n" +
                "    delay(250);\n" +
                "  }\n" +
                "  else{\n" +
                "    motor.write(90);\n" +
                "  }\n" +
                "  \n" +
                "}\n" +
                "------------------------------------------")
        dersDetayTextList3.add("Bluetooth modülü de tıpkı bilgisayar gibi Arduino seri haberleşmesini kullanır.\n" +
                "Bu sebeple Bluetoot modülü kullanırken setup kısmına Serial.begin(9600) komutunu yazıyoruz.\n" +
                "\n" +
                "Kodlarımızın tamamı aşağıdaki gibidir;\n" +
                "-----------------------------------------\n" +
                "int veri;\n" +
                "int kirmiziPin=9;\n" +
                "int yesilPin=10;\n" +
                "int maviPin=11;\n" +
                "\n" +
                "void setup() {\n" +
                "  Serial.begin(9600);\n" +
                "  pinMode(kirmiziPin,OUTPUT);\n" +
                "  pinMode(yesilPin,OUTPUT);\n" +
                "  pinMode(maviPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  if(Serial.available()>0){\n" +
                "    veri=Serial.read();\n" +
                "  }\n" +
                "  if(veri=='k'){\n" +
                "    digitalWrite(kirmiziPin,LOW);\n" +
                "    digitalWrite(yesilPin,HIGH);\n" +
                "    digitalWrite(maviPin,HIGH);\n" +
                "  }\n" +
                "   else if(veri=='y'){\n" +
                "    digitalWrite(kirmiziPin,HIGH);\n" +
                "    digitalWrite(yesilPin,LOW);\n" +
                "    digitalWrite(maviPin,HIGH);\n" +
                "  }\n" +
                "   else if(veri=='m'){\n" +
                "    digitalWrite(kirmiziPin,HIGH);\n" +
                "    digitalWrite(yesilPin,HIGH);\n" +
                "    digitalWrite(maviPin,LOW);\n" +
                "  }\n" +
                "  else{\n" +
                "    digitalWrite(kirmiziPin,HIGH);\n" +
                "    digitalWrite(yesilPin,HIGH);\n" +
                "    digitalWrite(maviPin,HIGH);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------\n")
        dersDetayTextList3.add("Toprak nem sensörü potansiyometre ile ayarladığımız değerin altında nem ölçtüğü zaman DO pini 5v çıkış verecektir. \n" +
                "Nem değeri bu değerin üstünde ise DO pini 0v çıkış verecektir.\n" +
                "Kodların tamamı aşağıdadır;\n" +
                "------------------------------------------\n" +
                "#define sensorPin 9\n" +
                "#define buzzerPin 8\n" +
                "int sensorDurum;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(sensorPin,INPUT);\n" +
                "  pinMode(buzzerPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  sensorDurum=digitalRead(sensorPin);\n" +
                "  if(sensorDurum==HIGH){\n" +
                "    tone(buzzerPin,440);\n" +
                "    delay(200);\n" +
                "    noTone(buzzerPin);\n" +
                "    delay(200);\n" +
                "  }\n" +
                "  else{\n" +
                "    noTone(buzzerPin);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------")
        dersDetayTextList3.add("Yağmur sensörü Arduino analog pinine bağlı olduğu için 0-1023 değerleri arasında veri gönderecektir. bu değerler yağmur şiddetine göre artar ya da azalır.\n" +
                "\n" +
                "Kodumuzda sınır değerimizi 100 olarak belirledik ve if içinde bunu belirttik.\n" +
                "Sınır yetersiz gelirle değiştirilebilir.\n" +
                "\n" +
                "Kodların tamamı aşağıdadır;\n" +
                "-----------------------------------------\n" +
                "int sensorPin=A0;\n" +
                "int buzzerPin=8;\n" +
                "int sensorDurum;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(sensorPin,INPUT);\n" +
                "  pinMode(buzzerPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  sensorDurum=analogRead(sensorPin);\n" +
                "  if(sensorDurum>100){\n" +
                "    tone(buzzerPin,440);\n" +
                "    delay(200);\n" +
                "    noTone(buzzerPin);\n" +
                "    delay(200);\n" +
                "  }\n" +
                "  else{\n" +
                "     noTone(buzzerPin);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------")
        dersDetayTextList3.add("Gaz sensörü Arduino analog girişine bağlı olduğı için 0-1023 arasında değer gönderecektir. Gazın seviyesine göre bu değer değişir.\n" +
                "\n" +
                "sensorDurum içindeki verinin 400 den büyük olması halinde buzzer ötecektir.\n" +
                "400 değerini if içinde yazdık. eğer bu değeri istersek değiştirebiliriz.\n" +
                "\n" +
                "Kodların Tamamı Aşağıdadır;\n" +
                "------------------------------------------\n" +
                "int sensorPin=A0;\n" +
                "int buzzerPin=2;\n" +
                "int sensorDurum;\n" +
                "\n" +
                "void setup() {\n" +
                "  pinMode(buzzerPin,OUTPUT);\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "  sensorDurum=analogRead(sensorPin);\n" +
                "  if(sensorDurum>400){\n" +
                "    tone(buzzerPin,440);\n" +
                "    delay(200);\n" +
                "    noTone(buzzerPin);\n" +
                "    delay(200);\n" +
                "  }\n" +
                "  else{\n" +
                "     noTone(buzzerPin);\n" +
                "  }\n" +
                "}\n" +
                "------------------------------------------\n")

        dersDetayTextList1.add("Arduino yazılımının bilgisayara indirilmesi için aşağıdaki işlemlerin yapılması gerekmektedir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Led\n" +
                "-330Ω direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Devrenin Yapılışı")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Led\n" +
                "-Push buton\n" +
                "-330 ohm direnç\n" +
                "-10k ohm direnç\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulama ile butona basıldığı zaman ledin yanık, basılmadığı zaman ise\n" +
                "sönük kalması sağlanacaktır.\n" +
                "\n" +
                "Butonlar giriş olarak bağlanır(INPUT)\n" +
                "Ledler çıkış olarak bağlanır(OUTPUT)")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-10k ohm potansiyometre\n" +
                "-jumper kablo\n" +
                "\n" +
                "Arduino kart üzerinde Analog Input pinleri vardır. bu pinler ile 5V ve 0V arasında yer alan analog sinyaller ölçülebilir.\n" +
                "Bu devrede potansiyometre ile analog sinyal oluşturup arduino ile okuyacağız.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard-\n" +
                "-10k potansiyometre\n" +
                "-led\n" +
                "-330 ohm direnç\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada potansiyometreden okuduğumuz değer ile orantılı bir şekilde ledimizin parlaklığını ayarlayacağız.\n" +
                "\n" +
                "Led in parlaklığını analog çıkış ile ayarlayacağız.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-6 adet led\n" +
                "-6 adet 330 ohm direnç\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada for döngüsünün nasıl kullanıldığını göreceğiz.\n" +
                "\n" +
                "6 adet ledin her birisi sırası ile yanıp sönecekler.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-330 ohm direnç\n" +
                "-10k ohm direnç\n" +
                "-led\n" +
                "-ldr\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada LDR den gelen analog veriye göre ledimizi yakıp söndüreceğiz.\n" +
                "\n" +
                "LDR ışığa duyarlı dirençtir.Ortam ışığına göre direnç değeri değişir. Biz karanlık ortamde ledin yanmasını, aydınlık ortamda ise sönmesini istiyoruz.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-3 adet 330 ohm direnç\n" +
                "-RGB led\n" +
                "-10k potansiyometre\n" +
                "-jumper kablo\n" +
                "\n" +
                "RGB ledler sayesinde istediğimiz bütün renkleri elde edebiliyoruz.\n" +
                "RGB(kırmızı,yeşil,mavi) kısaltmasıdır.\n" +
                "RGB ledlerin bacak bağlantıları farklı olabilmekte.\n" +
                "\n" +
                "Bu devrede ortak anotlu RGB kullanıyoruz.\n" +
                "RGB ile proje yaparken bacaklarını arduino nun PWM özellikli pinlerine bağlamamız gerekiyor(3,5,6,9,10,11)")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-NTC Sıcaklık Sensörü\n" +
                "-Led\n" +
                "-330 ohm direnç\n" +
                "-10K ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "NTC ısıya duyarlı dirençtir.Ortam ısısı arttıkça iç direnci düşer.\n" +
                "Bu devrede NTC den gelen analog sinyali alarak matematiksel işlemlerden geçirip ortam sıcaklığını bulacağız.\n" +
                "\n" +
                "Burada matematiksel işlemlerin içeriğini bilmek önemli değil. Önemli olan NTC den gelen sinyali sıcaklığa dönüştürüp kullamnabilmektir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Buzzer\n" +
                "-330 ohm direnç\n" +
                "-HC-SR04 Ultrasonik Mesafe Sensörü\n" +
                "-Jumper Kablo\n" +
                "\n" +
                "HC-SR04 mesafe sensörü, önce ultrasonik bir dalga gönderir, sonra da bu dalganın yansımasını dinler. Arada geçen süreyi de formüle ederek mesafeyi bulmamızı sağlar.\n" +
                "\n" +
                "Devremiz aşağıdaki gibidir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-DC Motor\n" +
                "-330 ohm direnç\n" +
                "-L298N motor sürücüsü\n" +
                "-Ses sensör kartı\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada ses sensöründen okunan değere göre motorun hareketi sağlanacaktır.\n" +
                "\n" +
                "Ses sensör kartları ses seviyesi ayarlanan seviyenin üzerine ulaşınca 5v çıkış veren bir karttır. Ses seviyesinin sınırını belirlemek için üzerinde trimpot bulunur.\n" +
                "\n" +
                "DC motorlar çalışırken yüksek akım çekerler\n" +
                "Bu sebeple Arduino pinlerine direk bağlanamazlar. Arduino ile motor arasında motor sürücüler kullanılır.L298N süücüsünü bu sebeple kullanacağız.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Servo motor\n" +
                "-Joystick\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Joystick, üzerindeki kolu sağa sola ya da yukarı aşağı hareket ettirerek analog sinyal almamızı sağlar.\n" +
                "\n" +
                "Servo motorlar, data pininden aldığı sinyale göre açısal olarak hareket eden motorlardır.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-RGB led\n" +
                "-IR kumanda ve modülü\n" +
                "-3 adet 330 ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada IR kumandasından gelen kızılötesi sinyallere göre RGB ledin istenilen renkte yanması sağlanacaktır.\n" +
                "1'e basınca kırmızı\n" +
                "2'ye yasınca yeşil\n" +
                "3'e basınca mavi\n" +
                "4'e basınca beyaz ışık yanacaktır.\n" +
                "0'a basınca led sönecektir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-16x2 LCD\n" +
                "-HC-SR04 Ultrasonik Sensör\n" +
                "-10K potansiyometre\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Ultrasonik sensör ile mesafemizi ölçerek LCD ekran üzerinde bu mesafeyi yazdıracağız.\n" +
                "\n" +
                "LCD mizde 2 satır ve her satırda 16 karakter vardır.\n" +
                "\n" +
                "Potansiyometre ile LCD nin kontras ayarını yapacağız.\n" +
                "\n" +
                "Devremiz aşağıdaki gibidir;")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Servo motor\n" +
                "-PIR sensörü\n" +
                "-Jumper kablo\n" +
                "\n" +
                "PIR sensörü ortamdaki kızılötesi hareketleri algılayarak sinyal gönderen bir sensördür.\n" +
                "\n" +
                "Servo motor verilen açısal değere göre hareket eden motorlardır.\n" +
                "\n" +
                "Bu uygulamada PIR sensörü hareket alğıladığı zaman servo motorun çalışması sağlanacaktır.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-HC06 Bluetooth Modülü\n" +
                "-RGB led\n" +
                "-3 adet 330 ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada telefon üzerinden bluetooth yoluyla RGB ledlerin rengini kontrol edeceğiz.\n" +
                "Devremiz aşağıdaki gibidir;")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Topram nem sensörü\n" +
                "-Buzzer\n" +
                "-330 ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Toprak nem sensörü toprağa yerleştirilerek toprağın nemini ölçen bir sensördür.Sensörün üzerindeki potansiyometreyiayarlayarak sensörün hangi değerde çıkış vereceğini belirleyebiliyoruz.İstersek analog çıkışını kullanarak kendimiz kod üzerinde de bunu yapabiliriz.\n" +
                "Bu uygulamada sensörün dijital çıkışını kullanarak potansiyometre ile ayarlamasını yapacağız.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Yağmur sensörü\n" +
                "-Buzzer\n" +
                "-330 ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Yağmur sensörü üzerine yağmur değdiği anda yağmurun seviyesine göre analog sinyal üreten bir sensördür.\n" +
                "\n" +
                "Bu uygulamada yağmur yağmaya başladığında buzzer ın öteceği bir devre yapacağız.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Gaz sensörü\n" +
                "-Buzzer\n" +
                "-330 ohm direnç\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Gaz sensörü ortamdaki gazı ölçerek,analog sinyal gönderen bir sensördür.istenirse sensör üzerindeki potansiyometre ile istenen sınır değer ayarlanarak dijital olarak ta çıkış verebilir.\n" +
                "\n" +
                "Bu uygulamada ortamda gaz algılandığı zaman buzzer ötecek, ortamda gaz yoksa buzzer susacaktır.")

    }
}