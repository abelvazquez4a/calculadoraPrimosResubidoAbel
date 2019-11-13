package com.example.calculadoraprimos12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText entradaNumero;
    private Button boton_resultado;
    private TextView salidaResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<Integer> listaNumerosPrimos = new ArrayList<>();
        listaNumerosPrimos.add(0);
        final EditText entradaNumero = (EditText) findViewById(R.id.entrada_Numero);
        Button boton_resultado = (Button) findViewById(R.id.boton_Resultado);
        final TextView salidaResultado = (TextView) findViewById(R.id.salidaResultado);

        boton_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numero = Integer.parseInt(entradaNumero.getText().toString());
                    if (numero >= 1) {
                        Log.i("prueba", "onCreate: numero correcto");
                        int numeroDePrimos = 0;
                        int numeros = 0;
                        if (listaNumerosPrimos.size() > 1) {
                            numeros = (listaNumerosPrimos.get(listaNumerosPrimos.size() - 1) + 1);
                            numeroDePrimos = listaNumerosPrimos.size() - 1;
                            Log.i("prueba", "he encontrado " + numeroDePrimos + " numeros primos, último numero de la array: " + numeros + " en la posicion " + listaNumerosPrimos.size());
                        }
                        while (numeroDePrimos < numero) {
                            if (esPrimo(numeros)) {
                                Log.i("prueba", "voy por el numero: " + numeros);
                                listaNumerosPrimos.add(numeros);
                                numeroDePrimos++;
                                Log.i("prueba", "he encontrado: " + numeroDePrimos + " primos.");
                            }
                            numeros++;
                        }
                        salidaResultado.setText("El " + numero + " número primero es el " + String.valueOf(listaNumerosPrimos.get(numero)));
                    } else {
                        entradaNumero.setText("");
                        Toast.makeText(MainActivity.this, "Inserte un número mayor que 0", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    if (entradaNumero.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "No puede dejar el campo vacío, inserte algún número.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sólo puede insertar números", Toast.LENGTH_LONG).show();
                    }
                    entradaNumero.setText("");
                }
            }
        });
    }

    public static boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)) {
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
