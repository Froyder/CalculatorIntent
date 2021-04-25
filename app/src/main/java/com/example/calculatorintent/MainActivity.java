package com.example.calculatorintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_NUMBER = 99;
    TextView viewNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(buttonListener);
        viewNumber = findViewById(R.id.view_number);
    }

    private View.OnClickListener buttonListener = v-> {
        Intent intent = new Intent(Intent.ACTION_RUN);
        startActivityForResult(intent, REQUEST_NUMBER);
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_NUMBER) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            data.getParcelableExtra("NEW_NUMBER");
            String number = data.getStringExtra("NEW_NUMBER");
            viewNumber.setText(String.format("%s%s", getString(R.string.result_text), number));
        }
    }
}