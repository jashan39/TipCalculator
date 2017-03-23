package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String dollar = "$";
    private String numpad = "";
    private String totalBiller = "";
    private TextView totalBillValue;
    private TextView tipValue;
    private TextView billSplit;
    private TextView totalToPay;
    private TextView tipResult;
    private TextView splitResult;

    private int tip = 0;
    private int split = 0;
    private double payable = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalBillValue = (TextView) findViewById(R.id.editText);
        tipValue = (TextView) findViewById(R.id.tipper);
        billSplit = (TextView) findViewById(R.id.splitter);
        totalToPay = (TextView) findViewById(R.id.result2);
        tipResult = (TextView) findViewById(R.id.result4);
        splitResult = (TextView) findViewById(R.id.result6);
    }


    public void decreaseTip(View view){
        if(tip > 0) {
            --tip;
            updateTip();    }
        else{
            tip = 0;
            updateTip();
        }
    }

    public void increaseTip(View view){
        ++tip;
        updateTip();
    }


    public void decreaseSplitBill(View view){
        if(split > 0) {
            --split;
            updateSplit();
        }
        else{
            split = 0;
            updateSplit();
        }
    }

    public void increaseSplitBill(View view){
        ++split;
        updateSplit();
    }


    public void updateSplit(){
        billSplit.setText(String.valueOf(split));
        if(split > 0) {
            double totalSplit = payable / split;
            splitResult.setText(String.format("%.2f", totalSplit));
        }

        else{
            double totalSplit = payable;
            splitResult.setText(String.format("%.2f", totalSplit));
        }
    }

    public void updateTip() {
        tipValue.setText(String.valueOf(tip));
        if (numpad != "") {
            double payAmount = Double.valueOf(numpad);
            double totaltip = Double.valueOf(tip) * payAmount * 0.01;
            payable = payAmount + totaltip;
            totalToPay.setText(String.format("%.2f", payable));
            tipResult.setText(String.format("%.2f", totaltip));
        }
    }

    public void buttonReset(View view){
        totalBillValue.setText("0");
        tipValue.setText("0");
        billSplit.setText("0");
        totalToPay.setText("0");
        tipResult.setText("0");
        splitResult.setText("0");
        numpad = "";
        tip = 0;
        payable = 0;
        split = 0;
    }



    public void updateUI(){
        if(numpad.length() < 4) {
            totalBiller = "";
            totalBiller = dollar + numpad + ".00";
            totalBillValue.setText(totalBiller);
            updateTip();
            updateSplit();
        }
    }

    String button1(View view){
        numpad = numpad + "1";
        updateUI();
        return "1";
    }

    String button2(View view){
        numpad = numpad + "2";
        updateUI();
        return "2";
    }

    String button3(View view){
        numpad = numpad + "3";
        updateUI();
        return "3";
    }

    String button4(View view){
        numpad = numpad + "4";
        updateUI();
        return "4";
    }

    String button5(View view){
        numpad = numpad + "5";
        updateUI();
        return "5";
    }

    String button6(View view){
        numpad = numpad + "6";
        updateUI();
        return "6";
    }

    String button7(View view){
        numpad = numpad + "7";
        updateUI();
        return "7";
    }

    String button8(View view){
        numpad = numpad + "8";
        updateUI();
        return "8";
    }

    String button9(View view){
        numpad = numpad + "9";
        updateUI();
        return "9";
    }

    String button0(View view){
        numpad = numpad + "0";
        updateUI();
        return "0";
    }

    void buttonDel(View view){
        if(numpad.length() > 1) {
            numpad = numpad.substring(0, numpad.length() - 1);
            updateUI();
        }

        else{
            buttonReset(view);
        }
    }



}
