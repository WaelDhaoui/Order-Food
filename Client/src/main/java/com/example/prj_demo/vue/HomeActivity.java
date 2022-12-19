package com.example.prj_demo.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.prj_demo.R;
import com.example.prj_demo.outils.Client_Get;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Button btnUp,btnIn;

    private ArrayList<String> listFood = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        init();
        ecouteJouer();
        Client_Get client_Get = new Client_Get();
        client_Get.execute();
        listFood = getFood();
    }

    private void init()
    {
        btnUp=(Button)findViewById(R.id.btnUP);
        btnIn=(Button)findViewById(R.id.btnIN);
    }

    private void ecouteJouer(){
        btnUp.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, SignUp.class);
                startActivity(intent);
            }
        });

        btnIn.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, SignIn.class);
                startActivity(intent);
            }
        });
    }

    public ArrayList<String> getFood(){
        ArrayList<String> listF = new ArrayList<>();
        listF.add("pizza,20");
        listF.add("sandwitch,10");
        listF.add("tacos,15");
        return listF;
    }
}
