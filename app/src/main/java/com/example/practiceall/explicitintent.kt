package com.example.practiceall

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class explicitintent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_explicitintent)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val url="https://developer.android.com/develop/ui/views/launch/splash-screen#kotlin"
        val impliintent=findViewById<Button>(R.id.impliintent)
        impliintent.setOnClickListener {
//            val implicit=Intent(Intent.ACTION_VIEW, Uri.parse(url))
            val implicit=Intent(Intent.ACTION_GET_CONTENT)
            implicit.setType("image/*")
            startActivity(implicit)
        }
        val listviewgo=findViewById<Button>(R.id.btnlist)
        listviewgo.setOnClickListener {
            val intent=Intent(this,Listview::class.java)
            startActivity(intent)
        }
    }


}