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



class IssuesAdapter(private val issue: List<Example>) : RecyclerView.Adapter<IssuesAdapter.IssueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_title_status, parent, false)
        return IssueViewHolder(view)
    }

    override fun getItemCount() = issue.size

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(issue[position])


    }

    inner class IssueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var cardView = this.itemView.findViewById<CardView>(R.id.cv_statusTitulo)
        fun bind(example: Example) {
            var textView_title = this.itemView.findViewById<TextView>(R.id.tv_textTitulo)
            var imageView_status = this.itemView.findViewById<ImageView>(R.id.iv_status)
            with(example){
                textView_title.text = title.toString()
                if (state.toString().equals("open", true)){
                    imageView_status.setImageResource(R.mipmap.ic_alive)
                }
                else{
                    imageView_status.setImageResource(R.mipmap.ic_disabled)
                }

            }

        }
    }

    fun onItemClick(parent: IssuesAdapter, view: View, position: Int,id: Long): Unit {}

    fun onClick(v: View?) {}
}

private fun ImageView.setImageDrawable(icAlive: Int) {

}

