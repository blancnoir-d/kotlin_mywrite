package com.example.saeha.mywrite

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_input_write.*
import io.reactivex.android.schedulers.AndroidSchedulers // rxAndroid ..
import retrofit2.Retrofit
import java.net.HttpURLConnection
import java.net.URL


class InputWriteActivity : AppCompatActivity() {



    // retrofit
    private var disposable: Disposable? = null

    private val wikiApiServe by lazy {
        WikiApiService.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_write)


        var inputText = et_input_write.text

        // fuel http
        FuelManager.instance.basePath = "http://vlogdiary.com"

        // 저장 버튼
        bt_save_write.setOnClickListener {view ->
            //Toast.makeText(this,inputText,Toast.LENGTH_LONG).show()

            // fuel
//            httpPostJson(bt_save_write)


            // retrofit
            if (et_input_write.text.toString().isNotEmpty()) {
                beginSearch(et_input_write.text.toString())
            }
        }







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
            Fuel.get("api/get_sample.php").responseJson { request, response, result ->
            }
        } catch (e: Exception) {
        } finally {
        }
    }

    fun httpPostJson(view: View) {
        try {
            Fuel.post("kotlin/test.php", listOf("version_index" to "1",
                                                 "input_text" to  "TT" )).responseJson { request, response, result ->
                testText!!.text = result.get().content
            }
        } catch (e: Exception) {
        } finally {
        }
    }



    // retrofit
    private fun beginSearch(searchString: String) {

//        val retrofit = Retrofit .Builder().baseUrl("http://api.github.com").build()
//        val service  = retrofit.create(WikiApiService::class.java)
//        service.hitCountCheck("aaaa","aaaa","aaaaa","aaaaaa")


        disposable = wikiApiServe.hitCountCheck("query", "json", "search", searchString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> testText.text = "${result.query.searchinfo.totalhits} result found" },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }



}
