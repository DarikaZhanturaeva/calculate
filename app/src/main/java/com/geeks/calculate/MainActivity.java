package com.geeks.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstOperand;
    private Integer secondOperand;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void OnNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
        } else {
            String text = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }
        }
        isOperationClick = false;
    }

    public void OnOperationClick(View view) {
        String data = textView.getText().toString();
        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            operation = "+";

        } else if (view.getId() == R.id.btn_division) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            operation = "/";

        } else if (view.getId() == R.id.btn_minus) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            operation = "-";

        } else if (view.getId() == R.id.btn_multiplication) {
            firstOperand = Integer.valueOf(textView.getText().toString());
            operation = "*";

        } else if (view.getId() == R.id.btn_egual) {
            secondOperand = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                Integer result = firstOperand + secondOperand;
                textView.setText(result.toString());
            } else if (operation.equals("-")) {
                Integer result = firstOperand - secondOperand;
                textView.setText(result.toString());
            } else if (operation.equals("*")) {
                Integer result = firstOperand * secondOperand;
                textView.setText(result.toString());
            } else if (operation.equals("/")) {
                if (secondOperand == 0) {
                    textView.setText("Error");
                } else {
                    Integer result = firstOperand / secondOperand;
                    textView.setText(result.toString());
                }
            }

        }
        isOperationClick = true;
    }
}