package com.example.prj_demo.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prj_demo.R;
import com.example.prj_demo.model.Food;
import com.example.prj_demo.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnRetour,btnPannier,btnAff1,btnAff2,btnAff3;
    private TextView name,price,name2,price2,name3,price3;
    public ArrayList<String> list = new HomeActivity().getFood();
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
        ecouteJouer();
        getFoodInfo();
        intent = new Intent(MainActivity.this, Panier.class);
    }

    private void init()
    {
        btnRetour=(Button)findViewById(R.id.MainRetour);
        btnPannier=(Button)findViewById(R.id.btnPanier);
        btnAff1=(Button)findViewById(R.id.btnAff1);
        btnAff2=(Button)findViewById(R.id.btnAff2);
        btnAff3=(Button)findViewById(R.id.btnAff3);
        name = (TextView)findViewById(R.id.Name);
        name2 = (TextView)findViewById(R.id.Name2);
        name3 = (TextView)findViewById(R.id.Name3);
        price = (TextView)findViewById(R.id.Price);
        price2 = (TextView)findViewById(R.id.Price2);
        price3 = (TextView)findViewById(R.id.Price3);
    }

    private void getFoodInfo()
    {
        String[] s1 = list.get(0).split(",");
        name.setText(s1[0]);
        price.setText(s1[1]);

        String[] s2 = list.get(1).split(",");
        name2.setText(s2[0]);
        price2.setText(s2[1]);

        String[] s3 = list.get(2).split(",");
        name3.setText(s3[0]);
        price3.setText(s3[1]);
    }

    private void ecouteJouer(){
        btnRetour.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        btnAff1.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                intent.putExtra("name1",name.getText().toString());
                intent.putExtra("price1",price.getText().toString());
            }
        });

        btnAff2.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                intent.putExtra("name2",name2.getText().toString());
                intent.putExtra("price2",price2.getText().toString());
            }
        });

        btnAff3.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                intent.putExtra("name3",name3.getText().toString());
                intent.putExtra("price3",price3.getText().toString());
            }
        });

        btnPannier.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

}
