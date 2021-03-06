package com.example.a00960952_steineremanuel_se2_einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_SendNumberToServer;
    Button btn_CalculateMod7;
    EditText txtMNumber;
    TextView text_result;
    String host = "143.205.174.165"; // se2-isys.aau.at domain
    int port = 53212;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMNumber = findViewById(R.id.txtfNumber);
        text_result = findViewById(R.id.txtResult);

        btn_CalculateMod7 = findViewById(R.id.btn_calc);
        btn_CalculateMod7.setOnClickListener(MainActivity.this);

        btn_SendNumberToServer = findViewById(R.id.btn_send);
        btn_SendNumberToServer.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        if(btn_SendNumberToServer.isPressed()) {
            NetworkActivity networkAct = new NetworkActivity(host, port, txtMNumber.getText().toString());
            AsyncTask aTask = networkAct.execute();
            try {
                Object waitTillDone = aTask.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.text_result.setText(networkAct.getReturnMessage());
        } else if(btn_CalculateMod7.isPressed()) {
            SortMatrNumber sortNumber = new SortMatrNumber(txtMNumber.getText().toString());
            text_result.setText(sortNumber.getSortedNumber());
        }
    }
}
