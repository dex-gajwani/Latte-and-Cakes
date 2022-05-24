package com.example.latteandcakes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    TextView click;
    ImageView arrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = findViewById(R.id.click);
        arrow = findViewById(R.id.arrow);

        click.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }

    });
        arrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, MainActivity2.class);

                startActivity(intent);
            }

        });
}}