package com.dam.proyectoandroid;

import static com.dam.proyectoandroid.RegisterFragment.crearUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.proyectoandroid.Controlador.PageController;
import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.UserInterface;
import com.dam.proyectoandroid.Database.model.Usuario;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogReg extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1,tab2;
    PageController pagerAdapter;
    UserInterface userInterface;

    Usuario usuario;
    Button registerbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tab1 = findViewById(R.id.tablog);
        tab2 = findViewById(R.id.tabreg);


        registerbutton = findViewById(R.id.registerbutton);
        pagerAdapter = new PageController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0) {
                    pagerAdapter.notifyDataSetChanged();
                    registerbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //comprobar
                            changeToInicio(v);
                        }
                    });
                }
                if (tab.getPosition()==1) {
                    pagerAdapter.notifyDataSetChanged();
                    registerbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            addUser(crearUser());
                            changeToInicio(v);
                        }
                    });
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    public void changeToInicio(View view) {
        Intent intent = new Intent(LogReg.this, Inicio.class);
        startActivity(intent);
    }
    public void addUser(Usuario usuario) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userInterface = retrofit.create(UserInterface.class);

        Toast.makeText(getApplicationContext(), usuario.getNombre(), Toast.LENGTH_SHORT).show();
        Call<Usuario> call = userInterface.create(usuario);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "no respuesta", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "no conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

}