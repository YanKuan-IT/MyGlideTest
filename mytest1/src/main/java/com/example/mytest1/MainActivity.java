package com.example.mytest1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.test_iv);

        findViewById(R.id.change_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 加载本地的资源
//                Glide.with(MainActivity.this).load(R.mipmap.pic_1000).into(imageView);

                // 加载公网的资源
                String faceUrl = String.format("https://picsum.photos/id/%d/200/200", new Random().nextInt(1000));
                Glide.with(MainActivity.this)
                        .load(faceUrl)
                        .placeholder(R.mipmap.pic_1000)  // 占位符
                        .error(new ColorDrawable(Color.RED))  // 错误符
                        .fallback(new ColorDrawable(Color.BLUE))  // 后备回调符
//                        .apply(RequestOptions.bitmapTransform(new CircleCrop())) // 圆形
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(200))) // 圆角
                        .into(imageView);
            }
        });
    }
}