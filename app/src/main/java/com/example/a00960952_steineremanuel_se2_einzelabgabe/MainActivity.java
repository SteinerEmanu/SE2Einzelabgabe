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
    Socket socketTCP;
    PrintWriter pw;
    String host = "se2-isys.aau.at"; //Log.dweivw("TAG", "HALLO WELT!");
    String host2 = "143.205.174.165";
    int port = 53212;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sendNumber = findViewById(R.id.btn_send);
        btn_sendNumber.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        txtMNumber = findViewById(R.id.txtfNumber);

        try {
            //socketTCP = new Socket(host2, port); // error here
            socketTCP = new Socket(); // Use Threads use hostname IP, Port
            // InputStream Reader, OutputStreamReader --> readLine() writeBytes(text + "\n")!!!
            /**
             * Use IP and Port to connect. Kommunikation über Streams
             * Server muss wissen dass Verbindung vorbei ist! Enter Taste oder ähnliches
             * Server nutzt ServerSocket! CLient nur Socket
             * send request, read reply, close socket
             * --> BufferedReader for Read? .readLine(). -> writeBytes
             * Wichtig Threads! Eigener Thread nur fürs Netzwerk! sonst blockiert es App
             * Erben von der Klasse Thread, Implementieren Runnable <-- schöner!
             * new Thread(signature - constructor).start();
             * Thread myThread = new Thread(meineAufgabe);
             * myThread.start();
             * void join(); Fürs blocking
             */
            SocketAddress sadr = new InetSocketAddress(host2, port);
            socketTCP.connect(sadr); // Exception here IOEX
            pw = new PrintWriter(socketTCP.getOutputStream());
            pw.write(txtMNumber.getText().toString());
            pw.flush();
            pw.close();
            socketTCP.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ServerSocket receiveTCP = new ServerSocket();
            boolean rec = false;
            while(!rec) {
                Socket recSocket = receiveTCP.accept();
                InputStreamReader inpReader = new InputStreamReader(recSocket.getInputStream());
                BufferedReader bufReader = new BufferedReader(inpReader);

                text_result = findViewById(R.id.txtResult);
                text_result.setText(bufReader.readLine());
                if (!text_result.getText().toString().isEmpty()) rec = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
