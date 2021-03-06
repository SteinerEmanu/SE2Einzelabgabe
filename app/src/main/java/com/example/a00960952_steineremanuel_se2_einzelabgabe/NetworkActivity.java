package com.example.a00960952_steineremanuel_se2_einzelabgabe;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkActivity extends AsyncTask {

    private Socket skt;
    private BufferedReader dataIn;
    private DataOutputStream dataOut;
    private String host;
    private String message;
    private String retMessage;
    private int port;

    public NetworkActivity(String host, int port, String message) {
        this.host = host;
        this.port = port;
        this.message = message;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        try {
            skt = new Socket(host, port);

            dataOut = new DataOutputStream(skt.getOutputStream());
            dataIn = new BufferedReader(new InputStreamReader(skt.getInputStream()));

            dataOut.writeBytes(message + "\n");
            this.retMessage = dataIn.readLine();

            skt.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", "IO Exception triggered when connecting to Server.");
        }

        return retMessage;
    }

    public String getReturnMessage() {
        return this.retMessage;
    }

}
