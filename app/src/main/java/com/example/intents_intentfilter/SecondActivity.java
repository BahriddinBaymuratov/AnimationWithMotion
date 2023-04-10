package com.example.intents_intentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener {

    private ImageView imageView1, imageView2, img3, img4;
    private List<ImageView> list;
    boolean a = false, b = false, c = false, d = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        list = new ArrayList<>();
        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale1);
        switch (id) {
            case R.id.img1:
                imageView1.startAnimation(animation);
                a = true;
                animation.setAnimationListener(this);
                break;
            case R.id.img2:
                imageView2.startAnimation(animation);
                b = true;
                animation.setAnimationListener(this);
                break;
            case R.id.img3:
                img3.startAnimation(animation);
                c = true;
                animation.setAnimationListener(this);
                break;
            case R.id.img4:
                img4.startAnimation(animation);
                d = true;
                animation.setAnimationListener(this);
                break;

        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (list.size() == 2) {
            if (list.get(0).getTag() == list.get(1).getTag()) {
                list.get(0).setVisibility(View.INVISIBLE);
                list.get(1).setVisibility(View.INVISIBLE);
            } else {
                Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale2);
                imageView1.setImageResource(R.drawable.ic_launcher_background);
                imageView2.setImageResource(R.drawable.ic_launcher_background);
                imageView1.startAnimation(animation1);
                imageView2.startAnimation(animation1);
            }
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale2);
            if (a) {
                imageView1.setImageResource(R.drawable.java);
                imageView1.startAnimation(animation1);
                list.add(imageView1);
                a = false;
            } else if (b) {
                imageView2.setImageResource(R.drawable.python);
                imageView2.startAnimation(animation1);
                list.add(imageView2);
                b = false;
            } else if (c) {
                img3.setImageResource(R.drawable.python);
                img3.startAnimation(animation1);
                list.add(img3);
                c = false;
            } else if (d) {
                img4.setImageResource(R.drawable.java);
                img4.startAnimation(animation1);
                list.add(img3);
                c = false;
            }
            animation1.setAnimationListener(this);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}