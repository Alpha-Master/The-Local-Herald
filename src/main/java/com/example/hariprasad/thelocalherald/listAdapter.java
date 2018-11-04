package com.example.hariprasad.thelocalherald;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceActivity;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;

/**
 * Created by Hari Prasad on 22-11-2017.
 */

public class listAdapter extends ArrayAdapter {
    public listAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes ArrayList<News> textViewResourceId) {
        super(context, resource, textViewResourceId);
    }



    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        News n = (News) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.newslistlayout, parent, false);
        }
        TextView heading = (TextView) convertView.findViewById(R.id.tvHeading_NL);
        TextView description = (TextView) convertView.findViewById(R.id.tvDescription_NL);
        TextView date = (TextView) convertView.findViewById(R.id.tvDate_NL);
        TextView location = (TextView) convertView.findViewById(R.id.tvLocation_NL);

        heading.setText(n.heading);
        description.setText(n.description);
        date.setText(n.date);
        location.setText(n.location);


       /* AsyncHttpClient client = new AsyncHttpClient();
        client.get(temp, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, byte[] responseBody) {
                Bitmap img = BitmapFactory.decodeByteArray(responseBody, 0,responseBody.length);
                im.setImageBitmap(img);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });*/
        return convertView;
    }
}
