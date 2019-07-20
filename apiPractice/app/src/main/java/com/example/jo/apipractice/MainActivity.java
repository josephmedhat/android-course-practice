package com.example.jo.apipractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView name1,age1,job1,address1;
    Button button;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init(){
        name1=(TextView)findViewById(R.id.name);
        age1 =(TextView)findViewById(R.id.age);
        job1=(TextView)findViewById(R.id.job);
        address1=(TextView)findViewById(R.id.address);
        queue= Volley.newRequestQueue(MainActivity.this);
    }

    public void show(View view) {
        String url = "https://api.myjson.com/bins/ywurf";
        /*JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String address = "", name = "", job = "", age = "";
                try {
                    JSONArray array = response.getJSONArray("employees");
                    JSONObject nadeen = array.getJSONObject(1);
                    name = nadeen.getString("name");
                    job = nadeen.getString("job");
                    age = nadeen.getString("age");

                    JSONObject addressObject = nadeen.getJSONObject("address");
                    address = addressObject.getString("street") + ":" + addressObject.getInt("build_number");

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                name1.setText(name);
                job1.setText(job);
                address1.setText(address);
                age1.setText(age);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });*/
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject object=response.getJSONObject(1);
                    String name="",age="",address="",job="";
                    name=object.getString("name");
                    age
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })

        queue.add(request);

    }
}
