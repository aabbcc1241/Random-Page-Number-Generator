package com.example.RandomPageNumberGenerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LauncherActivity extends Activity {
    EditText min, max;
    TextView generated;
    Random random = new Random(System.currentTimeMillis());
    EditText q1, q2;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generate();
            }
        });
        min = (EditText) findViewById(R.id.editTextMin);
        max = (EditText) findViewById(R.id.editTextMax);
        generated = (TextView) findViewById(R.id.textViewGenerated);
        q1 = (EditText) findViewById(R.id.editTextq1);
        q2 = (EditText) findViewById(R.id.editTextq2);
        generate();
    }

    void generate() {
        double last = Double.parseDouble(this.generated.getText().toString());
        double min = Double.parseDouble(this.min.getText().toString());
        double max = Double.parseDouble(this.max.getText().toString());
        double generated = last;
        while (generated == last)
            generated = random.nextDouble() * (max - min) + min;
        this.generated.setText("" + Math.round(generated));
        q1.setText("");
        q2.setText("");
    }
}
