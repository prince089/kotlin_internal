package com

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
//import com.cahrusat.sqlitedemodiv1.MainActivity
//import com.cahrusat.sqlitedemodiv1.R
import com.charusat.viswatest1.MyTable
import com.charusat.viswatest1.R
import kotlinx.android.synthetic.main.cardview.view.*

//import kotlinx.android.synthetic.main.card_item_layout.view.*


class Adapter(val context:Context,var arr:ArrayList<MyTable>)
    :RecyclerView.Adapter<Adapter.PersonViewHolde>()

{


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {
//        var inflater=LayoutInflater.from(parent.context)
//        var view= inflater.inflate(R.layout.cardview,parent,false)
//        return PersonViewHolde(view)
//    }
//
//    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
//        holder.bind(arr[position])
//
//    }
//
//    override fun getItemCount(): Int {
//        return  arr.size
//    }

    class PersonViewHolde(var view:View):RecyclerView.ViewHolder(view)
    {
        fun bind(p:MyTable)
        {
            view.tid.setText(p.id.toString())
            view.tname.setText(p.name.toString())
            view.tlname.setText(p.lname.toString())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolde {

        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.cardview,parent,false)
        return PersonViewHolde(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolde, position: Int) {
        holder.bind(arr[position])
    }

    override fun getItemCount(): Int {
        return  arr.size
    }
}