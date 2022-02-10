package com.example.superheros.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheros.data.repository.HeroRepository
import com.example.superheros.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class HeroListViewModel @Inject constructor(
    private val heroRepository: HeroRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val list = MutableLiveData<List<Hero>>()

   fun onCreate(){
       viewModelScope.launch {
           isLoading.postValue(true)
           val result = heroRepository.getAllHeros()
           list.postValue(result)
           isLoading.postValue(false)
       }
   }



}