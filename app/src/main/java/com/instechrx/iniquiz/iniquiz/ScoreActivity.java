package com.instechrx.iniquiz.iniquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

public class ScoreActivity extends AppCompatActivity {
    Integer nilai, totalNilai;
    TextView txtHasil, txtScore;
    Button btncoba;

    ImageView gifquiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tangkap();
        kenalan();
        ketikaButtonDipencet();
        totalNilai = 100 * nilai / 15;
        txtScore.setText("Score Anda adalah ");
        txtHasil.setText("Benar " + nilai +
                "\nScore " + totalNilai);

        gifquiz = (ImageView)findViewById(R.id.gifquiz);

        Glide.with(ScoreActivity.this)
                .load(R.drawable.giflogo)
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(gifquiz);
    }

    public void exit(View view){
        // untuk melempar data ke class lain
        Intent a = new Intent(getApplicationContext(),SplashActivity.class);
        startActivity(a);
        moveTaskToBack(true);
        finish();
        System.exit(0);
    }
    private void ketikaButtonDipencet() {
        btncoba.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent a = new Intent(getApplicationContext(),SoalSatuActivity.class);
                startActivity(a);
            }
        });
    }

    private void kenalan() {
        txtHasil =(TextView)findViewById(R.id.txtHasil);
        txtScore =(TextView)findViewById(R.id.txtScore);
        btncoba = findViewById(R.id.btncoba);
    }

    private void tangkap() {
        nilai = getIntent().getIntExtra("nilai",0);
        Log.i("Tangkap Sukses", String.valueOf(nilai));
    }
}
