package com.example.yonny.login;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Yonny on 26/10/2017.
 */

public interface ApiService {

    String API_BASE_URL = "https://productos-api2-yonnyrivera.c9users.io";

    @GET("api/v1/productos")
    retrofit2.Call<List<Producto>> getProductos();

    @FormUrlEncoded
    @POST("api/v1/productos")
    retrofit2.Call<ResponseMessage> createProducto(@Field("nombre") String nombre,
                                                   @Field("detalles") String detalles,
                                                   @Field("ubicacion") String ubicacion);
    @Multipart
    @POST("api/v1/productos")
    retrofit2.Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("detalles") RequestBody detalles,
            @Part("ubicacion") RequestBody ubicacion,
            @Part MultipartBody.Part imagen
    );

    @DELETE("api/v1/productos/{id}")
    retrofit2.Call<ResponseMessage> destroyProducto(@Path("id") Integer id);

    @GET("api/v1/productos/{id}")
    retrofit2.Call<Producto> showProducto(@Path("id") Integer id);

}
