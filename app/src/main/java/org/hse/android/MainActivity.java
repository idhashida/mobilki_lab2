package org.hse.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        resultText = findViewById(R.id.resultText);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton2();
            }
        });
    }

    private void clickButton1() {
        String numberVal = editText.getText().toString();
        if (numberVal.isEmpty()) {
            numberVal = "0";
        }
        int count = Integer.parseInt(numberVal);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i + 1);
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        resultText.setText(String.format("Result1: " + sum));
    }

    private void clickButton2() {
        String numberVal = editText.getText().toString();
        if (numberVal.isEmpty()) {
            numberVal = "0";
        }
        int count = Integer.parseInt(numberVal);
        long product = 1;
        for (int i = 2; i <= count; i += 2) {
            product *= i;
        }
        resultText.setText(String.format("Result2: " + product));
    }
}






















