package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ItemBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<String> world;

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

    }

    @Override
    public int getItemCount() {
        return world.size();
    }

//Enlace ente data y adapter
    public void setData(List<String> data) {
        this.world = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemBinding itemBinding;
        public ViewHolder(@NonNull ItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;//Se inicializa para usar el parámetro
            itemView.setOnClickListener(this);
        }

        //Para que viewHolder reciba información y la pueda mostrar
        public void bind(String worlds){
            itemBinding.textViewItem.setText(worlds);
        }

        public void onClick(View v){
                int position = getLayoutPosition();
                String item = world.get(position);
                world.set(position, "Clicked " + item);
                notifyDataSetChanged();
               // Toast.makeText(itemView.getContext(), "Se seleccionó " + item, Toast.LENGTH_LONG).show();
        }
    }
}

