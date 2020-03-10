package com.example.a00960952_steineremanuel_se2_einzelabgabe;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class NetworkActivity extends AsyncTask {

    Socket skt;
    BufferedReader dataIn;
    DataOutputStream dataOut;
    String host;
    int port;
    String message;
    String retMessage;

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
            retMessage = dataIn.readLine();

            skt.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", "IO Exception triggered when connecting to Server.");
        }

        return retMessage;
    }

    public String getReturnMessage() {
        return retMessage;
    }
}
