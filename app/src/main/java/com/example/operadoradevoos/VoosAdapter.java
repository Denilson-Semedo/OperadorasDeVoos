package com.example.operadoradevoos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VoosAdapter extends RecyclerView.Adapter<VoosAdapter.VoosViewHolder> {
    private List<Voos> voosList;

    public VoosAdapter(List<Voos> voosList) {
        this.voosList = voosList;
    }

    // Constructor and other necessary methods

    static class VoosViewHolder extends RecyclerView.ViewHolder {
        TextView textViewChegada;
        TextView textViewData;
        TextView textViewLugares;
        TextView textViewOperadora;
        TextView textViewPartida;
        TextView textViewPreco;
        TextView textViewId;

        VoosViewHolder(View itemView) {
            super(itemView);
            // Initialize views
            textViewChegada = itemView.findViewById(R.id.textViewChegada);
            textViewData = itemView.findViewById(R.id.textViewData);
            textViewLugares = itemView.findViewById(R.id.textViewLugares);
            textViewOperadora = itemView.findViewById(R.id.textViewOperadora);
            textViewPartida = itemView.findViewById(R.id.textViewPartida);
            textViewPreco = itemView.findViewById(R.id.textViewPreco);
            textViewId = itemView.findViewById(R.id.textViewId);
        }
    }


    @NonNull
    @Override
    public VoosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your item layout and create a ViewHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_voos, parent, false);
        return new VoosViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VoosViewHolder holder, int position) {
        Voos currentVoos = voosList.get(position);

        // Populate the views with data from the current object
        holder.textViewChegada.setText("Chegada: " + currentVoos.getChegada());
        holder.textViewData.setText("Data: " + currentVoos.getData());
        holder.textViewLugares.setText("Lugares: " + currentVoos.getLugares());
        holder.textViewOperadora.setText("Operadora: " + currentVoos.getOperadora());
        holder.textViewPartida.setText("Partida: " + currentVoos.getPartida());
        holder.textViewPreco.setText("Preço: " + currentVoos.getPreco());
        holder.textViewId.setText("ID: " + currentVoos.getId());
    }



    @Override
    public int getItemCount() {
        return voosList != null ? voosList.size() : 0;
    }
}
