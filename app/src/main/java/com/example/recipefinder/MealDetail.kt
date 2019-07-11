package com.example.recipefinder

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_meal_detail.*

class MealDetail : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)

        val extras=intent.extras
        val strVideo=extras.getString("video")
        val strInstrction=extras.getString("instruction")
        val split=strVideo.split("=")
        val videoid=split[1]

        val ingredientsList=extras.getStringArrayList("ingredients")
        val filteredingredientList=ArrayList<String>()


      video.initialize("AIzaSyAagvMyIfqf1SBUf9vmzmyNvqUFyg3jeIw",object :YouTubePlayer.OnInitializedListener{
          override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {

             p1!!.cueVideo(videoid)
          }

          override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

          }

      })




        instruction.movementMethod=ScrollingMovementMethod.getInstance()
        instruction.text=strInstrction


                ingredients.adapter=IngredientAdapter(ingredientsList)




    }
}
