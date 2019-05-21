package io.arunbuilds.rxjavaplayground

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.v("Inside onCreate:")


       // val professor = PublishSubject.create<String>()
        //val professor = ReplaySubject.create<String>()
        //val professor = BehaviourSubject.create<String>()
        val professor = AsyncSubject.create<String>()

        //first student joins class
        professor.subscribe(getFirstStudent())

        professor.onNext("c")
        professor.onNext("c++")
        professor.onNext("python")

        professor.subscribe(getLastStudent())

        professor.onNext("Java")
        professor.onNext("Kotlin")
        professor.onNext("Rxjava")

        professor.onComplete()


    }


    /*
    Check comments:
    1.publish subject bad professor (no teaching again)
    2.replay subject Good professor (teaches everyting again)
    3.behaviour subject smart professor (only teaches last session)
    4. async subject only last session is taken and completed.

 PublishSubject :                                                                                           First Student is joined.
 First Student Learns c
 First Student Learns c++
 First Student Learns python
 Last Student is joined.
 First Student Learns Java
 Last Student Learns Java
 First Student Learns Kotlin
 Last Student Learns Kotlin
 First Student Learns Rxjava
 Last Student Learns Rxjava
 First Student : Class is Over.
 Last Student : Class is Over.



ReplaySubject:
First Student is joined.
First Student Learns c
First Student Learns c++
First Student Learns python
Last Student is joined.
Last Student Learns c
Last Student Learns c++
Last Student Learns python
First Student Learns Java
Last Student Learns Java
First Student Learns Kotlin
Last Student Learns Kotlin
First Student Learns Rxjava
Last Student Learns Rxjava
First Student : Class is Over
Last Student : Class is Over.



BehaviourSubject :
First Student is joined.
First Student Learns c
First Student Learns c++
First Student Learns python
 Last Student is joined.
 Last Student Learns python
First Student Learns Java
 Last Student Learns Java
First Student Learns Kotlin
 Last Student Learns Kotlin
First Student Learns Rxjava
 Last Student Learns Rxjava
First Student : Class is Over.
 Last Student : Class is Over.

 Async Subject:
First Student is joined.
Last Student is joined.
First Student Learns Rxjava
First Student : Class is Over
Last Student Learns Rxjava
Last Student : Class is Over.


     */

    private fun getFirstStudent() = object : Observer<String> {
        override fun onComplete() {
            Timber.v("First Student : Class is Over.")
        }

        override fun onSubscribe(d: Disposable) {
            Timber.v("First Student is joined.")
        }

        override fun onNext(t: String) {
            Timber.v(
                "First Student Learns $t"
            )
        }

        override fun onError(e: Throwable) {
            Timber.v("First student error. ${e.message}")
        }

    }

    private fun getLastStudent() = object : Observer<String> {
        override fun onComplete() {
            Timber.v("Last Student : Class is Over.")
        }

        override fun onSubscribe(d: Disposable) {
            Timber.v("Last Student is joined.")
        }

        override fun onNext(t: String) {
            Timber.v(
                "Last Student Learns $t"
            )
        }

        override fun onError(e: Throwable) {
            Timber.v("Last student error. ${e.message}")
        }

    }

}
