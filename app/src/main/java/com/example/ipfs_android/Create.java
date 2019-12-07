package com.example.ipfs_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multiaddr.MultiAddress;

public class Create extends AppCompatActivity implements View.OnClickListener{

    static Button browse, createFile;
    static TextView file;
    static File selectedFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
//        byte[] multAddr = "/ip4/127.0.0.1/tcp/5001".getBytes();
//        IPFS ipfs = new IPFS(new MultiAddress(multAddr));

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }

        file = findViewById(R.id.createFile);
        browse = findViewById(R.id.browse);
//        createFile = findViewById(R.id.cFile);

        browse.setOnClickListener(this);
//        createFile.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            selectedFile = new File(filePath);
            String FileName = selectedFile.getName();
            file.setText(FileName);
        }
    }

//    private void uploadFile(File selectedFile) {
//        NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(selectedFile);
//        try {
//            MerkleNode addResult = ipfs.add(file).get(0);
////            Optional<String> name = addResult.name;
////            if (name.isPresent()) {
////                Toast.makeText(this, "File Upload Success!", Toast.LENGTH_LONG).show();
////            }else {
////                Toast.makeText(this, "File Upload Failed!", Toast.LENGTH_LONG).show();
////            }
//            Toast.makeText(this, "File Upload!",Toast.LENGTH_LONG).show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1001:{
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Permission Denied!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.browse:
                new MaterialFilePicker()
                        .withActivity(Create.this)
                        .withRequestCode(1000)
                        .withFilter(Pattern.compile(".*\\.txt$"))
                        .start();
                break;

//            case R.id.cFile:
////                uploadFile(selectedFile);
//                break;
        }
    }
}
