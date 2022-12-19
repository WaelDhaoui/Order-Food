package com.example.prj_demo.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prj_demo.R;

public class Panier extends AppCompatActivity {

    private TextView name1,name2,name3,price1,price2,price3;
    private Button btnAcheter,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);
        init();
        ecouteJouer();
    }

    private void init()
    {
        btnRetour=(Button)findViewById(R.id.MainRetourMain);
        btnAcheter=(Button)findViewById(R.id.btnAcheter3);
        name1=(TextView)findViewById(R.id.NamePanier1);
        name2=(TextView)findViewById(R.id.NamePanier2);
        name3=(TextView)findViewById(R.id.NamePanier3);
        price1=(TextView)findViewById(R.id.PricePanier1);
        price2=(TextView)findViewById(R.id.PricePanier2);
        price3=(TextView)findViewById(R.id.PricePanier3);

        Intent intent = getIntent();
        if(intent.hasExtra("name1")) {
            name1.setText(intent.getStringExtra("name1"));
            price1.setText(intent.getStringExtra("price1"));
        }
        if(intent.hasExtra("name2")) {
            System.out.println(intent.getStringExtra("name2"));
            name2.setText(intent.getStringExtra("name2"));
            price2.setText(intent.getStringExtra("price2"));
        }
        if(intent.hasExtra("name3")) {
            name2.setText(intent.getStringExtra("name3"));
            price2.setText(intent.getStringExtra("price3"));
        }
    }

    private void ecouteJouer(){
        btnRetour.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(Panier.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnAcheter.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = getIntent();
                if (!intent.hasExtra("name1") && !intent.hasExtra("name2") && !intent.hasExtra("name3")) {
                    Toast.makeText(getApplicationContext(),"panier est vide",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"ordre est envoyer",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
