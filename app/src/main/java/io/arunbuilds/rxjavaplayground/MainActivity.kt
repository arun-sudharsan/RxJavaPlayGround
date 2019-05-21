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


      createTimeout("arun").subscribe ({
          a->Timber.v("Data is successfully reached.")
      },{
          e->Timber.v("Error - ${e.message}")
      })
    }

    fun createTimeout(name : String): Observable<String> = Observable.fromCallable{
        if(name=="arun")
            Thread.sleep(150)
        name
    }.timeout(100,TimeUnit.MILLISECONDS)



}

