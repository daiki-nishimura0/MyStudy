package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.mystudy.api.ApiRequests
import com.example.mystudy.api.CatJson
import com.example.mystudy.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://cat-fact.herokuapp.com"

class MainActivity : AppCompatActivity() {

    private var TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        getCurrentData()

        binding.layoutGenerateNewFact.setOnClickListener {
            getCurrentData()
        }
    }

    private fun getCurrentData() {

        binding.tvTextView.visibility = View.INVISIBLE
        binding.tvTimeStamp.visibility = View.INVISIBLE
        binding.progressBar.visibility = View.VISIBLE

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequests::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response: Response<CatJson> = api.getCatFacts().awaitResponse()
                if (response.isSuccessful) {
                    val data: CatJson = response.body()!!
                    Log.d(TAG, data.text)

                    withContext(Dispatchers.Main) {
                        binding.tvTextView.visibility = View.VISIBLE
                        binding.tvTimeStamp.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE

                        binding.tvTextView.text = data.text
                        binding.tvTimeStamp.text = data.createdAt
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    Toast.makeText(
                        applicationContext,
                        "Seems like something went wrong...",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }
}