package com.example.prj_demo.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prj_demo.R;

public class SignIn extends AppCompatActivity {

    private EditText txtEmail,txtMdp;
    private Button btnIn,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        init();
        ecouteJouer();
    }

    private void init()
    {
        btnIn=(Button)findViewById(R.id.btnInUser2);
        btnRetour=(Button)findViewById(R.id.btnRetourUser2);
        txtEmail=(EditText)findViewById(R.id.txtEmailUser2);
        txtMdp=(EditText)findViewById(R.id.txtPassUser2);
    }

    private void ecouteJouer(){
        btnRetour.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(SignIn.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnIn.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v) {

                if( txtEmail.getText().toString().equals("") || txtMdp.getText().toString().equals("") )
                    Toast.makeText(getApplicationContext(), "Veuillez vérifier email et mot de passe!", Toast.LENGTH_SHORT).show();
                else
                {
                    if(0 != 0)
                        Toast.makeText(getApplicationContext(), "email et mot de passe invalide", Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(SignIn.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }


}
