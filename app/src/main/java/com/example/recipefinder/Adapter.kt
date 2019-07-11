package com.example.recipefinder

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.meal_item.view.*

class Adapter(val context: Context,val meals:ArrayList<Meal>):RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.meal_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return  meals.size

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.bindview(meals[p1])
        p0.itemView.setOnClickListener {


            val intent=Intent(context,MealDetail::class.java)
            val ingredietnts=ArrayList<String>()
            ingredietnts.add(meals[p1].strIngredient1!!)
            ingredietnts.add(meals[p1].strIngredient2!!)
            ingredietnts.add(meals[p1].strIngredient3!!)
            ingredietnts.add(meals[p1].strIngredient4!!)
            ingredietnts.add(meals[p1].strIngredient5!!)
            ingredietnts.add(meals[p1].strIngredient6!!)
            ingredietnts.add(meals[p1].strIngredient7!!)
            ingredietnts.add(meals[p1].strIngredient8!!)
            ingredietnts.add(meals[p1].strIngredient9!!)
            ingredietnts.add(meals[p1].strIngredient10!!)
            ingredietnts.add(meals[p1].strIngredient11!!)
            ingredietnts.add(meals[p1].strIngredient12!!)
            ingredietnts.add(meals[p1].strIngredient13!!)
            ingredietnts.add(meals[p1].strIngredient14!!)
            ingredietnts.add(meals[p1].strIngredient15!!)
            ingredietnts.add(meals[p1].strIngredient16!!)
            ingredietnts.add(meals[p1].strIngredient17!!)
            ingredietnts.add(meals[p1].strIngredient18!!)
            ingredietnts.add(meals[p1].strIngredient19!!)
            ingredietnts.add(meals[p1].strIngredient20!!)
            intent.putExtra("video",meals[p1].strYoutube)
            intent.putExtra("instruction",meals[p1].strInstruction)
            intent.putStringArrayListExtra("ingredients",ingredietnts)



            context.startActivity(intent)
        }
    }


    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){


        fun bindview(meal: Meal){



             Picasso.get()
                .load(meal.image)
                .placeholder(R.drawable.ic_image_black_24dp)
                .into(itemView.meal_image)
            itemView.meal_name.text=meal.name
        }


    }



}