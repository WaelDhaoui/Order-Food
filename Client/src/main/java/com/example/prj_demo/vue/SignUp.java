package com.example.prj_demo.vue;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prj_demo.R;
import com.example.prj_demo.model.User;
import com.example.prj_demo.outils.Client_Post;

public class SignUp extends AppCompatActivity {

    private EditText txtNom,txtPrenom,txtEmail,txtMdp;
    private Button btnUp,btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        init();
        ecouteJouer();
    }

    private void init()
    {
        btnUp=(Button)findViewById(R.id.btnUpUser);
        btnRetour=(Button)findViewById(R.id.btnRetourUser);
        txtNom=(EditText)findViewById(R.id.txtNomUser);
        txtPrenom=(EditText)findViewById(R.id.txtPrenomUser);
        txtEmail=(EditText)findViewById(R.id.txtEmailUser);
        txtMdp=(EditText)findViewById(R.id.txtPassUser);
    }

    private void ecouteJouer(){
        btnRetour.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View v) {

                Intent intent = new Intent(SignUp.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btnUp.setOnClickListener(new Button.OnClickListener()
        {

            public void onClick(View v) {

                if(txtNom.getText().toString().equals("") || txtPrenom.getText().toString().equals("") || txtEmail.getText().toString().equals("") || txtMdp.getText().toString().equals("") )
                    Toast.makeText(getApplicationContext(), "Veuillez vérifier les champs!", Toast.LENGTH_SHORT).show();
                else
                {
                    new Client_Post(new User(txtNom.getText().toString(),txtPrenom.getText().toString(),txtEmail.getText().toString(),txtMdp.getText().toString())).execute();
                    Toast.makeText(getApplicationContext(),"User sent",Toast.LENGTH_LONG).show();
                    //activateSvante();
                }
            }
        });
    }


}
