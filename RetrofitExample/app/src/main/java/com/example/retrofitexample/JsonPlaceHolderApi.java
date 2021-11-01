package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
<<<<<<< HEAD
    @GET("Clientes")
    Call<List<Cliente>> getClientes();
=======

    @GET("Item")
    Call<List<Item>> getItens();
>>>>>>> d542f5acdea3f6d3f85d603a0df726175e7ae9c3
}
