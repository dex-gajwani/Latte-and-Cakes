package com.example.latteandcakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    CheckBox espresso,cappucino,filter,caffe,vanilla;
    Button forward,backward;
    TextView cakes,submitorder;
    TextView beverages;
    String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        espresso = findViewById(R.id.checkBox1);
        cappucino= findViewById(R.id.checkBox2);
        filter= findViewById(R.id.checkBox3);
        caffe=findViewById(R.id.checkBox4);
        vanilla=findViewById(R.id.checkBox5);
        forward=findViewById(R.id.forward);
        backward=findViewById(R.id.backward);
        cakes=findViewById(R.id.selectcakes);
        submitorder=findViewById(R.id.submitorder);

        submitorder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");
                if(espresso.isChecked()){
                    result.append("\nEye opener Espresso Rs105");
                    totalamount+=105;
                }
                if(cappucino.isChecked()){
                    result.append("\nClassic Cappucino Rs110");
                    totalamount+=110;
                }
                if(filter.isChecked()){
                    result.append("\nFilter coffee Rs120");
                    totalamount+=120;
                }
                if(caffe.isChecked()){
                    result.append("\nCaffe Latte Rs135");
                    totalamount+=135;
                }


                if(vanilla.isChecked()){
                    result.append("\nIced Vanilla Latte Rs175");
                    totalamount+=175;
                }
                str = "\nTotal:"+totalamount+"Rs";
                result.append(str);
                Bundle b =new Bundle();
                b.putString("key", str);
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
               //Bundle bundle = new Bundle();

                Fragment fragment= new SubmitOrder();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container2,fragment).commit();

           }

        });
        cakes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("chose cakes");
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, cakes1.class);
               // intent.putExtra("Q1", +totalamount+);

                startActivity(intent);
            }

            });
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this, cakes1.class);
                startActivity(intent);
            }
        });
        backward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
        }
}