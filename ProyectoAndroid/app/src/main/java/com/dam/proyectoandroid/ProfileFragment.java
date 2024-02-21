package com.dam.proyectoandroid;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText editTextNombre,editTextDescripcion,editTextFechaFin;
    String fechaInicio;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_profile, container, false);
        Button myButton = view.findViewById(R.id.buttonOption3);

        // Asignar una función al botón usando un OnClickListener
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica que se ejecutará cuando se haga clic en el botón
                onMyButtonClick();
            }
        });
        view.findViewById(R.id.buttonOption1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        return view;
    }
    @SuppressLint("MissingInflatedId")
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

        // Establecer el título del AlertDialog y su color
        builder.setTitle(Html.fromHtml("<font color='#0F3800'>Editar Perfil</font>"));

        // Inflar el layout personalizado
        View dialogView = getLayoutInflater().inflate(R.layout.alertdialog_editprof, null);
        builder.setView(dialogView);

        // Referenciar los campos del layout
        editTextNombre = dialogView.findViewById(R.id.editTextNombre);
        editTextDescripcion = dialogView.findViewById(R.id.editTextDescripcion);
        editTextFechaFin = dialogView.findViewById(R.id.editTextFechaFin);

        // Configurar la fecha de inicio como la fecha actual
        // (Puedes cambiar el formato según tus necesidades)
        fechaInicio = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Configurar los campos según tus necesidades
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getContext(), editTextNombre.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    public void onMyButtonClick() {
        Toast.makeText(getActivity(), "Cerrando Sesión", Toast.LENGTH_SHORT).show();
        Intent nIntent = new Intent(getActivity(), LogReg.class);
        startActivity(nIntent);
    }
}