package com.dam.proyectoandroid.Database;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.proyectoandroid.Database.Interfaces.CRUDInterface;
import com.dam.proyectoandroid.Database.adapters.ProyectsAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class provisional extends AppCompatActivity {
    List<Proyecto> proyectos;
    CRUDInterface crudInterface;
    ListView listView;

     public void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_prueba);
         listView = findViewById(R.id.listView);
     }


    private void getAll(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Proyecto>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Proyecto>>() {
            @Override
            public void onResponse(Call<List<Proyecto>> call, Response<List<Proyecto>> response) {
                if(!response.isSuccessful()){
                    Log.e("Response err: ",response.message());
                    return;
                }
                proyectos = response.body();
                ProyectsAdapter proyectsAdapter = new ProyectsAdapter(proyectos,getApplicationContext());
                listView.setAdapter(proyectsAdapter);
                proyectos.forEach(p -> Log.i("Proyectos: ",p.toString()));
            }

            @Override
            public void onFailure(Call<List<Proyecto>> call, Throwable t) {
                Log.e("Trow err: ",t.getMessage());
            }
        });
    }
}


