package com.example.calculatorintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(buttonListener);
    }

    private View.OnClickListener buttonListener = v-> {
        Intent intent = new Intent(Intent.ACTION_RUN);
        startActivity(intent);
    };
}