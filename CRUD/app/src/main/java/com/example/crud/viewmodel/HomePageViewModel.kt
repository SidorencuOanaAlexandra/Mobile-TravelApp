package com.example.crud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crud.domain.TravelPlace
import com.example.crud.repo.Repository
import logd

class HomePageViewModel constructor(private val repository: Repository): ViewModel() {
    // TODO: Implement the ViewModel
    private val _travelPlaceList = MutableLiveData<List<TravelPlace>>();
    val travelPlaceList: LiveData<List<TravelPlace>>
        get() = _travelPlaceList

    fun getAllData(): MutableList<TravelPlace> {
        logd("HomePage:")
        val travelPlaceList = repository.getAllData();
        _travelPlaceList.value = travelPlaceList
        return travelPlaceList;
    }

    fun getTravelPlaceWithId(id_place: String) : TravelPlace {
        return repository.getTravelPlaceWithId(id_place)
    }
    fun Update(id:String, new_item:TravelPlace){
        repository.Update(id,new_item)
    }
    fun Add(new_item: TravelPlace){
        repository.Add(new_item)
    }

    fun Remove(id:String){
       repository.Remove(id)
    }


}

