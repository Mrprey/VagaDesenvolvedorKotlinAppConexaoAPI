package com.vagaDevJya

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.vagaDevJya.Controller.EndPoints
import com.vagaDevJya.Controller.RetrofitClient
import com.vagaDevJya.Controller.RetrofitConfig
import com.vagaDevJya.Models.Example
import com.vagaDevJya.View.IssuesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.vagaDevJya.Util.ListExample


class MainActivity : AppCompatActivity(){

    private lateinit var adapter: IssuesAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var page = 1
    private var totalPage = 1
    private var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        adapter = IssuesAdapter()
        setupRecyclerView()
        getIssues(false)

        //var listExample = ListExample()
       // getData(listExample)


    }

    private fun getIssues(isOnRefresh: Boolean) {
        isLoading = true
        val listResponse = ListExample()
        //if (!isOnRefresh) progressBar.visibility = View.VISIBLE
        val parameters = HashMap<String, String>()
        parameters["page"] = page.toString()
        RetrofitClient.instace.getProfile().enqueue(object : Callback<List<Example>>{

            override fun onFailure(call: Call<List<Example>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<List<Example>>,
                response: Response<List<Example>>
            ) {
                //totalPage = 5
                response.body()?.forEach(){
                    listResponse.setList(it)
                    adapter.addList(listResponse.getList())
                }

            }
        })
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}