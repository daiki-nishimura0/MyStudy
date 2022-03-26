package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
        Log.d("increment()","test")
    }

    fun main() {
        val close = increment()

        println(close())
        println(close())
    }
// クロージャ
    private fun increment(): ()->Int{
        var x = 0
        return {
            x++
            x
        }
    }
}