package com.example.saeha.mywrite

import android.content.ContentProviderClient
import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import android.widget.Toast

class WriteListAdapter(val context: Context, val writeList: ArrayList<WriteItemData>): RecyclerView.Adapter<WriteListAdapter.ViewHolder>() {


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WriteListAdapter.ViewHolder{
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_write_list_layout,parent,false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return writeList.size
//    }
//
//    override fun onBindViewHolder(holder:WriteListAdapter.ViewHolder, position: Int) {
//       holder.bindItems(writeList[position])
//       holder.itemView.setOnClickListener {view ->
//           Snackbar.make(view,"테스트 입니다",Snackbar.LENGTH_LONG).setAction("OK", View.OnClickListener {
//               holder.tvSubject.text = "ssssss"
//           }).show()
//
//       }
//    }
//

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_write_list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return writeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItems(writeList[position])
        holder.itemView.setOnClickListener { view ->
            Snackbar.make(view,"테스트 입니다",Snackbar.LENGTH_LONG).setAction("OK",View.OnClickListener {
                holder.tvSubject.text = "sssssss"
            }).show()
        }
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val tvSubject = itemView.findViewById<TextView>(R.id.tv_subject)
        val tvDateTime = itemView.findViewById<TextView>(R.id.tv_datetime)

        fun bindItems(user: WriteItemData) {
            tvSubject.text = user.subject
            tvDateTime.text = user.dateTime
        }
    }
}