package com.example.a00960952_steineremanuel_se2_einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_sendNumber;
    EditText txtMNumber;
    TextView text_result;
    Socket socketTCP;
    DataOutputStream dataOut;
    PrintWriter pw;
    String host = "se2-isys.aau.at";
    String host2 = "143.205.174.165";
    int port = 53212;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sendNumber = findViewById(R.id.btn_send);
        btn_sendNumber.setOnClickListener(MainActivity.this);

        text_result = findViewById(R.id.txtResult);
    }

    @Override
    public void onClick(View v) {
        txtMNumber = findViewById(R.id.txtfNumber);

        try {
            socketTCP = new Socket(host, port);
            pw = new PrintWriter(socketTCP.getOutputStream());
            pw.write(txtMNumber.getText().toString());
            pw.flush();
            pw.close();
            socketTCP.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
