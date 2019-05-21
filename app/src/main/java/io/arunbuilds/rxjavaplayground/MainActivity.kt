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

        createFlatMap().subscribe { a ->
            Timber.v(" data - $a")
        }
    }


    fun createMap() = Observable.just(1, 2, 3, 4)
        .map { z -> z * 2 }

    fun createFlatMap(): Observable<String> = Observable.just("arunm619", "drogon", "kavinlaxman", "wwe", "keerthi")
        .flatMap { id ->
            getUserFullName(id)
        }

    private fun getUserFullName(id: String): Observable<String> {
        return when (id) {
            "wwe" -> Observable.just("WWE")
            "arunm619" -> Observable.just("Arun sudharsan")
            "drogon" -> Observable.just("Thenmugilan")
            "kavinlaxman" -> Observable.just("Kavin Rama Laxman")
            else -> Observable.empty<String>()
        }
    }
}
