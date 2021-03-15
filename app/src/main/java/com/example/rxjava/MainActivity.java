package com.example.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable observable = Observable.just(0,1,2,3,4);

//        Observable observable = Observable.create(new ObservableOnSubscribe<Object>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Throwable {
//                for (int i = 0 ; i < 5 ; i++) {
//                    emitter.onNext(i);
//                }
//                emitter.onComplete();
//            }
//        });


        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull Object o) {
                Log.d(TAG, "onNext: " + o);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        observable.subscribe(observer);

//        PublishSubject<String> subject = PublishSubject.create();
//        subject.subscribe(i -> Log.d(TAG,"onCreate: student 1:" + i));
//        subject.onNext("A");
//        sleep(1000);
//        subject.onNext("B");
//        sleep(1000);
//        subject.onNext("C");
//        sleep(1000);
//        subject.onNext("D");
//        sleep(1000);
//        subject.subscribe(i -> Log.d(TAG,"onCreate: student 2:" + i));
//        subject.onNext("E");
//        sleep(1000);
//        subject.onNext("F");
//        sleep(1000);
//        subject.onNext("G");
//        sleep(1000);


//        Observable<Long> cold = Observable
//                .intervalRange(0, 5, 0, 1, TimeUnit.SECONDS);
//
//        ConnectableObservable<Long> hot = ConnectableObservable
//                .intervalRange(0, 5, 0, 1, TimeUnit.SECONDS).publish();
//        hot.connect();
//
//        hot.subscribe(i -> Log.d(TAG,"onCreate: student 1:" + i));
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        hot.subscribe(i -> Log.d(TAG,"onCreate: student 2:" + i));


    }

    public void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}