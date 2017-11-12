package com.example.franciscoandrade.foodsharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText favoriteFoodInput;
    private Button saveFood, goToGame;
    private static final String SHARED_PREFS_KEY = "sharedPrefsFood";
    private SharedPreferences login;

    private TextView test, testGame;

    private Boolean valid;
    int counter=0;


    private Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, GuessActivity.class);


        //Typed food is store in favoritefooInput
        favoriteFoodInput=(EditText) findViewById(R.id. favfood_input);
        //button saves text to hsare preferences
        saveFood=(Button) findViewById(R.id.savefood);
        //button goes to next level
        goToGame=(Button) findViewById(R.id.gotoGame);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        test= (TextView) findViewById(R.id.texttest);


        saveFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();

                if(!TextUtils.isEmpty(favoriteFoodInput.getText())){
                    valid =true;

                    test.setText(favoriteFoodInput.getText());
                    counter++;
                    editor.putString(favoriteFoodInput.getText().toString(), favoriteFoodInput.getText().toString());
                    editor.commit();
                    favoriteFoodInput.setText("");
                }
                else{
                    valid=false;
                    test.setText("Nothing Entered");
                    editor.commit();
                }

            }
        });

        goToGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(valid){
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No text to send", Toast.LENGTH_SHORT).show();                }
            }
        });


    }

}

