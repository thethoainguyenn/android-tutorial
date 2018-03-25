package com.example.thoailun.eesty;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraDemoActivity extends AppCompatActivity {
    Button btnCamera;
    ImageView imgCamera;
    int REQUEST_CODE_CAMERA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);
        btnCamera = (Button) findViewById(R.id.btnCamera);
        imgCamera = (ImageView) findViewById(R.id.imgCamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Xin quyền
                ActivityCompat.requestPermissions(CameraDemoActivity.this,
                        new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
            }
        });
    }
    // Hứng phản hồi của khách hàng
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //kết quả trả lời: grantResults
        if(requestCode == REQUEST_CODE_CAMERA && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // Truyền qua màn hình khác, đồng thời nhận kết quả
            startActivityForResult(intent, REQUEST_CODE_CAMERA);
        } else  {
            Toast.makeText(this, "Bạn không cho phép mở camera", Toast.LENGTH_SHORT).show();
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    // Hứng kết quả trả về : gọi onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // resultCode : sự kiện tích vào dấu tích sau khi chụp xong
        if(requestCode == REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data"); // mặc định
            imgCamera.setImageBitmap(bitmap);


        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
