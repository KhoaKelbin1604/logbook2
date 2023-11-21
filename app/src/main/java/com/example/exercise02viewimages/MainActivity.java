package com.example.exercise02viewimages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private int ImageIndex = 0;
    private int [] mImageResources = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6
    };
    private ImageView imageView;
    private Button Button_next;
    private Button Button_previous;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(mImageResources[ImageIndex]);

        Button_previous = findViewById(R.id.button_previous);
        Button_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPreviousClick();
            }
        });
        Button_next = findViewById(R.id.button_next);
        Button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNextClick();
            }
        });

    }

    private void onPreviousClick(){
        ImageIndex = (ImageIndex - 1 + mImageResources.length) % mImageResources.length;
        imageView.setImageResource(mImageResources[ImageIndex]);
    }

    private void onNextClick(){
        ImageIndex = (ImageIndex + 1) % mImageResources.length;
        imageView.setImageResource(mImageResources[ImageIndex]);

    }

}