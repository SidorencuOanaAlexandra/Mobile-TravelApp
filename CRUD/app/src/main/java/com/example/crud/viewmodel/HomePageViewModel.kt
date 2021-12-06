package com.example.crud.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.domain.TravelPlace
import com.example.crud.repo.Repository
import com.example.crud.repo.roomRepo.RoomDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import logd

class HomePageViewModel constructor(private val repository: Repository): ViewModel() {
    // TODO: Implement the ViewModel
//    private val _travelPlaceList = MutableLiveData<List<TravelPlace>>();
//    val travelPlaceList: LiveData<List<TravelPlace>>
//        get() = _travelPlaceList

    val allWords: LiveData<List<TravelPlace>>
    
//    init{
//        _travelPlaceList = repository.list_TravelPlaces
//    }

//    init {
//
//        val wordsDao = RoomDataBase.getDatabase(application,viewModelScope).travelPlaceDao()
//        repository = Repository(wordsDao)
//        allWords = repository.allWords
//    }

//    suspend fun getAllData(): LiveData<List<TravelPlace>> {
//        logd("HomePage:")
//        val travelPlaceList = repository.getAllData();
//       // _travelPlaceList.value = travelPlaceList
//        return travelPlaceList;
//    }

//    fun gatAll() = viewModelScope.launch(Dispatchers.IO) {
//       return repository.Add(word)
//    }

    fun getTravelPlaceWithId(id_place: Int) : TravelPlace {
       // return repository.getTravelPlaceWithId(id_place)
        var elem = TravelPlace(1,"Castelul Corvinilor","Hunedoara","45","22","Castelul Corvinilor, numit și Castelul Huniazilor sau al Hunedoarei, este cetatea medievală a Hunedoarei, unul din cele mai importante monumente de arhitectură gotică din România.\n" +
                "\n" +
                "Este considerat unul dintre cele mai frumoase castele din lume, fiind situat în „top 10 destinații de basm din Europa”","10:00-16:00 L-S","https://www.descopera.ro/wp-content/uploads/2021/05/castelul-corvinilor-hunedoara-shutter_descopera-3-scaled.jpg")
        return elem;
    }
    fun Update(id:Int, new_item:TravelPlace){
        repository.Update(id,new_item)
    }
//    suspend fun Add(new_item: TravelPlace){
//        repository.Add(new_item)
//    }

    fun insert(word: TravelPlace) = viewModelScope.launch(Dispatchers.IO) {
        repository.Add(word)
    }

    fun Remove(id:Int){
       repository.Remove(id)
    }


}

