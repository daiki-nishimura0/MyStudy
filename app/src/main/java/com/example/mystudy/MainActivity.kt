package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    // 例外を意図的に起こす
    fun main(args: Array<String>) {
        try {
            // 成功時の処理
            val number = args[0].toInt()
            println(number)
        } catch (e: NumberFormatException) {
            // 例外発生時の処理
            println("「${args[0]}」という文字は数字に変換できない")
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("文字を入力してください")
        } catch (e: Exception) {
            println("想定外エラー")
            // 何がおきてもとりあえず出力したいもの
        }finally {
            println("thank!")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("あいう", "えおおえ")

        main(name)
        //  例外処理
//        val text = "例外"
//        try {
//            // 成功時の処理
//            val number = text.toInt()
//            println(number)
//            // String型の変数textにIntに変換できるものがない為以下のExptionが発生
//        } catch (e: NumberFormatException) {
//            // 例外発生時の処理
//            println("「${text}」という文字は数字に変換できない")
//        }
    }
}