package com.example.clase3_ciclodevida;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    String Tag="actividad1",usuarioReal="Mtabares",claveReal="12345",nombreUsuario="Mateo Tabares";
    EditText usuario,contrasena;
    Button ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(Tag, "OnCreated");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "onStart");
        usuario = findViewById(R.id.usuario);
        contrasena = findViewById(R.id.contrasena);
        ingresar = findViewById(R.id.ingresar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "onResume");
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!usuario.getText().toString().isEmpty() && !contrasena.getText().toString().isEmpty()){

                    Log.i("variables2",usuario.getText().toString());

                    if (usuarioReal.equals(usuario.getText().toString())&&claveReal.equals(contrasena.getText().toString())){
                        goToPantalla2();
                    } else{
                        Toast.makeText(MainActivity.this,"Usuario o Clave Incorrectos",Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this,"Datos Incorrectos",Toast.LENGTH_LONG).show();
                }
            }
        }
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy");
    }

    private void crearAlarma() {
        Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,"Mi Alarmita")
                .putExtra(AlarmClock.EXTRA_HOUR,5)
                .putExtra(AlarmClock.EXTRA_MINUTES,45);

        if (alarma.resolveActivity(getPackageManager())!=null) {
            startActivity(alarma);
        }
    }
    private void goToPantalla2(){
        String contra = claveReal;
        String usua = usuarioReal;
        String nameUsuario = nombreUsuario;
        Intent intent = new Intent(this,Pantalla2.class);
        intent.putExtra("password",contra)
        .putExtra("user",usua)
        .putExtra("nameUser",nameUsuario);
        startActivity(intent);
        Log.i("data",""+contra+usua+nameUsuario);
    }


}