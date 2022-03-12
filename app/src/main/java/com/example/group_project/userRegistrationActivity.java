package com.example.group_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userRegistrationActivity extends AppCompatActivity {

    Button register;
    EditText firstname,lastname,email,regusername,regpassword,regrepassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        regusername = findViewById(R.id.regusername);
        regpassword = findViewById(R.id.regpassword);
        regrepassword = findViewById(R.id.regrepassword);
        register = findViewById(R.id.register);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstname.getText().toString();
                String lname = lastname.getText().toString();
                String mail = email.getText().toString();
                String user = regusername.getText().toString();
                String pass = regpassword.getText().toString();
                String repass = regrepassword.getText().toString();

                if(fname.equals("")||lname.equals("")||mail.equals("")||user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(userRegistrationActivity.this,"Please enter all the fields",Toast.LENGTH_SHORT).show();
                else
                if (pass.equals(repass)){
                    Boolean checkuser = DB.checkUsername(user);
                    if(checkuser==false){
                        boolean reguser = DB.regUser(fname,lname,mail,user,pass);
                        if(reguser==true){
                            Toast.makeText(userRegistrationActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            Toast.makeText(userRegistrationActivity.this,"Please enter your details to Log in",Toast.LENGTH_SHORT).show();
                            Intent userIntent = new Intent(getApplicationContext(), userLoginActivity.class);
                            startActivity(userIntent);
                        }
                        else{
                            Toast.makeText(userRegistrationActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(userRegistrationActivity.this,"User already exist please Log in",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(userRegistrationActivity.this,"Passwords not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}