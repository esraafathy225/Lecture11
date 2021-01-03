package com.company.explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button=findViewById(R.id.btn);
        editText=findViewById(R.id.edit1);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("profession",message);

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }


}