package com.example.operadoradevoos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.operadoradevoos.*;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.inicio);
    }
    Inicio telaInicio = new Inicio();
    Perfil telaPerfil = new Perfil();
    Compras telaCompras = new Compras();


    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

//        switch (item.getItemId()) {
//            case R.id.inicio:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.flFragment, telaInicio)
//                        .commit();
//                return true;
//            case R.id.compras:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.flFragment, telaCompras)
//                        .commit();
//                return true;
//
//            case R.id.perfil:
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.flFragment, telaPerfil)
//                        .commit();
//                return true;
//
//            case R.id.sair:
//                Toast.makeText(this, "Adeus!!", Toast.LENGTH_SHORT).show();
//                return true;
//        }

        int itemId = item.getItemId();

        if (itemId == R.id.inicio) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, telaInicio)
                    .commit();
            return true;
        } else if (itemId == R.id.compras) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, telaCompras)
                    .commit();
            return true;
        } else if (itemId == R.id.perfil) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, telaPerfil)
                    .commit();
            return true;
        } else if (itemId == R.id.sair) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Adeus!!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
    }
}
