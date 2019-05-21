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

        createConcat().subscribe{
            a->Timber.v(" data - $a")
        }
    }

    fun createMerge(): Observable<Int> {
        val first = Observable.just(1,2,3)
        val second = Observable.just(4,5,6)
        return first.mergeWith(second)

    }

    fun createConcat(): Observable<Int> {
        val first = Observable.just(1,2,3)
        val second = Observable.just(4,5,6)
        return first.concatWith(second)

    }


    /*
    a quick note is that if the sources are synchronous then then merge = concat
     */

   /*

    Observable.merge(
    Observable.interval(1, TimeUnit.SECONDS).map(id -> "A" + id),
    Observable.interval(1, TimeUnit.SECONDS).map(id -> "B" + id))
    .subscribe(System.out::println);
    A0 B0 A1 B1 B2 A2 B3 A3 B4 A4

    versus

    Observable.concat(
    Observable.interval(1, TimeUnit.SECONDS).map(id -> "A" + id),
    Observable.interval(1, TimeUnit.SECONDS).map(id -> "B" + id))
    .subscribe(System.out::println);
    A0 A1 A2 A3 A4 A5 A6 A7 A8
    */
}
