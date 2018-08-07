package com.example.jason.sandwiches;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView checkOrder; //check_order_textView - display the sandwich order
    Bundle bundle; // gets the string myfill from main3activity(sandwich filling)

    String bread = "white bread";
    String sandwich;
    TextView mytextview;
    String with = "";
    String name;
    String salad = "";
    String mayo = "";
    String bbq = "";
    String ketchup = "";
    String email;
    String department;
    String mysandwich;
    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bundle = getIntent().getExtras();
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        checkOrder = (TextView) findViewById(R.id.check_order_textView);
        myTextView();

    }

    public void myradiobutton(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.bloomer:
                bread = "bloomer";

                break;
            case R.id.white_bread:
                bread = "white bread";

                break;
            case R.id.brown_bread:
                bread = "brown bread";

                break;
            case R.id.wholemeal:
                bread = "wholemeal";

                break;
            case R.id.wrap:
                bread = "a wrap";
                break;
            default:
                bread = "white bread";

        }
        myText();

    }

    /**
     * @param view checkbox for user input to choice any extra's they would like
     */
    public void checkbox(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.salad:
                if (checked) {
                    salad = " salad ";

                } else {
                    salad = "";
                }

                break;
            case R.id.bbq:

                if (checked) {
                    if ((!salad.equals(""))) {
                        bbq = " ,BBQ";

                    } else {
                        bbq = " BBQ";
                    }
                } else {
                    bbq = "";
                }
                break;
            case R.id.mayo:

                if (checked) {
                    if ((!salad.equals("")) || (!bbq.equals(""))) {
                        mayo = " ,mayo";
                    } else {
                        mayo = "mayo";
                    }

                } else {
                    mayo = "";
                }
                break;
            case R.id.ketup:

                if (checked) {
                    if ((!salad.equals("")) || (!bbq.equals("")) || (!mayo.equals(""))) {
                        ketchup = " ,ketchup";
                    } else {
                        ketchup = "ketchup";
                    }

                } else {
                    ketchup = "";
                }
            }

        myText();

    }

    /**
     * chechOrder = R.id.check_order_textView
     * textview to display the sandwich filling radiobutton(bread) and checkbox(extra)
     */
    public void myText() {
        name = mPreferences.getString(getString(R.string.name), "");
        email = mPreferences.getString(getString(R.string.email), "");
        department = mPreferences.getString(getString(R.string.department), "");

        checkOrder.setText("I would like to order: \nFilling: " + sandwich + " \nBread: " + bread + "\nDressing: " + salad + bbq + mayo + ketchup + "\n\nname: " + name + "\nEmail: " + email + "\nDepartment: " + department);
        mysandwich = ("I would like to order: \n Filling:" + sandwich + "\n Bread: " + bread + "\n Dressing: " + salad + bbq + mayo + ketchup);
    }


    // gets the string value from the activity3main (sandwich filling)
    public void myTextView() {

        if (bundle != null) {
            sandwich = (String) bundle.get("filling");
        }

    }
    // send email intent Including sandwich order
    public void send(View view) {
        Intent intent = null, chooser = null;
        intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to = {"jasonedwardeseurope@gmail.com", email};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, "sandwich line ");
        intent.putExtra(Intent.EXTRA_TEXT, "Name:  " + name + "\n" + "Department: " + department + "\n\n" + mysandwich);
        intent.setType("message/rfc822");
        chooser = Intent.createChooser(intent, "send Email");
        startActivity(chooser);

        //lifeCycle finish all 3 activities

        MainActivity.firstActivity.finish();
        Main2Activity.secondActivity.finish();
        finish();

    }

}
