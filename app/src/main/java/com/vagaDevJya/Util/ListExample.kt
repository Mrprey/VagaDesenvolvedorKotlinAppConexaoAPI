package com.vagaDevJya.Util

import com.vagaDevJya.Models.Example

class ListExample {
    protected var listExample: ArrayList<Example> = ArrayList()

    fun setList(example: Example) {
        listExample.add(example)
    }

    fun getList() = listExample
}