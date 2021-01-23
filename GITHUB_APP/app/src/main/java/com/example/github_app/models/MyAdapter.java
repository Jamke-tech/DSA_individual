package com.example.github_app.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.github_app.DetailUser;
import com.example.github_app.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<User> followerlist;
    Context context;

     public MyAdapter(Context ct, List<User> Users) {
        context =ct;
        followerlist=Users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameText.setText(followerlist.get(position).getLogin());
        Picasso.get().load(followerlist.get(position).getAvatar_url()).into(holder.myImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailUser.class);
                intent.putExtra("Followername", followerlist.get(position).getLogin() );
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("imagen",followerlist.get(position).getAvatar_url());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return followerlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.followerName);
            myImage = (ImageView) itemView.findViewById(R.id.imageFollower);
        }
    }
}
