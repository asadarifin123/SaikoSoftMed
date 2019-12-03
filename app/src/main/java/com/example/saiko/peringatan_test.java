package com.example.saiko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class peringatan_test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peringatan_test);
    }

    public void launchTest(View view) {
        Intent intent = new Intent(this, test_activity.class);
        startActivity(intent);
    }

}
