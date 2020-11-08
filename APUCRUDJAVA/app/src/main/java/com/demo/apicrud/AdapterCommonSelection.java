package com.demo.apicrud;


import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.apicrud.Models.GetUsers.Demo;

import java.util.ArrayList;


public class AdapterCommonSelection extends RecyclerView.Adapter<AdapterCommonSelection.Holder> {

    private MainActivity context;
    ArrayList<Demo> arrayListSelection;

    public AdapterCommonSelection(MainActivity context, ArrayList<Demo> arrayUsers) {
        this.context = context;
        this.arrayListSelection = arrayUsers;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cell_simple_list, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        final Demo obj = arrayListSelection.get(position);

        String data = "Name:" + obj.getName() + "\nContact:" + obj.getContact() + "\nCity:" + obj.getCity() + "\nCreatedAt:" + obj.getCreatedAt();
        holder.textViewTitle.setText(data);
        holder.itemView.setOnClickListener(v -> {


            context.getUserDetails(obj.getId().toString());
        });
        holder.buttonDelete.setOnClickListener(v -> {
            context.deleteUser(obj.getId().toString());
        });
    }

    @Override
    public int getItemCount() {
        return arrayListSelection.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public Button buttonDelete;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
