package com.example.fakestore.presentation.ui.screenHome

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.data.network.model.Category
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.data.network.model.User
import com.example.fakestore.domain.useCase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelHome @Inject constructor(
    val useCase: UseCase
): ViewModel(){
    var product by mutableStateOf<Result<List<ProductEntity>>?>(null)
        private set
    var category by mutableStateOf<Result<List<Category>>?>(null)
        private set
    var user by mutableStateOf<Result<User>?>(null)
        private set

    var loading by mutableStateOf(false)

    init {
        startHome()
    }

    fun startHome(){
        loading = true
        getProducts()
        getCategory()
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            user = useCase.home.getUser()
        }
    }

    fun loadingStatus(){
        loading = product == null || category == null
    }

    fun getProducts(){
        viewModelScope.launch {
            product = useCase.home.getProduct()
        }

    }

    fun getCategory(){
        viewModelScope.launch {
            category = useCase.home.getCategory()
        }
    }
}