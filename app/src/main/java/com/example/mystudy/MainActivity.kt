package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // ラムダの学習
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        println(lambda1(2))
//        println(lambda2(2))
//        println(lambda3(2))

        main()
    }

    val lambda1: (Int) -> Int = { x: Int ->
        x + x
    }
    val lambda2: (Int) -> Int = fun(x: Int): Int {
        return x + x
    }
    val lambda3: (Int) -> Int = fun(x: Int) = x + x

    fun main() {
        val func1: (String) -> String = fun(x: String): String {
            return x + "ちゃん"
        }
        val func2: (String) -> String = fun(x: String) = x + "ちゃん"
        val func3: (String) -> String = {x -> x + "ちゃん"}
        val func4: (String) -> String = {it + "ちゃん"}

        val result1 = func2("たけし")
        val result2 = func3("たけし")
        val result3 = func4("たけし")

        println(result1)
        println(result2)
        println(result3)
    }

}
