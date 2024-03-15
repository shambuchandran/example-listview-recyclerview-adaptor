package com.example.practiceall

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Recycleonclick : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycleonclick)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val image=intent.getIntExtra("IMAGE",R.drawable.baseline_article_24)
        val title=intent.getStringExtra("TITLE")
        val detail=intent.getStringExtra("DETAIL")

        val rcimage=findViewById<ImageView>(R.id.rcshowimg)
        val rctitle=findViewById<TextView>(R.id.rcshowtv)
        val rcdetail=findViewById<TextView>(R.id.rcshowdt)

        rcimage.setImageResource(image)
        rctitle.setText(title)
        rcdetail.setText(detail)
        val newlistviewgo=findViewById<Button>(R.id.newlistgobtn)
        newlistviewgo.setOnClickListener {
            val intent=Intent(this,Newlistview::class.java)
            startActivity(intent)
        }
    }
}