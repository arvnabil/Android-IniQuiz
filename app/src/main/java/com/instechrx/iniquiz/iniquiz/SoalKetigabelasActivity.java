package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalKetigabelasActivity extends AppCompatActivity {
    private static long time;

    Integer  nilai;
    EditText editJawaban13;
    Button btnNext13, btnBack13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_ketigabelas);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalan() {
        editJawaban13 = (EditText)findViewById(R.id.editJawaban13);
        btnNext13 = (Button)findViewById(R.id.btnnext13);
        btnBack13 = (Button)findViewById(R.id.btnback13);
    }

    private void ketikaButtonDipencet() {
        btnNext13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kondisi if, jika jawabannya bentuk string
                if (editJawaban13.getText().toString().equalsIgnoreCase("core")) {
                    Toast.makeText(SoalKetigabelasActivity.this,
                            "jawaban anda, " + editJawaban13.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                }
                else{
                    Toast.makeText(SoalKetigabelasActivity.this, "Jawaban Anda, " + editJawaban13.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKeempatbelasActivity.class);
                a.putExtra("nilai", nilai);
                startActivity(a);
            }
        });
        btnBack13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKeduabelasActivity.class);
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
            Toast.makeText(SoalKetigabelasActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
