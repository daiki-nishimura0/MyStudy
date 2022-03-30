package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // ラムダの学習

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(lambda1(2))
        println(lambda2(2))
        println(lambda3(2))

    }

    val lambda1: (Int) -> Int = { x: Int ->
        x + x
    }
    val lambda2: (Int) -> Int = fun(x: Int): Int {
        return x + x
    }
    val lambda3: (Int) -> Int = fun(x: Int) = x + x
}