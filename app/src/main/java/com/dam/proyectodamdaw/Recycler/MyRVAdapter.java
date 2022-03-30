package com.dam.proyectodamdaw.Recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.proyectodamdaw.R;

import java.util.List;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.ViewHolder>{
    private List<WeatherOne> list;
    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;

    public MyRVAdapter(Context context, List<WeatherOne> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRVAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView dia;
        TextView fecha;
        TextView hora;
        TextView temperatura;
        TextView gradosTemp;
        TextView tempMax;
        TextView gradosMax;
        TextView tempMin;
        TextView gradosMin;
        TextView descrip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            dia = itemView.findViewById(R.id.image);
            fecha = itemView.findViewById(R.id.image);
            hora = itemView.findViewById(R.id.image);
            descrip = itemView.findViewById(R.id.image);
            temperatura = itemView.findViewById(R.id.image);
            gradosTemp = itemView.findViewById(R.id.image);
            tempMax = itemView.findViewById(R.id.image);
            gradosMax = itemView.findViewById(R.id.image);
            tempMin = itemView.findViewById(R.id.image);
            gradosMin = itemView.findViewById(R.id.image);
        }
    }
}
