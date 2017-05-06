package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText cajan1, cajan2;
    private TextView cajaResultado;
    private Button cal, bor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajan1 = (EditText)findViewById(R.id.txtNumeroUno);
        cajan2 = (EditText)findViewById(R.id.txtNumeroDos);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);
    }

    public void calcular(View v) {
        if (validar()) {
            double n1, n2, suma;
            n1 = Double.parseDouble(cajan1.getText().toString());
            n2 = Double.parseDouble(cajan2.getText().toString());
            suma = n1 + n2;
            cajaResultado.setText("El resultado es: " + suma);
        }
    }
    public void borrar(View v){
       cajan1.setText("");
       cajan2.setText("");
        cajaResultado.setText("");
        cajan1.requestFocus();
    }

    public boolean validar(){
        if(cajan1.getText().toString().isEmpty()){
            cajan1.setError(this.getResources().getString(R.string.error_num_one));
            return false;
        }else if(cajan2.getText().toString().isEmpty()){
            cajan2.setError(this.getResources().getString(R.string.error_num_dos));
            return false;
        }
        return true;
    }
}
