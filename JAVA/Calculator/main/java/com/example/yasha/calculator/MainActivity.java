package com.example.yasha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one, two, three, four, five, six, seven, eight, nine, zero, addition, multiply, subtract, divide, clear, finalResult;
    TextView result;

    String num1 = "";
    String num2 = "";
    String op = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*make connection between element and java variable*/

        one = (Button) findViewById(R.id.BT1);
        two = (Button) findViewById(R.id.BT2);
        three = (Button) findViewById(R.id.BT3);
        four = (Button) findViewById(R.id.BT4);
        five = (Button) findViewById(R.id.BT5);
        six = (Button) findViewById(R.id.BT6);
        seven = (Button) findViewById(R.id.BT7);
        eight = (Button) findViewById(R.id.BT8);
        nine = (Button) findViewById(R.id.BT9);
        zero = (Button) findViewById(R.id.BT0);
        addition = (Button) findViewById(R.id.ADD);
        multiply = (Button) findViewById(R.id.MUL);
        subtract = (Button) findViewById(R.id.SUB);
        divide = (Button) findViewById(R.id.DIV);
        clear = (Button) findViewById(R.id.CLR);
        finalResult = (Button) findViewById(R.id.EQLS);
        result = (TextView) findViewById(R.id.TV1);

        /*set buttons as listeners*/

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        addition.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        finalResult.setOnClickListener(this);


    }

    /*decide operation based on clicked buttons*/
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.BT1:
                num1 = num1 + "1";
                result.setText(num1);
                break;

            case R.id.BT2:

                num1 = num1 + "2";
                result.setText(num1);
                break;

            case R.id.BT3:
                num1 = num1 + "3";
                result.setText(num1);

                break;

            case R.id.BT4:
                num1 = num1 + "4";
                result.setText(num1);

                break;

            case R.id.BT5:

                num1 = num1 + "5";
                result.setText(num1);


                break;

            case R.id.BT6:

                num1 = num1 + "6";
                result.setText(num1);

                break;

            case R.id.BT7:
                num1 = num1 + "7";
                result.setText(num1);

                break;

            case R.id.BT8:
                num1 = num1 + "8";
                result.setText(num1);

                break;

            case R.id.BT9:
                num1 = num1 + "9";
                result.setText(num1);

                break;

            case R.id.BT0:
                num1 = num1 + "0";
                result.setText(num1);

                break;

            case R.id.ADD: {
                op = "+";
                float x;
                if (num1 == "")
                    x = 0;
                else
                    x = Float.parseFloat(num1);
                num1 = "";
                float y;
                if (num2.isEmpty())
                    y = 0;
                else
                    y = Float.parseFloat(num2);
                y = y + x;
                num2 = Float.toString(y);
                result.setText(num2);
            }
            break;


            case R.id.SUB: {
                op = "-";
                float x = Float.parseFloat(num1);
                num1 = "";
                float y;
                if (num2.isEmpty())
                    y = x;
                else {
                    y = Float.parseFloat(num2);
                    y = y - x;
                }
                num2 = Float.toString(y);
                result.setText(num2);
            }

            break;
            case R.id.DIV: {
                op = "/";
                float x;
                if (num1 == "")
                    x = 0;
                else
                    x = Float.parseFloat(num1);
                num1 = "";
                float y;
                if (num2.isEmpty())
                    y = x;
                else {
                    y = Float.parseFloat(num2);
                    /*check whether divider is zero8*/
                    if (x == 0) {
                        Toast.makeText(getApplicationContext(), "ERROR!! can not divide by 0", Toast.LENGTH_LONG).show();
                    } else
                        y = y / x;
                }

                num2 = Float.toString(y);
                result.setText(num2);
            }
            break;
            case R.id.MUL: {
                op = "*";
                float x;
                if (num1 == "")
                    x = 0;
                else
                    x = Float.parseFloat(num1);
                num1 = "";
                float y;
                if (num2.isEmpty())
                    y = 1;
                else
                    y = Float.parseFloat(num2);
                y = y * x;
                num2 = Float.toString(y);
                result.setText(num2);
            }
            break;

            /* remove last element from number*/

            case R.id.CLR:
                num1 = num1.substring(0, num1.length() - 1);
                result.setText(num1);
                break;

            /*display final result so that user can perform different operation on that value*/

                    case R.id.EQLS:
                if (op == "+") {
                    num1 = Float.toString(Float.parseFloat(num1) + Float.parseFloat(num2));
                    num2 = "";
                    result.setText(num1);
                }
                if (op == "-") {
                    num1 = Float.toString(Float.parseFloat(num2) - Float.parseFloat(num1));
                    num2 = "";
                    result.setText(num1);
                }
                if (op == "*") {
                    num1 = Float.toString(Float.parseFloat(num1) * Float.parseFloat(num2));
                    num2 = "";
                    result.setText(num1);
                }
                if (op == "/") {
                    /*check whether divider is zero8*/
                    if (num1.equals("0"))

                        Toast.makeText(getApplicationContext(), "Error!! cannot divide by 0", Toast.LENGTH_LONG).show();
                    else {
                        num1 = Float.toString(Float.parseFloat(num2) / Float.parseFloat(num1));
                        num2 = "";
                        result.setText(num1);
                    }
                }

                break;

            default:
                break;

        }


    }

}
