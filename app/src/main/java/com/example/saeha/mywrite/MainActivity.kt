package com.example.saeha.mywrite

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val writeList = ArrayList<WriteItemData>()


    private lateinit var tvWriteList: TextView

    private val messageView : TextView by lazy {
        // messageView의 첫 액세스에서 실행됩니다
        findViewById(R.id.rv_main_write_list) as TextView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val rvWriteList  = findViewById<RecyclerView>(R.id.rv_main_write_list)
        rv_main_write_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


//        // extenstions 플러그인 적용
//        rv_main_write_list.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
       // fab_add_write.setOnClickListener(this)


        for (i in 1..10) {
            writeList.add(WriteItemData("제목입니다~", i.toString()))
        }

        // adapter 생성
        val adapter = WriteListAdapter(this, writeList)

        //adding the adapter to recyclerview
        rv_main_write_list.adapter = adapter

    }


//    //아우 ㅠ _-
//    override fun onClick(v: View?) {
//        // when 은 switch 대체
//        when(v!!.getId()){
//            R.id.fab_add_write -> inputActivity()
//        }
//    }
//
//    private fun inputActivity(){
//        val intent  = Intent(this,InputWriteActivity::class.java)
//        startActivity(intent)
//    }

        /**
         * when
         */
//        when(x){
//            100 -> "A"
//            90 -> "B"
//            80 -> "C"
//            else ->"F"
//        }
//
//        // 여러개 가능
//        when(x){
//            0,1->print("x == 0 or x == 1")
//            else -> print("otherwise")
//        }
//
//        // range나 collection에 in이나 !in으로 범위 등을 검사할 수 있음
//        val validNumbers = listOf(3,6,9)
//        when(x){
//            in validNumbers -> print("x is valid")
//            in 1..10 -> print("x is in the range")
//            !in 10..20 -> print("x is outside the range")
//            else -> print("none of the above")
//        }
//
//        // Is 나 !Is를 이용하여 타입도 검사 할 수 있음
//        //이 때 스마트 캐스트가 적용됨
//        fun hsdPrefix(x:Any) = when(x){
//            is String -> x.startsWith("prefix")
//            else -> false
//        }
//
//        // when은 if -else if 체인을 대체할 수 있음
//        // when에 인자를 입력하지 않으면, 논리 연산으로 처리됨
//        when{
//            x.isOdd() -> print("x is odd")  // 홀수냐
//            x.isEven() -> print("x is even") // 짝수냐
//            else -> print("x is funny")
//        }
      }



