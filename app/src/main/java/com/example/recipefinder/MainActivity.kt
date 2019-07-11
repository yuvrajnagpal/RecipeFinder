package com.example.recipefinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import android.widget.Toast
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import android.R.string
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.squareup.okhttp.Call
import com.squareup.okhttp.Callback

import java.io.IOException


class MainActivity : AppCompatActivity() {

   lateinit var requestQueue:RequestQueue
    lateinit var meals:ArrayList<Meal>
    lateinit var ingredients:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url="https://www.themealdb.com/api/json/v1/1/search.php?s"

        requestQueue=Volley.newRequestQueue(this)
        meals= ArrayList()
        ingredients= ArrayList()

        progressBar.visibility=View.VISIBLE

        getRecipes(url)


        search_bt.setOnClickListener {

            progressBar.visibility=View.VISIBLE
            meals.clear()
            val url="https://www.themealdb.com/api/json/v1/1/search.php?s=${search_et.text.toString()}"
            getRecipes(url)
        }



    }

    fun  getRecipes(url:String){




        val request=JsonObjectRequest(0,url,null, Response.Listener {


                val jsonArray = it.getJSONArray("meals")

                for (i in 0 until jsonArray.length()) {

                    val jsonObject = jsonArray.getJSONObject(i)
                    val mealname = jsonObject.getString("strMeal")
                    val mealimage = jsonObject.getString("strMealThumb")

                    val i1 = jsonObject.getString("strIngredient1") + " "  + jsonObject.getString("strMeasure1")
                    val i2 = jsonObject.getString("strIngredient2") + " " + jsonObject.getString("strMeasure2")
                    val i3 = jsonObject.getString("strIngredient3") + " " + jsonObject.getString("strMeasure3")
                    val i4 = jsonObject.getString("strIngredient4") + " " + jsonObject.getString("strMeasure4")
                    val i5 = jsonObject.getString("strIngredient5") + " " + jsonObject.getString("strMeasure5")
                    val i6 = jsonObject.getString("strIngredient6") + " " + jsonObject.getString("strMeasure6")
                    val i7 = jsonObject.getString("strIngredient7") + " " + jsonObject.getString("strMeasure7")
                    val i8 = jsonObject.getString("strIngredient8") + " " + jsonObject.getString("strMeasure8")
                    val i9 = jsonObject.getString("strIngredient9") + " " + jsonObject.getString("strMeasure9")
                    val i10 = jsonObject.getString("strIngredient10") + " " + jsonObject.getString("strMeasure10")
                    val i11 = jsonObject.getString("strIngredient11") + " " + jsonObject.getString("strMeasure11")
                    val i12 = jsonObject.getString("strIngredient12") + " " + jsonObject.getString("strMeasure12")
                    val i13 = jsonObject.getString("strIngredient13") + " " + jsonObject.getString("strMeasure13")
                    val i14 = jsonObject.getString("strIngredient14") + " " + jsonObject.getString("strMeasure14")
                    val i15 = jsonObject.getString("strIngredient15") + " " + jsonObject.getString("strMeasure15")
                    val i16 = jsonObject.getString("strIngredient16") + " " + jsonObject.getString("strMeasure16")
                    val i17 = jsonObject.getString("strIngredient17") + " " + jsonObject.getString("strMeasure17")
                    val i18 = jsonObject.getString("strIngredient18") + " " + jsonObject.getString("strMeasure18")
                    val i19 = jsonObject.getString("strIngredient19") + " " + jsonObject.getString("strMeasure19")
                    val i20 = jsonObject.getString("strIngredient20") + " " + jsonObject.getString("strMeasure20")

                    val strYoutube = jsonObject.getString("strYoutube")
                    val strInsructions = jsonObject.getString("strInstructions")


                    val meal = Meal(
                        mealimage, mealname, i1, i2, i3, i4, i5, i6, i7, i8, i9, i10,
                        i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, strYoutube, strInsructions
                    )
                    meals.add(meal)
                    meals_recycler.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
                    meals_recycler.adapter = Adapter(this, meals)

                    progressBar.visibility = View.GONE


                }



        }, Response.ErrorListener {

            Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
        })





        requestQueue.add(request)



    }


}




//                   ingredients.add(jsonObject.getString("strMeasure1"))
//                   ingredients.add(jsonObject.getString("strMeasure2"))
//                   ingredients.add(jsonObject.getString("strMeasure3"))
//                   ingredients.add(jsonObject.getString("strMeasure4"))
//                   ingredients.add(jsonObject.getString("strMeasure5"))
//                   ingredients.add(jsonObject.getString("strMeasure6"))
//                   ingredients.add(jsonObject.getString("strMeasure7"))
//                   ingredients.add(jsonObject.getString("strMeasure8"))
//                   ingredients.add(jsonObject.getString("strMeasure9"))
//                   ingredients.add(jsonObject.getString("strMeasure10"))
//                   ingredients.add(jsonObject.getString("strMeasure11"))
//                   ingredients.add(jsonObject.getString("strMeasure12"))
//                   ingredients.add(jsonObject.getString("strMeasure13"))
//                   ingredients.add(jsonObject.getString("strMeasure14"))
//                   ingredients.add(jsonObject.getString("strMeasure15"))
//                   ingredients.add(jsonObject.getString("strMeasure16"))
//                   ingredients.add(jsonObject.getString("strMeasure17"))
//                   ingredients.add(jsonObject.getString("strMeasure1"))