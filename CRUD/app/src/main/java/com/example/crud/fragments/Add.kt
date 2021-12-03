package com.example.crud.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.crud.R
import com.example.crud.domain.TravelPlace
import com.example.crud.viewmodel.HomePageViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [add.newInstance] factory method to
 * create an instance of this fragment.
 */
class add : Fragment() {
    // TODO: Rename and change types of parameters
    private val viewModel: HomePageViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var myview = inflater.inflate(R.layout.fragment_add, container, false)

        val name_field = myview.findViewById<EditText>(R.id.name_edit);
        val city_field = myview.findViewById<EditText>(R.id.city_edit);
        val lat_field = myview.findViewById<EditText>(R.id.lat_edit);
        val long_field = myview.findViewById<EditText>(R.id.long_edit);
        val description_field = myview.findViewById<EditText>(R.id.description_edit);
        val availability_field = myview.findViewById<EditText>(R.id.availability_edit);
        val img_field = myview.findViewById<EditText>(R.id.imgUrl_edit);

        myview.findViewById<TextView>(R.id.button).setOnClickListener{

            var new_travelPlace = TravelPlace("",name_field.text.toString(),city_field.text.toString(),lat_field.text.toString(),long_field.text.toString(),description_field.text.toString(),availability_field.text.toString(),img_field.text.toString())
            Add(new_travelPlace)
        }

        return myview
    }

    fun Add(new_item: TravelPlace){
        var error_mess = ""
        var iden = 0
        if (new_item.name == "")
            error_mess = error_mess + "Name field invalid!\n"
        if (new_item.city == "")
            error_mess = error_mess + "City field invalid!\n"
        if (new_item.lat == "")
            error_mess = error_mess + "Lat field invalid!\n"
        if (new_item.long == "")
            error_mess = error_mess + "Long field invalid!\n"
        if (new_item.description == "")
            error_mess = error_mess + "Description field invalid!\n"
        if (new_item.availability == "")
            error_mess = error_mess + "Availability field invalid!\n"
        if (new_item.imgUrl == "")
            error_mess = error_mess + "ImgUrl field invalid!\n"


        if(error_mess!=""){
            Toast.makeText(getActivity(), error_mess, Toast.LENGTH_SHORT).show();
        }else{
                viewModel.Add(new_item)
                Toast.makeText(getActivity(), "Add Ok!", Toast.LENGTH_SHORT).show()
        }

    }


}