package com.example.productform;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etCode, etName, etPrice;
    TextView tvProducts;
    ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCode = findViewById(R.id.etCode);
        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        tvProducts = findViewById(R.id.tvProducts);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnCancel = findViewById(R.id.btnCancel);
        Button btnShow = findViewById(R.id.btnShow);

        // Add Product
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = etCode.getText().toString();
                String name = etName.getText().toString();
                String priceStr = etPrice.getText().toString();

                if (!code.isEmpty() && !name.isEmpty() && !priceStr.isEmpty()) {
                    double price = Double.parseDouble(priceStr);
                    Product p = new Product(code, name, price);
                    productList.add(p);

                    Toast.makeText(MainActivity.this, "Product added!", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Cancel
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });

        // Show Products
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder sb = new StringBuilder();
                for (Product p : productList) {
                    sb.append(p.toString()).append("\n");
                }
                tvProducts.setText(sb.toString());
            }
        });
    }

    private void clearFields() {
        etCode.setText("");
        etName.setText("");
        etPrice.setText("");
    }
}
