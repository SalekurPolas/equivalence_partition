package com.salekur.equivalancepartition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private Button button;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckInputValue();
            }
        });
    }

    private void CheckInputValue() {
        //Question: get input in 3 digit but 911 is not included
        //Partition: [(-)INF - (-)1] [000 - 910] [911] [912 - 999] [1000 - (+)INF]

        String StringValue = input.getText().toString();
        int value = Integer.parseInt(StringValue);

        //checking input is 3 digit or not
        if (StringValue.length() == 3) {
            if (value < 0) { //checking 1st partition
                result.setText(StringValue + " is a Invalid input");
            } else if(value >= 0 && value < 911) { //checking 2nd partition
                result.setText(StringValue + " is a Valid input");
            } else if (value == 911) { //checking 3rd partition
                result.setText(StringValue + " is a Invalid input");
            } else if (value >= 912 && value < 1000) { //checking 4th partition
                result.setText(StringValue + " is a Valid input");
            } else if(value >= 1000) { //checking 5th partition
                result.setText(StringValue + " is a Invalid input");
                //this else if can be replace with only else
            }
        } else { // if input is not 3 digit
            result.setText(StringValue + " is a Invalid input");
        }
    }
}
