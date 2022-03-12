package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userLoginActivity extends AppCompatActivity {

    EditText username,password;
    Button registernew,login;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(userLoginActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkUser(user, pass);
                    if (checkuser == true) {
                        Toast.makeText(userLoginActivity.this, "Log in Successful", Toast.LENGTH_SHORT).show();
                        Intent userIntent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(userIntent);
                    } else {
                        Toast.makeText(userLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        registernew = findViewById(R.id.registernew);

        registernew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userIntent = new Intent(userLoginActivity.this, userRegistrationActivity.class);
                startActivity(userIntent);
            }
        });
    }
}