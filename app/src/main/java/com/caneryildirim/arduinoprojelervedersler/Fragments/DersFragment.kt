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

        dersKonuList.add("Arduino nedir ve nas??l kurulur")
        dersKonuList.add("Arduino ??le Led Yakma ve S??nd??rme (Blink)")
        dersKonuList.add("Buton ??le Led Yakma ve S??nd??rme")
        dersKonuList.add("Analog De??er Okuma ve Seri Haberle??me")
        dersKonuList.add("Potansiyometre ile led kontrol??")
        dersKonuList.add("Ledlerle Kara??im??ek")
        dersKonuList.add("LDR ??le Led Kontrol??")
        dersKonuList.add("Potansiyometre ve RGB")
        dersKonuList.add("NTC ile Led Kontrol??")
        dersKonuList.add("Park Sens??r?? Uygulamas??")
        dersKonuList.add("Mikrofon ile Motor Kontrol??")
        dersKonuList.add("Joystick ??le Servo Motor Kontrol??")
        dersKonuList.add("IR Kumanda ??le RGB Kontrol??")
        dersKonuList.add("Dijital Metre Uygulamas??")
        dersKonuList.add("PIR Sens??r?? ??le Servo Motor Kontrol??")
        dersKonuList.add("Bluetooth Mod??l?? ??le RGB Kontrol??")
        dersKonuList.add("Toprak Nem Alarm??")
        dersKonuList.add("Ya??mur Alarm??")
        dersKonuList.add("Gaz Alarm??")

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


        dersDetayBaslikList.add("Arduino Yaz??l??m??n??n ??ndirilmesi")
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


        dersDetayTextList2.add("Kurulum i??lemi bittikten sonra Arduino kart??m??z?? usb kablo ile bilgisayar??m??za ba??l??yoruz.Yeni donan??m bulundu uyar??s?? ????k??p bir s??re sonra ge??ecek ve s??r??c??ler otomatik olarak y??klenmi?? olacakt??r. Arduino Kart??n Program ile Ba??lant??s?? Arduino program??n?? a??t??ktan sonra Ara??lar>Kart men??s??nden Arduino Uno yu se??meliyiz.")
        dersDetayTextList2.add("Devre kurulduktan sonra Arduino IDE program??n?? a??arak, Dosya sekmesine gelip Yeni se??ene??ini se??erek yeni bir program dosyas?? a????yoruz ve Arduino kart??m??z?? bilgisayar??m??za ba??l??yoruz.// ile ba??layan sat??rlar yorum sat??r??d??r ve silinebilirler.")
        dersDetayTextList2.add("Butonlardan d??zg??n bi??imde veri okuyabilmek i??in 10k ohm diren?? ile kullan??lmal??d??r. Bu dirence pull-down direnci denir. Butona basmad??????m??z zaman buton pininden okunan de??er 0V olacakt??r. Butona bast??????m??z anda buton pininden okunan de??er 5V olacakt??r.")
        dersDetayTextList2.add("Kodlar??m??z a??a????daki gibidir.")
        dersDetayTextList2.add("Arduino dan analog sinyal alabilmek i??in(~) i??areti olan pinlerden istedi??imiz kullanmam??z gerekiyor.(3,5,6,9,10,11. pinler). Biz bu devrede 3. pini kulland??k.")
        dersDetayTextList2.add("Kodlar??m??z?? a??a????daki gibi yaz??yoruz.")
        dersDetayTextList2.add("Devremize ait Arduino kodlar?? a??a????daki gibidir.")
        dersDetayTextList2.add("Kod k??sm??nda pin tan??mlamalar??m??z?? bu sefer int de??i??kenleri ile yapaca????z. #define komutu ile bunu yapmak aras??nda her hangi bir fark yoktur. Yani; #define potPin 3 ve int potPin=3 ayn?? i??e yarayan kodlard??r.")
        dersDetayTextList2.add("Devremize ait kodlar a??a????daki gibidir.")
        dersDetayTextList2.add("Devremize ait kodlar a??a????daki gibidir.")
        dersDetayTextList2.add("Motor s??r??c?? harici bir g???? kayna???? ile ??al??????r. Bu sebeple devremizde pil kullan??yoruz. 6V ile 12V aras??nda bir gerilim yeterli olacakt??r. Devremize ait kodlar a??a????daki gibidir.")
        dersDetayTextList2.add("Joystick i ileri geri hareket ettirince VRX pini, sa??a sola hareket ettirince VRY pini analog sinyal ??retir. Servo motorlar??n ise beslemesi ayr?? olarak yap??l??r. data pini ise PWM pinlerden birine ba??lan??r. Bu sebeple servonun data pinini 3 nolu pine ba??l??yoruz. Devremizin kodlar?? a??a????daki gibidir;")
        dersDetayTextList2.add("IR kumandan??n 1,2,3,4 numaral?? butonlar??n?? kullanaca????z. Di??er butonlar kodlanmayacak. Devreye ait kodlar a??a????dad??r;")
        dersDetayTextList2.add("Devremize ait kodlar a??a????daki gibidir;")
        dersDetayTextList2.add("Devremize ait kodlar a??a????daki gibidir;")
        dersDetayTextList2.add("Arduino 0. pini RX pinidir ve 1. pini TX pinidir. Bu pinler haberle??me pinleridir. ba??ka cihazlarla haberle??mek i??in kullan??l??rlar. Burada bluetooth mod??l?? ile haberle??meyi sa??lamak i??in bu pinleri kulland??k. Buluetoot mod??l??n??n vericisini(TX), Arduino al??c??s??na(rx), Arduino vericisini(tcx), Bluetooth al??c??s??na(rx) ba??l??yoruz. RGB ledimiz ortak anotlu oldu??u i??in, ortak ucunu + hatt??na ba??lad??k ve renk pinlerini arduino PWM pinlerine ba??lad??k. Devremizin kodlar?? a??a????daki gibidir;")
        dersDetayTextList2.add("Bu devrede topra????n nemi belli bir de??erin alt??na geldi??inde buzzer ??tmeye ba??layacak. Devrenin kodlar?? a??a????dad??r;")
        dersDetayTextList2.add("Devremizin kodlar?? a??a????dad??r;")
        dersDetayTextList2.add("Devremizin kodlar?? a??a????dad??r;")


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


        dersDetayTextList3.add("Art??k Arduino programlanmaya haz??r. void setup() k??sm??na yaz??lan komutlar sadece 1 kere ??al??????r. Giri?? ????k???? pinleri,seri haberle??me gibi ayarlar burada yap??l??r. void lood() k??sm??nda genel olarak yap??lmas?? istenen i??e uygun programlama yap??l??r ve buradaki kodlar s??rekli d??ng?? halinde ??al??????r. Program??m??z?? yazd??ktan sonra y??klemeden ??nce Kontrol Et se??ene??i se??ilir. Ard??ndan program??m??z?? kaydetmemiz i??in bir se??enek a????lacakt??r.Kay??t yerimizi belirledikten sonra Program otomatik olarak derlenir. Program??n herhangi bir sat??r??nda kodlama hatas?? varsa bu sat??r k??rm??z?? bir ??ekilde bize uyar?? olarak g??sterilecektir.")
        dersDetayTextList3.add("void setup() k??sm??nda kullanaca????m??z 8 numaral?? pinin dijital ????k???? oldu??unu s??yledik.\n" +
                "void loop() k??sm??nda ilk olarak ledimizi HIGH komutu ile yakt??k. Ard??ndan 0.5 saniye hi?? bir i??lem yapmadan bekledik.\n" +
                "ledimizi LOW komutu ile s??nd??rd??k.\n" +
                "Tekrar 0.5 saniye bekledik.\n" +
                "void loop k??sm??nda son sat??rdaki komut ??al????t??ktan sonra tekrar ilk komuta geri d??ner. ve bu ??ekilde program??m??z sonsuz d??ng??de tekrarlan??r.\n" +
                "Kodlamam??z?? bitirdikten sonra Kontrol Et tu??una bas??yoruz. Bir hata ????kmaz ve Derleme tamamland?? yaz??s??n?? g??r??rsek Y??kle butonuna basarak program?? arduino muza y??klemi?? oluruz.\n" +
                "Kodlar??n tamam?? a??a????dad??r;\n" +
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
        dersDetayTextList3.add("#define sat??r?? ile 8 nolu pine buton,10 nolu pine led ad??n?? veriyoruz.\n" +
                "Bu durum kod yazarken rahatl??k sa??lar.\n" +
                "\n" +
                "Kod yazarken verileri kaydetmek i??in de??i??kenler kullan??l??r.\n" +
                "Tam say?? olan verileri kaydetmek i??in int kodunu kullan??r??z.\n" +
                "int butonDurum diyerek butonun burumunu bu de??i??kene kaydederiz.\n" +
                "Butona bas??l??rsa butonDurum 1 olur,\n" +
                "butona bas??lmazsa butonDurum 0 olur.\n" +
                "\n" +
                "pinMode komutu ile buton pinini giri??, led pinini ????k???? olarak tan??mlad??k.\n" +
                "void loop k??sm??nda digitalRead komutu ile butonun durumunu okuyup butonDurum a kaydediyoruz.\n" +
                "if ve else ikilisi ??art durumlar??nda kullan??l??r. butonDurum 1 olursa if i??indeki komut ??al??????r.\n" +
                "butonDurum un 1 olmad?????? durumlarda else i??indeki komut ??al??????r.\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("En yukar??da define komutu ile A0 pinine potPin ismini verdik ve int komutu ile deger ad??nda de??i??kenimizi olu??turduk.\n" +
                "setup k??sm??nda pot tan gelen verileri Seri port ekran??nda g??rmek istedi??imiz i??in Serial.begin komutunu kulland??k ve istedi??imiz bir yaz?? yazd??rd??k.\n" +
                "loop k??sm??nda ise potansiyometreden gelen de??eri analogRead ile okuyarak deger'e kaydettik ve de??eri\n" +
                "Serial.println komutu ile seri port a g??ndermi?? olduk.\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
                "-----------------------------------------\n" +
                "#define potPin A0\n" +
                "int deger=0;\n" +
                "\n" +
                "void setup() {\n" +
                "Serial.begin(9600);\n" +
                "Serial.println(\"Pot de??eri=\");\n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "deger=analogRead(potPin);\n" +
                "Serial.println(deger);\n" +
                "delay(500);\n" +
                "}\n" +
                "-----------------------------------------\n" +
                "\n")
        dersDetayTextList3.add("setup k??sm??nda genellikle dijital giri?? ve ????k????lar tan??mlan??r.\n" +
                "Bu devrede analog giri?? ve analog ????k???? kulland??????m??z i??in void setup k??sm??n?? bo?? b??rakt??k.\n" +
                "define komutlar?? ile led i??in 3,pot i??in A0 de??erlerini tan??mlad??k.\n" +
                "void loop k??sm??nda analogRead ile pot tan gelen de??eri okuyarak int deger de??i??kenimize kaydettik.\n" +
                "Arduino analog okumay?? 0 ile 1023 de??erleri aras??nda yaparken,analog yazmay?? 0 ile 255 aras??nda yap??yor.\n" +
                "Bu iki de??eri map komutu ile e??itliyoruz.\n" +
                "analogWrite komutu ile lede\"deger\" de??i??kenindeki veri kadar sinyal g??nderiyoruz.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("6 adet ledi tan??mlarken dizi kullanaca????z.\n" +
                "Diziler de??i??kenlerden olu??an bir k??medir.\n" +
                "int ledler ad??nda bir dizi tan??mlad??k ve her birisinin ba??lanaca???? pinlerin numaralar??n?? k??me i??erisine yazd??k.\n" +
                "Yani 1. led 2 nolu pine, 2. led 3 nolu pine .... ??eklinde bir tan??mlama yapt??k.\n" +
                "\n" +
                "Dizileri ??a????r??rken ledler[ ] ??eklinde ??a????r??yoruz.\n" +
                "ledler[0] dersek, 0. k??me eleman?? olan \"2\" de??erini getirir.\n" +
                "ledler[5] yazarsak 5. k??me eleman?? olan \"7\" de??erini getirecektir.\n" +
                "\n" +
                "void loop k??sm??nda led pinlerini tan??t??rken for d??ng??s??n?? kullan??yoruz.\n" +
                "\n" +
                "for (de??i??ken ad??,ko??ulumuz,yap??lacak i??) bi??iminde parantez i??ini kodluyoruz.\n" +
                "i de??i??kenimizin ad??\n" +
                "\n" +
                "i<6 ??art??m??z yani i, 6 dan k??????k oldu??u s??rece for i??indeki kodlar ??al????acak\n" +
                "\n" +
                "i++ yap??lacak i??imiz. i++ demek\n" +
                "i nin i??indeki de??eri bir artt??rmak demek\n" +
                "yani i i??indeki de??er 2 ise 3 olur.\n" +
                "\n" +
                "bu ??ekilde for d??ng??s?? ile b??t??n ledlerin pinlerini tan??mlam???? oluruz.\n" +
                "\n" +
                "void loop i??erisinde iki tane for d??ng??m??z var. bunlardan ilki ledleri soldan sa??a do??ru yak??p s??nd??r??yor.\n" +
                "A??a????daki for d??ng??s?? ise ledleri sa??dan sola do??ru yak??p s??nd??r??yor.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
                "int ldrVeri ad??nda de??i??ken tan??ml??yoruz.\n" +
                "\n" +
                "void setup k??sm??nda led pinimizi ????k???? pini olarak tan??ml??yoruz. Serial.begin ile seri haberle??meyi ba??lat??yoruz.\n" +
                "\n" +
                "analogRead ile ldr nin sinyalini alarak ldrVeri de??i??kenine aktar??yoruz.\n" +
                "Serial.println komutu ile ldrVeri i??indeki de??erleri seri port ??zerinden g??rece??iz.Seri haberle??menin ??ok h??zl?? olmamas?? i??in delay ile 50ms lik bir gecikme yap??yoruz.\n" +
                "\n" +
                "if komutu ile ldrVeri>900 ise ledimiz s??necek, de??ilse else komutu ile ledimiz yanacakt??r.\n" +
                "\n" +
                "Kodumuzu y??kledikten sonra Seri port ile ldrVeri de??erlerine g??re if i??erisindeki ko??ul de??erini artt??r??p azaltabiliriz.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("Pin tan??mlamalar??m??z?? yukar??da yapt??ktan sonra void setup k??sm??nda pinlerimizin ????k???? pinleri oldu??unu belirtiyoruz.\n" +
                "\n" +
                "loop k??sm??nda ise pot tan okudu??umuz de??eri potDeger de??i??kenine kaydediyoruz.\n" +
                "if,ifelse ve else komutlar?? ile ko??ullara g??re ledimizin renklerini ayarl??yoruz.\n" +
                "\n" +
                "potDeger den gelen de??erler 0 ile 1023 aras??nda oldu??u i??in her renk i??in 3 aral??k olu??turmak gerekiyor.\n" +
                "0-341 aral??????,\n" +
                "342-681 aral??????,\n" +
                "682-1023 aral??????.\n" +
                "\n" +
                "if komutunda gelen de??er 341 den k??????kse if parantezi alt??ndaki i??lemler yap??l??r.\n" +
                "Burada potDeger i??indeki de??eri 0 ile 255 aras??na getirmek i??in 4 e b??l??p 3 ile ??arp??yoruz.\n" +
                "\n" +
                "if ko??ulu sa??lanmazsa ifelse k??sm??na bak??l??r.buradaki ko??ul sa??lan??rsa alt??ndaki komutlar ??al??????r. yoksa else komutunun alt??ndaki komutlar ??al????acakt??r.\n" +
                "\n" +
                "ko??ullar??n alt??ndaki komutlar renkleri ayarlamak i??in haz??rlanm???? matematiksel i??lemlerdir.\n" +
                "\n" +
                "Son olarak ta analogWrite komutlar?? ile RGB nin bacaklar??na analog sinyaller yollanarak istenilen renk elde edilir.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("Kodumuzda matematiksel i??lemler yapaca????m??z i??in matematik k??t??phanesini kodumuza dahil ettik.\n" +
                "\n" +
                "setup k??sm??nda Seri haberle??meyi ba??latt??k ve ledimize ait pini ????k???? olarak tan??mlad??k.\n" +
                "\n" +
                "loop k??sm??nda ise NTC den gelen analog sinyali \"deger\" isimli de??i??kene kaydettik.\n" +
                "\n" +
                "deger de??i??kenini Termistor fonksiyonunda matematiksel i??lemden ge??irip s??cakl????a d??n????t??r??yoruz.\n" +
                "\n" +
                "Az ??nce bahsetti??imiz matematiksel i??lemler Termistor fonksiyonu i??inde ger??ekle??iyor.\n" +
                "\n" +
                "if else yap??s?? ile s??cakl??k de??eri 30 derece ??zerindeyse led yanacak,de??ilse s??necektir.\n" +
                "\n" +
                "Seri haberle??meyi yava??latmak i??in kodumuzun sonunda delay komutu ile 250ms gecikme yarat??yoruz.\n" +
                "\n" +
                "Kodumuzu Arduino muza y??kledikten sonra Seri port ekran??n?? a??arak s??cakl??k de??erlerimizi g??rebiliriz.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("Bu kodda i??lerimizin b??y??k k??s??m?? fonksiyon olu??turarak halletmi?? olduk.\n" +
                "\n" +
                "HC-SR04 sens??r?? ile ??l????m yapaca????m??z mesafe fonksiyonu olu??turduk.\n" +
                "\n" +
                "Gelen ??l????m de??erine g??re buzzer ??n aral??kl?? ??alma h??z??n?? ayarlayan melodi fonksiyonu olu??turduk.\n" +
                "\n" +
                "Bu iki fonksiyonu da void loop i??inde birer kere kullanarak kodumuzu tamamlad??k.\n" +
                "\n" +
                "long de??i??keni int de??i??kenine g??re daha y??ksek tamsay?? aral?????? alabildi??i i??in long ile duration ve distance de??i??kenleri olu??turuldu.\n" +
                "\n" +
                "delayMicroseconds komutu ile mikrosaniye cinsinden gecikme olu??turduk.\n" +
                "\n" +
                "pulseIn komutu ile echoPin in ka?? saniye sonra tetiklendi??ini buluyoruz.\n" +
                "\n" +
                "distance=duration/58.2 komutu ile buldu??umuz s??reyi mesafeye ??eviriyoruz.\n" +
                "\n" +
                "Kodlar??n B??t??n Hali A??a????daki Gibidir;\n" +
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
        dersDetayTextList3.add("Motorumuzun ??al????mas??n??  IN3 ve IN4 pinlerine gerilim vererek kontrol ederiz.bu sebeple motorPin1 ve motorPin2 olarak bu giri??leri tan??mlad??k.\n" +
                "\n" +
                "Ses sens??r??nden gelen bilgiyi almak i??in sensorDurum isimli bir de??i??ken tan??mlad??k. \n" +
                "\n" +
                "Setup k??sm??nda bu pinlerimizi tan??tm???? olduk\n" +
                "\n" +
                "Loop k??sm??nda sens??r bilgimizi kaydettikten sonra if ve else komutlar?? ile ko??ul durumu olu??turuyoruz.\n" +
                "\n" +
                "sensorDurum HIGH olarak okundu??u zaman if i??erisindeki komutlar ??al????acakt??r.\n" +
                "Motorun ??al????mas?? i??in herhangi bir pinine 5v verip di??er pinine 0v vermek yeterli olacakt??r.\n" +
                "\n" +
                "sensorDurum LOW olarak okundu??u zaman else i??erisindeki komutlar ??al????acakt??r.\n" +
                "Motorun durmas?? i??in her iki pine de 0v vermek yeterli olacakt??r.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("Servo motorumuz 0 ile 180 derece aras??nda a????sal hareket edebilmektedir.\n" +
                "\n" +
                "Joystick mod??l??nden arduino nun A0 pinine giden veri ise 0 ile 1023 aras??ndad??r.\n" +
                "\n" +
                "map komutu ile joystick ten gelen bu de??eri servoya uygun dereceye d??n????t??rd??k.\n" +
                "\n" +
                "Projemizde servo kullanaca????m??z zaman her motora Servo komutu ile isim veriyoruz\n" +
                "\n" +
                "E??er 2 motorumuz olsayd?? bunlar?? motor1 ve motor2 olarak belirleyebilirdik.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("define kodlar?? ile biz sadece kullanaca????m??z butonlar?? tan??mlad??k.\n" +
                "B??t??n butonlar i??in gerekli kodlara internetten ula????labilmektedir.\n" +
                "\n" +
                "IR ile ilgili b??t??n yazd??????m??z kodlar?? IRremote.h k??t??phanesini ekledi??imiz i??in kullanabiliyoruz.\n" +
                "\n" +
                "Kulland??????m??z RGB ortak anotlu oldu??u i??in ledi s??nd??rmek i??in di??er u??lara 5v vermek gerekiyor. Bu y??zden Buton0 i??in yazd??????m??z else if komutunun alt??nda b??t??n RGB pinlerini HIGH yapt??k.\n" +
                "\n" +
                "Ayn?? mant??kla ledin t??m renklerini a??arak beyaz yanmas?? i??in ortak anot d??????ndaki bacaklar??m??za 0V vermemiz gerekiyor.\n" +
                "Bu y??zden Buton4 i??in yaz??lan else if komutunun alt??nda b??t??m RGB pinlerini LOW yapt??k.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("loop k??sm??nda ??nce trig pini LOW yap??larak sens??r ??l????me haz??rlan??r.\n" +
                "Sonra trig pini ??nce HIGH sonra LOW yap??larak bir ses dalgas?? g??nderilir.\n" +
                "\n" +
                "pulseIn komutu ile ses dalgas??n??n s??resi ??l????l??r. Bu s??re 0,0345 ile ??arp??l??p 2 ye b??l??nerek mesafe bulunur.\n" +
                "\n" +
                "lcd mize yaz?? yazd??rmak i??in lcd.print komutunu kullan??yoruz. E??er parantez i??inde kendi istedi??imiz bir yaz?? vs.yazd??rmak istersek, yazd??raca????m??z ??eyi t??rnak i??ine al??p ??yle yazar??z.\n" +
                "??rnek lcd.print(\"DENEME\");\n" +
                "\n" +
                "E??er bir de??i??ken yazd??racaksak parantez i??ine de??i??ken ad??m??z?? yazmam??z yeterli olur.\n" +
                "??rnek lcd.print(uzaklik);\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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
        dersDetayTextList3.add("loop k??sm??nda PIR sens??r??nden gelen bilgileri hareket de??i??kenine kaydederiz.\n" +
                "\n" +
                "Hareketin HIGH olmas?? durumunda if alt??nda bulunan komutlar ??al??????r.\n" +
                "Burada servo ??nce 150 derece hareket eder.\n" +
                "250ms bekler ve sonra 30 derece hareket ederek 250 ms bekler. \n" +
                "\n" +
                "E??er hareket yoksa motor 90 derece a???? ile duracakt??r.\n" +
                "\n" +
                "Kodlar??n Tamam?? a??a????dad??r;\n" +
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
        dersDetayTextList3.add("Bluetooth mod??l?? de t??pk?? bilgisayar gibi Arduino seri haberle??mesini kullan??r.\n" +
                "Bu sebeple Bluetoot mod??l?? kullan??rken setup k??sm??na Serial.begin(9600) komutunu yaz??yoruz.\n" +
                "\n" +
                "Kodlar??m??z??n tamam?? a??a????daki gibidir;\n" +
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
        dersDetayTextList3.add("Toprak nem sens??r?? potansiyometre ile ayarlad??????m??z de??erin alt??nda nem ??l??t?????? zaman DO pini 5v ????k???? verecektir. \n" +
                "Nem de??eri bu de??erin ??st??nde ise DO pini 0v ????k???? verecektir.\n" +
                "Kodlar??n tamam?? a??a????dad??r;\n" +
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
        dersDetayTextList3.add("Ya??mur sens??r?? Arduino analog pinine ba??l?? oldu??u i??in 0-1023 de??erleri aras??nda veri g??nderecektir. bu de??erler ya??mur ??iddetine g??re artar ya da azal??r.\n" +
                "\n" +
                "Kodumuzda s??n??r de??erimizi 100 olarak belirledik ve if i??inde bunu belirttik.\n" +
                "S??n??r yetersiz gelirle de??i??tirilebilir.\n" +
                "\n" +
                "Kodlar??n tamam?? a??a????dad??r;\n" +
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
        dersDetayTextList3.add("Gaz sens??r?? Arduino analog giri??ine ba??l?? oldu???? i??in 0-1023 aras??nda de??er g??nderecektir. Gaz??n seviyesine g??re bu de??er de??i??ir.\n" +
                "\n" +
                "sensorDurum i??indeki verinin 400 den b??y??k olmas?? halinde buzzer ??tecektir.\n" +
                "400 de??erini if i??inde yazd??k. e??er bu de??eri istersek de??i??tirebiliriz.\n" +
                "\n" +
                "Kodlar??n Tamam?? A??a????dad??r;\n" +
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

        dersDetayTextList1.add("Arduino yaz??l??m??n??n bilgisayara indirilmesi i??in a??a????daki i??lemlerin yap??lmas?? gerekmektedir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Led\n" +
                "-330?? diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Devrenin Yap??l??????")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Led\n" +
                "-Push buton\n" +
                "-330 ohm diren??\n" +
                "-10k ohm diren??\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulama ile butona bas??ld?????? zaman ledin yan??k, bas??lmad?????? zaman ise\n" +
                "s??n??k kalmas?? sa??lanacakt??r.\n" +
                "\n" +
                "Butonlar giri?? olarak ba??lan??r(INPUT)\n" +
                "Ledler ????k???? olarak ba??lan??r(OUTPUT)")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-10k ohm potansiyometre\n" +
                "-jumper kablo\n" +
                "\n" +
                "Arduino kart ??zerinde Analog Input pinleri vard??r. bu pinler ile 5V ve 0V aras??nda yer alan analog sinyaller ??l????lebilir.\n" +
                "Bu devrede potansiyometre ile analog sinyal olu??turup arduino ile okuyaca????z.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard-\n" +
                "-10k potansiyometre\n" +
                "-led\n" +
                "-330 ohm diren??\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada potansiyometreden okudu??umuz de??er ile orant??l?? bir ??ekilde ledimizin parlakl??????n?? ayarlayaca????z.\n" +
                "\n" +
                "Led in parlakl??????n?? analog ????k???? ile ayarlayaca????z.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-6 adet led\n" +
                "-6 adet 330 ohm diren??\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada for d??ng??s??n??n nas??l kullan??ld??????n?? g??rece??iz.\n" +
                "\n" +
                "6 adet ledin her birisi s??ras?? ile yan??p s??necekler.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-330 ohm diren??\n" +
                "-10k ohm diren??\n" +
                "-led\n" +
                "-ldr\n" +
                "-jumper kablo\n" +
                "\n" +
                "Bu uygulamada LDR den gelen analog veriye g??re ledimizi yak??p s??nd??rece??iz.\n" +
                "\n" +
                "LDR ????????a duyarl?? diren??tir.Ortam ??????????na g??re diren?? de??eri de??i??ir. Biz karanl??k ortamde ledin yanmas??n??, ayd??nl??k ortamda ise s??nmesini istiyoruz.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-3 adet 330 ohm diren??\n" +
                "-RGB led\n" +
                "-10k potansiyometre\n" +
                "-jumper kablo\n" +
                "\n" +
                "RGB ledler sayesinde istedi??imiz b??t??n renkleri elde edebiliyoruz.\n" +
                "RGB(k??rm??z??,ye??il,mavi) k??saltmas??d??r.\n" +
                "RGB ledlerin bacak ba??lant??lar?? farkl?? olabilmekte.\n" +
                "\n" +
                "Bu devrede ortak anotlu RGB kullan??yoruz.\n" +
                "RGB ile proje yaparken bacaklar??n?? arduino nun PWM ??zellikli pinlerine ba??lamam??z gerekiyor(3,5,6,9,10,11)")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-NTC S??cakl??k Sens??r??\n" +
                "-Led\n" +
                "-330 ohm diren??\n" +
                "-10K ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "NTC ??s??ya duyarl?? diren??tir.Ortam ??s??s?? artt??k??a i?? direnci d????er.\n" +
                "Bu devrede NTC den gelen analog sinyali alarak matematiksel i??lemlerden ge??irip ortam s??cakl??????n?? bulaca????z.\n" +
                "\n" +
                "Burada matematiksel i??lemlerin i??eri??ini bilmek ??nemli de??il. ??nemli olan NTC den gelen sinyali s??cakl????a d??n????t??r??p kullamnabilmektir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Buzzer\n" +
                "-330 ohm diren??\n" +
                "-HC-SR04 Ultrasonik Mesafe Sens??r??\n" +
                "-Jumper Kablo\n" +
                "\n" +
                "HC-SR04 mesafe sens??r??, ??nce ultrasonik bir dalga g??nderir, sonra da bu dalgan??n yans??mas??n?? dinler. Arada ge??en s??reyi de form??le ederek mesafeyi bulmam??z?? sa??lar.\n" +
                "\n" +
                "Devremiz a??a????daki gibidir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-DC Motor\n" +
                "-330 ohm diren??\n" +
                "-L298N motor s??r??c??s??\n" +
                "-Ses sens??r kart??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada ses sens??r??nden okunan de??ere g??re motorun hareketi sa??lanacakt??r.\n" +
                "\n" +
                "Ses sens??r kartlar?? ses seviyesi ayarlanan seviyenin ??zerine ula????nca 5v ????k???? veren bir kartt??r. Ses seviyesinin s??n??r??n?? belirlemek i??in ??zerinde trimpot bulunur.\n" +
                "\n" +
                "DC motorlar ??al??????rken y??ksek ak??m ??ekerler\n" +
                "Bu sebeple Arduino pinlerine direk ba??lanamazlar. Arduino ile motor aras??nda motor s??r??c??ler kullan??l??r.L298N s????c??s??n?? bu sebeple kullanaca????z.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Servo motor\n" +
                "-Joystick\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Joystick, ??zerindeki kolu sa??a sola ya da yukar?? a??a???? hareket ettirerek analog sinyal almam??z?? sa??lar.\n" +
                "\n" +
                "Servo motorlar, data pininden ald?????? sinyale g??re a????sal olarak hareket eden motorlard??r.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-RGB led\n" +
                "-IR kumanda ve mod??l??\n" +
                "-3 adet 330 ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada IR kumandas??ndan gelen k??z??l??tesi sinyallere g??re RGB ledin istenilen renkte yanmas?? sa??lanacakt??r.\n" +
                "1'e bas??nca k??rm??z??\n" +
                "2'ye yas??nca ye??il\n" +
                "3'e bas??nca mavi\n" +
                "4'e bas??nca beyaz ??????k yanacakt??r.\n" +
                "0'a bas??nca led s??necektir.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-16x2 LCD\n" +
                "-HC-SR04 Ultrasonik Sens??r\n" +
                "-10K potansiyometre\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Ultrasonik sens??r ile mesafemizi ??l??erek LCD ekran ??zerinde bu mesafeyi yazd??raca????z.\n" +
                "\n" +
                "LCD mizde 2 sat??r ve her sat??rda 16 karakter vard??r.\n" +
                "\n" +
                "Potansiyometre ile LCD nin kontras ayar??n?? yapaca????z.\n" +
                "\n" +
                "Devremiz a??a????daki gibidir;")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Servo motor\n" +
                "-PIR sens??r??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "PIR sens??r?? ortamdaki k??z??l??tesi hareketleri alg??layarak sinyal g??nderen bir sens??rd??r.\n" +
                "\n" +
                "Servo motor verilen a????sal de??ere g??re hareket eden motorlard??r.\n" +
                "\n" +
                "Bu uygulamada PIR sens??r?? hareket al????lad?????? zaman servo motorun ??al????mas?? sa??lanacakt??r.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-HC06 Bluetooth Mod??l??\n" +
                "-RGB led\n" +
                "-3 adet 330 ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Bu uygulamada telefon ??zerinden bluetooth yoluyla RGB ledlerin rengini kontrol edece??iz.\n" +
                "Devremiz a??a????daki gibidir;")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Topram nem sens??r??\n" +
                "-Buzzer\n" +
                "-330 ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Toprak nem sens??r?? topra??a yerle??tirilerek topra????n nemini ??l??en bir sens??rd??r.Sens??r??n ??zerindeki potansiyometreyiayarlayarak sens??r??n hangi de??erde ????k???? verece??ini belirleyebiliyoruz.??stersek analog ????k??????n?? kullanarak kendimiz kod ??zerinde de bunu yapabiliriz.\n" +
                "Bu uygulamada sens??r??n dijital ????k??????n?? kullanarak potansiyometre ile ayarlamas??n?? yapaca????z.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Ya??mur sens??r??\n" +
                "-Buzzer\n" +
                "-330 ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Ya??mur sens??r?? ??zerine ya??mur de??di??i anda ya??murun seviyesine g??re analog sinyal ??reten bir sens??rd??r.\n" +
                "\n" +
                "Bu uygulamada ya??mur ya??maya ba??lad??????nda buzzer ??n ??tece??i bir devre yapaca????z.")
        dersDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-Gaz sens??r??\n" +
                "-Buzzer\n" +
                "-330 ohm diren??\n" +
                "-Jumper kablo\n" +
                "\n" +
                "Gaz sens??r?? ortamdaki gaz?? ??l??erek,analog sinyal g??nderen bir sens??rd??r.istenirse sens??r ??zerindeki potansiyometre ile istenen s??n??r de??er ayarlanarak dijital olarak ta ????k???? verebilir.\n" +
                "\n" +
                "Bu uygulamada ortamda gaz alg??land?????? zaman buzzer ??tecek, ortamda gaz yoksa buzzer susacakt??r.")

    }
}