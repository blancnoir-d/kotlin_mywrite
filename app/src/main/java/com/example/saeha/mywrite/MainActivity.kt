package com.example.saeha.mywrite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val writeList = ArrayList<WriteItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvWriteList  = findViewById<RecyclerView>(R.id.rv_main_write_list)
        rvWriteList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

//        // extenstions 플러그인 적용
//        rv_main_write_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)


        for (i in 1..10){
            writeList.add(WriteItemData("오늘은 어쩐지 모르겠다",i.toString()))
        }

        // adapter 생성
        val adapter = WriteListAdapter(writeList)

        //adding the adapter to recyclerview
        rv_main_write_list.adapter = adapter
    }
}
