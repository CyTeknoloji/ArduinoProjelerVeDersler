package com.caneryildirim.arduinoprojelervedersler.Activity

import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment

import android.webkit.CookieManager
import android.webkit.URLUtil
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image1PD
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.image2PD

import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeDetayText1
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeDetayText2
import com.caneryildirim.arduinoprojelervedersler.Adaptors.Singleton.projeKod

import com.caneryildirim.arduinoprojelervedersler.R
import com.caneryildirim.arduinoprojelervedersler.databinding.ActivityProjeDetayBinding
import com.google.android.gms.ads.*




class ProjeDetayActivity : AppCompatActivity() {


    private lateinit var binding: ActivityProjeDetayBinding

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode==1 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            val request= DownloadManager.Request(Uri.parse(projeKod))
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            var title= URLUtil.guessFileName(projeKod,null,null)
            request.setTitle(title)
            request.setDescription("İndiriliyor")
            var cookie= CookieManager.getInstance().getCookie(projeKod)
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
        binding= ActivityProjeDetayBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        var toolbarName=intent.getStringExtra("toolbar")
        binding.toolbarProjeDetay.title=toolbarName
        setSupportActionBar(binding.toolbarProjeDetay)

        binding.toolbarProjeDetay.setNavigationOnClickListener {
            onBackPressed()
        }


        binding.textProjeMalzemeler.text= projeDetayText1
        binding.textViewProje1.text= projeDetayText2


        binding.imageViewProje1.pageCount= image1PD.size
        binding.imageViewProje1.setImageListener { position, imageView ->
            imageView.adjustViewBounds=true
            imageView.setImageResource(image1PD[position])
        }

        binding.imageViewProje2.pageCount= image2PD.size
        binding.imageViewProje2.setImageListener { position, imageView ->
            imageView.adjustViewBounds=true
            imageView.setImageResource(image2PD[position])
        }

        binding.buttonProjeKod.setOnClickListener {
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                if (ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),1)

                }else{
                    val request=DownloadManager.Request(Uri.parse(projeKod))
                    request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                    var title=URLUtil.guessFileName(projeKod,null,null)
                    request.setTitle(title)
                    request.setDescription("İndiriliyor")
                    var cookie=CookieManager.getInstance().getCookie(projeKod)
                    request.addRequestHeader("cookie",cookie)
                    request.allowScanningByMediaScanner()
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,title)
                    val manager=getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    manager.enqueue(request)
                }
            }else{
                val request=DownloadManager.Request(Uri.parse(projeKod))
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                var title=URLUtil.guessFileName(projeKod,null,null)
                request.setTitle(title)
                request.setDescription("İndiriliyor")
                var cookie=CookieManager.getInstance().getCookie(projeKod)
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