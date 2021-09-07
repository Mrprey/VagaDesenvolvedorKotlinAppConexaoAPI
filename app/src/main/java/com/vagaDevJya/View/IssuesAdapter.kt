package com.vagaDevJya.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.vagaDevJya.Models.Example
import com.vagaDevJya.R



class IssuesAdapter
    : RecyclerView.Adapter<IssuesAdapter.IssueViewHolder>() {

    private var listIssues = ArrayList<Example>()
    var page = 1
    var isLoading = false
    val limit = 21

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : IssueViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_title_status, parent, false)
        return IssueViewHolder(view)
    }

    override fun getItemCount() = listIssues.size

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(listIssues[position])


    }

    fun getPage(page: Int, limit: Int){
        val start: Int = (page*limit) + 1
        val end: Int = page*limit

        for (i in start..end){

        }
    }

    inner class IssueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView = this.itemView.findViewById<CardView>(R.id.cv_statusTitulo)
        fun bind(example: Example) {
            val textView_title = this.itemView.findViewById<TextView>(R.id.tv_textTitulo)
            val imageView_status = this.itemView.findViewById<ImageView>(R.id.iv_status)
            with(example) {
                textView_title.text = title.toString()
                if (state.toString().equals("open", true)) {
                    imageView_status.setImageResource(R.mipmap.ic_alive)
                } else {
                    imageView_status.setImageResource(R.mipmap.ic_disabled)
                }

            }

        }
    }

    fun addList(newIssues: ArrayList<Example>){
        listIssues.addAll(newIssues)
        notifyDataSetChanged()
    }

    fun clearList(){
        listIssues.clear()
        notifyDataSetChanged()
    }

}