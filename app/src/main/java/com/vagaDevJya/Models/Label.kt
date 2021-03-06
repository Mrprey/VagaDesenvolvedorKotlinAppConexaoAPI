package com.vagaDevJya.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Label {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null

    @SerializedName("default")
    @Expose
    var default: Boolean? = null

    @SerializedName("description")
    @Expose
    var description: String? = null
}