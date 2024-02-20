package com.dam.proyectoandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.UserInterface;
import com.dam.proyectoandroid.Database.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    UserInterface userInterface;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static EditText inputname;
    static EditText inputlastname;
    static EditText inputmail;
    static EditText inputpassword;

    public RegisterFragment() {
        // Required empty public constructor
    }
    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        inputname = view.findViewById(R.id.inputname);
        inputlastname = view.findViewById(R.id.inputlastname);
        inputmail = view.findViewById(R.id.inputemail);
        inputpassword = view.findViewById(R.id.inputpassword);

        return view;
    }

    @NonNull
    public static Usuario crearUser(){
        Usuario usuario = new Usuario(inputname.getText().toString(),
                inputlastname.getText().toString(),
                inputmail.getText().toString(),inputpassword.getText().toString());
        return usuario;
    }


}