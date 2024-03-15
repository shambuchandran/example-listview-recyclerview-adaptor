package com.example.practiceall

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Listview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lv = findViewById<ListView>(R.id.listview)
        val lvitems = arrayOf("apple", "banana", "orange", "mango", "grape")
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lvitems)
        lv.adapter = listAdapter
        lv.setOnItemClickListener { parent, view, position, id ->
            val selectedItem=parent.getItemAtPosition(position) as String
            Toast.makeText(this, "clicked on $selectedItem", Toast.LENGTH_SHORT).show()
        }
        val rcvbuttom=findViewById<Button>(R.id.rvbtn)
        rcvbuttom.setOnClickListener {
            val intent=Intent(this,Recycleview::class.java)
            startActivity(intent)
        }
    }
}