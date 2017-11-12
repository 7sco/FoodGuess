package com.example.franciscoandrade.foodsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class GuessActivity extends AppCompatActivity {
    private TextView testGame;
    private SharedPreferences registerPrefs;

    private Button checkword;
    private static final String SHARED_PREFS_KEY = "sharedPrefsFood";
    private SharedPreferences login;



    private EditText usertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);


        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        usertext=(EditText)findViewById(R.id.usertext);

        testGame= (TextView) findViewById(R.id.testgame);

        checkword=(Button) findViewById(R.id.checkword);

        checkword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!TextUtils.isEmpty(usertext.getText())){

                    if(login.contains(String.valueOf(usertext.getText().toString()))){

                        testGame.setText("It contains");
                    }
                    else{
                        testGame.setText("No");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "No text to Check", Toast.LENGTH_SHORT).show();

                }

            }
        });




    }
}
