package com.example.alibaba.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alibaba.viewModel.CitiesActivityViewModel
import com.example.test.repository.Repository

class CitiesActivityViewModelFactory (
    private val repository: Repository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CitiesActivityViewModel(repository) as T
    }
}