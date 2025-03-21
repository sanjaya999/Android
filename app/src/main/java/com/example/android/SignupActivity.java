package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignupActivity extends AppCompatActivity {

    private EditText loginEmailFirst, loginPasswordFirst, confirmPasswordArea ;
    private AppCompatButton SubmitBtn ;
    private TextView gotoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        
        // Initialize views
        loginEmailFirst = findViewById(R.id.loginEmailFirst);
        loginPasswordFirst = findViewById(R.id.loginPasswordFirst);
        confirmPasswordArea = findViewById(R.id.confirmPassword_area);
        gotoLogin = findViewById(R.id.goToLogin);

        SubmitBtn = findViewById(R.id.SubmitBtn);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmailFirst.getText().toString();
                String password = loginPasswordFirst.getText().toString();
                String confirmPassword = confirmPasswordArea.getText().toString();

                if(email.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if(password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if(confirmPassword.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Confirm password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if(!password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Here you would typically implement your signup logic
                    Toast.makeText(SignupActivity.this, "Ready to create account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}