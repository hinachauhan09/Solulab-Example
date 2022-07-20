package com.solulab.example.model

data class Data(
    val itemsPerPage: Int,
    val list: List<Item>,
    val startIndex: Int,
    val totalItems: Int
)