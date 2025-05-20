package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class camera extends AppCompatActivity {

    ImageView imgView;
    Button btnCam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imgView=findViewById(R.id.img1);
        btnCam=findViewById(R.id.btncamera);

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),7);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bitmap bitmap= (Bitmap) data.getExtras().get("data");
        imgView.setImageBitmap(bitmap);
        super.onActivityResult(requestCode, resultCode, data);
    }
}