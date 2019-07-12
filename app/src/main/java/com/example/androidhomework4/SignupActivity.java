package com.example.androidhomework4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SignupActivity extends AppCompatActivity {

    Button btnSend;

    public static final int RESULT_CODE_FOR_REGISTRATION = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Spinner spinner = findViewById(R.id.sprSgnupGender);


        String [] gender = {"Select Gender...","Male","Female","Prefer not to say"};



        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.spr_gender_layout, gender){
            @Override
            public boolean isEnabled(int position) {
                if (position == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =  super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;

                if (position==0)
                {
                    tv.setTextColor(Color.GRAY);
                }
                else
                {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spr_gender_layout);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelectedText = adapterView.getItemAtPosition(i).toString();
                if (i > 0)
                {
                    //Do something here later
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btnSend = findViewById(R.id.btnSgnup);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = findViewById(R.id.edtTxtSgnupUsername);
                EditText age = findViewById(R.id.edtTxtSgnupAge);

                String un = username.getText().toString();
                String a = age.getText().toString();

                if (un.isEmpty() || a.isEmpty() || spinner.getSelectedItemPosition() < 1)
                {
                    Toast.makeText(SignupActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CheckBox checkBox;
                    for (int i = 1; i <=5; i++) {
                        int id = getResources().getIdentifier("chkboxSgnup"+i, "id", getPackageName());
                        checkBox = findViewById(id);

                        if (checkBox.isChecked())
                        {
                            hobbies.add(checkBox.getText().toString());
                        }
                    }



                    Intent i = new Intent();
                    i.putExtra("USERNAME", un);
                    i.putExtra("AGE", a);
                    i.putExtra("HOBBIES", hobbies);
                    i.putExtra("GENDER", spinner.getSelectedItem().toString());
                    setResult(RESULT_CODE_FOR_REGISTRATION, i);

                    finish();
                }
            }
        });
    }

    ArrayList<String> hobbies = new ArrayList<>();
}
