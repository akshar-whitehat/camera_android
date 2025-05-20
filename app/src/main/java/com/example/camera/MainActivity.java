package com.example.camera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vv1;
    Button bt1;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv1=findViewById(R.id.vv1);
        bt1=findViewById(R.id.bt1);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Camera Demo");
        actionBar.setDisplayShowHomeEnabled(true);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            vv1.setVideoPath("android.resources://"+getPackageName()+"/"+R.raw.ghi);
            mc=new MediaController(MainActivity.this);
            mc.setAnchorView(vv1);
            vv1.setMediaController(mc);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.camera:
//                Toast.makeText(this, "code for camera", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,camera.class));
                return true;
            case R.id.call:
                Toast.makeText(this, "code for call", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "code for logout", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}