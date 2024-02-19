package com.dam.proyectoandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarFragment extends Fragment {

    private CalendarView calendarView;
    private TextView textodia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        textodia = rootView.findViewById(R.id.textodia);
        calendarView = rootView.findViewById(R.id.calendarView);
        // Establecer la fecha mínima
        calendarView.setMinDate(Calendar.getInstance().getTimeInMillis());

        // Establecer la fecha máxima
        Calendar maxCalendar = Calendar.getInstance();
        maxCalendar.add(Calendar.YEAR, 1);
        calendarView.setMaxDate(maxCalendar.getTimeInMillis());

        // Obtener la fecha actual y establecerla en el TextView
        String fechaActual = obtenerFechaActual();
        textodia.setText("Día actual: " + fechaActual);
        calendarView.setWeekDayTextAppearance(R.style.MyCalendarMonthTextAppearance);
        calendarView.setBackgroundColor(getResources().getColor(R.color.verde_claro));
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;
                textodia.setText("Día seleccionado: " + fechaSeleccionada);
            }
        });

        // Cambiar el primer día de la semana
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        return rootView;
    }

    private String obtenerFechaActual() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }
}
