package com.vagaDevJya

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vagaDevJya.Controller.EndPoints
import com.vagaDevJya.Controller.RetrofitConfig
import com.vagaDevJya.Models.Example
import com.vagaDevJya.View.IssuesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.vagaDevJya.Util.ListExample


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var listExample = ListExample()
        getData(listExample)


    }

    private fun setupRecyclerView(data: List<Example>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.adapter = IssuesAdapter(data)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getData(listExample: ListExample){
        val retrofitClient = RetrofitConfig.getRetrofitInstance("https://api.github.com/repos/JetBrains/kotlin/")
        val endpoint = retrofitClient.create(EndPoints::class.java).apply {
            getProfile().enqueue(object : Callback<List<Example>> {

                override fun onFailure(call: Call<List<Example>>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(call: Call<List<Example>>, response: Response<List<Example>>) {
                    response.body()?.forEach{
                        listExample.setList(it)
                        setupRecyclerView(listExample.getList())
                        //textView_title.text = textView_title.text.toString().plus(it.title+"\n")
                    }
                }
            })
        }
    }


}