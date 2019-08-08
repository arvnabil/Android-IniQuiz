package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalKeempatbelasActivity extends AppCompatActivity {
    private static long time;

    Integer  nilai;
    EditText editJawaban14;
    Button btnNext14, btnBack14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_keempatbelas);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalan() {
        editJawaban14 = (EditText)findViewById(R.id.editJawaban14);
        btnNext14 = (Button)findViewById(R.id.btnnext14);
        btnBack14 = (Button)findViewById(R.id.btnback14);

    }

    private void ketikaButtonDipencet() {
        btnNext14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kondisi if, jika jawabannya bentuk string
                if (editJawaban14.getText().toString().equalsIgnoreCase("charles babbage")) {
                    Toast.makeText(SoalKeempatbelasActivity.this,
                            "jawaban anda, " + editJawaban14.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                }
                else{
                    Toast.makeText(SoalKeempatbelasActivity.this, "Jawaban Anda, " + editJawaban14.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalkelimabelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });
        btnBack14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKetigabelasActivity.class);
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
            Toast.makeText(SoalKeempatbelasActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
