package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        //OkHttpClient client = new OkHttpClient();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://177.70.244.192:14245/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Cliente>> call = jsonPlaceHolderApi.getClientes();

        call.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if(!response.isSuccessful())
                {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Cliente> clientes = response.body();

                for (Cliente cliente : clientes)
                {
                    String content = "";
                    content += "ID: " + cliente.getCod_clnt() + "\n";
                    content += "User ID: " + cliente.getUsuario() + "\n";
                    content += "Password: " + cliente.getSenha() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}