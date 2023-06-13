package com.example.tealist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyleViewAdapter extends RecyclerView.Adapter<RecyleViewAdapter.MyViewHolder> {
    List<Tea> teaList;
    Context context;

    interface onItemClickListener{
        void onItemClick(Tea tea,int position);

    }
    private final onItemClickListener onItemClickListener;


    public RecyleViewAdapter(List<Tea> teaList, Context context, onItemClickListener onItemClickListener) {
        this.teaList = teaList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_tea,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Tea tea = teaList.get(position);
        holder.tv_teaName.setText(tea.getName());
        holder.tv_teaDisc.setText(tea.getDescription());
        Glide.with(this.context).load(teaList.get(position).getImageURL()).into(holder.iv_teaPic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(tea, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return teaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_teaPic;
        TextView tv_teaName;
        TextView tv_teaDisc;
        ConstraintLayout parentLayout;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_teaPic = itemView.findViewById(R.id.iv_teaPicture);
            tv_teaName = itemView.findViewById(R.id.tv_teaName);
            tv_teaDisc = itemView.findViewById(R.id.tv_teaDiscription);
            parentLayout = itemView.findViewById(R.id.oneLineTeaLayout);

    }}}

