package com.example.ipfs_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Search extends AppCompatActivity implements View.OnClickListener{

    public static Button searchFile;
    public static TextView searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchFile = findViewById(R.id.sFile);
        searchText = findViewById(R.id.searchFile);

        searchFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sFile:
                printSearchResults();
                break;
        }
    }

    private void printSearchResults() {

    }
}
