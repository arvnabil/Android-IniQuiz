package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalkelimabelasActivity extends AppCompatActivity {
    private static long time;

    Integer  nilai;
    EditText editJawaban15;
    Button btnNext15, btnBack15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soalkelimabelas);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalan() {
        editJawaban15 = (EditText)findViewById(R.id.editJawaban15);
        btnNext15 = (Button)findViewById(R.id.btnnext15);
        btnBack15 = (Button)findViewById(R.id.btnback15);

    }

    private void ketikaButtonDipencet() {
        btnNext15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kondisi if, jika jawabannya bentuk string
                if (editJawaban15.getText().toString().equalsIgnoreCase("1969")) {
                    Toast.makeText(SoalkelimabelasActivity.this,
                            "jawaban anda, " + editJawaban15.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                }
                else{
                    Toast.makeText(SoalkelimabelasActivity.this, "Jawaban Anda, " + editJawaban15.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),ScoreActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });
        btnBack15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKeempatbelasActivity.class);
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
            Toast.makeText(SoalkelimabelasActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
