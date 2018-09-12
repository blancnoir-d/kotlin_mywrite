package com.example.saeha.mywrite

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import kotlinx.android.synthetic.main.activity_input_write.*
import java.net.HttpURLConnection
import java.net.URL


class InputWriteActivity : AppCompatActivity() {

    var urlConnection: HttpURLConnection? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_write)


        var inputText = et_input_write.text

        // 저장 버튼
        bt_save_write.setOnClickListener {view ->
            //Toast.makeText(this,inputText,Toast.LENGTH_LONG).show()
            httpPostJson(bt_save_write)
            /**
             * aaaaa 나옴 'ㅁ' echo 세상 신기
             */
        }

        // fuel http
        FuelManager.instance.basePath = "http://vlogdiary.com"


    }

    private fun initViewsAndWidgets() {
//        tvGetResponse = findViewById(R.id.tvGetResponse)
//        tvPostResponse = findViewById(R.id.tvPostResponse)
//        progress = ProgressDialog(this)
//        progress!!.setTitle("Kotlin Fuel Http Sample")
//        progress!!.setMessage("Loading...")
    }

    fun httpGetJson(view: View) {
        try {
            //progress!!.show()
            Fuel.get("api/get_sample.php").responseJson { request, response, result ->

            }
        } catch (e: Exception) {
           // tvGetResponse!!.text = e.message
        } finally {
           // progress!!.dismiss()
        }
    }

    fun httpPostJson(view: View) {
        try {
           // progress!!.show()
            Fuel.post("kotlin/test.php", listOf("version_index" to "1")).responseJson { request, response, result ->
                testText!!.text = result.get().content
            }
        } catch (e: Exception) {
          //  tvPostResponse!!.text = e.message
        } finally {
           // progress!!.dismiss()
        }
    }

}
