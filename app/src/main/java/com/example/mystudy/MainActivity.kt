package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // mapは読み取り専用
        // 文字列のキーバリューMAPを生成する
//        val map: Map<String, String> = mapOf("Pen" to "ぺん", "Apple" to "りんご", "Pineapple" to "パイナップル")
//        val value1 = map["Pen"]
//        val value2 = map["Pineapple"]
//        val value3 = map["Apple"]
//        val value4 = map["Pen"]
//        println("${value1},${value2},${value3},${value4},")

        // 型を変えて生成
        val map2: Map<Char, Int> = mapOf('a' to 1, 'b' to 2, 'c' to 3, 'z' to 26,)
        println(map2['a'])
        println(map2['b'])
        println(map2['c'])
        println(map2['z'])

        // 読み書きできるMAP
        val map3: MutableMap<String, String> = mutableMapOf("Pen" to "ぺん")
        map3.put("Apple", "アップル")
        map3.put("Pineapple", "パイナップル")
        val value1 = map3["Pen"]
        val value2 = map3["Pineapple"]
        val value3 = map3["Apple"]
        val value4 = map3["Pen"]
        println("${value1},${value2},${value3},${value4},")
    }
}