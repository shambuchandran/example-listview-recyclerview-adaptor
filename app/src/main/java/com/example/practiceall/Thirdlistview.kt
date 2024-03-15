package com.example.practiceall

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Thirdlistview : AppCompatActivity() {
    private lateinit var userArrayList: ArrayList<ThirdDataClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thirdlistview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = arrayOf("nameA", "nameB", "nameC", "nameD", "nameE", "nameF", "nameG")
        val lastmsg = arrayOf(
            "last message of nameA",
            "last message of nameB",
            "last message of nameC",
            "last message of nameD",
            "last message of nameE",
            "last message of nameF",
            "last message of nameG"
        )
        val lastmsgtime =
            arrayOf("8:50am", "1:20am", "9:00am", "4:20am", "5:50am", "6:30am", "3:40am")
        val phnumber = arrayOf(
            "3978492039",
            "83125738352",
            "623920458",
            "278529053",
            "8273203933",
            "732375309",
            "372893354"
        )
        val profilepic = intArrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g
        )
        userArrayList = ArrayList()
        for (i in name.indices) {
            val user =
                ThirdDataClass(name[i], lastmsg[i], lastmsgtime[i], profilepic[i], phnumber[i])
            userArrayList.add(user)
        }
        val listview = findViewById<ListView>(R.id.thirdlist)
        listview.adapter = LvAdapter(this, userArrayList)
        listview.setOnItemClickListener { parent, view, position, id ->
            val passname=name[position]
            val passphnumber=phnumber[position]
            val passprofilepic=profilepic[position]

            val intent=Intent(this,thirdlistclicked::class.java)
            intent.putExtra("NAME",passname)
            intent.putExtra("PHNUMBER",passphnumber)
            intent.putExtra("PROFILEPIC",passprofilepic)
            startActivity(intent)
        }

    }
}