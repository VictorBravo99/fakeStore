package com.example.fakestore.data.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("category")
    val category: Category,
    @SerialName("creationAt")
    val creationAt: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("images")
    val images: List<String>,
    @SerialName("price")
    val price: Int,
    @SerialName("slug")
    val slug: String,
    @SerialName("title")
    val title: String,
    @SerialName("updatedAt")
    val updatedAt: String
) {
    @Serializable
    data class Category(
        @SerialName("creationAt")
        val creationAt: String,
        @SerialName("id")
        val id: Int,
        @SerialName("image")
        val image: String,
        @SerialName("name")
        val name: String,
        @SerialName("slug")
        val slug: String,
        @SerialName("updatedAt")
        val updatedAt: String
    )
}