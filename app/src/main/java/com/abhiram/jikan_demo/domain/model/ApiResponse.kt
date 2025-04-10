package com.abhiram.jikan_demo.domain.model

data class ApiResponse(
    val pagination: Pagination,
    val data: List<Data>
)