package com.example.practiceall

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Recycleview : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var dataList: ArrayList<Dataclass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycleview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)
        myRecyclerView.layoutManager=LinearLayoutManager(this)
        var imageArray = arrayOf(
            R.drawable.diversity,
            R.drawable.baseline_article_24,
            R.drawable.diversity,
            R.drawable.baseline_article_24,
            R.drawable.diversity,
            R.drawable.baseline_article_24
        )
        var titileArray =
            arrayOf("diversity", "article", "diversity", "article", "diversity", "article")
        var detailsArray =
            arrayOf("diversitydetails", "articlejkasjfk", "diversitylakhfai", "articleskahiapkfsoa", "diversitysakhsoiaia", "articleakjhaisfhpaoi")


        dataList= arrayListOf<Dataclass>()
        for (i in imageArray.indices){
            val data=Dataclass(imageArray[i],titileArray[i],detailsArray[i])
            dataList.add(data)
        }
        val rvadaptor=RvAdaptor(dataList,this)
        myRecyclerView.adapter=rvadaptor
        rvadaptor.setitemclick(object:RvAdaptor.onItemClickedListen{
            override fun onItemClicked(position: Int) {
                val intent=Intent(this@Recycleview,Recycleonclick::class.java)
                intent.putExtra("TITLE",dataList[position].dataTitle)
                intent.putExtra("IMAGE",dataList[position].dataImage)
                intent.putExtra("DETAIL",dataList[position].dataDetails)
                startActivity(intent)

            }

        })
    }
}