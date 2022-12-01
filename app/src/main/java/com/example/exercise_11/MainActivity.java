package com.example.exercise_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView imageListGridView;
    private Button verifyBtn;
    private CheckBox notRobot;
    private ImageButton refreshBtn;

    ArrayList<Integer> images = new ArrayList<>();
    CustomAdapter customAdapter;
//    private ArrayAdapter<Integer> customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageListGridView = findViewById(R.id.imageListGrid);
        verifyBtn = findViewById(R.id.verifyBtn);
        notRobot = findViewById(R.id.notRobotCheckBox);
        refreshBtn = findViewById(R.id.refreshIB);
        verifyBtn.setVisibility(View.INVISIBLE);

        images.add(R.drawable.img1);
        images.add(R.drawable.img2);
        images.add(R.drawable.img3);
        images.add(R.drawable.img4);
        images.add(R.drawable.img5);
        images.add(R.drawable.img6);
        images.add(R.drawable.img7);
        images.add(R.drawable.img8);
        images.add(R.drawable.img9);

       customAdapter = new CustomAdapter(getApplicationContext(), images);
        imageListGridView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
        // implement setOnItemClickListener event on GridView
        imageListGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                customAdapter.notifyDataSetChanged();
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked){
            verifyBtn.setVisibility(View.VISIBLE);
        }else{
            verifyBtn.setVisibility(View.INVISIBLE);
        }
    }
}