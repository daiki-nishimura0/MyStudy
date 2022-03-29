package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // ラムダの学習

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    println(lambda(2))

    }
    val lambda: (Int) -> Int = { i: Int ->
        i + i
    }
}