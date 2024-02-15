package com.dam.proyectoandroid;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.dam.proyectoandroid.Database.Constants;
        import com.dam.proyectoandroid.Database.Interfaces.CRUDInterface;
        import com.dam.proyectoandroid.Database.adapters.ProyectsAdapter;
        import com.dam.proyectoandroid.Database.model.Proyecto;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
    public TextView forgotPassword;
    private EditText editTextUser, editTextPassword;
    private Button buttonLogin;
    List<Proyecto> proyectos;
    CRUDInterface crudInterface;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAll();

        setContentView(R.layout.activity_login);
        forgotPassword = (TextView) findViewById(R.id.forgotPasswordText);
        forgotPassword.setOnClickListener(view -> {
            new AlertDialog.Builder(this)
                    .setTitle("¿Olvidaste tu contraseña?")
                    .setMessage("Puedes recuperarla a través de tu correo electrónico.")
                    //.setView(taskEditText)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.search_go, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })

                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        });
        editTextUser = findViewById(R.id.inputuser);
        editTextPassword = findViewById(R.id.inputpassword);
        buttonLogin = findViewById(R.id.loginButton);

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
    public void changeToRegister(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
    public void changeToInicio(View view) {
        Intent intent = new Intent(Login.this, Inicio.class);
        startActivity(intent);
    }

}