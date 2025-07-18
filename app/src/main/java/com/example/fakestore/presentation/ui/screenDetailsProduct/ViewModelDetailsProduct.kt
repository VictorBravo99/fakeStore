package com.example.fakestore.presentation.ui.screenDetailsProduct

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.domain.useCase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelDetailsProduct @Inject constructor(
    val useCase: UseCase
) : ViewModel() {

    var details by mutableStateOf<ProductEntity?>(null)
        private set

    fun startDetailsProduct(id: Int) {
        viewModelScope.launch {
            useCase.detailsProduct.getDetailsProduct(id).collect {
                details = it
            }
        }
    }




}