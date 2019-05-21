package io.arunbuilds.rxjavaplayground

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.v("Inside onCreate:")


      val s =   createFilter().subscribe { a ->
            Timber.v("$a is printed")
        }

    }


    private fun createInterval() = Observable
        .interval(1, TimeUnit.SECONDS)
        .takeWhile { v -> v < 20 }

    private fun createTimer() = Observable
        .timer(5, TimeUnit.SECONDS)


    private fun createFilter() = Observable.just(1,3,4,5,6,7,8,9,10,11)
        .filter{
            it%2==0
        }
}

