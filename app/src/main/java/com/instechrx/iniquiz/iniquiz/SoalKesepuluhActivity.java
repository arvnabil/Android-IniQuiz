package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoalKesepuluhActivity extends AppCompatActivity {
    private static long time;
    Button jwb1s10,jwb2s10,jwb3s10,jwb4s10;
    int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_kesepuluh);
        tangkapNilai();
        kenalandong();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalandong() {
        jwb1s10 = findViewById(R.id.jwb1s10);
        jwb2s10 = findViewById(R.id.jwb2s10);
        jwb3s10 = findViewById(R.id.jwb3s10);
        jwb4s10 = findViewById(R.id.jwb4s10);
    }

    private void ketikaButtonDipencet() {
        jwb1s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesepuluhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalkesebelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb2s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesepuluhActivity.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                nilai++;
                Log.i("Benar", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalkesebelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb3s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesepuluhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalkesebelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }

        });

        jwb4s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesepuluhActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalkesebelasActivity.class);
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
            Toast.makeText(SoalKesepuluhActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
