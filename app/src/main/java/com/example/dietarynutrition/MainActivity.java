package com.example.dietarynutrition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button btn;
    TextView version;
    Member member;
    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        version = (TextView)findViewById(R.id.version);
        btn = (Button)findViewById(R.id.button);
        member = new Member();
        dbreff = FirebaseDatabase.getInstance().getReference().child("Member");
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                member.setEmail(email.getText().toString());
                member.setPassword(password.getText().toString());
                dbreff.push().setValue(member);
                Toast.makeText(MainActivity.this, "Data inserted sucessfully!", Toast.LENGTH_LONG).show();
            }
        });
    }
}