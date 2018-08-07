package com.example.jason.sandwiches;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String Tag = "login";
    public static Activity firstActivity;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private EditText mName,mEmail;
    private EditText mDepartment;
    private Button btn_login;
    private CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstActivity = this;
        mEmail = (EditText)findViewById(R.id.et_email);
        mName = (EditText)findViewById(R.id.et_name);
        mDepartment=(EditText)findViewById(R.id.et_deparment);
        btn_login = (Button)findViewById(R.id.btn_login);
        mCheckBox = (CheckBox)findViewById(R.id.checkbox);
        // takes the information and stores it to a file with the 4 parts
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // mEditor = the PreferenceManager.getDefaultSharedPreferences object
        mEditor = mPreferences.edit();

        checkSharedPreferences();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set a checkbox when the application starts
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    //save the name
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name), name);
                    mEditor.commit();

                    //save the email
                    String email = mEmail.getText().toString();
                    mEditor.putString(getString(R.string.email), email);
                    mEditor.commit();
                    // save the Department
                    String department = mDepartment.getText().toString();
                    mEditor.putString(getString(R.string.department), department);
                    mEditor.commit();

                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }
        });

    }
    private void checkSharedPreferences() {
        String name = mPreferences.getString(getString(R.string.name), "");
        String email = mPreferences.getString(getString(R.string.email), "");
        String department = mPreferences.getString(getString(R.string.department), "");

        //sets mName = name saves after app closes
        mName.setText(name);
        mEmail.setText(email);
        mDepartment.setText(department);

    }

}
