package com.caneryildirim.arduinoprojelervedersler.Activity

import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.CookieManager
import android.webkit.URLUtil
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetayText3
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersDetaybaslik
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.dersKod
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image1DD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image2DD
import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.ActivityDersDetayBinding
import com.google.android.gms.ads.*


class DersDetayActivity : AppCompatActivity() {
    var position:Int?=null

    private lateinit var binding:ActivityDersDetayBinding



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            val request=DownloadManager.Request(Uri.parse(dersKod))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            var title=URLUtil.guessFileName(dersKod,null,null)
            request.setTitle(title)
            request.setDescription("İndiriliyor")
            var cookie=CookieManager.getInstance().getCookie(dersKod)
            request.addRequestHeader("cookie",cookie)
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title)
            val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            manager.enqueue(request)
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDersDetayBinding.inflate(layoutInflater)
        val view=binding.root
            setContentView(view)

            var toolbarName=intent.getStringExtra("toolbar")
            binding.toolbarDersDetay.title=toolbarName
            setSupportActionBar(binding.toolbarDersDetay)
        binding.toolbarDersDetay.setNavigationOnClickListener {
            onBackPressed()
        }

            position=intent.getIntExtra("position",50)

            if (position==0){
                binding.dersKodButton.visibility=View.INVISIBLE

            }

            binding.textViewDersDetayBaslik.text= dersDetaybaslik
            binding.textViewDersDetay1.text= dersDetayText1
            binding.textViewDersDetay2.text= dersDetayText2
            binding.textViewDersDetay3.text= dersDetayText3

        binding.carouselViewDD1.pageCount= image1DD.size
        binding.carouselViewDD1.setImageListener { position, imageView ->
                imageView.adjustViewBounds=true
                imageView.setImageResource(image1DD[position])
            }

        binding.carouselViewDD2.pageCount= image2DD.size
        binding.carouselViewDD2.setImageListener { position, imageView ->
                imageView.adjustViewBounds=true
                imageView.setImageResource(image2DD[position])
            }
        binding.dersKodButton.setOnClickListener {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),1)

                }else{
                    val request=DownloadManager.Request(Uri.parse(dersKod))
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                    var title=URLUtil.guessFileName(dersKod,null,null)
                    request.setTitle(title)
                    request.setDescription("İndiriliyor")
                    var cookie=CookieManager.getInstance().getCookie(dersKod)
                    request.addRequestHeader("cookie",cookie)
                    request.allowScanningByMediaScanner()
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title)
                    val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    manager.enqueue(request)
                }
            }else{
                val request=DownloadManager.Request(Uri.parse(dersKod))
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                var title=URLUtil.guessFileName(dersKod,null,null)
                request.setTitle(title)
                request.setDescription("İndiriliyor")
                var cookie=CookieManager.getInstance().getCookie(dersKod)
                request.addRequestHeader("cookie",cookie)
                request.allowScanningByMediaScanner()
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title)
                val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                manager.enqueue(request)

            }
        }

    }
}