package com.dam.proyectoandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricEventRVAdapter extends RecyclerView.Adapter<HistoricEventRVAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> eventNames;
    private ArrayList<String> eventDates;
    private ArrayList<String> eventLocations;
    private ArrayList<String> textColors;

    public HistoricEventRVAdapter(Context context, ArrayList<String> eventNames, ArrayList<String> eventDates, ArrayList<String> eventLocations, ArrayList<String> textColors) {
        this.context = context;
        this.eventNames = eventNames;
        this.eventDates = eventDates;
        this.eventLocations = eventLocations;
        this.textColors = textColors;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvEventName.setText(eventNames.get(position));
        holder.tvEventDate.setText(eventDates.get(position));
        holder.tvEventLocation.setText(eventLocations.get(position));

        // Obtener el color de texto para la posición actual
        String colorString = textColors.get(position);

        // Verificar si el colorString no es null y no está vacío antes de intentar parsearlo
        if (colorString != null && !colorString.isEmpty()) {
            // Parsear el color desde el String
            int color = Color.parseColor(colorString);

            // Establecer el color de texto para cada TextView
            holder.tvEventName.setTextColor(color);
            holder.tvEventDate.setTextColor(color);
            holder.tvEventLocation.setTextColor(color);
        }
    }


    @Override
    public int getItemCount() {
        return eventNames.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvEventName, tvEventDate, tvEventLocation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEventName = itemView.findViewById(R.id.tvEventName);
            tvEventDate = itemView.findViewById(R.id.tvEventDate);
            tvEventLocation = itemView.findViewById(R.id.tvEventLocation);
        }
    }
}
