package com.example.a00960952_steineremanuel_se2_einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_sendNumber;
    EditText txtMNumber;
    TextView text_result;
    String host = "143.205.174.165"; // se2-isys.aau.at domain
    int port = 53212;
//    String host = "se2-isys.aau.at";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMNumber = findViewById(R.id.txtfNumber);
        text_result = findViewById(R.id.txtResult);
        text_result.setText("Waiting for Server...");

        btn_sendNumber = findViewById(R.id.btn_send);
        btn_sendNumber.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        NetworkActivity networkAct = new NetworkActivity(host, port, txtMNumber.getText().toString());
        networkAct.execute();
        this.text_result.setText("Erfolg " + networkAct.getReturnMessage());
    }
}
