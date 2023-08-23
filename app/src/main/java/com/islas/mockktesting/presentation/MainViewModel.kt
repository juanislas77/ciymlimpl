package com.islas.mockktesting.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.islas.mockktesting.data.repository.ServiceRepository
import com.islas.mockktesting.domain.models.LaunchDomain
import com.islas.mockktesting.domain.utils.ResultAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: ServiceRepository
) : ViewModel() {


    private val _result = mutableStateListOf<LaunchDomain>()
    val result: SnapshotStateList<LaunchDomain>
        get() = _result

    private var _id = MutableLiveData("NonKey")

    fun setId(idItem: String) {
        _id.value = idItem
    }

    fun getId(): String {
        return _id.value ?: "NonKey"
    }

    fun getItemLaunch(idItem: String): LaunchDomain {
        val emptyItem = LaunchDomain(
            id = "",
            nameLaunched = "",
            dateLaunchedLocal = "",
            logoLaunched = "",
            article = "",
            description = "",
            original = emptyList()
        )

        when (_result.isEmpty()) {
            true -> {}
            false -> {
                for (item in _result) {
                    if (item.id == idItem) {
                        return item
                    }
                }
            }
        }
        return emptyItem
    }

    internal fun getLaunchesList() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = repository.getData()) {
            is ResultAPI.Error -> {
                Log.e("MainViewModel", "getLaunchesList failed")
            }

            is ResultAPI.Success -> {
                _result.clear()
                _result.addAll(result.data)
                Log.d("MainViewModel", "ResultAPI Success" + _result.size.toString())
            }

            is ResultAPI.Loading -> {

            }

            else -> {

            }
        }
    }
}
