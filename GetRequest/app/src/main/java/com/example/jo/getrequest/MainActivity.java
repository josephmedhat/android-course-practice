package com.example.jo.getrequest;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    TextView mTextViewResult;
    Button get;
    ImageView img;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(img);

    }

    public void init(){
        mTextViewResult=findViewById(R.id.textView);
        get=findViewById(R.id.button);
        img=findViewById(R.id.imageView);
        queue= Volley.newRequestQueue(MainActivity.this);
    }

    public void parse(View view)  {
       /* String url="http://api.ipstack.com/156.218.83.81";
        JSONObject postparams = new JSONObject();
        postparams.put("access_key", "c8e4eee983fa2bc24aec17407450b243");
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, postparams, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String title="";
                Log.d("api","respone");

                try {
                     title = response.getString("ip");
                    Log.d("api",title);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mTextViewResult.setText(title);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };*/

     /*  String url="https://api.myjson.com/bins/ywurf";
      JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
          @Override
          public void onResponse(JSONArray response) {
              String street ="";
              int building_number=0;
                  try {
                      JSONObject employee=response.getJSONObject(0);
                      JSONObject address =employee.getJSONObject("address");
                      street=address.getString("street");
                      building_number=address.getInt("build_number");

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }

                  mTextViewResult.setText(street+" : "+building_number);

          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {

          }
      });*/

        String url = "http://api.bartita.com/api/v1/contact_us";
        StringRequest request=new StringRequest(Request.Method.POST, url,  new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Respone","done");
                mTextViewResult.setText("done");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Respone","fail "+error.toString());

                Toast.makeText(MainActivity.this,"error "+error.toString(),Toast.LENGTH_LONG).show();

            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>Params=new HashMap<String, String>();
                Params.put("name","jo");
                Params.put("email","jo");
                Params.put("message","jo");
                return Params;
            }
        };
       /* JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            *//*JSONArray jsonArray = response.getJSONArray("employees");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String firstName = employee.getString("firstname");
                                int age = employee.getInt("age");
                                String mail = employee.getString("mail");

                                mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }*//*
                            String title=response.getString("title");
                            mTextViewResult.setText(title);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });*/
        queue.add(request);

    }
}
