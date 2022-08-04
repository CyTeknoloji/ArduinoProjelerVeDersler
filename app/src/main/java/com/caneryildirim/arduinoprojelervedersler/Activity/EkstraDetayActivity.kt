package com.caneryildirim.arduinoprojelervedersler.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.ekstraDetayText3
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.imageED1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.imageED2

import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.ActivityEkstraDetayBinding
import com.google.android.gms.ads.*



class EkstraDetayActivity : AppCompatActivity() {


    private lateinit var binding: ActivityEkstraDetayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityEkstraDetayBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        var toolbarName=intent.getStringExtra("toolbar")
        binding.toolbarEkstraDetay.title=toolbarName
        setSupportActionBar(binding.toolbarEkstraDetay)

        binding.toolbarEkstraDetay.setNavigationOnClickListener {
            onBackPressed()
        }

        binding.textEkstraDetay1.text= ekstraDetayText1
        binding.textEkstraDetay2.text= ekstraDetayText2
        binding.textEkstraDetay3.text= ekstraDetayText3

        binding.imageEkstraDetay1.pageCount= imageED1.size
        binding.imageEkstraDetay1.setImageListener { position, imageView ->
            imageView.adjustViewBounds=true
            imageView.setImageResource(imageED1[position])
        }

        binding.imageEkstraDetay2.pageCount= imageED2.size
        binding.imageEkstraDetay2.setImageListener { position, imageView ->
            imageView.adjustViewBounds=true
            imageView.setImageResource(imageED2[position])
        }


    }
}