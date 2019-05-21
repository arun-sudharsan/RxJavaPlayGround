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

       val subscription =  createFromArray().subscribe{
            arr-> println("Received array ${Arrays.toString(arr)}")
        }
    }

    private fun createFromArray() = Observable.fromArray(arrayOf(1, 2, 3, 4, 5, 6))
}

