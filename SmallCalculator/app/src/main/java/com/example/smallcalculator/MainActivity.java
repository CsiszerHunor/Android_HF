package com.example.smallcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button add;
    private Button substract;
    private Button multiply;
    private Button divide;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        substract = findViewById(R.id.substract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        result = findViewById(R.id.result);

        add.setOnClickListener(v -> calculate('+'));
        substract.setOnClickListener(v -> calculate('-'));
        multiply.setOnClickListener(v -> calculate('*'));
        divide.setOnClickListener(v -> calculate('/'));

    }

    private void calculate(char operation) {
        String text1 = num1.getText().toString();
        String text2 = num2.getText().toString();

        try {
            double number1 = Double.parseDouble(text1);
            double number2 = Double.parseDouble(text2);
            double calculation = 0;

            switch (operation) {
                case '+':
                    calculation = number1 + number2;
                    break;
                case '-':
                    calculation = number1 - number2;
                    break;
                case '*':
                    calculation = number1 * number2;
                    break;
                case '/':
                    if (number2 == 0) {
                        result.setText("Hiba: 0-val osztás!");
                        return;
                    }
                    calculation = number1 / number2;
                    break;
            }

            result.setText(String.valueOf(calculation));

        } catch (NumberFormatException e) {
            result.setText("Hiba: nem szám!");
        }
    }

}