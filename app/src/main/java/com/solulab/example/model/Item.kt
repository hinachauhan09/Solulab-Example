package com.solulab.example.model

data class Item (
    val _id: String,
    val age: Int,
    val history: String,
    val isCoin: Boolean,
    val isGraded: Boolean,
    val isSold: Boolean,
    val name: String,
    val pictures: Pictures,
    val price: Int,
    val tags: List<String>,
    val year: Int
)