package com.example.example

import com.google.gson.annotations.SerializedName


data class To (

  @SerializedName("day"   ) var day   : Int? = null,
  @SerializedName("month" ) var month : Int? = null,
  @SerializedName("year"  ) var year  : Int? = null

)