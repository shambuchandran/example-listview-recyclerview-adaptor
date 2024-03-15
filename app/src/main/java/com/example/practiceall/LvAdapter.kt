package com.example.practiceall

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class LvAdapter(val context: Activity, val arrayList: ArrayList<ThirdDataClass>) :
    ArrayAdapter<ThirdDataClass>(context, R.layout.activity_thirdlistview, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater=LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.eachlistitem,null)

        val image=view.findViewById<CircleImageView>(R.id.passpic)
        val firstname=view.findViewById<TextView>(R.id.nametv)
        val lastmsg=view.findViewById<TextView>(R.id.lastmsg)
        val lastmsgtime=view.findViewById<TextView>(R.id.lasttime)

        image.setImageResource(arrayList[position].profilepic)
        firstname.text=arrayList[position].name
        lastmsg.text=arrayList[position].lastmsg
        lastmsgtime.text=arrayList[position].lastmsgtime
        return view
    }
}