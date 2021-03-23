package com.example.minervaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
private EditText email;
private Button reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email =findViewById(R.id.emailid);
        reset=findViewById(R.id.sendMail);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String email_text=email.getText().toString();
               if(TextUtils.isEmpty(email_text)){
                   email.setError("Email is Required.");
                   return;
               }
               FirebaseAuth auth= FirebaseAuth.getInstance();
               auth.sendPasswordResetEmail(email_text).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(ForgotPassword.this,"Mail sent Successfully",Toast.LENGTH_SHORT).show();
                       }
                   }
               });
            }
        });
    }

}