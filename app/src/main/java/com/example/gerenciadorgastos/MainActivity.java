package com.example.gerenciadorgastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText txtGasto;
    private EditText txtValor;
    private Button btnAdicionar;
    private Button btnLista;
    private Button btnTotal;
    HashMap<String, Double> gastos = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGasto = findViewById(R.id.txtGasto);
        txtValor = findViewById(R.id.txtValor);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnLista = findViewById(R.id.btnLista);
        btnTotal = findViewById(R.id.btnTotal);
        btnAdicionar.setOnClickListener(view -> {
            gastos.put(txtGasto.getText().toString(), Double.parseDouble(txtValor.getText().toString()));
            Toast.makeText(getApplicationContext(), "Gasto adicionado!", Toast.LENGTH_LONG).show();
            txtGasto.setText("");
            txtValor.setText("");
        });
        btnLista.setOnClickListener(view -> {
            for (String gasto : gastos.keySet()) {
                double valor = gastos.get(gasto);
                String msg;
                msg = "Gasto: " + gasto + "\n";
                msg += "Valor: " + valor;
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
        btnTotal.setOnClickListener(view -> {
            double total = 0;
            for (String gasto : gastos.keySet()) {
                double valor = gastos.get(gasto);
                total += valor;
            }
            Toast.makeText(getApplicationContext(), "Total: " + total, Toast.LENGTH_LONG).show();
        });
    }
}