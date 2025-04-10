package com.example.example

import com.google.gson.annotations.SerializedName


data class AnimeData (
  @SerializedName("data" ) var data : Data? = Data()
)