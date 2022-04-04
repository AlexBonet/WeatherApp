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
import com.dam.proyectodamdaw.activities.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MyRVAdapter<T> extends RecyclerView.Adapter<MyRVAdapter.ViewHolder>{
    private List<T> list;
    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;

    public MyRVAdapter(Context context, List<T> list){
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @NonNull
    @Override
    public MyRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_view,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRVAdapter.ViewHolder holder, int position) {
        WeatherOne w= (WeatherOne) list.get(position);
        holder.dia.setText(w.getDia());
        holder.fecha.setText(w.getFecha());
        holder.hora.setText(w.getHora());
        holder.gradosMin.setText(w.getGradosMin());
        holder.gradosMax.setText(w.getGradosMax());
        holder.gradosTemp.setText(w.getGradosTemp());
        holder.descrip.setText(w.getDescripcion());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
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
            dia = itemView.findViewById(R.id.dia);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);
            descrip = itemView.findViewById(R.id.descripcion);
            temperatura = itemView.findViewById(R.id.temp);
            gradosTemp = itemView.findViewById(R.id.gradosTemp);
            tempMax = itemView.findViewById(R.id.max);
            gradosMax = itemView.findViewById(R.id.gradosMax);
            tempMin = itemView.findViewById(R.id.min);
            gradosMin = itemView.findViewById(R.id.gradosMin);
        }
    }
}
