package com.example.hellohomeo;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class holder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView name,agency,wikipedia,status;
    public holder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.image1);
        name=itemView.findViewById(R.id.name);
        agency=itemView.findViewById(R.id.agency);
        wikipedia=itemView.findViewById(R.id.wiki);
        status=itemView.findViewById(R.id.status);
    }
}
