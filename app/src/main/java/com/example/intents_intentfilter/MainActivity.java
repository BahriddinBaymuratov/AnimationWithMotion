package com.example.intents_intentfilter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);

        textView.setOnClickListener(view -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.combination);
            textView.startAnimation(animation);

            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Toast.makeText(MainActivity.this, "Start Animation", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    textView.setVisibility(View.INVISIBLE);
                    Toast.makeText(MainActivity.this, "End Animation", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        });

    }
}