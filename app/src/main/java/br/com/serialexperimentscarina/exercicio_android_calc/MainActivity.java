package br.com.serialexperimentscarina.exercicio_android_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private EditText etOp;
    private Button btnCalc;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        etOp = findViewById(R.id.etOp);
        btnCalc = findViewById(R.id.btnCalc);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalc.setOnClickListener(l -> calcular());
    }

    private void calcular() {
        String in1 = etNum1.getText().toString();
        String in2 = etNum2.getText().toString();
        String op = etOp.getText().toString();

        if (in1.length() == 0 || in2.length() == 0 || op.length() == 0) {
            Toast.makeText(this, R.string.vazio_erro, Toast.LENGTH_LONG).show();
            return;
        }

        int num1, num2;
        try {
            num1 = Integer.parseInt(in1);
            num2 = Integer.parseInt(in2);
        } catch (Exception e) {
            Toast.makeText(this, R.string.num_erro, Toast.LENGTH_LONG).show();
            return;
        }

        switch (op) {
            case "+":
                tvResultado.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                tvResultado.setText(String.valueOf(num1 - num2));
                break;
            case "*":
            case "x":
                tvResultado.setText(String.valueOf(num1 * num2));
                break;
            case "/":
            case "%":
                if (num2 == 0) {
                    Toast.makeText(this, R.string.div_zero_erro, Toast.LENGTH_LONG).show();
                    break;
                }
                tvResultado.setText(String.valueOf(num1 / num2));
                break;
            default:
                Toast.makeText(this, R.string.op_erro, Toast.LENGTH_LONG).show();
                break;
        }

    }
}