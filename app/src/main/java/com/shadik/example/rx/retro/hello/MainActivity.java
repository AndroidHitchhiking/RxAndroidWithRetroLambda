package com.shadik.example.rx.retro.hello;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private TextView textViewHello;
    private Button buttonChangeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //lambda Expression
        fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
        );

        textViewHello = (TextView) findViewById(R.id.textViewHello);
        buttonChangeText = (Button) findViewById(R.id.buttonChangeText);

        helloText();
        //lambda Expression
        buttonChangeText.setOnClickListener(v -> changeText());
    }

    private void helloText() {
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(textViewUpdate);
    }

    private void changeText() {
        observableUpdate.observeOn(AndroidSchedulers.mainThread());// For observing the result on Main Thread
        observableUpdate.subscribe(textViewUpdate);
        buttonChangeText.setVisibility(View.GONE);
    }

    //Observer For Default text Hello Developer
    Observable.OnSubscribe rxAction = new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello, Developer!");
            subscriber.onCompleted();
        }
    };
    Observable<String> observable = Observable.create(rxAction);

    //Observer for Button click change text
    Observable.OnSubscribe rxActionChangeText = new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Text Updated!");
            subscriber.onCompleted();
        }
    };
    Observable<String> observableUpdate = Observable.create(rxActionChangeText);

    Subscriber<String> textViewUpdate = new Subscriber<String>() {
        public void onCompleted() {
        }

        public void onError(Throwable e) {
        }

        public void onNext(String s) {
            textViewHello.setText(s);
        }
    };


}
