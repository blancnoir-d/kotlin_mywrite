package com.example.saeha.mywrite

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.item_write_list_layout.view.*

class WriteListAdapter(private val writeList: ArrayList<WriteItemData>): RecyclerView.Adapter<WriteListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteListAdapter.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_write_list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return writeList.size
    }

    override fun onBindViewHolder(holder:WriteListAdapter.ViewHolder, position: Int) {
       holder.bindItems(writeList[position])
        // 스낵바
       holder.itemView.setOnClickListener {view ->
           Snackbar.make(view,"테스트 입니다",Snackbar.LENGTH_LONG).setAction("OK", View.OnClickListener {
               holder.tvSubject.text = "ssssss"
           }).show()


       }
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        // findViewBy를 매번 호출하게 되므로 성능이 떨어지며 데이터의 수가 증가할 수록 그 영향은 더욱 커집니다...
        // 뷰홀더 내부에 각 뷰를 위한 프로퍼티를 추가....???
        val tvSubject: TextView = itemView.tv_subject
        val tvDateTime = itemView.findViewById<TextView>(R.id.tv_datetime)

        fun bindItems(user: WriteItemData) {

            tvSubject.text = user.subject
            tvDateTime.text = user.dateTime
        }
    }
}



