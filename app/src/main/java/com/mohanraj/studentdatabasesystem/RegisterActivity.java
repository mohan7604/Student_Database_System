package com.mohanraj.studentdatabasesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword, signupDepartment, signupSection, signupPhonenum;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupName = findViewById(R.id.name_reg);
        signupEmail = findViewById(R.id.editText_email_reg);
        signupUsername = findViewById(R.id.editText_username_reg);
        signupPassword = findViewById(R.id.editText_Reg_number_reg_re);
        signupDepartment = findViewById(R.id.editText_department);
        signupSection = findViewById(R.id.editText_section);
        signupPhonenum = findViewById(R.id.phone_num);
        loginRedirectText = findViewById(R.id.login_here);
        signupButton = findViewById(R.id.button_proceed_reg);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validateEmail() | !validateDep() | !validateName() | !validatePass() | !validateSection() | !validatePhone()) {
                    return;
                } else {
                    Registration();
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    public Boolean validateName() {
        String val0 = signupName.getText().toString();
        if (val0.isEmpty()) {
            signupName.setError("it cannot be empty");
            return false;
        } else {
            signupName.setError(null);
            return true;
        }
    }
    public Boolean validatePhone() {
        String val0 = signupPhonenum.getText().toString();
        if (val0.isEmpty()) {
            signupPhonenum.setError("it cannot be empty");
            return false;
        } else {
            signupPhonenum.setError(null);
            return true;
        }
    }

    public Boolean validateEmail() {
        String val1 = signupEmail.getText().toString();
        if (val1.isEmpty()) {
            signupEmail.setError("it cannot be empty");
            return false;
        } else {
            signupEmail.setError(null);
            return true;
        }
    }
    public Boolean validatePass() {
        String val2 = signupPassword.getText().toString();
        if (val2.isEmpty()) {
            signupPassword.setError("it cannot be empty");
            return false;
        } else {
            signupPassword.setError(null);
            return true;
        }
    }
    public Boolean validateUsername() {
        String val1 = signupUsername.getText().toString();
        if (val1.isEmpty()) {
            signupUsername.setError("it cannot be empty");
            return false;
        } else {
            signupUsername.setError(null);
            return true;
        }
    }
    public Boolean validateDep() {
        String val1 = signupDepartment.getText().toString();
        if (val1.isEmpty()) {
            signupDepartment.setError("it cannot be empty");
            return false;
        } else {
            signupDepartment.setError(null);
            return true;
        }
    }
    public Boolean validateSection() {
        String val1 = signupSection.getText().toString();
        if (val1.isEmpty()) {
            signupSection.setError("it cannot be empty");
            return false;
        } else {
            signupSection.setError(null);
            return true;
        }
    }

        public void Registration () {

            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
            String name = signupName.getText().toString();
            String email = signupEmail.getText().toString();
            String username = signupUsername.getText().toString();
            String password = signupPassword.getText().toString();
            String department = signupDepartment.getText().toString();
            String section = signupSection.getText().toString();
            HelperClass helperClass = new HelperClass(name, email, username, password, department, section);
            reference.child(username).setValue(helperClass);
            Toast.makeText(RegisterActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);

        }


}
