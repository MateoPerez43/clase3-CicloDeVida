package com.example.clase3_ciclodevida;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;

public class Pantalla2 extends AppCompatActivity {

    TextView nombreUsuario,contrasena,usuario;
    EditText telefono;
    Button abrir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        nombreUsuario = findViewById(R.id.nombreusuarioPantalla2);
        contrasena = findViewById(R.id.clavePantalla2);
        usuario = findViewById(R.id.usuarioPantalla2);
        String nameUser = getIntent().getStringExtra("nameUser");
        String password = getIntent().getStringExtra("password");
        String user = getIntent().getStringExtra("user");

        nombreUsuario.setText(nameUser);
        contrasena.setText(password);
        usuario.setText(user);
    }

    @Override
    protected void onStart() {
        super.onStart();
        telefono = findViewById(R.id.telefono);
        abrir = findViewById(R.id.abrir);
    }

    @Override
    protected void onResume() {
        super.onResume();
        abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Telefono",telefono.getText().toString());
                if (!telefono.getText().toString().isEmpty()) {
                abrirPhone(telefono.getText().toString());
                } else {
                    Toast.makeText(Pantalla2.this, "Ingrese Número de Telefono", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }

    private void abrirPhone(String numberphone) {
        String number="tel:" + numberphone;
        Intent telefono = new Intent(Intent.ACTION_DIAL, Uri.parse(number));

        if (telefono.resolveActivity(getPackageManager())!=null) {
            startActivity(telefono);
        }
    }


}