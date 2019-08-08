package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoalSatuActivity extends AppCompatActivity {
    private static long time;
    Button jwb1s1,jwb3s1,jwb2s1,jwb4s1;
    int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_satu);
        kenalandong();
        ketikaButtonDipencet();
    }

    private void kenalandong() {
        jwb1s1 = findViewById(R.id.jwb1s1);
        jwb2s1 = findViewById(R.id.jwb2s1);
        jwb3s1 = findViewById(R.id.jwb3s1);
        jwb4s1 = findViewById(R.id.jwb4s1);
    }
    private void ketikaButtonDipencet() {

        jwb1s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalSatuActivity.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                nilai = 1;
                Log.i("Benar", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalDuaActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }

        });

        jwb2s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalSatuActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                nilai = 0;
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalDuaActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb3s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalSatuActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                nilai = 0;
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalDuaActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb4s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalSatuActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                nilai = 0;
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalDuaActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        }

    @Override
    public void onBackPressed() {
        if (time + 2000 > System.currentTimeMillis()) { //2000 in miliseconds -- 2 seconds
            super.onBackPressed();
            moveTaskToBack(true);
            finish();
            System.exit(0);
        } else {
            Toast.makeText(SoalSatuActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
    }
