package com.example.minervaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class DocumentActivity extends AppCompatActivity {
    ListView lvProgram;
    String[] programName = {"Database Management System","Operating System","Computer Networks","Algorithms","Data Structure","C","PYTHON"};
    String [] urls = {"https://drive.google.com/drive/folders/1Dv-ZQl_g3RM8I5-L9VssTztyaiCzenB0?usp=sharing",
            "https://drive.google.com/drive/folders/1DEE65NrHcgmIoHMsCpSbDd_rLqJ8DP2J?usp=sharing",
            "https://drive.google.com/drive/folders/18kDNORGRrkqizuXYHk1HQhkG7tKYiXzm?usp=sharing",
            "https://drive.google.com/drive/folders/1EDibEThub5Kpm1NkVNzMnE0la6vsEgyo?usp=sharing",
            "https://drive.google.com/drive/folders/1ChgZ1tk2yxBkKBxzFMu8Np1aGabX4Cyq?usp=sharing",
            "https://drive.google.com/drive/folders/15eOGFHbbadkvqC-cLNV-hyORFHmU5Nwf?usp=sharing",
            "https://drive.google.com/drive/folders/1AQ1iDituUG3MSKI77DypM67XP39DU8XA?usp=sharing"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        lvProgram = findViewById(R.id.lvProgram);
        DocAdapter docAdapter = new DocAdapter(this,programName,urls);
        lvProgram.setAdapter(docAdapter);
    }
}