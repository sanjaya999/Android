package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class forgetPassword extends AppCompatActivity {
    private EditText forgetEmailtxt;
     private AppCompatButton forgetBtn;
     private TextView gotoLoginPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        forgetEmailtxt = findViewById(R.id.forgetEmailtxt);
        forgetBtn = findViewById(R.id.forgetBtn);
        gotoLoginPage = findViewById(R.id.gotoLoginPage);

        gotoLoginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(  forgetPassword.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}