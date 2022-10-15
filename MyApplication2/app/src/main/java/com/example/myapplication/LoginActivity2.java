package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity2 extends AppCompatActivity {

    EditText idusuario;
    EditText idpassword;
    Button idacepetar;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        idusuario = findViewById(R.id.idusuario);
        idpassword = findViewById(R.id.idusuario);
        idacepetar= findViewById(R.id.idaceptar);
        firebaseAuth=FirebaseAuth.getInstance();
        idacepetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String usuario =idusuario.getText().toString();
                String password =idpassword.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(usuario,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(LoginActivity2.this,"se  agrego el usuario",Toast.LENGTH_SHORT).show();
                        irlogin2();
                        finish();
                    }
                });
            }




            });
    }


    public void irlogin2() {
        // Do something in response to button
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);

    }
    }
