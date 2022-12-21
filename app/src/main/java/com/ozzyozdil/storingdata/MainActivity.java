package com.ozzyozdil.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Objects
    EditText editTextNumber;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.ozzyozdil.storingdata", Context.MODE_PRIVATE);

        int kaydedilmis_Age = sharedPreferences.getInt("kaydedilmis_Age", 0);

        if (kaydedilmis_Age == 0){
            textView.setText("Your Age: ");
        }
        else{

            textView.setText("Your Age: " + kaydedilmis_Age);
        }
    }

    // Methods
    public void save(View view){
        if (!editTextNumber.getText().toString().matches("")){

            int userAge = Integer.parseInt(editTextNumber.getText().toString());
            textView.setText("Your Age: " + userAge);

            sharedPreferences.edit().putInt("kaydedilmis_Age", userAge).apply();
        }
    }

    public void delete(View view){

        int storedData = sharedPreferences.getInt("kaydedilmis_Age", 0);
        if (storedData != 0){

            sharedPreferences.edit().remove("kaydedilmis_Age").apply();
            textView.setText("Your Age: ");
        }
    }
}