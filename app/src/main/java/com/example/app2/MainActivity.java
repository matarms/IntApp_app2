package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    double ta ;
    String c = "Pessoa Alcoolizada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = getIntent();

        double peso = it.getDoubleExtra("peso",0);
        String sexo = it.getStringExtra("sexo");
        int copos = it.getIntExtra("copos",0);
        String jejum = it.getStringExtra("jejum");

        double coef = 1.1;
        if(jejum == "s") {
            if (sexo == "m") coef = 0.7;
            else if (sexo == "f") coef= 0.6;
        }
        this.ta = (copos*4.8)/(peso*coef);

        if(ta <0.2) this.c = "Pessoa NÃO Alcoolizada";
    }

    public void calcular(View view){
        Intent it = new Intent();

        it.putExtra("taxa", this.ta);
        it.putExtra("c", this.c);

        setResult(3, it);
        finish();

    }
}