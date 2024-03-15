package com.example.practiceall

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Newlistview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_newlistview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listview=findViewById<ListView>(R.id.newlistview)
        val tasklist= arrayListOf<String>()
        tasklist.add("task number one")
        tasklist.add("task number two")
        tasklist.add("task number three")
        tasklist.add("task number four")
        tasklist.add("task number five")
        val listadaptor=ArrayAdapter(this, android.R.layout.simple_list_item_1,tasklist)
        listview.adapter=listadaptor
        listview.setOnItemClickListener { parent, view, position, id ->
            val text="clicked on"+ (view as TextView).text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        val nextbtn=findViewById<Button>(R.id.nextbtn)
        nextbtn.setOnClickListener {
            val intent=Intent(this,Thirdlistview::class.java)
            startActivity(intent)
        }
    }
}