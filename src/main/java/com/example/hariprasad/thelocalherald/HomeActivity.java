package com.example.hariprasad.thelocalherald;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class HomeActivity extends AppCompatActivity {

    Button addN,loadN;
    String url = "http://192.168.43.192/newsapp/json_get_news.php";
    News temp;
    ArrayList<News> newsArrayList = new ArrayList<>();
    ListView listView;
    listAdapter la;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getResult(url);
        loadN = (Button)findViewById(R.id.btLoad_HM);
        addN = (Button) findViewById(R.id.btAddNews_HM);
        listView=(ListView)findViewById(R.id.lwNews_HM);
        addN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddNewsActivity.class );
                startActivity(i);
            }
        });

        loadN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsArrayList.clear();
                getResult(url);
            }
        });

    }

    public void getResult(String url){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                getNews(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    private void getNews(final String jsonstring)
    {
        try {
            JSONObject root = new JSONObject(jsonstring);
            JSONArray sresponsearray = root.getJSONArray("server_response");
            for(int i = 0; i < sresponsearray.length(); i++)
            {
                JSONObject jsobject = (JSONObject) sresponsearray.get(i);
                String heading = jsobject.getString("heading");
                String description = jsobject.getString("description");
                String date = jsobject.getString("date");
                String place = jsobject.getString("place");
                temp = new News(heading,description,date,place);
                newsArrayList.add(temp);
            }
        }catch (JSONException e){
            e.printStackTrace();
        };
        la = new listAdapter(this,0,newsArrayList);
        listView.setAdapter(la);
        listView.invalidateViews();
    }
}
