package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ItemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> words;
    @NonNull
    //Implementación del Adapter con estos 3 metodos
    @Override
    //Crea un nuevo ViewHolder
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = ItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    //Enlaza información
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String item = words.get(position);
        holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return words.size();
    }

//Enlace ente data y adapter
    public void setData(List<String> data) {
        this.words = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;//Se inicializa para usar el parámetro
        }
        //Para que viewHolder reciba información y la pueda mostrar
        public void bind(String words){
            itemBinding.textViewItem.setText(words);
        }
    }
}
