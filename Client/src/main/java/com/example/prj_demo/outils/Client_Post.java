package com.example.prj_demo.outils;

import android.os.AsyncTask;

import com.example.prj_demo.model.User;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_Post extends AsyncTask<Void, Void, Void>{

    public User user;

    public Client_Post(User user) {
        this.user = user;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            // the IP and port should be correct to have a connection established
            // Creates a stream socket and connects it to the specified port number on the named host.
            Socket socket = new Socket("192.168.56.1", 402);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osr = new OutputStreamWriter(os);
            PrintWriter pw =new PrintWriter(osr,true);

            pw.println(user.email+","+user.nom+","+user.prenom+","+user.mdp);

            System.out.println("Send");

            socket.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
