package com.dam.proyectoandroid;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectoandroid.Database.Constants;
import com.dam.proyectoandroid.Database.Interfaces.ProjectInterface;
import com.dam.proyectoandroid.Database.Interfaces.TaskInterface;
import com.dam.proyectoandroid.Database.adapters.ProjectAdapter;
import com.dam.proyectoandroid.Database.adapters.TaskAdapter;
import com.dam.proyectoandroid.Database.model.Proyecto;
import com.dam.proyectoandroid.Database.model.Tarea;
import com.dam.proyectoandroid.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalendarFragment extends Fragment {

    private CalendarView calendarView;
    private TextView textodia;
    RecyclerView tasksRecycler;
    TaskInterface taskInterface;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        textodia = rootView.findViewById(R.id.textodia);
        calendarView = rootView.findViewById(R.id.calendarView);
        tasksRecycler = rootView.findViewById(R.id.tareasCalendarRecycler);

        // Obtener el primer día del mes actual
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1); // Establecer el primer día del mes
        long minDate = calendar.getTimeInMillis();

        // Establecer la fecha mínima
        calendarView.setMinDate(minDate);

        // Establecer la fecha máxima
        Calendar maxCalendar = Calendar.getInstance();
        maxCalendar.add(Calendar.YEAR, 1);
        calendarView.setMaxDate(maxCalendar.getTimeInMillis());

        // Obtener la fecha actual y establecerla en el TextView
        String fechaActual = obtenerFechaActual();
        textodia.setText("Día actual: " + fechaActual);

        // Configurar el CalendarView
        calendarView.setWeekDayTextAppearance(R.style.MyCalendarMonthTextAppearance);
        calendarView.setBackgroundColor(getResources().getColor(R.color.verde_claro));
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fechaSeleccionada = year + "-" + (month + 1) + "-" + dayOfMonth;
                getTasksByDay(fechaSeleccionada);
                textodia.setText("Día seleccionado: " + fechaSeleccionada);
            }
        });

        // Cambiar el primer día de la semana
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        return rootView;
    }

    private String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }
    public void getTasksByDay(String dia) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        taskInterface = retrofit.create(TaskInterface.class);

        Call<List<Tarea>> call = taskInterface.getTareaByDay(dia);
        call.enqueue(new Callback<List<Tarea>>() {
            @Override
            public void onResponse(Call<List<Tarea>> call, Response<List<Tarea>> response) {
                if (!response.isSuccessful()) {
                    Log.e("Response err: ", response.message());
                    return;
                }

                List<Tarea> tareas = response.body();

                // Asignar el adaptador al RecyclerView
                TaskAdapter taskAdapter = new TaskAdapter(getContext(), tareas);
                tasksRecycler.setAdapter(taskAdapter);
                tasksRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));

            }

            @Override
            public void onFailure(Call<List<Tarea>> call, Throwable t) {
                Log.e("Trow err: ", t.getMessage());
            }
        });
    }
}
