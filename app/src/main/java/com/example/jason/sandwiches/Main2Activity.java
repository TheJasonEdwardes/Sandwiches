package com.example.jason.sandwiches;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    public static Activity secondActivity;
    boolean ButtonOn = false;
    String myfill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondActivity = this;
        setContentView(R.layout.activity_main2);

        Button TunaMayo = (Button) findViewById(R.id.tuna_mayo);
        TunaMayo.setOnClickListener(this);

        Button tuna_mayo_cucumber = (Button) findViewById(R.id.tuna_mayo_cucumber);
        tuna_mayo_cucumber.setOnClickListener(this);

        Button prawn_in_seafood_sauce = (Button) findViewById(R.id.prawn);
        prawn_in_seafood_sauce.setOnClickListener(this);


        Button salad = (Button) findViewById(R.id.salad);
        salad.setOnClickListener(this);

        Button egg_mayo = (Button) findViewById(R.id.egg_mayo);
        egg_mayo.setOnClickListener(this);

        Button sliced_egg_and_tomato = (Button) findViewById(R.id.sliced_egg);
        sliced_egg_and_tomato.setOnClickListener(this);

        Button cheese = (Button) findViewById(R.id.cheese);
        cheese.setOnClickListener(this);

        Button cheese_and_pickel = (Button) findViewById(R.id.cheese_and_pickel);
        cheese_and_pickel.setOnClickListener(this);

        Button brie_and_cranberry = (Button) findViewById(R.id.brie_and_cranberry);
        brie_and_cranberry.setOnClickListener(this);

        Button ham_and_cheese = (Button) findViewById(R.id.ham_and_cheese);
        ham_and_cheese.setOnClickListener(this);

        Button chicken_and_bacon = (Button) findViewById(R.id.Chicken_and_bacon);
        chicken_and_bacon.setOnClickListener(this);

        Button chicken_and_bacon_sweetcorn = (Button) findViewById(R.id.chicken_and_bacon_sweetcorn);
        chicken_and_bacon_sweetcorn.setOnClickListener(this);

        Button coronation_chicken = (Button) findViewById(R.id.coronation_chicken);
        coronation_chicken.setOnClickListener(this);

        Button chicken_tikka = (Button) findViewById(R.id.chicken_tikka);
        chicken_tikka.setOnClickListener(this);

        Button chicken = (Button) findViewById(R.id.chicken);
        chicken.setOnClickListener(this);


        Button ham = (Button) findViewById(R.id.ham);
        ham.setOnClickListener(this);

        Button ham_and_pickel = (Button) findViewById(R.id.ham_and_pickel);
        ham_and_pickel.setOnClickListener(this);

        Button ham_and_egg = (Button) findViewById(R.id.ham_and_egg);
        ham_and_egg.setOnClickListener(this);

        Button blt = (Button) findViewById(R.id.blt);
        blt.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tuna_mayo:
                myfill = getResources().getString(R.string.tuna_mayo);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.prawn:
                myfill = getResources().getString(R.string.prawn_in_seafood_sauce);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.tuna_mayo_cucumber:
                myfill = getResources().getString(R.string.tuna_mayo_and_cucumber);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.chicken_and_bacon_sweetcorn:
                myfill = getResources().getString(R.string.chicken_bacon_and_sweetcorn);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.coronation_chicken:
                myfill = getResources().getString(R.string.coronation_chicken);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.salad:
                myfill = getResources().getString(R.string.salad);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.egg_mayo:
                myfill = getResources().getString(R.string.egg_mayo);
                ButtonOn = true;
                myButtonPressed();
                break;
            case R.id.sliced_egg:
                myfill = getResources().getString(R.string.sliced_egg);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.cheese:
                myfill = getResources().getString(R.string.cheese);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.cheese_and_pickel:
                myfill = getResources().getString(R.string.cheese_and_pickel);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.brie_and_cranberry:
                myfill = getResources().getString(R.string.brie_and_cranberry);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.ham_and_cheese:
                myfill = getResources().getString(R.string.ham_and_cheese);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.Chicken_and_bacon:
                myfill = getResources().getString(R.string.chicken_and_bacon);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.chicken_tikka:
                myfill = getResources().getString(R.string.chicken_tikka);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.chicken:
                myfill = getResources().getString(R.string.chicken);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.blt:
                myfill = getResources().getString(R.string.BLT);
                ButtonOn = true;
                myButtonPressed();
                break;
            case R.id.ham:
                myfill = getResources().getString(R.string.ham);
                ButtonOn = true;
                myButtonPressed();
                break;

            case R.id.ham_and_pickel:
                myfill = getResources().getString(R.string.ham_and_pickel);
                ButtonOn = true;
                myButtonPressed();
                break;
            case R.id.ham_and_egg:
                myfill = getResources().getString(R.string.ham_and_egg);
                ButtonOn = true;
                myButtonPressed();
                break;
        }
    }

    public void myButtonPressed() {
        if (ButtonOn) {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("filling", ("" + myfill));
            startActivity(intent);
        }
    }
}