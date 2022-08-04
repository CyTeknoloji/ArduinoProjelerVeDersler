package com.caneryildirim.arduinoprojelervedersler.Adaptors

import com.google.android.gms.ads.interstitial.InterstitialAd

object Singleton {
    lateinit var dersDetaybaslik:String
    lateinit var dersDetayText1:String
    lateinit var dersDetayText2:String
    lateinit var dersDetayText3:String
    lateinit var image1DD:List<Int>
    lateinit var image2DD:List<Int>
    lateinit var dersKod:String

    lateinit var ekstraDetayText1:String
    lateinit var ekstraDetayText2:String
    lateinit var ekstraDetayText3:String
    lateinit var imageED1:List<Int>
    lateinit var imageED2:List<Int>

    lateinit var projeDetayText1:String
    lateinit var projeDetayText2:String
    lateinit var image1PD:List<Int>
    lateinit var image2PD:List<Int>
    lateinit var projeKod:String

    var mInterstitialAd: InterstitialAd?=null


}