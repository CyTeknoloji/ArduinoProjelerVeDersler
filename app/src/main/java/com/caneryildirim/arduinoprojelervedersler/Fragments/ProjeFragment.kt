package com.caneryildirim.arduinoprojelervedersler.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.caneryildirim.arduinoprojelervedersler.Activity.ProjeDetayActivity
import com.caneryildirim.arduinoprojelervedersler.Adaptors.ProjeViewAdapter
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image1PD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image2PD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.mInterstitialAd
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeKod
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.FragmentProjeBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback




class ProjeFragment : Fragment(),ProjeViewAdapter.Listener{
    private var _binding: FragmentProjeBinding? = null
    private val binding get() = _binding!!

    var projeNoList=ArrayList<String>()
    var imageProjeList=ArrayList<Int>()
    var projeKonuList=ArrayList<String>()
    var projeDetayImageList1=ArrayList<List<Int>>()
    var projeDetayImageList2=ArrayList<List<Int>>()
    var projeDetayTextList1=ArrayList<String>()
    var projeDetayTextList2=ArrayList<String>()
    var projeKodList=ArrayList<String>()





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProjeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Listeler()

        val layoutManagerProje= LinearLayoutManager(this.context)
        binding.recyclerViewProje.layoutManager=layoutManagerProje

