package com.example.github_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.github_app.models.MyAdapter;
import com.example.github_app.models.User;
import com.example.github_app.service.gitHubService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FollowersView extends AppCompatActivity {

    User infoUser;
    TextView followersText;
    TextView followingText;
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<User> followersvector;

    private gitHubService gitHubAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers_view);
        followersvector= new ArrayList<User>();
        infoUser = (User) getIntent().getExtras().getSerializable("User");//recuperem la info que em passat de pantalla en pantalla

        //retrofit connection
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        Retrofit retrofitinstance = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        gitHubAPI = retrofitinstance.create(gitHubService.class);

        searchfollowers(infoUser.getLogin());
        //Toast.makeText(getApplicationContext(), "Followers: " + infoUser.getFollowers() , Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "image_urls: " + infoUser.getAvatar_url() , Toast.LENGTH_LONG).show();
        Picasso.get().load(infoUser.getAvatar_url()).into((ImageView)findViewById(R.id.imageView));//para conseguir la imagen
        followersText= this.findViewById((R.id.textFollowers));
        followingText= this.findViewById((R.id.textFollowing));
        String followersTextDisplay = followersText.getText ().toString() + infoUser.getFollowers();
        followersText.setText(followersTextDisplay);
        String followingTextDisplay = followingText.getText ().toString() + infoUser.getFollowing();
        followingText.setText(followingTextDisplay);

        //recycleview
        recyclerView = this.findViewById(R.id.myRecycler);





    }

    public void searchfollowers(String LoginName){

        Call <List<User>> call = gitHubAPI.getFollowers(LoginName);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                for (User user : response.body())
                {
                    followersvector.add(user);
                }

                //followersvector = response.body();
                    Toast.makeText(getApplicationContext(), "Followers: " + followersvector.get(0).getLogin() , Toast.LENGTH_LONG).show();
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                // use a linear layout manager


                //Hem d'inizialitzar els vectors


                mAdapter = new MyAdapter(getApplicationContext(),followersvector);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }









}