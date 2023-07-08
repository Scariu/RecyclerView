package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.FragmentFirstBinding;
import com.example.recyclerview.databinding.ItemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> world;
    private ItemBinding binding;
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
        String item = world.get(position);
        holder.bind(item);
        ItemBinding binding = ItemBinding.bind(holder.itemView);
        holder.itemView.setOnClickListener(v -> {
            binding.textViewItem.setText("Clicked " + item);
                /*TextView textView = holder.itemView.findViewById(R.id.textViewItem);
                textView.setText("Clicked " + item);*/
        });
    }

    @Override
    public int getItemCount() {
        return world.size();
    }

//Enlace ente data y adapter
    public void setData(List<String> data) {
        this.world = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;//Se inicializa para usar el parámetro
        }

        //Para que viewHolder reciba información y la pueda mostrar
        public void bind(String worlds){
            itemBinding.textViewItem.setText(worlds);
        }
    }
}