        val recycleViewProjeAdapter=ProjeViewAdapter(this,imageProjeList,projeNoList,projeKonuList)
        binding.recyclerViewProje.adapter=recycleViewProjeAdapter

    }

    override fun onItemClick(position: Int) {


        val intent= Intent(this.context, ProjeDetayActivity::class.java)
        intent.putExtra("toolbar",projeNoList[position])
        intent.putExtra("position",position)
        projeDetayText1=projeDetayTextList1[position]
        projeDetayText2=projeDetayTextList2[position]


        image1PD=projeDetayImageList1[position]
        image2PD=projeDetayImageList2[position]

        projeKod= projeKodList[position]


        startActivity(intent)


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun Listeler(){
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje1.ino?alt=media&token=e7ae87ec-e253-47ac-ac8a-88f84cb93db9")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje2.ino?alt=media&token=ea3c66a4-4b6f-43d0-b7d8-d76ba197fdc7")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2F3-Dijital%20Saat.rar?alt=media&token=53d1234b-26a7-43b0-b0c3-ca1f4877974c")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje4.ino?alt=media&token=1ed39b43-af75-4768-bd24-5d99543b434c")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje5.ino?alt=media&token=51b18b41-8dfe-470c-ac81-321b78ef019d")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje6.ino?alt=media&token=9d0331b5-e85b-4db1-923b-0e06ef24a703")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje7.rar?alt=media&token=91107d1f-16d3-428d-b504-bc61c6ca10a9")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje8.ino?alt=media&token=7c59fdb3-a8db-4e49-b831-e151deceff74")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje9.rar?alt=media&token=ae1abed2-3b03-42e5-8a90-402df5edbeb9")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje10.rar?alt=media&token=1d5ffbab-a8b3-4e11-b780-b0f53cbeff45")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje11.ino?alt=media&token=fc85596e-8dc1-44b5-84f3-fbd513162779")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje12.rar?alt=media&token=25dfc019-d54d-4ea3-bee4-2e4ba5028d20")
        projeKodList.add("https://firebasestorage.googleapis.com/v0/b/arduino-projeler-ve-dersler.appspot.com/o/ProjelerKod%2Fproje13.rar?alt=media&token=b7ce5fae-29de-4fe5-b642-0f29237967b8")


        projeNoList.add("Engelden Ka??an Robot")
        projeNoList.add("??izgi ??zleyen Robot")
        projeNoList.add("Dijital Saat")
        projeNoList.add("RFID ??le ??ifreli Kap?? Kilidi")
        projeNoList.add("TFT Ekran ??le Paint")
        projeNoList.add("Bluetooth Kontroll?? Ara??")
        projeNoList.add("Labirent Oyunu")
        projeNoList.add("Nab??z ??l??er")
        projeNoList.add("Otto Robot")
        projeNoList.add("Renk Ay??r??c??")
        projeNoList.add("Sumo Robot")
        projeNoList.add("Ate?? ??l??er")
        projeNoList.add("Hesap Makinesi")


        projeKonuList.add("HC-SR04 mesafe sens??r??")
        projeKonuList.add("K??z??l??tesi sens??r")
        projeKonuList.add("RTC mod??l??")
        projeKonuList.add("RFID mod??l??")
        projeKonuList.add("TFT ekran mod??l??")
        projeKonuList.add("HC06 mod??l??")
        projeKonuList.add("Servo, HC06")
        projeKonuList.add("Pulse nab??z ??l??er")
        projeKonuList.add("Servo")
        projeKonuList.add("RGB renk alg??lama sens??r??")
        projeKonuList.add("Sumo kiti ile")
        projeKonuList.add("GY 906")
        projeKonuList.add("TFT ekran ")

        imageProjeList.add(R.drawable.proje2)
        imageProjeList.add(R.drawable.proje3)
        imageProjeList.add(R.drawable.proje4)
        imageProjeList.add(R.drawable.proje6)
        imageProjeList.add(R.drawable.proje10)
        imageProjeList.add(R.drawable.proje12)
        imageProjeList.add(R.drawable.labirent)
        imageProjeList.add(R.drawable.proje15)
        imageProjeList.add(R.drawable.proje16)
        imageProjeList.add(R.drawable.proje19)
        imageProjeList.add(R.drawable.proje20)
        imageProjeList.add(R.drawable.proje22)
        imageProjeList.add(R.drawable.proje13)



        var proje1ImageList1= listOf<Int>(R.drawable.proje1a1,R.drawable.proje1a2)
        projeDetayImageList1.add(proje1ImageList1)

        var proje2ImageList1= listOf<Int>(R.drawable.proje2a1,R.drawable.proje2a2)
        projeDetayImageList1.add(proje2ImageList1)

        var proje3ImageList1= listOf<Int>(R.drawable.proje3a1)
        projeDetayImageList1.add(proje3ImageList1)

        var proje4ImageList1= listOf<Int>(R.drawable.proje4a1,R.drawable.proje4a2)
        projeDetayImageList1.add(proje4ImageList1)

        var proje5ImageList1= listOf<Int>(R.drawable.proje5a1,R.drawable.proje5a2)
        projeDetayImageList1.add(proje5ImageList1)

        var proje6ImageList1=listOf<Int>(R.drawable.proje6a1)
        projeDetayImageList1.add(proje6ImageList1)

        var proje7ImageList1= listOf<Int>(R.drawable.proje7a1,R.drawable.proje7a2)
        projeDetayImageList1.add(proje7ImageList1)

        var proje8ImageList1= listOf<Int>(R.drawable.proje8a1,R.drawable.proje8a2)
        projeDetayImageList1.add(proje8ImageList1)

        var proje9ImageList1=listOf<Int>(R.drawable.proje9a1,R.drawable.proje9a2)
        projeDetayImageList1.add(proje9ImageList1)

        var proje10ImageList1=listOf<Int>(R.drawable.proje10a1)
        projeDetayImageList1.add(proje10ImageList1)

        var proje11ImageList1= listOf<Int>(R.drawable.proje11a1,R.drawable.proje11a2)
        projeDetayImageList1.add(proje11ImageList1)

        var proje12ImageList1= listOf<Int>(R.drawable.proje12a1)
        projeDetayImageList1.add(proje12ImageList1)

        var proje13ImageList1= listOf<Int>(R.drawable.proje13a1)
        projeDetayImageList1.add(proje13ImageList1)


        projeDetayTextList1.add("-Arduino Uno\n" +
                "-2 Motorlu Robot ??asesi\n" +
                "-L298N Motor S??r??c??\n" +
                "-HC-SR04 Ultrasonik Sens??r\n" +
                "-6 Adet Kalem Pil\n" +
                "-6'lu AA Pil Yuvas??\n" +
                "-Jumper Kablo")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-2 Motorlu Robot ??asesi\n" +
                "-L298N Motor S??r??c??s??\n" +
                "-3 Adet ??izgi ??zleyen Sens??r Mod??l??\n" +
                "-6 adet kalem pil\n" +
                "-6 l?? AA Pil Yuvas??\n" +
                "\n")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-DS1302 RTC Mod??l\n" +
                "-2x16 LCD Ekran i2c mod??ll??\n" +
                "-10K pot")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-Breadboard\n" +
                "-RC522 RFID NFC Kiti\n" +
                "-Servo Motor")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-TFT Ekran")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-4 Motorlu Robot G??vdesi\n" +
                "-L298N Motor S??r??c??\n" +
                "-HC06 Bluetooth Mod??l??\n" +
                "-6 Adet Kalem pil\n" +
                "-6 L?? Pil Yuvas??")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-2 adet SG90 Servo motor\n" +
                "-HCSR06 Bluetooth Mod??l??\n" +
                "-Labirent 3b Yaz??c?? par??alar??\n" +
                "\n" +
                "Kodu indir butonuna basarak kodlarla beraber 3b yaz??c?? dosyalar??na da ula??abilirsiniz.")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-Pulse Sens??r??\n" +
                "-2x16 LCD Ekran\n" +
                "-10K Pot\n" +
                "-220 ohm diren??\n" +
                "-Led\n")
        projeDetayTextList1.add("-Arduino Nano\n" +
                "-Arduino Nano Protoshield\n" +
                "-HCSR-04 Sens??r\n" +
                "-4 Adet SG90 Servo Motor\n" +
                "-5V Buzzer\n" +
                "-2 Adet AA pil\n" +
                "-2 li AA Pil Yuvas??\n" +
                "-3D yaz??c?? par??alar??\n" +
                "\n" +
                "Robotun 3b yaz??c?? dosyalar??na kodlar?? indir butonuna basarak ula??abilirsiniz.\n")
        projeDetayTextList1.add("-Arduino Nano\n" +
                "-TCS34725 RGB Renk Alg??lama Sens??r??\n" +
                "-2 Adet Sg90 Servo\n" +
                "-3b Yaz??c?? Par??alar??\n" +
                "\n" +
                "3b yaz??c?? dosyalar??na kodlar?? indir butonuna basarak ula??abilirsiniz.\n" +
                "\n" +
                "Projede kullan??lan renkler a??a????daki gibidir;\n" +
                "-K??rm??z??\n" +
                "-Pik Ye??il\n" +
                "-Sar??\n" +
                "-A????k Mavi\n" +
                "-Turuncu\n" +
                "-Pembe\n")
        projeDetayTextList1.add("-Arduino Nano\n" +
                "-Sumo Robot G??vdesi ve K??za????\n" +
                "-2 Adet 6V 500RPM Red??kt??rl?? DC Motor\n" +
                "-L9110 Motor S??r??c??\n" +
                "-2 li QTR-1A K??z??l??tesi Sens??r\n" +
                "-2 Adet GP2Y0D815F K??z??l??tesi Sens??r\n" +
                "-6 Adet AA pil\n" +
                "-6 l?? AA Pil Yuvas??\n" +
                "-Anahtar")
        projeDetayTextList1.add("-Arduino Nano\n" +
                "-12x12mm Tact Switch\n" +
                "-5K Ohm Diren??\n" +
                "-200 Ohm Diren??\n" +
                "-5V Lazer\n" +
                "-On/Off Switch\n" +
                "-Oled Ekran 0.96\n" +
                "-GY-906 S??cakl??k Serns??r??\n" +
                "-9V Pil\n" +
                "-3B Yaz??c?? Par??alar??")
        projeDetayTextList1.add("-Arduino Uno\n" +
                "-TFT LCD Shield")




        var proje1ImageList2= listOf<Int>(R.drawable.proje1b1,R.drawable.proje1b2,R.drawable.proje1b3,R.drawable.proje1b4,R.drawable.proje1b5,R.drawable.proje1b6,R.drawable.proje1b7)
        projeDetayImageList2.add(proje1ImageList2)

        var proje2ImageList2= listOf<Int>(R.drawable.proje2b1,R.drawable.proje2b2,R.drawable.proje2b3,R.drawable.proje2b4,R.drawable.proje2b5,R.drawable.proje2b6,R.drawable.proje2b7)
        projeDetayImageList2.add(proje2ImageList2)

        var proje3ImageList2= listOf<Int>(R.drawable.proje3b1,R.drawable.proje3b2,R.drawable.proje3b3,R.drawable.proje3b4,R.drawable.proje3b5,R.drawable.proje3b6)
        projeDetayImageList2.add(proje3ImageList2)

        var proje4ImageList2= listOf<Int>(R.drawable.proje4b1,R.drawable.proje4b2,R.drawable.proje4b3,R.drawable.proje4b4,R.drawable.proje4b5,R.drawable.proje4b6)
        projeDetayImageList2.add(proje4ImageList2)

        var proje5ImageList2= listOf<Int>(R.drawable.proje5b1,R.drawable.proje5b2)
        projeDetayImageList2.add(proje5ImageList2)

        var proje6ImageList2= listOf<Int>(R.drawable.proje6b1,R.drawable.proje6b2,R.drawable.proje6b3,R.drawable.proje6b4,R.drawable.proje6b5,R.drawable.proje6b6,R.drawable.proje6b7)
        projeDetayImageList2.add(proje6ImageList2)

        var proje7ImageList2= listOf<Int>(R.drawable.proje7b1,R.drawable.proje7b2,R.drawable.proje7b3,R.drawable.proje7b4,R.drawable.proje7b5)
        projeDetayImageList2.add(proje7ImageList2)

        var proje8ImageList2= listOf<Int>(R.drawable.proje8b1,R.drawable.proje8b2,R.drawable.proje8b3,R.drawable.proje8b4,R.drawable.proje8b5,
            R.drawable.proje8b6,R.drawable.proje8b7,R.drawable.proje8b8,R.drawable.proje8b9,R.drawable.proje8b10)
        projeDetayImageList2.add(proje8ImageList2)

        var proje9ImageList2= listOf<Int>(R.drawable.proje9b1,R.drawable.proje9b2,R.drawable.proje9b3,R.drawable.proje9b4,R.drawable.proje9b5,R.drawable.proje9b6,
            R.drawable.proje9b7,R.drawable.proje9b8,R.drawable.proje9b9)
        projeDetayImageList2.add(proje9ImageList2)

        var proje10ImageList2= listOf<Int>(R.drawable.proje10b1,R.drawable.proje10b2,R.drawable.proje10b3,R.drawable.proje10b4,R.drawable.proje10b5,R.drawable.proje10b6)
        projeDetayImageList2.add(proje10ImageList2)

        var proje11ImageList2= listOf<Int>(R.drawable.proje11b1,R.drawable.proje11b2,R.drawable.proje11b3,R.drawable.proje11b4,R.drawable.proje11b5,
            R.drawable.proje11b6,R.drawable.proje11b7,R.drawable.proje11b8,R.drawable.proje11b9,R.drawable.proje11b10)
        projeDetayImageList2.add(proje11ImageList2)

        var proje12ImageList2= listOf<Int>(R.drawable.proje12b1,R.drawable.proje12b2,R.drawable.proje12b3,R.drawable.proje12b4,R.drawable.proje12b5,
            R.drawable.proje12b6,R.drawable.proje12b7,R.drawable.proje12b8,R.drawable.proje12b9,R.drawable.proje12b10)
        projeDetayImageList2.add(proje12ImageList2)

        var proje13ImageList2= listOf<Int>(R.drawable.proje13b1)
        projeDetayImageList2.add(proje13ImageList2)


        projeDetayTextList2.add("Projede Mesafe sens??r??nden gelen bilgiye g??re robot kar????s??nda bir engel ald??lad??????nda y??n de??i??tirerek engelden kurtulmaya ??al????acakt??r.\n" +
                "\n" +
                "Projenin kodlar?? a??a????dad??r;\n" +
                "\n" +
                "#define echoPin 12\n" +
                "#define trigPin 13\n" +
                "#define MotorR1 7\n" +
                "#define MotorR2 6\n" +
                "#define MotorRE 9\n" +
                "#define MotorL1 5\n" +
                "#define MotorL2 4\n" +
                "#define MotorLE 3\n" +
                "long sure, uzaklik;\n" +
                "void setup() {\n" +
                "\n" +
                "  pinMode(echoPin, INPUT);\n" +
                "  pinMode(trigPin, OUTPUT);\n" +
                "  pinMode(MotorL1, OUTPUT);\n" +
                "  pinMode(MotorL2, OUTPUT);\n" +
                "  pinMode(MotorLE, OUTPUT);\n" +
                "  pinMode(MotorR1, OUTPUT);\n" +
                "  pinMode(MotorR2, OUTPUT);\n" +
                "  pinMode(MotorRE, OUTPUT);\n" +
                "  Serial.begin(9600);\n" +
                "}\n" +
                "void loop() {\n" +
                "  digitalWrite(trigPin, LOW);\n" +
                "  delayMicroseconds(5);\n" +
                "  digitalWrite(trigPin, HIGH);\n" +
                "  delayMicroseconds(10);\n" +
                "  digitalWrite(trigPin, LOW);\n" +
                "  sure = pulseIn(echoPin, HIGH);\n" +
                "  uzaklik = sure / 29.1 / 2;\n" +
                "  Serial.println(uzaklik);\n" +
                "  if (uzaklik < 15)\n" +
                "  {\n" +
                "    geri();\n" +
                "    delay(150);\n" +
                "    sag();\n" +
                "    delay(250);\n" +
                "  }\n" +
                "  else {\n" +
                "    ileri();\n" +
                "  }\n" +
                "}\n" +
                "void ileri(){\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  analogWrite(MotorRE, 150);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  analogWrite(MotorLE, 150);\n" +
                " \n" +
                " \n" +
                "}\n" +
                "void sag(){\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  analogWrite(MotorRE, 0);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  analogWrite(MotorLE, 150);\n" +
                "  \n" +
                "  \n" +
                "}\n" +
                "void geri(){\n" +
                "  digitalWrite(MotorR1, LOW);\n" +
                "  digitalWrite(MotorR2, HIGH);\n" +
                "  analogWrite(MotorRE, 150);\n" +
                "  digitalWrite(MotorL1, LOW);\n" +
                "  digitalWrite(MotorL2, HIGH);\n" +
                "  analogWrite(MotorLE, 150);\n" +
                "  \n" +
                "}")
        projeDetayTextList2.add("Projenin kodlar?? a??a????dad??r;\n" +
                "\n" +
                "-------------------------------------\n" +
                "#define SensorSol 10\n" +
                "#define SensorOrta 11\n" +
                "#define SensorSag 12\n" +
                "#define MotorR1 6\n" +
                "#define MotorR2 7 \n" +
                "#define MotorRE 9\n" +
                "#define MotorL1 5\n" +
                "#define MotorL2 4\n" +
                "#define MotorLE 3\n" +
                "void setup() {\n" +
                "  pinMode(SensorSol, INPUT);\n" +
                "  pinMode(SensorOrta, INPUT);\n" +
                "  pinMode(SensorSag, INPUT);\n" +
                "  pinMode(MotorR1, OUTPUT);\n" +
                "  pinMode(MotorR2, OUTPUT);\n" +
                "  pinMode(MotorL1, OUTPUT);\n" +
                "  pinMode(MotorL2, OUTPUT);\n" +
                "}\n" +
                "void loop() {\n" +
                "  if (digitalRead(SensorSol) \n" +
                "  == 0 && digitalRead(SensorOrta)\n" +
                "  == 1 && digitalRead(SensorSag) == 0)\n" +
                "  {\n" +
                "    ileri();\n" +
                "  }\n" +
                "  if (digitalRead(SensorSol)\n" +
                "  == 0 && digitalRead(SensorOrta)\n" +
                "  == 0 && digitalRead(SensorSag) == 1)\n" +
                "  {\n" +
                "    sag();\n" +
                "  }\n" +
                "  if (digitalRead(SensorSol)\n" +
                "  == 1 && digitalRead(SensorOrta)\n" +
                "  == 0 && digitalRead(SensorSag) == 0)\n" +
                "  {\n" +
                "    sol();\n" +
                "  }\n" +
                "}\n" +
                "void ileri() {\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  analogWrite(MotorRE, 150);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  analogWrite(MotorLE, 150);\n" +
                "}\n" +
                "void sag() {\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  analogWrite(MotorRE, 0);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  analogWrite(MotorLE, 150);\n" +
                "}\n" +
                "void sol() {\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  analogWrite(MotorRE, 150);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  analogWrite(MotorLE, 0);\n" +
                "}\n" +
                "void dur() {\n" +
                "  digitalWrite(MotorR1, HIGH);\n" +
                "  digitalWrite(MotorR2, LOW);\n" +
                "  digitalWrite(MotorRE, LOW);\n" +
                "  digitalWrite(MotorL1, HIGH);\n" +
                "  digitalWrite(MotorL2, LOW);\n" +
                "  digitalWrite(MotorLE, LOW);\n" +
                "}\n" +
                "\n" +
                "--------------------------------------")
        projeDetayTextList2.add("Projenin ??al????mas?? i??in DS1302 isimli k??t??phanenin arduino program??na kurulmas?? gerekmektedir. Kodu indir butonuna basarak hem kodu hem de k??t??phaneyi indirebilirsiniz.\n" +
                "\n" +
                "Projenin kodlar?? a??a????dad??r;\n" +
                "\n" +
                "---------------------------------------\n" +
                "#include <DS1302.h>\n" +
                "#include <Wire.h>\n" +
                "#include <LiquidCrystal_I2C.h>\n" +
                "\n" +
                "\n" +
                "DS1302 rtc(2, 3, 4);\n" +
                "\n" +
                "\n" +
                "LiquidCrystal_I2C lcd(0x27, 16, 2); \n" +
                "\n" +
                "void setup()\n" +
                "{\n" +
                "  \n" +
                "  rtc.halt(false);\n" +
                "  rtc.writeProtect(false);\n" +
                "\n" +
                "  \n" +
                "  Serial.begin(9600);\n" +
                "\n" +
                " \n" +
                "  lcd.init();\n" +
                "  lcd.backlight();\n" +
                "\n" +
                " //G??ncel G??n Saat ve tarihi buradan kendinize g??re ayarlayabilirsiniz\n" +
                "\n" +
                "  rtc.setDOW(SUNDAY);       \n" +
                "  rtc.setTime(11, 32, 0);     \n" +
                "  rtc.setDate(12, 2, 2017);   \n" +
                "}\n" +
                "\n" +
                "void loop()\n" +
                "{\n" +
                "  \n" +
                "  Serial.print(rtc.getDOWStr());\n" +
                "  Serial.print(\" \");\n" +
                "\n" +
                " \n" +
                "  Serial.print(rtc.getDateStr());\n" +
                "  Serial.print(\" -- \");\n" +
                "\n" +
                " \n" +
                "  Serial.println(rtc.getTimeStr());\n" +
                "\n" +
                " \n" +
                "  lcd.clear();\n" +
                "  data (); \n" +
                "  ora (); \n" +
                "\n" +
                "\n" +
                "  delay (1000);\n" +
                "}\n" +
                "\n" +
                "void data ()\n" +
                "{\n" +
                "  lcd.setCursor(0, 0);\n" +
                "  lcd.print(rtc.getDOWStr());\n" +
                "  lcd.print(\" \");\n" +
                "  lcd.print(rtc.getDateStr());\n" +
                "}\n" +
                "\n" +
                "void ora()\n" +
                "{\n" +
                "  lcd.setCursor(0, 1);\n" +
                "  lcd.print(rtc.getTimeStr());\n" +
                "}\n" +
                "--------------------------------------")
        projeDetayTextList2.add("Projenin ??al????abilmesi i??in RFID k??t??phanesinin y??klenmesi gerekmektedir.\n" +
                "\n" +
                "Arduino program??nda Ara??lar-> K??t??phaneleri Y??net sekmesine girilerek arama k??sm??na mfrc522 yaz??p ayn?? isimli k??t??phane y??klenerek k??t??phane indirilir.\n" +
                "\n" +
                "Projeye ait kodlar a??a????dad??r;\n" +
                "\n" +
                "-------------------------------------\n" +
                "#include <spi.h>\n" +
                "#include <mfrc522.h>\n" +
                "#include <servo.h>\n" +
                "int RST_PIN = 9;\n" +
                "int SS_PIN = 10;\n" +
                "int servoPin = 8;\n" +
                "Servo motor;\n" +
                "MFRC522 rfid(SS_PIN, RST_PIN);\n" +
                "byte ID[4] = {\n" +
                "  97,\n" +
                "  76,\n" +
                "  67,\n" +
                "  9\n" +
                "};\n" +
                "void setup() {\n" +
                "  motor.attach(servoPin);\n" +
                "  Serial.begin(9600);\n" +
                "  SPI.begin();\n" +
                "  rfid.PCD_Init();\n" +
                "}\n" +
                "void loop() {\n" +
                "  if (!rfid.PICC_IsNewCardPresent())\n" +
                "    return;\n" +
                "  if (!rfid.PICC_ReadCardSerial())\n" +
                "    return;\n" +
                "  if (rfid.uid.uidByte[0] == ID[0] &&\n" +
                "    rfid.uid.uidByte[1] == ID[1] &&\n" +
                "    rfid.uid.uidByte[2] == ID[2] &&\n" +
                "    rfid.uid.uidByte[3] == ID[3]) {\n" +
                "    Serial.println(\"Kapi acildi\");\n" +
                "    ekranaYazdir();\n" +
                "    motor.write(180);\n" +
                "    delay(3000);\n" +
                "    motor.write(0);\n" +
                "    delay(1000);\n" +
                "  } else {\n" +
                "    Serial.println(\"Yetkisiz Kart\");\n" +
                "    ekranaYazdir();\n" +
                "  }\n" +
                "  rfid.PICC_HaltA();\n" +
                "}\n" +
                "void ekranaYazdir() {\n" +
                "  Serial.print(\"ID Numarasi: \");\n" +
                "  for (int sayac = 0;sayac< 4;sayac++){\n" +
                "    Serial.print(\n" +
                "    rfid.uid.uidByte[sayac]);\n" +
                "    Serial.print(\" \");\n" +
                "  }\n" +
                "  Serial.println(\"\");\n" +
                "}\n" +
                "-------------------------------------")
        projeDetayTextList2.add("Projenin kodlar?? haz??r olarak AdafruitTFTLCD k??t??phanesinde bulundu??u i??in burada tekrar yaz??lmam????t??r.\n")
        projeDetayTextList2.add("Bluetooth mod??l??n??n uygulama ile nas??l ??al????t??????na dersler b??l??m??nde yer verildi??i i??in bu k??s??mda sadece kodlar payla????lacakt??r;\n" +
                "\n" +
                "--------------------------------------\n" +
                " \n" +
                "  const int motorA1  = 5;\n" +
                "  const int motorA2  = 7;\n" +
                "  const int motorB1  = 6;\n" +
                "  const int motorB2  = 4;\n" +
                "  int i=0; \n" +
                "  int j=0;\n" +
                "  int state;\n" +
                "  int vSpeed=255;\n" +
                "void setup() {\n" +
                "    \n" +
                "    pinMode(motorA1, OUTPUT);\n" +
                "    pinMode(motorA2, OUTPUT);\n" +
                "    pinMode(motorB1, OUTPUT);\n" +
                "    pinMode(motorB2, OUTPUT);    \n" +
                "   \n" +
                "    Serial.begin(9600);\n" +
                "}\n" +
                " \n" +
                "void loop() {\n" +
                "\n" +
                "    if(Serial.available() > 0){     \n" +
                "      state = Serial.read();   \n" +
                "    }\n" +
                "  \n" +
                "  \n" +
                "    if (state == '0'){\n" +
                "      vSpeed=0;}\n" +
                "    else if (state == '1'){\n" +
                "      vSpeed=100;}\n" +
                "    else if (state == '2'){\n" +
                "      vSpeed=180;}\n" +
                "    else if (state == '3'){\n" +
                "      vSpeed=200;}\n" +
                "    else if (state == '4'){\n" +
                "      vSpeed=255;}\n" +
                "     \n" +
                " \n" +
                "  //Gelen veri 'F' ise \n" +
                "  //araba ileri gider.\n" +
                "    if (state == 'F') {\n" +
                "      analogWrite(motorA1, vSpeed);\n" +
                "      analogWrite(motorA2, 0);\n" +
                "      analogWrite(motorB1, vSpeed);  \n" +
                "      analogWrite(motorB2, 0);\n" +
                "    }\n" +
                " \n" +
                "  //Gelen veri 'A' ise \n" +
                "  //araba ileri sol(??apraz) gider.\n" +
                "    else if (state == 'A') {\n" +
                "      analogWrite(motorA1,vSpeed );\n" +
                "      analogWrite(motorA2, 0);  \n" +
                "      analogWrite(motorB1, 100);\n" +
                "      analogWrite(motorB2, 0); \n" +
                "    }\n" +
                "  \n" +
                "  //Gelen veri 'B' ise \n" +
                "  //araba ileri sa??(??apraz) gider.\n" +
                "    else if (state == 'B') {\n" +
                "        analogWrite(motorA1, 100);\n" +
                "        analogWrite(motorA2, 0); \n" +
                "        analogWrite(motorB1, vSpeed);\n" +
                "        analogWrite(motorB2, 0); \n" +
                "    }\n" +
                "  \n" +
                "  //Gelen veri 'C' ise \n" +
                "  //araba geri gider.\n" +
                "    else if (state == 'C') {\n" +
                "      analogWrite(motorA1, 0);\n" +
                "      analogWrite(motorA2, vSpeed); \n" +
                "      analogWrite(motorB1, 0);\n" +
                "      analogWrite(motorB2, vSpeed); \n" +
                "    }\n" +
                "  \n" +
                "  //Gelen veri 'D' ise \n" +
                "  //araba geri sol(??apraz) gider\n" +
                "    else if (state == 'D') {\n" +
                "      analogWrite(motorA1, 0);\n" +
                "      analogWrite(motorA2, 100); \n" +
                "      analogWrite(motorB1, 0);\n" +
                "      analogWrite(motorB2, vSpeed); \n" +
                "    }\n" +
                "  \n" +
                "  //Gelen veri 'E' ise \n" +
                "  //araba geri sa??(??apraz) gider\n" +
                "    else if (state == 'E') {\n" +
                "      analogWrite(motorA1, 0);\n" +
                "      analogWrite(motorA2, vSpeed); \n" +
                "       analogWrite(motorB1, 0);\n" +
                "       analogWrite(motorB2, 100); \n" +
                "    }\n" +
                "  \n" +
                "  //Gelen veri 'F' ise \n" +
                "  //araba sola gider.\n" +
                "    else if (state == 'F') {\n" +
                "      analogWrite(motorA1, vSpeed);\n" +
                "      analogWrite(motorA2, 150); \n" +
                "      analogWrite(motorB1, 0);\n" +
                "      analogWrite(motorB2, 0); \n" +
                "    }\n" +
                "\n" +
                "  //Gelen veri 'G' ise \n" +
                "  //araba sa??a gider\n" +
                "    else if (state == 'G') {\n" +
                "      analogWrite(motorA1, 0);\n" +
                "      analogWrite(motorA2, 0); \n" +
                "      analogWrite(motorB1, vSpeed);\n" +
                "      analogWrite(motorB2, 150);     \n" +
                "    }\n" +
                "  \n" +
                "  \n" +
                "  //Gelen veri 'H' ise \n" +
                "  //arabay?? durdur.\n" +
                "    else if (state == 'H'){\n" +
                "        analogWrite(motorA1, 0);\n" +
                "        analogWrite(motorA2, 0); \n" +
                "        analogWrite(motorB1, 0);\n" +
                "        analogWrite(motorB2, 0);\n" +
                "    }  \n" +
                "}\n" +
                "-------------------------------------\n")
        projeDetayTextList2.add("Projeye ait VarSpeedServo isimli k??t??phaneyi ve labirentin ??al????mas?? i??in gerekli olan telefon uygulamas??n?? ayr??ca 3b yaz??c?? dosyalar?? ile proje kodlar??n?? a??a????daki kodlar?? indir butonuna basarak indirebilirsiniz.\n" +
                "\n" +
                "--------------------------------------\n" +
                " \n" +
                "const int pitchHm = 97;\n" +
                "const int rollHm = 90;\n" +
                "int pitch;\n" +
                "int roll;\n" +
                " \n" +
                "void setup()\n" +
                "{\n" +
                "\n" +
                "Serial.begin(9600);\n" +
                " \n" +
                "pitchServo.attach(10);\n" +
                "rollServo.attach(11);\n" +
                " \n" +
                "pitchServo.slowmove(pitchHm, svsp);\n" +
                "rollServo.slowmove(rollHm, svsp);\n" +
                "delay(200);\n" +
                " \n" +
                "}\n" +
                " \n" +
                "void loop()\n" +
                "{\n" +
                "\n" +
                "while (Serial.available() > 0) {\n" +
                "\n" +
                "pitch = Serial.parseInt();\n" +
                "\n" +
                "roll = Serial.parseInt();\n" +
                "if (Serial.read() == '\\n') break;\n" +
                "}\n" +
                "\n" +
                "pitch = constrain(pitch, -15, 15);\n" +
                "roll = constrain(roll, -15, 15);\n" +
                "\n" +
                "pitchServo.slowmove\n" +
                "(pitchHm - pitch, svsp);\n" +
                "rollServo.slowmove\n" +
                "(rollHm + roll, svsp);\n" +
                "delay(70); \n" +
                "}\n" +
                "-------------------------------------\n")
        projeDetayTextList2.add("Projeye ait PulseSensorPlayground isimli k??t??phane, Ara??lar-> K??t??phane y??neticisi ne girerek, arama k??sm??na yaz??l??p kurulmal??d??r.\n" +
                "\n" +
                "--------------------------------------\n" +
                " #include<LiquidCrystal.h>\n" +
                "\n" +
                "#define USE_ARDUINO_INTERRUPTS true\n" +
                "#include <PulseSensorPlayground.h>\n" +
                "\n" +
                "const int PulseWire = 0;\n" +
                "const int LED13 = 13;\n" +
                "int Threshold = 550;\n" +
                "                         \n" +
                "PulseSensorPlayground pulseSensor;  \n" +
                "\n" +
                "LiquidCrystal lcd (12, 11, 5, 4, 3, 2);\n" +
                "\n" +
                "void setup() {   \n" +
                "  Serial.begin(9600);\n" +
                "  lcd.begin(16,2);\n" +
                "  \n" +
                "  pulseSensor.analogInput(PulseWire); \n" +
                "  pulseSensor.blinkOnPulse(LED13);\n" +
                "  pulseSensor.setThreshold(Threshold);\n" +
                "\n" +
                "  if (pulseSensor.begin()) {    \n" +
                "    Serial.println(\n" +
                "   \"Sens??r basariyla ??alistirildi.\");      \n" +
                "    lcd.setCursor(0,0);\n" +
                "    lcd.print(\"NABIZ OLCULUYOR\");\n" +
                "  } \n" +
                "}\n" +
                "\n" +
                "void loop() { \n" +
                "  int nabiz = \n" +
                "  pulseSensor.getBeatsPerMinute(); \n" +
                "\n" +
                "  if (pulseSensor.sawStartOfBeat()) {     \n" +
                "    Serial.println(\n" +
                "    \"Nabiz tespit edildi! \"); \n" +
                "    Serial.print(\"NABIZ: \");\n" +
                "    Serial.println(nabiz);\n" +
                "    lcd.setCursor(0,2); \n" +
                "    lcd.setCursor(3,3); \n" +
                "    lcd.print(\" NABIZ: \");\n" +
                "    lcd.print(nabiz);\n" +
                "    lcd.clear();\n" +
                "  } \n" +
                "  delay(20);\n" +
                "}\n" +
                "\n" +
                "-------------------------------------\n")
        projeDetayTextList2.add("Otto program?? indirdikten sonra libraries k??sm??n?? arduino???nun i??indeki libraries k??sm??na kopyal??yoruz.\n" +
                "Sonra servo home program??n?? ??al????t??r??p servolar?? home konutuna al??yoruz ki montaj s??ras??nda yanl???? ba??lad?? ise hatam??z?? g??relim. Tam servo home da g??sterildi??i gibi duruyorsa ottonuz dans etmeye haz??r demektir.")

        projeDetayTextList2.add("RGB renk ay??rma sens??r??n??n k??t??phanesine 3 Boyutl?? yaz??c?? dosyalar??na ve proje kodlar??na kodlar?? indir butonuna basarak ula??abilirsiniz.")
        projeDetayTextList2.add("Projenin kodlar?? a??a????dad??r;\n" +
                "-------------------------------------\n" +
                "#define OnSensor 3\n" +
                "#define SolSensor 2\n" +
                "#define SagCizgi 4\n" +
                "#define SolCizgi 5\n" +
                "\n" +
                "#define MotorR1 7\n" +
                "#define MotorR2 6\n" +
                "#define MotorL1 9\n" +
                "#define MotorL2 8\n" +
                "\n" +
                "\n" +
                "void setup() {\n" +
                "\n" +
                "  pinMode(OnSensor, INPUT);\n" +
                "  pinMode(SolSensor, INPUT);\n" +
                "  pinMode(SagCizgi, INPUT);\n" +
                "  pinMode(SolCizgi, INPUT);\n" +
                "\n" +
                "  pinMode(MotorR1, OUTPUT);\n" +
                "  pinMode(MotorR2, OUTPUT);\n" +
                "  pinMode(MotorL1, OUTPUT);\n" +
                "  pinMode(MotorL2, OUTPUT);\n" +
                "  \n" +
                "  //Serial.begin(9600);\n" +
                "\n" +
                "  while(digitalRead(OnSensor) == 1);\n" +
                " \n" +
                "}\n" +
                "\n" +
                "void loop() {\n" +
                "\n" +
                " \n" +
                "  if(digitalRead(SagCizgi) == 0 && \n" +
                "  digitalRead(SolCizgi) == 0){\n" +
                "\n" +
                "    if(digitalRead(OnSensor) == 0 && \n" +
                "    digitalRead(SolSensor) == 1){\n" +
                "      ileri();\n" +
                "    }\n" +
                "    if(digitalRead(OnSensor) == 1 && \n" +
                "    digitalRead(SolSensor) == 0){\n" +
                "      sol();\n" +
                "    }\n" +
                "    if(digitalRead(OnSensor) == 1 && \n" +
                "    digitalRead(SolSensor) == 1){\n" +
                "      ileri();\n" +
                "    }\n" +
                "    \n" +
                "  }\n" +
                "  else{\n" +
                "\n" +
                "    geri();\n" +
                "    delay(1000);\n" +
                "    sol();\n" +
                "    delay(400);\n" +
                "    \n" +
                "  }\n" +
                "  \n" +
                "}\n" +
                "\n" +
                "void ileri(){\n" +
                "    digitalWrite(MotorR1, HIGH);\n" +
                "    digitalWrite(MotorR2, LOW);\n" +
                "\n" +
                "    digitalWrite(MotorL1, HIGH);\n" +
                "    digitalWrite(MotorL2, LOW);\n" +
                "  \n" +
                "}\n" +
                "\n" +
                "void geri(){\n" +
                "    digitalWrite(MotorR1, LOW);\n" +
                "    digitalWrite(MotorR2, HIGH);\n" +
                "\n" +
                "    digitalWrite(MotorL1, LOW);\n" +
                "    digitalWrite(MotorL2, HIGH);\n" +
                "  \n" +
                "}\n" +
                "\n" +
                "void sol(){\n" +
                "    digitalWrite(MotorR1, HIGH);\n" +
                "    digitalWrite(MotorR2, LOW);\n" +
                "\n" +
                "    digitalWrite(MotorL1, LOW);\n" +
                "    digitalWrite(MotorL2, HIGH);\n" +
                "  \n" +
                "}\n" +
                "\n" +
                "void sag(){\n" +
                "    digitalWrite(MotorR1, LOW);\n" +
                "    digitalWrite(MotorR2, HIGH);\n" +
                "\n" +
                "    digitalWrite(MotorL1, HIGH);\n" +
                "    digitalWrite(MotorL2, LOW);\n" +
                "  \n" +
                "}\n" +
                "-------------------------------------")
        projeDetayTextList2.add("Projeye ait 3d yaz??c?? par??alar??na kodlar?? indir butonundan ula??abilirsiniz.\n" +
                "\n" +
                "Projede Adafruits SSD1306 ve Adafruits MLX90614 isimli k??t??phaneler kullan??lm????t??r.\n" +
                "Kodlar?? indir butonundan indirebilir ya da Ara??lar> K??t??phaneleri Y??net sekmesine girince arama k??sm??na  k??t??phanelerin isimlerini yazarak indirebilirsiniz.\n" +
                "\n" +
                "Ayr??ca projeye ait arduino kodlar??na da kodlar?? indir butonundan ula??abilirsiniz.")
        projeDetayTextList2.add("Projeye ait SPFD5408 isimli k??t??phaneye ve arduino kodlar??na kodlar?? indir butonundan ula??abilirsiniz.")
    }

}