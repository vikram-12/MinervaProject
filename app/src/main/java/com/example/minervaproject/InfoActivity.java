package com.example.minervaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class InfoActivity extends AppCompatActivity {
    private ListView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        logout = findViewById(R.id.infoView);
        String[] values = new String[]{
                "About", "Help", "Logout"
        };

        ArrayAdapter<String> Adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, values);
        logout.setAdapter(Adapter);

        logout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), AboutActivity.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    String uriText =
                            "mailto:minervaminor5@gmail.com" +
                                    "?subject=" + Uri.encode("Issue with the app") +
                                    "&body=" + Uri.encode("");

                    Uri uri = Uri.parse(uriText);

                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                    sendIntent.setData(uri);
                    startActivity(Intent.createChooser(sendIntent, "Send email"));


                }
                if (position == 2) {
                    FirebaseAuth.getInstance().signOut();//logout
                    Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();


                }

            }

        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(InfoActivity.this
                , HomeActivity.class);
        startActivity(intent);
        finish();

    }
}

