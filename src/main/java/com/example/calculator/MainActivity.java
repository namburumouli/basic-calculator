package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button one, two, three, four, five, six, seven, eight, nine, add, sub, mul, div, zero, equal, clear;
    private TextView info, result;
    private final char Addition = '+';
    private final char Subtraction = '-';
    private final char Multiplication = '*';
    private final char Division = '/';
    private final char Equal = '0';
    private double val1 = Double.NaN;
    private double val2;
    private char Action;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUIViews();
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        equal.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    private void setUIViews() {
        zero = (Button) findViewById(R.id.btn0);
        one = (Button) findViewById(R.id.btn1);
        two = (Button) findViewById(R.id.btn2);
        three = (Button) findViewById(R.id.btn3);
        four = (Button) findViewById(R.id.btn4);
        five = (Button) findViewById(R.id.btn5);
        six = (Button) findViewById(R.id.btn6);
        seven = (Button) findViewById(R.id.btn7);
        eight = (Button) findViewById(R.id.btn8);
        nine = (Button) findViewById(R.id.btn9);
        add = (Button) findViewById(R.id.btnadd);
        sub = (Button) findViewById(R.id.btnsub);
        mul = (Button) findViewById(R.id.btnmul);
        div = (Button) findViewById(R.id.btndiv);
        equal = (Button) findViewById(R.id.btnequal);
        clear = (Button) findViewById(R.id.btnclear);
        info = (TextView) findViewById(R.id.textViewcontrol);
        result = (TextView) findViewById(R.id.textViewdispay);

    }

    private void compute() {
        if (!Double.isNaN(val1)) {//is a number
            val2 = Double.parseDouble(info.getText().toString());
            switch (Action) {
                case Addition:
                    val1 = val1 + val2;
                    break;

                case Subtraction:
                    val1 = val1 - val2;
                    break;

                case Multiplication:
                    val1 = val1 * val2;
                    break;

                case Division:
                    val1 = val1 / val2;
                    break;

                case Equal:
                    break;
            }
        } else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn0){
            info.setText(info.getText().toString() +"0");

        } else if(view.getId()==R.id.btn1){
            info.setText(info.getText().toString() +"1");

        } else if(view.getId()==R.id.btn2){
            info.setText(info.getText().toString() +"2");

        }else if(view.getId()==R.id.btn3){
            info.setText(info.getText().toString() +"3");

        }else if(view.getId()==R.id.btn4){
            info.setText(info.getText().toString() +"4");

        }else if(view.getId()==R.id.btn5){
            info.setText(info.getText().toString() +"5");

        }else if(view.getId()==R.id.btn6){
            info.setText(info.getText().toString() +"6");

        }else if(view.getId()==R.id.btn7){
            info.setText(info.getText().toString() +"7");

        }else if(view.getId()==R.id.btn8){
            info.setText(info.getText().toString() +"8");

        }else if(view.getId()==R.id.btn9){
            info.setText(info.getText().toString() +"9");

        }else if(view.getId()==R.id.btnadd){
            if(info.getText().toString().trim().length() > 0) {
                Action = Addition;
                compute();
                result.setText(String.valueOf(val1) + "+");//display operator
                info.setText(" ");// when we call any operator clear the text
            }

        }else if(view.getId()==R.id.btnsub){
            if(info.getText().toString().trim().length() > 0) {
                Action = Subtraction;
                compute();
                result.setText(String.valueOf(val1) + "-");//display operator
                info.setText(" ");// when we call any operator clear the text
            }

        }else if(view.getId()==R.id.btnmul){
            if(info.getText().toString().trim().length() > 0) {
                Action = Multiplication;
                compute();
                result.setText(String.valueOf(val1) + "*");//display operator
                info.setText(" ");// when we call any operator clear the text
            }

        }else if(view.getId()==R.id.btndiv){
            if(info.getText().toString().trim().length() > 0) {

                Action = Division;
                compute();
                result.setText(String.valueOf(val1) + "/");//display operator
                info.setText(" ");// when we call any operator clear the text
            }
        }else if(view.getId()==R.id.btnequal) {
            if(info.getText().toString().trim().length() > 0) {
                Action = Equal;
                compute();
                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                info.setText(" ");// when we call any operator clear the text
            }

        }else if(view.getId()==R.id.btnclear) {
            if((info.getText().length() > 0) ){
                CharSequence name=info.getText().toString();
                info.setText(name.subSequence(0,name.length()-1));
            }else {
                val1=Double.NaN;
                val2=Double.NaN;
                info.setText(" ");
                result.setText(" ");
            }

        }

    }
}