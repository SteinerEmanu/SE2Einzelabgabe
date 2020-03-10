package com.example.a00960952_steineremanuel_se2_einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_sendNumber;
    EditText txtMNumber;
    TextView text_result;
    String host = "143.205.174.165"; // se2-isys.aau.at domain
    int port = 53212;
//    String host = "se2-isys.aau.at"; //Log.dweivw("TAG", "HALLO WELT!");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sendNumber = findViewById(R.id.btn_send);
        btn_sendNumber.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        NetworkActivity nA = new NetworkActivity(host, port, btn_sendNumber.getText().toString());
        
    }
}
