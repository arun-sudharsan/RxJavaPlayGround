package io.arunbuilds.rxjavaplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val subscription =  createFromRange(1,3).subscribe{
            arr-> println("Received item is ${arr}")
        }
    }

    private fun createFromArray() = Observable.fromArray(arrayOf(1, 2, 3, 4, 5, 6))

    private fun createFromIterable() = Observable.fromIterable(mutableListOf(1, 2, 3, 4, 5, 6))

    private fun createFromRange(start:Int = 0 ,count: Int = 10) = Observable.range(start,count).repeat(3)
}

