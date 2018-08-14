package com.example.saeha.mywrite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private val writeList = ArrayList<WriteItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvWriteList  = findViewById<RecyclerView>(R.id.rv_main_write_list)
        rvWriteList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

//        // extenstions 플러그인 적용
//        rv_main_write_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        fab_add_write.setOnClickListener(this)


        for (i in 1..10){
            writeList.add(WriteItemData("제목입니다~",i.toString()))
        }

        // adapter 생성
        val adapter = WriteListAdapter(writeList)

        //adding the adapter to recyclerview
        rv_main_write_list.adapter = adapter



    }

    //아우 ㅠ _-
    override fun onClick(v: View?) {
        // when 은 switch 대체
        when(v!!.getId()){
            R.id.fab_add_write -> inputActivity()
        }

    }

    private fun inputActivity(){
        val intent  = Intent(this,InputWriteActivity::class.java)
        startActivity(intent)
    }
}
