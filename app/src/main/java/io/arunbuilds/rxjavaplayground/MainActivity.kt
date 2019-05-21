package io.arunbuilds.rxjavaplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datastream = Observable.just(1,2,3,4,5)
        val dataObserver = object : Observer<Int>{
            override fun onComplete() {
                println("All the data has been received")
            }

            override fun onSubscribe(d: Disposable) {
            println("Subscription: is Disposed? ${d.isDisposed}")
            }

            override fun onNext(t: Int) {
            println("The data received is $t")
            }

            override fun onError(e: Throwable) {
            println(e.localizedMessage)
            }

        }

        datastream.subscribe(dataObserver)
    }
}


/*
Console Log:

05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: Subscription: is Disposed? false
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: The data received is 1
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: The data received is 2
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: The data received is 3
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: The data received is 4
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: The data received is 5
05-21 13:27:52.563 11881-11881/io.arunbuilds.rxjavaplayground I/System.out: All the data has been received*/