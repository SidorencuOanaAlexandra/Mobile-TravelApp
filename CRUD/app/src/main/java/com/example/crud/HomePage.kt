package com.example.crud

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.domain.TravelPlace
import com.example.crud.repo.Repository
import com.example.crud.viewmodel.HomePageViewModel
import com.example.crud.viewmodel.MyViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import logd


class HomePage : Fragment() {

    private val viewModel: HomePageViewModel by activityViewModels()
    private lateinit var recycleView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_page_fragment, container, false)
        recycleView = view.findViewById(R.id.myrecyclerview)

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton2).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.add2);

        }


        return view;
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = Repository();
        val myAdapter = MyAdapter(viewModel.getAllData())
        //factory = MyViewModelFactory(repository)
//        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        //viewModel = ViewModelProvider(this,factory).get(HomePageViewModel::class.java)
        viewModel.travelPlaceList.observe(viewLifecycleOwner, Observer<List<TravelPlace>>(){
            logd("onCreate: $it")
            //myAdapter.update
        })
        recycleView.adapter = myAdapter
    }


}