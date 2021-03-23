package com.example.minervaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    private EditText fullname;
    private EditText email;
    private EditText password;
    private Button registerBtn;
    private TextView login;
    private FirebaseAuth fAuth;
    private DatabaseReference myRef;
    public static String nameRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname=findViewById(R.id.fullName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        registerBtn=findViewById(R.id.register_btn);
        login=findViewById(R.id.login);
        fAuth=FirebaseAuth.getInstance();
        myRef=FirebaseDatabase.getInstance().getReference();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString();
                String password_txt = password.getText().toString();
                String name_txt = fullname.getText().toString();
                nameRef =fullname.getText().toString();
                if (TextUtils.isEmpty(email_txt)) {
                    email.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password_txt)) {
                    password.setError("Password is Required.");
                    return;
                }
                if (TextUtils.isEmpty(name_txt)) {
                    fullname.setError("Full name required");
                    return;
                }
                if (password.length() < 6) {
                    password.setError("Password Must be >= 6 Characters");
                    return;
                }
                registerUser(name_txt, email_txt, password_txt);

            }
        });
        
}
    


    private void registerUser(String name, String email, String password) {
        fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                HashMap<String,Object> map =new HashMap<>();
                map.put("Email",email);
                map.put("Name",name);
                map.put("id",fAuth.getCurrentUser().getUid());
                myRef.child("User").child(fAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(RegisterActivity.this,"Welcome to Minerva",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(RegisterActivity.this,HomeActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    }