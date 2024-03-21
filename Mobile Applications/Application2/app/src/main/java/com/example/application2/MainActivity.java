package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText et_nota;
    TextView  tv_final,tv_bacsis, tv_persoane;
    Button b_plus,b_minus,b_plus1,b_minus1, b_calculate;

    int procentaj = 0;
    int persoane = 1;
    double nota = 10.00;
    double bacsis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nota = findViewById(R.id.et_nota);
        tv_bacsis = findViewById(R.id.tv_bacsis);
        tv_persoane = findViewById(R.id.tv_persoane);
        tv_final = findViewById(R.id.tv_final);
        b_plus = findViewById(R.id.b_plus);
        b_plus1 = findViewById(R.id.b_plus1);
        b_minus = findViewById(R.id.b_minus);
        b_minus1 = findViewById(R.id.b_minus1);
        b_calculate = findViewById(R.id.b_calculate);

        b_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View biew){
                String x = et_nota.getText().toString();
                if (!x.equals("")){
                    nota = Double.valueOf(x);
                    nota *= 100;
                    nota = Math.round(nota);
                    nota /= 100;

                    et_nota.setText(String.format(Locale.getDefault(), "%.2f", nota));

                    bacsis = (nota * procentaj) / 100;
                    bacsis *= 100;
                    bacsis = Math.round(bacsis);
                    bacsis /= 100;
                    bacsis = bacsis / persoane;

                    tv_final.setText(String.format(Locale.US, "%.2f", bacsis));
                }
            }
        });

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View biew){
                if (procentaj >= 0 && procentaj <= 30) {
                    procentaj = procentaj + 1;
                    tv_bacsis.setText(procentaj + "%");
                }
            }
        });

        b_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View biew){
                if (persoane >= 1){
                    persoane ++;
                    tv_persoane.setText(String.valueOf(persoane));
                }
            }
        });


        b_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View biew){
                if (procentaj > 0) {
                    procentaj = procentaj - 1;
                    tv_bacsis.setText(procentaj + "%");
                }
            }
        });

        b_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View biew){
                if (persoane > 1){
                    persoane --;
                    tv_persoane.setText(String.valueOf(persoane));
                }
            }
        });
    }
}
