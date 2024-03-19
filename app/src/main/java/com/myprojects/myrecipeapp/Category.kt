package com.myprojects.myrecipeapp

data class Category(
    val id: Int,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class CategoriesResponse(
    val categories: List<Category>
)
