package com.demo.country.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.country.data.CountryApi
import com.demo.country.domain.Country
import kotlinx.coroutines.launch

enum class CountryApiStatus { LOADING, ERROR, DONE }

class CountryListViewModel : ViewModel() {

    private val _status = MutableLiveData<CountryApiStatus>()

    val status: LiveData<CountryApiStatus>
        get() = _status

    private val _countries = MutableLiveData<List<Country>>()

    val countries: LiveData<List<Country>>
        get() = _countries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _status.value = CountryApiStatus.LOADING
            try {
                _countries.value = CountryApi.retrofitService.getCountries()
                _status.value = CountryApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CountryApiStatus.ERROR
                _countries.value = ArrayList()
            }
        }
    }
}