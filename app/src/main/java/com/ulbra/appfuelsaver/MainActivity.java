package com.ulbra.appfuelsaver;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText edtNome, edtPlaca, edtDistancia, edtPreco, edtConsumo;
Button btnCalcular;
TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       edtNome = findViewById(R.id.edtNome);
       edtPlaca = findViewById(R.id.edtPlaca);
       edtDistancia = findViewById(R.id.edtDistancia);
       edtConsumo = findViewById(R.id.edtConsumo);
       edtPreco = findViewById(R.id.edtPreco);
       txtResultado = findViewById(R.id.txtResultado);
       btnCalcular = findViewById(R.id.btnCalcular);
       btnCalcular.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               double distancia, consumo, combNecessario, custo, preco;
               String nome, placa;

               if (edtNome.getText().toString().isEmpty() ||
                       edtPlaca.getText().toString().isEmpty() ||
                       edtDistancia.getText().toString().isEmpty() ||
                       edtConsumo.getText().toString().isEmpty() ||
                       edtPreco.getText().toString().isEmpty()) {

                   Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                   return;
               }

               distancia = Double.parseDouble(edtDistancia.getText().toString());
               consumo = Double.parseDouble(edtConsumo.getText().toString());
               preco = Double.parseDouble(edtPreco.getText().toString());

               if (distancia <= 0 || consumo <= 0 || preco <= 0) {
                   Toast.makeText(MainActivity.this, "Valores devem ser maiores que zero!", Toast.LENGTH_SHORT).show();
                   return;
               }

               nome = edtNome.getText().toString();
               placa = edtPlaca.getText().toString();

               combNecessario = distancia / consumo;
               custo = combNecessario * preco;

               txtResultado.setText(
                               "VEÍCULO: " + nome + "\n" +
                               "PLACA: " + placa + "\n" +
                               "DISTÂNCIA: " + distancia + "km\n" +
                               "COMBUSTÍVEL: " + Math.round(combNecessario) + "L\n" +
                                "CUSTO: $ " + Math.round(custo) + "\n"
               );
           }
       });
        }
    }
