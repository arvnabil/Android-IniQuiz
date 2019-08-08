package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoalKeTujuhActivity extends AppCompatActivity {
    private static long time;
    Button jwb1s7,jwb2s7,jwb3s7,jwb4s7;
    int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_ke_tujuh);
        tangkapNilai();
        kenalandong();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalandong() {
        jwb1s7 = findViewById(R.id.jwb1s7);
        jwb2s7 = findViewById(R.id.jwb2s7);
        jwb3s7 = findViewById(R.id.jwb3s7);
        jwb4s7 = findViewById(R.id.jwb4s7);
    }

    private void ketikaButtonDipencet() {
        jwb1s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKeTujuhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKedelapanActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb2s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKeTujuhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKedelapanActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb3s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKeTujuhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKedelapanActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }

        });

        jwb4s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKeTujuhActivity.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                nilai++;
                Log.i("Benar", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKedelapanActivity.class);
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
            Toast.makeText(SoalKeTujuhActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
