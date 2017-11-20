package com.example.yonny.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tv_registrar;
    Button   btn_log;
    EditText et_usu,et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tv_registrar=(TextView)findViewById(R.id.tv_registrar);
    btn_log=(Button) findViewById(R.id.Btn_iniciar);
    et_usu=(EditText) findViewById(R.id.TV_usu);
    et_pass=(EditText) findViewById(R.id.TV_pass);
    btn_log=(Button) findViewById(R.id.Btn_iniciar);


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg=new Intent(MainActivity.this,Registro.class);
                MainActivity.this.startActivity(intentReg);

            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username=et_usu.getText().toString();
                final String password=et_pass.getText().toString();


                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{

                            JSONObject jsonResponse=new JSONObject(response);



                                Intent intent=new Intent(MainActivity.this,Main2Activity.class);


                                MainActivity.this.startActivity(intent);


/*
                            if(success){
                                String name=jsonResponse.getString("name");
                                int age=jsonResponse.getInt("age");

                                Intent intent=new Intent(MainActivity.this,Usuario.class);
                                intent.putExtra("name",name);
                                intent.putExtra("usuario",username);
                                intent.putExtra("age",age);
                                intent.putExtra("password",password);

                                MainActivity.this.startActivity(intent);   1

                            }else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                                builder.setMessage("error Login")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }*/
                        }catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest=new LoginRequest(username,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
            }
        });

    }
}
