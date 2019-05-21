package io.arunbuilds.rxjavaplayground

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.v("Inside onCreate:")

        createZip().subscribe { a ->
            Timber.v(" data - $a")
        }
    }


    fun createZip(): Observable<String> {
        val firstNames = Observable.just("Arun", "akshaya", "uma")
        val lastNames = Observable.just("Sudharsan", "Nallathambi", "maheswari")
        return firstNames.zipWith(lastNames, BiFunction { first, last ->
            "$first $last"
        })
    }


}
