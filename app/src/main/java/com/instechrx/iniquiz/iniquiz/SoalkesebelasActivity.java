package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SoalkesebelasActivity extends AppCompatActivity {
    private static long time;
    Integer  nilai;
    EditText editJawaban11;
    Button btnNext11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soalkesebelas);
        tangkapNilai();
        kenalan();
        ketikaButtonDipencet();
    }

    private void tangkapNilai() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkapan Berhasil", String.valueOf(nilai));
    }

    private void kenalan() {
        editJawaban11 = (EditText)findViewById(R.id.editJawaban11);
        btnNext11 = (Button)findViewById(R.id.btnnext11);
    }

    private void ketikaButtonDipencet() {
        btnNext11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Kondisi if, jika jawabannya bentuk string
                if (editJawaban11.getText().toString().equalsIgnoreCase("HTC Dream")) {
                    Toast.makeText(SoalkesebelasActivity.this,
                            "jawaban anda, " + editJawaban11.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    nilai++;
                    Log.i("Benar", String.valueOf(nilai));
                }
                else{
                    Toast.makeText(SoalkesebelasActivity.this, "Jawaban Anda, " + editJawaban11.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                    Log.i("Salah", String.valueOf(nilai));
                }

                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalKeduabelasActivity.class);
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
            Toast.makeText(SoalkesebelasActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
