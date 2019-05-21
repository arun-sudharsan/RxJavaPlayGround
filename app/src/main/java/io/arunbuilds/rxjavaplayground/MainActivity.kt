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

        createStartWith().subscribe{
            a->Timber.v("the data - $a")
        }
    }

    fun createDistinct() = Observable.just(1,1,3,1,2,2,1,2,1,2)
        .distinctUntilChanged()
    //.distinct()

    fun createStartWith() = Observable.just("B","C","D","E").startWith("A")
}

