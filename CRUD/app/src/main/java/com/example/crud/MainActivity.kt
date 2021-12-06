package com.example.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.crud.domain.TravelPlace
import com.example.crud.repo.Repository
import com.example.crud.repo.roomRepo.RoomDataBase
import com.example.crud.viewmodel.HomePageViewModel
import com.example.crud.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var factory: MyViewModelFactory
    private lateinit var viewModel: HomePageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordsDao = RoomDataBase.getDatabase(application, this.application).travelPlaceDao()
        val repository = Repository(wordsDao);
        factory = MyViewModelFactory(repository);
//        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        viewModel = ViewModelProvider(this,factory).get(HomePageViewModel::class.java)




    }
}