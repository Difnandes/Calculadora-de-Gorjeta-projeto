package com.example.calculadoradegorjetaprojeto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textPocentagem;
    private TextView textGorjeta;
    private TextView textTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textPocentagem  = findViewById(R.id.textPorcentagem);
        textTotal       = findViewById(R.id.textTotal);
        seekBarGorjeta  = findViewById(R.id.seekBarGorjeta);



        //Adicionar listener Seekbar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPocentagem.setText( Math.round( porcentagem ) + " % " ); // (Math.round) Deixa número inteiro como: 12% , 20% , 45% etc
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }else {

            //Converter string para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //Calcula a gorgeta total
            double gorgeta = valorDigitado *  porcentagem/100 ;
            double total = gorgeta + valorDigitado;

            //exibir gorgeta e total
            //textGorjeta.setText(" R$ " + Math.round(gorgeta) );
            textGorjeta.setText(" R$ " + gorgeta );
            textTotal.setText(" R$ " + total );


        }


    }

}













