package com.example.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmailFirst ,loginPasswordFirst ;
    private AppCompatButton SubmitBtn;
    private TextView txtSignup , forgettxt;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        findView();
        edtToolbar();
        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this , SignupActivity.class);
                intent.putExtra("data" , "Signup");
                startActivity(intent);
                finish();
            }
        });
        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmailFirst.getText().toString();
                String password = loginPasswordFirst.getText().toString();

                if(email.isEmpty()){
                    Toast.makeText(LoginActivity.this , "Email cannot be empty" , Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this , "Password cannot be empty" , Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent1 = new Intent(LoginActivity.this , ProductGridActivity.class);
                    startActivity(intent1);
                    finish();


                }
            }
        });

        forgettxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this , forgetPassword.class);
                startActivity(intent);
                finish();

            }
        });

    }

    private void findView() {
        loginEmailFirst = findViewById(R.id.emailFirst); // Corrected ID
        loginPasswordFirst = findViewById(R.id.passwordFirst); // Corrected ID
        SubmitBtn = findViewById(R.id.btn); // Corrected ID
        txtSignup = findViewById(R.id.txtSignup);
        forgettxt = findViewById(R.id.forgettxt);

    }
    private void edtToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.contact){
            Toast.makeText(this , "Contact" , Toast.LENGTH_SHORT).show();
        } else if (id == R.id.ic) {
            Toast.makeText(this , "IC" , Toast.LENGTH_SHORT).show();
        }else if (id == R.id.home) {
            Toast.makeText(this , "HOme" , Toast.LENGTH_SHORT).show();
        } else if (id == android.R.id.home) {
            Toast.makeText(this , "Back button clicked" , Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}