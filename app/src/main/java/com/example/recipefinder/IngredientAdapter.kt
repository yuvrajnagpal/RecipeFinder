package com.example.recipefinder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.ingredient_item.view.*

class IngredientAdapter(val ingredients:ArrayList<String>):BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view=LayoutInflater.from(parent!!.context).inflate(R.layout.ingredient_item,parent,false)

        view.ingredient.text=ingredients[position]
        return view
    }

    override fun getItem(position: Int): Any {

        return ingredients[position]

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {

        return ingredients.size
    }


}