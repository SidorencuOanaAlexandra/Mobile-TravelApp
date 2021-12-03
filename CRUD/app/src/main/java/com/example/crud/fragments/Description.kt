package com.example.crud.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.crud.R
import com.example.crud.domain.TravelPlace
import com.example.crud.viewmodel.HomePageViewModel
import com.example.crud.viewmodel.MyViewModelFactory
import logd
import android.view.Gravity
import android.widget.ImageButton
import androidx.lifecycle.Observer
import com.example.crud.MyAdapter
import com.example.crud.repo.Repository
import com.google.android.material.dialog.MaterialDialogs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = null
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Description.newInstance] factory method to
 * create an instance of this fragment.
 */
class Description : Fragment() {
    // TODO: Rename and change types of parameters
    private var id: String? = null
    private val viewModel: HomePageViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString("id_travelplace")
            logd("onCreate: $id")
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val myview = inflater.inflate(R.layout.fragment_description, container, false)

        val myTravelPlace = id?.let { viewModel.getTravelPlaceWithId(it) } as TravelPlace
        logd("onCreate: $myTravelPlace")

        val name_field = myview.findViewById<EditText>(R.id.name_edit);
        name_field.setText(myTravelPlace.name).toString();
        val city_field = myview.findViewById<EditText>(R.id.city_edit);
        city_field.setText(myTravelPlace.city).toString();
        val lat_field = myview.findViewById<EditText>(R.id.lat_edit);
        lat_field.setText(myTravelPlace.lat).toString();
        val long_field = myview.findViewById<EditText>(R.id.long_edit);
        long_field.setText(myTravelPlace.long).toString();
        val description_field = myview.findViewById<EditText>(R.id.description_edit);
        description_field.setText(myTravelPlace.description).toString();
        val availability_field = myview.findViewById<EditText>(R.id.availability_edit);
        availability_field.setText(myTravelPlace.availability).toString();
        val img_field = myview.findViewById<EditText>(R.id.imgUrl_edit);
        img_field.setText(myTravelPlace.imgUrl).toString();


        myview.findViewById<TextView>(R.id.button).setOnClickListener{

            var elem = name_field.text.toString()

            var new_travelPlace = TravelPlace(myTravelPlace.id,name_field.text.toString(),city_field.text.toString(),lat_field.text.toString(),long_field.text.toString(),description_field.text.toString(),availability_field.text.toString(),img_field.text.toString())


            update(myTravelPlace,new_travelPlace)
        }
        val myButton: ImageButton = myview.findViewById(R.id.imageButton2) as ImageButton
        myButton.setOnClickListener{
//            var dialog = DialogRemove()

            var builder = AlertDialog.Builder(activity)
            builder.setTitle("Are you sure you want to delete this item?")
            //builder.setMessage("ceva")
            builder.setPositiveButton("Yes",DialogInterface.OnClickListener{
                dialog, id ->
                delete()
               // Toast.makeText(getActivity(), "Item sters!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(myview).navigate(R.id.homePage);

            })
            builder.setNegativeButton("No",DialogInterface.OnClickListener{
                    dialog, id ->

            })
            var alert = builder.create()
            alert.show()

        }

        return myview;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val repository = Repository();
        //factory = MyViewModelFactory(repository)
//        viewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)
        //viewModel = ViewModelProvider(this,factory).get(HomePageViewModel::class.java)
        viewModel.travelPlaceList.observe(viewLifecycleOwner, Observer<List<TravelPlace>>(){

        })
    }

    fun delete(){
        viewModel.Remove(id.toString())
    }


    fun update(old_item:TravelPlace, new_item:TravelPlace){
        var error_mess = ""
        var iden = 0
        if (new_item.name == "")
            error_mess = error_mess + "Name field invalid!\n"
        if(new_item.name == old_item.name)
            iden+=1
        if (new_item.city == "")
            error_mess = error_mess + "City field invalid!\n"
        if(new_item.city == old_item.city)
            iden+=1
        if (new_item.lat == "")
            error_mess = error_mess + "Lat field invalid!\n"
        if(new_item.lat == old_item.lat)
            iden+=1
        if (new_item.long == "")
            error_mess = error_mess + "Long field invalid!\n"
        if(new_item.long == old_item.long)
            iden+=1
        if (new_item.description == "")
            error_mess = error_mess + "Description field invalid!\n"
        if(new_item.description == old_item.description)
            iden+=1
        if (new_item.availability == "")
            error_mess = error_mess + "Availability field invalid!\n"
        if(new_item.availability == old_item.availability)
            iden+=1
        if (new_item.imgUrl == "")
            error_mess = error_mess + "ImgUrl field invalid!\n"
        if(new_item.imgUrl == old_item.imgUrl)
            iden+=1


            if(error_mess!=""){
                Toast.makeText(getActivity(), error_mess, Toast.LENGTH_SHORT).show();
            }else{
                if(iden==7){
                    Toast.makeText(getActivity(), "Nu exista modificari", Toast.LENGTH_SHORT).show();
                }else{
                    viewModel.Update(old_item.id,new_item);
                    Toast.makeText(getActivity(), "Update Ok!", Toast.LENGTH_SHORT).show();
                }
            }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Description.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            Description().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    //putString(ARG_PARAM2, param2)
//                }
//            }
//
//        @JvmStatic
//        fun newInstance(param1: TravelPlace, param2: String) =
//            Description().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    //putString(ARG_PARAM2, param2)
//                }
//            }
    }
}