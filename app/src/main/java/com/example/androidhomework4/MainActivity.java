package com.example.androidhomework4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btn;
    public static final int REQUEST_CODE_FOR_REGISTRATION = 1;
    TextView tvUN, tvA, tvG; ListView ListViewH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivityForResult(i, REQUEST_CODE_FOR_REGISTRATION);

            }
        });

        tvUN = findViewById(R.id.txtViewMainUsername);
        tvA = findViewById(R.id.txtViewMainAge);
        tvG = findViewById(R.id.txtViewMainGender);
        ListViewH = findViewById(R.id.listViewMainHobbies);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_FOR_REGISTRATION && resultCode == SignupActivity.RESULT_CODE_FOR_REGISTRATION)
        {
            tvUN.setText(data.getStringExtra("USERNAME"));
            tvA.setText(data.getStringExtra("AGE"));
            tvG.setText(data.getStringExtra("GENDER"));
            ArrayList <String> hobbies = (ArrayList<String>) data.getSerializableExtra("HOBBIES");
            ArrayAdapter<String> hl = new ArrayAdapter(this, R.layout.listview_hobbies_layout, R.id.txtViewHobbiesLayoutLabel, hobbies);
            ListViewH.setAdapter(hl);





        }
    }
}
