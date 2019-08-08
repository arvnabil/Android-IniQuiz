package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalKeduabelasActivity extends AppCompatActivity {
    private static long time;
    Integer  nilai;
    EditText editJawaban12;
    Button btnNext12, btnBack12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_keduabelas);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalan() {
        editJawaban12 = (EditText)findViewById(R.id.editJawaban12);
        btnNext12 = (Button)findViewById(R.id.btnnext12);
        btnBack12 = (Button)findViewById(R.id.btnback12);
    }

    private void ketikaButtonDipencet() {
        btnNext12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kondisi if, jika jawabannya bentuk string
                if (editJawaban12.getText().toString().equalsIgnoreCase("SMTP")) {
                    Toast.makeText(SoalKeduabelasActivity.this,
                            "jawaban anda, " + editJawaban12.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                }
                else{
                    Toast.makeText(SoalKeduabelasActivity.this, "Jawaban Anda, " + editJawaban12.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKetigabelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });
        btnBack12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalkesebelasActivity.class);
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
            Toast.makeText(SoalKeduabelasActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
