package com.example.saiko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class aktifitasMasuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);
    }

    public void launchLogin(View view) {
        Intent intent = new Intent(this, aktifitasUtama.class);
        startActivity(intent);
    }
}
