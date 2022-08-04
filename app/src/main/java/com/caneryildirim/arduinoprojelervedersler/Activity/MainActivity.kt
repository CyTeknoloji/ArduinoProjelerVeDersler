package com.caneryildirim.arduinoprojelervedersler.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.mInterstitialAd
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.ActivityMainBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adRequest:AdRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        MobileAds.initialize(this) {}
        adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-8642310051732821/8182391206", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                println(adError)
                Singleton.mInterstitialAd = null
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent=Intent(this@MainActivity,AnaActivity::class.java)
                    startActivity(intent)
                    finish()

                },1000)

            }
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Singleton.mInterstitialAd = interstitialAd
                val intent=Intent(this@MainActivity,AnaActivity::class.java)
                startActivity(intent)
                finish()
            }
        })

        mInterstitialAd?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {

            }

            override fun onAdFailedToShowFullScreenContent(adError: AdError?) {

            }

            override fun onAdShowedFullScreenContent() {
                mInterstitialAd = null

            }
        }


    }

    override fun onBackPressed() {

    }
}