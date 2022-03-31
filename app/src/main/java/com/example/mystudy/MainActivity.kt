package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    // 例外を意図的に起こす
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  例外処理
        val text = "例外"
        try {
            // 成功時の処理
            val number = text.toInt()
            println(number)
            // String型の変数textにIntに変換できるものがない為以下のExptionが発生
        } catch (e: NumberFormatException) {
            // 例外発生時の処理
            println("「${text}」という文字は数字に変換できない")
        }
    }
}