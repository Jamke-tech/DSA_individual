package com.example.github_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.github_app.models.User;
import com.example.github_app.service.gitHubService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private gitHubService gitHubAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
        Retrofit retrofitinstance = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        gitHubAPI = retrofitinstance.create(gitHubService.class);
    }

    public void exploreButtonClicked(View v){

        userName = findViewById(R.id.textUserID);//recupero el text del user
        String nameOfUser = userName.getText().toString();
        buscarfollowers(nameOfUser);
    }


    public void buscarfollowers(String nameOfUser) {
        Call<User> call = gitHubAPI.getUser(nameOfUser);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code()==200) {
                    User userSearch = User.getInstance();
                    userSearch.setFollowers(response.body().getFollowers());
                    userSearch.setFollowers_url(response.body().getFollowers_url());
                    userSearch.setFollowing(response.body().getFollowing());
                    userSearch.setPublic_repos(response.body().getPublic_repos());
                    userSearch.setAvatar_url(response.body().getAvatar_url());
                    userSearch.setLogin(response.body().getLogin());

                    //Guardamos user
                    SharedPreferences preferences= getSharedPreferences("Login credentials", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("User", nameOfUser);
                    editor.apply();




                    //Toast.makeText(getApplicationContext(), "Followers: " + response.body().getFollowers_url() , Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), FollowersView.class);
                    intent.putExtra("User",userSearch);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error: " + response.code() , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });




    }



}