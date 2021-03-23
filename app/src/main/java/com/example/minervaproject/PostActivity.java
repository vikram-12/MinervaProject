package com.example.minervaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hendraanggrian.appcompat.widget.SocialAutoCompleteTextView;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;

public class PostActivity extends AppCompatActivity {
   private Button postbtn;
   private SocialAutoCompleteTextView postTxt;
   private EditText namePublisher;

   private FirebaseAuth fAuth;
   private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        postbtn = findViewById(R.id.postBtn);
        postTxt = findViewById(R.id.inputEt);
        namePublisher =findViewById(R.id.nameField);
        fAuth=FirebaseAuth.getInstance();
        myRef= FirebaseDatabase.getInstance().getReference();

        postbtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
                final String userid=firebaseUser.getUid();
                String post_str= postTxt.getText().toString();
                String  name_str =namePublisher.getText().toString();

                if(TextUtils.isEmpty(post_str)){
                    Toast.makeText(PostActivity.this,"Please Share your Experience",Toast.LENGTH_SHORT).show();
                }
               else if(TextUtils.isEmpty(name_str)){
                    namePublisher.setError("Please Enter your Name");

               }
                else {

                    postData(name_str,post_str);
                }
            }


        });
    }

    private void postData(String name, String post) {
        HashMap<String,Object> mapPost =new HashMap<>();
        mapPost.put("Name",name);
        mapPost.put("Post",post);
        myRef.child("Post").child(PostActivity.getAlphaNumericString(20)).setValue(mapPost).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    Toast.makeText(PostActivity.this,"Updating",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(PostActivity.this,FeedActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PostActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }



        static String getAlphaNumericString(int n)
        {

            // chose a Character random from this String
            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            // create StringBuffer size of AlphaNumericString
            StringBuilder sb = new StringBuilder(n);

            for (int i = 0; i < n; i++) {

                // generate a random number between
                // 0 to AlphaNumericString variable length
                int index
                        = (int)(AlphaNumericString.length()
                        * Math.random());

                // add Character one by one in end of sb
                sb.append(AlphaNumericString
                        .charAt(index));
            }

            return sb.toString();
        }
    }
