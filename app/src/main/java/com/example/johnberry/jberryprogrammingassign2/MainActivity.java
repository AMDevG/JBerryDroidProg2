package com.example.johnberry.jberryprogrammingassign2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String currentScreenText;
    private String buttonText;
    private String newTextToDisplay;
    private int returnSum = 0;
    private String[] numbersArrayStr;
    private boolean equalLastPush = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v) {
        TextView calcScreen = (TextView) findViewById(R.id.textView);
        Button b = (Button) v;

        currentScreenText = calcScreen.getText().toString();
        buttonText = b.getText().toString();

        if (b.getText().equals("c")){
            returnSum = 0;
            numbersArrayStr = new String[numbersArrayStr.length];
            calcScreen.setText("");
        }

        else if (buttonText.equals("=")) {
            currentScreenText = currentScreenText.replaceAll("\\s+","");
            numbersArrayStr = currentScreenText.split("\\+");

            for (String n : numbersArrayStr) {
             returnSum = returnSum + Integer.parseInt(n);
            }
            calcScreen.setText(Integer.toString(returnSum));
            equalLastPush = true;
            returnSum = 0;
        }

        else if((buttonText.equals("+")&& currentScreenText.contains("+"))){

            currentScreenText = currentScreenText.replaceAll("\\s+","");
            numbersArrayStr = currentScreenText.split("\\+");
            for (String n : numbersArrayStr) {
                returnSum = returnSum + Integer.parseInt(n);
            }
            calcScreen.setText(Integer.toString(returnSum));
            returnSum = 0;
        }

        else if ((!buttonText.equals("=") && !equalLastPush)){
            newTextToDisplay = currentScreenText + buttonText;
            calcScreen.setText(newTextToDisplay);
        }

        else if ((equalLastPush && buttonText.equals("+"))){
            newTextToDisplay = currentScreenText + buttonText;
            calcScreen.setText(newTextToDisplay);
            equalLastPush = false;
        }

        else{
            newTextToDisplay = buttonText;
            calcScreen.setText(newTextToDisplay);
            equalLastPush = false;
            returnSum = 0;
            numbersArrayStr = new String[numbersArrayStr.length];
        }
    }
}
