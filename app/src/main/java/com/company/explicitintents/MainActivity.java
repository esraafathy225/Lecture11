package com.company.explicitintents;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button,showToast,showAlert;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button=findViewById(R.id.btn);
        showToast=findViewById(R.id.showToast);
        showAlert=findViewById(R.id.showAlert);
        username=findViewById(R.id.edit1);
        password=findViewById(R.id.edit2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String name=username.getText().toString();
              String passwordValue=password.getText().toString();

              if(name.trim().length()>0&&passwordValue.trim().length()>0){
                  Intent i =new Intent(MainActivity.this,SecondActivity.class);
                  i.putExtra("data",name);
                  startActivity(i);
              }
              else{
                  Toast.makeText(MainActivity.this,"Please enter your name and password",Toast.LENGTH_SHORT).show();
              }
            }
        });


        showToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflater=getLayoutInflater();
                View layout=layoutInflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.layout));

                Toast toast=new Toast(MainActivity.this);

                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

            }
        });

        showAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Title")
                        .setMessage("My Message")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog dialog=builder.create();
                dialog.show();


            }
        });


    }
}