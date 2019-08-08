
package com.instechrx.iniquiz.iniquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class HomeActivity extends AppCompatActivity {
    private static long time;
    Button btnmulai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        kenalan();
        ketikaButtonDiPencet();
    }

    private void kenalan() {
        btnmulai = (Button)findViewById(R.id.btnmulai);
    }

    private void ketikaButtonDiPencet() {
        btnmulai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // untuk melempar data ke class lain
                Intent intent = new Intent(getApplicationContext(),SoalSatuActivity.class);
                startActivity(intent);
            }
        });

//        btnkeluar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent btnkeluar = new Intent(getApplicationContext(), SplashActivity.class);
//                btnkeluar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                btnkeluar.putExtra("EXIT", true);
//                startActivity(btnkeluar);
//
//                finish();
//                System.exit(0);
//            }
//        });
    }

    //public void clickKeluar(View view){
        //finish(); // exit dari aplikasi tanpa konfirmasi
        //System.exit(0);
   // }
    @Override
    public void onBackPressed() {
        if (time + 2000 > System.currentTimeMillis()) { //2000 in miliseconds -- 2 seconds
            super.onBackPressed();
            moveTaskToBack(true);
            finish();
            System.exit(0);
        } else {
            Toast.makeText(HomeActivity.this, "Press Once Again to Exit", Toast.LENGTH_SHORT).show();
        }
        time = System.currentTimeMillis();
    }
}
