package com.caneryildirim.arduinoprojelervedersler.Activity


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.mInterstitialAd

import com.caneryildirim.arduinoprojelervedersler.Fragments.DersFragment
import com.caneryildirim.arduinoprojelervedersler.Fragments.EkstraFragment
import com.caneryildirim.arduinoprojelervedersler.Fragments.ProjeFragment
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.ActivityAnaBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.tabs.TabLayoutMediator



class AnaActivity : AppCompatActivity() {
    val fragmentList=ArrayList<Fragment>()
    val fragmentTabList=ArrayList<String>()
    private lateinit var binding: ActivityAnaBinding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ana,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.paylas){
            val shareBody="Sorunu Paylaş uygulamasını Play Store'dan yükle : https://play.google.com/store/apps/details?id=com.caneryildirim.arduinoprojelervedersler"
            val shareIntent=Intent(Intent.ACTION_SEND)
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody)
            startActivity(Intent.createChooser(shareIntent,"Paylaş"))

        }else if (item.itemId==R.id.puanla){
            val packageName="com.caneryildirim.arduinoprojelervedersler"
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${packageName}"))
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAnaBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
            mInterstitialAd=null
        }


        binding.toolbar.title="Arduino Projeler Ve Dersler"
        setSupportActionBar(binding.toolbar)

        fragmentList.add(DersFragment())
        fragmentList.add(ProjeFragment())
        fragmentList.add(EkstraFragment())

        fragmentTabList.add("Dersler")
        fragmentTabList.add("Projeler")
        fragmentTabList.add("Kullanımlar")

        val adapter=ViewPagerAdapter(this)
        binding.viewPager2.adapter=adapter

        TabLayoutMediator(binding.tablayout,binding.viewPager2){tab, position ->
        tab.setText(fragmentTabList[position])
        }.attach()





    }

    inner class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
           return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }





    override fun onResume() {
        super.onResume()
    }
}