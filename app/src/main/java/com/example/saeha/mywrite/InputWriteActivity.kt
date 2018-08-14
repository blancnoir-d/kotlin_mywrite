package com.example.saeha.mywrite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_input_write.*

class InputWriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_write)

        var inputText = et_input_write.text


        //호스팅어 retrofit 이용해서 데이터 전송, 저장, 출력 해보기

    }
}
