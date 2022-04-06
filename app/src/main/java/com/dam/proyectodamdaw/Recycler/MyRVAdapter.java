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

public class MyRVAdapter<T> extends RecyclerView.Adapter<MyRVAdapter.ViewHolder>{
    private Root root;
    private LayoutInflater inflater;
    private View.OnClickListener onClickListener;

    public MyRVAdapter(Context context, Root list){
        this.root = list;
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

        holder.dia.setText( String.valueOf(root.list.get(position).dt_txt));
        holder.fecha.setText(String.valueOf(root.list.get(position).dt));
        holder.hora.setText(String.valueOf(root.list.get(position).weather.get(position).main));
        holder.gradosMin.setText(String.valueOf(root.list.get(position).main.temp_min));
        holder.gradosMax.setText(String.valueOf(root.list.get(position).main.temp_max));
        holder.gradosTemp.setText(String.valueOf(root.list.get(position).main.temp));
        holder.descrip.setText(String.valueOf(root.list.get(position).weather.get(position).description));

    }

    @Override
    public int getItemCount() {
        return root.list.size();
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
