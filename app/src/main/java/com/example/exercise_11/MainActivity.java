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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private GridView imageListGridView;
    private Button verifyBtn;
    private CheckBox notRobot;
    private ImageButton refreshBtn;

    ArrayList<ImageObject> images = new ArrayList<>();
    CustomAdapter customAdapter;
    ArrayList<ImageObject> selectedImages = new ArrayList<>();
    ArrayList<ImageObject> validImageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageListGridView = findViewById(R.id.imageListGrid);
        verifyBtn = findViewById(R.id.verifyBtn);
        notRobot = findViewById(R.id.notRobotCheckBox);
        refreshBtn = findViewById(R.id.refreshIB);
        verifyBtn.setVisibility(View.INVISIBLE);

        images.add(new ImageObject(R.drawable.img1, true));
        images.add(new ImageObject(R.drawable.img2, true));
        images.add(new ImageObject(R.drawable.img3, true));
        images.add(new ImageObject(R.drawable.img4, true));
        images.add(new ImageObject(R.drawable.img5, false));
        images.add(new ImageObject(R.drawable.img6, false));
        images.add(new ImageObject(R.drawable.img7, false));
        images.add(new ImageObject(R.drawable.img8, false));
        images.add(new ImageObject(R.drawable.img9, false));

        for (ImageObject image : images) {
            if (image.isTrafficLight() == true) {
                validImageList.add(image);
            }
        }

        customAdapter = new CustomAdapter(getApplicationContext(), images);
        imageListGridView.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
        // implement setOnItemClickListener event on GridView
        imageListGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageObject selectedItem = (ImageObject) parent.getItemAtPosition(position);
                selectedImages.add(selectedItem);
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Collections.shuffle(images);
                customAdapter.notifyDataSetChanged();
                notRobot.setChecked(false);
                verifyBtn.setVisibility(View.INVISIBLE);
                selectedImages.removeAll(selectedImages);
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean valid = checkValidation();
                if (valid) {
                    Toast.makeText(getApplicationContext(), "Verified", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Not Verified", Toast.LENGTH_SHORT).show();
                }
                selectedImages.removeAll(selectedImages);
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        if (checked) {
            verifyBtn.setVisibility(View.VISIBLE);
        } else {
            verifyBtn.setVisibility(View.INVISIBLE);
        }
    }

    private boolean checkValidation() {

        if (selectedImages.size() != validImageList.size()) {
            return false;
        } else {

            for (ImageObject image : selectedImages) {
                if (image.isTrafficLight() == false) {
                    return false;
                }
            }
            for (int i = 0; i < selectedImages.size(); i++) {
                if (!validImageList.contains(selectedImages.get(i))) {
                    return false;
                } else {
                    continue;
                }
            }
            return true;
        }
    }
}