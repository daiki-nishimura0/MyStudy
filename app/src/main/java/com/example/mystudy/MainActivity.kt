package com.example.mystudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.concurrent.atomic.AtomicBoolean

class MainActivity : AppCompatActivity() {
    //スタートボタンを押すとスレッドを新規作成し１秒ごとにカウンタを１増加させる

    var mWorker: Thread? = null
    var running = AtomicBoolean(false)
    var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.start).setOnClickListener {
            runWoker()
        }

        findViewById<Button>(R.id.stop).setOnClickListener {
            interrupWoker()
        }
    }

    fun runWoker(){
        running.set(true)
        mWorker = Thread {
            while (running.get()) {
                try {
                    Thread.sleep(1000)
                    counter++
                    println("counter $counter")
                } catch (ex: InterruptedException) {
                    Thread.currentThread().interrupt()
                    println("スレッドを中断。操作失敗")
                }
            }
        }
        mWorker?.start()
    }

    fun interrupWoker() {
        running.set(false)
        mWorker?.interrupt()
    }
}