package com.example.yonny.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yonny on 11/11/2017.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="https://productos-api2-yonnyrivera.c9users.io/api/v1/register";
    private Map<String ,String> params;
    public RegisterRequest(String correo, String username , String password, Response.Listener<String>listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("correo",correo);
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String ,String> getParams(){
        return params;
    }


}
