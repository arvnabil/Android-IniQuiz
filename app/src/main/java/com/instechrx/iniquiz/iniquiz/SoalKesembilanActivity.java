package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SoalKesembilanActivity extends AppCompatActivity {

    private static long time;
    Button jwb1s9,jwb2s9,jwb3s9,jwb4s9;
    int nilai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_kesembilan);
        tangkapNilai();
        kenalandong();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalandong() {
        jwb1s9 = findViewById(R.id.jwb1s9);
        jwb2s9 = findViewById(R.id.jwb2s9);
        jwb3s9 = findViewById(R.id.jwb3s9);
        jwb4s9 = findViewById(R.id.jwb4s9);

    }

    private void ketikaButtonDipencet() {
        jwb1s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesembilanActivity.this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                nilai++;
                Log.i("Benar", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKesepuluhActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb2s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesembilanActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKesepuluhActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });

        jwb3s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesembilanActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKesepuluhActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }

        });

        jwb4s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SoalKesembilanActivity.this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                Log.i("Salah", String.valueOf(nilai));
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(), SoalKesepuluhActivity.class);
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
            Toast.makeText(SoalKesembilanActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }

}
