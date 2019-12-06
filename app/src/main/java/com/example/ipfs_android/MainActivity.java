package com.example.ipfs_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static Button search, create, read, update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search = findViewById(R.id.search);
        create = findViewById(R.id.create);
        read = findViewById(R.id.read);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        search.setOnClickListener(this);
        create.setOnClickListener(this);
        read.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search:
                searchFile();
                break;
            case R.id.create:
                addFile();
                break;
            case R.id.read:
                showFile();
                break;
            case R.id.update:
                updateFile();
                break;
            case R.id.delete:
                deleteFile();
                break;
        }
    }

    private void searchFile() {
        Intent intent = new Intent(this,Search.class);
        startActivity(intent);
    }

    private void addFile() {
        Intent intent = new Intent(this,Create.class);
        startActivity(intent);
    }

    private void showFile() {
        Intent intent = new Intent(this,Read.class);
        startActivity(intent);
    }

    private void updateFile() {
        Intent intent = new Intent(this,Update.class);
        startActivity(intent);
    }

    private void deleteFile() {
        Intent intent = new Intent(this,Delete.class);
        startActivity(intent);
    }
}
