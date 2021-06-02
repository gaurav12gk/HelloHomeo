package com.example.hellohomeo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hellohomeo.Modal.Modal;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<holder> {
    List<Modal> items;
    Context context;

    public Adapter(List<Modal> items, Context context) {
        this.items = items;
        this.context = (Context) context;
    }

    @NonNull
    @NotNull
    @Override
    public holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.crew_list, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull holder holder, int position) {
        holder.status.setText(items.get(position).getStatus());
        holder.name.setText(items.get(position).getName());
       //Toast.makeText(context, "done sir", Toast.LENGTH_SHORT).show();
        Log.d("bindd", "onBindViewHolder: ");
        holder.wikipedia.setText(items.get(position).getWikipedia());
        holder.agency.setText(items.get(position).getAgency());
       Glide.with(holder.itemView.getContext()).load(items.get(position).getImage()).into(holder.img);
       holder.wikipedia.setLinksClickable(true);
    }
public void getallcrew(List<Modal> items)
{
    this.items=items;
}
    @Override
    public int getItemCount() {
        return items.size();
    }
}
