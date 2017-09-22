package com.bignerdranch.android.statelist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    private String[] mStatesList = {"Andaman And Nicobar", "Andhra Pradesh", "Arunachal Pradesh",
            "Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Delhi",
            "Goa", "Haryana", "Himachal Pradesh", "Jammu And Kashmir", "Jharkhand", "Karnataka", "Kerala"
            , "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram"
            , "Nagaland", "Orissa", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttar Pradesh"
            , "Uttaranchal", "West Bengal"};

    private String[] mLatitudes = {"11.66702557", "14.7504291", "27.10039878", "26.7499809"
            , "25.78541445", "30.71999697", "22.09042035", "20.26657819", "28.6699929", "15.491997",
            "28.45000633", "31.10002545", "34.29995933", "23.80039349", "12.57038129", "8.900372741",
            "10.56257331", "21.30039105", "19.25023195", "24.79997072", "25.57049217", "23.71039899",
            "25.6669979", "19.82042971", "11.93499371", "31.51997398", "26.44999921", "27.3333303",
            "12.92038576", "23.83540428", "27.59998069", "30.32040895", "22.58039044"};

    private String[] mLongitudes = {"92.73598262", "78.57002559", "93.61660071", "94.21666744", "87.4799727",
            "76.78000565", "82.15998734", "73.0166178", "77.23000403", "73.81800065", "77.01999101", "77.16659704", "74.46665849",
            "86.41998572", "76.91999711", "76.56999263", "72.63686717", "76.13001949", "73.16017493", "93.95001705", "91.8800142",
            "92.72001461", "94.11657019", "85.90001746", "79.83000037", "75.98000281", "74.63998124", "88.6166475", "79.15004187"
            , "91.27999914", "78.05000565", "78.05000565", "88.32994665"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.state_list_view);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStatesList);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("geo:" + mLatitudes[position] + "," + mLongitudes[position]));
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
