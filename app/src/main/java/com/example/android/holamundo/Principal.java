package com.example.android.holamundo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText cajan1, cajan2;
    private TextView cajaResultado;
    private Spinner comboOpciones;
    private String[] opciones;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajan1 = (EditText)findViewById(R.id.txtNumeroUno);
        cajan2 = (EditText)findViewById(R.id.txtNumeroDos);
        cajaResultado = (TextView)findViewById(R.id.txtResultado);
        comboOpciones = (Spinner)findViewById(R.id.cmbOperaciones);

        opciones = this.getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones);
        comboOpciones.setAdapter(adapter);
    }

    public void calcular(View v) {
        int op;
        double n1, n2, res=0;

        if (validar()) {
            n1 = Double.parseDouble(cajan1.getText().toString());
            n2 = Double.parseDouble(cajan2.getText().toString());
            op = comboOpciones.getSelectedItemPosition();
            switch (op){
                case 0:
                    res = n1+n2;
                    break;
                case 1:
                    res = n1-n2;
                    break;
                case 2:
                    res = n1*n2;
                    break;
                case 3:
                    res = n1/n2;
                    break;
            }
            cajaResultado.setText("" + res);
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
            cajan1.requestFocus();
            cajan1.setError(this.getResources().getString(R.string.error_num_one));
            return false;
        }
        if(cajan2.getText().toString().isEmpty()){
            cajan2.requestFocus();
            cajan2.setError(this.getResources().getString(R.string.error_num_dos));
            return false;
        }
        if(comboOpciones.getSelectedItemPosition()==3 && Double.parseDouble(cajan2.getText().toString())==0) {
            cajan2.requestFocus();
            cajan2.setError(this.getResources().getString(R.string.error_division_num_dos));
            return false;
        }
        return true;
    }
}
