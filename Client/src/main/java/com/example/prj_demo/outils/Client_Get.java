package com.example.prj_demo.outils;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

@SuppressLint("NewApi")
public class Client_Get extends AsyncTask<Void, Void, Void> {

    private ArrayList<String> listF = new ArrayList<String>();

    @Override
    protected Void doInBackground(Void... voids) {

        try{
            //the IP and port should be correct to have a connection established
            // Creates a stream socket and connects it to the specified port number on the named host.
            Socket socket = new Socket("192.168.56.1", 401);

            InputStream sr = socket.getInputStream();
			InputStreamReader r = new InputStreamReader(sr);
			BufferedReader br = new BufferedReader(r);

			String s = br.readLine();
            String[] ch = s.split(" | ");

            listF.add(ch[0]);
            listF.add(ch[1]);
            listF.add(ch[2]);

            System.out.println(listF.get(0));

            socket.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<String> getList() {
        System.out.println(listF.get(0));
        return  listF;
    }
}
