package com.example.latteandcakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class cakes1 extends AppCompatActivity {
    CheckBox chocolava,muffin,cupcake,espresso,cappucino,filter,caffe,vanilla;
    TextView submit;
    Button forward, backward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cakes1);
        chocolava = findViewById(R.id.checkBox1a);
        muffin= findViewById(R.id.checkBox2a);
        cupcake= findViewById(R.id.checkBox3a);
        submit=findViewById(R.id.submitorder1);
        forward=findViewById(R.id.forward1);
        backward=findViewById(R.id.backward1);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int totalamoun=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");

                if(chocolava.isChecked()){
                    result.append("\nChoco lava cake 95/-");
                    totalamoun+=95;
                }
                if(muffin.isChecked()){
                    result.append("\nMuffin 80/-");
                    totalamoun+=80;
                }
                if(cupcake.isChecked()){
                    result.append("\nCupcake 120/-");
                    totalamoun+=120;
                }

                result.append("\nTotal: "+totalamoun+"Rs");

                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                 Bundle bundle = new Bundle();
                 bundle.putString("result", "total amoun");
                Fragment fragment= new SubmitOrder();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.cakesid,fragment).commit();
            }

        });
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Fragment fragment= new SubmitOrder();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.cakesid,fragment).commit();
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                  Intent intent = new Intent(cakes1.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}