package com.example.crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.domain.TravelPlace
import logd

class MyAdapter(private val values: List<TravelPlace>): RecyclerView.Adapter<MyAdapter.TravelPlaceViewHolder>() {

    class TravelPlaceViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageUrl: AppCompatImageView = view.findViewById(R.id.image)
        val title: TextView = view.findViewById(R.id.title)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelPlaceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_travelplace,parent,false);

        return TravelPlaceViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: TravelPlaceViewHolder, position: Int) {

        val currentItem = values[position]
        holder.title.text = currentItem.name

        with(holder.itemView) {
            tag = currentItem.id
            setOnClickListener(onClickListener)
        }

    }

    private val onClickListener: View.OnClickListener = View.OnClickListener { v ->
        val item = v.tag.toString()
        logd("onCreate: $item")

        var bundle = bundleOf("id_travelplace" to item)
        Navigation.findNavController(v).navigate(R.id.description,bundle);
    }

//    internal fun setWords(words: List<Word>) {
//        this.words = words
//        notifyDataSetChanged()
//    }


    override fun getItemCount(): Int {
        return values.size
    }

    public interface ContentListener {
        fun onItemClicked(item: TravelPlace)
    }
}

