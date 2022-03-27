package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // 高階関数の学習
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val p = ::calculatePlus
        val m = ::calculateMinus
        printRandomValuesCaluclation(p)
        printRandomValuesCaluclation(m)
    }
    // 足し算をする関数の定義
    fun calculatePlus(x: Double, y: Double) = x + y
    // 引き算をする関数の定義
    fun calculateMinus(x: Double, y: Double) = x - y
    // 関数をうけとって、実行する関数
    fun printRandomValuesCaluclation(calculator: (Double,Double) -> Double) {
        val x = Math.random()
        val y = Math.random()
        val result = calculator(x, y)
        println("計算結果${result}")
    }
}