package com.example.android;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmailFirst ,loginPasswordFirst , confirmPassword_area;
    private AppCompatButton SubmitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmailFirst.getText().toString();
                String password = loginPasswordFirst.getText().toString();
                String confirmPassword = confirmPassword_area.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(LoginActivity.this , "Email cannot be empty" , Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this , "Password cannot be empty" , Toast.LENGTH_SHORT).show();

                } else if (confirmPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this , "Confirm password cannot be empty" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this , "Email: "+email + "Password: " + password , Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void findView(){
        loginEmailFirst = findViewById(R.id.loginEmailFirst);
        loginPasswordFirst = findViewById(R.id.loginPasswordFirst);
        confirmPassword_area = findViewById(R.id.confirmPassword_area);
        SubmitBtn = findViewById(R.id.SubmitBtn);



    }
}