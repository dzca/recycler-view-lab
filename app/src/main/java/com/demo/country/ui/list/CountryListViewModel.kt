package com.demo.country.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.country.data.CountryApi
import com.demo.country.domain.Country
import com.demo.country.domain.RequestStatus
import kotlinx.coroutines.launch
import timber.log.Timber


class CountryListViewModel : ViewModel() {

    private val _status = MutableLiveData<RequestStatus>()

    val status: LiveData<RequestStatus>
        get() = _status

    private val _countries = MutableLiveData<List<Country>>()

    val countries: LiveData<List<Country>>
        get() = _countries

    init {
        getCountries()
    }

    private fun getCountries() {
        Timber.d("[CountryListViewModel] getCountries()")
        viewModelScope.launch {
            _status.value = RequestStatus.LOADING
            try {
                _countries.value = CountryApi.retrofitService.getCountries()
                Timber.d("[CountryListViewModel] CountryApi.retrofitService.getCountries()")
                _status.value = RequestStatus.DONE
            } catch (e: Exception) {
                _status.value = RequestStatus.ERROR
                _countries.value = ArrayList()
            }
        }
    }
}