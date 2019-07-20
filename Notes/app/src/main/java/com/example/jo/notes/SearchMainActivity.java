package com.example.jo.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchMainActivity extends AppCompatActivity {

    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        init();
    }

    public void init(){
        searchView=(SearchView) findViewById(R.id.search);
    }

    public void search(View view) {
        Log.d("onclick","clicked");
        String value=searchView.getQuery().toString();
        Toast.makeText(SearchMainActivity.this,value,Toast.LENGTH_LONG).show();
    }
}
