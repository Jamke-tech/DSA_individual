package com.example.github_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.github_app.R;
import com.squareup.picasso.Picasso;

public class DetailUser extends AppCompatActivity {

   private ImageView imagenfollower;
   private TextView textFollower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        imagenfollower=findViewById(R.id.imageDetailFollower);
        textFollower=findViewById(R.id.textDetailFollower);

        //inicializamos los valores
        Picasso.get().load( getIntent().getExtras().getString("imagen")).into(imagenfollower);
        textFollower.setText(getIntent().getExtras().getString("Followername"));









    }
}