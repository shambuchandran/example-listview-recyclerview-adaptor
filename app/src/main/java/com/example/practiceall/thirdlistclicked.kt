package com.example.practiceall

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class thirdlistclicked : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thirdlistclicked)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name=intent.getStringExtra("NAME")
        val phone=intent.getStringExtra("PHNUMBER")
        val pic=intent.getIntExtra("PROFILEPIC",R.drawable.a)

        val nameshow=findViewById<TextView>(R.id.passname)
        val phshow=findViewById<TextView>(R.id.passphno)
        val picshow=findViewById<CircleImageView>(R.id.passpic)

        nameshow.text=name
        phshow.text=phone
        picshow.setImageResource(pic)

    }
}