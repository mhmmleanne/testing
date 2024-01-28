package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.PersistableBundle;

import java.io.File;
import java.util.ArrayList;


public class CustomGalleryActivity extends AppCompatActivity {
    ArrayList<String> f = new ArrayList<>();
    File[] listFile;
    private String folderName = "MyPhotoDir";
    ViewPager mViewPager;
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_photo_result);
        getFromSdcard();
        mViewPager = findViewById(R.id.viewPagerMain);
        mViewPagerAdapter = new ViewPagerAdapter(this,f);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    public void getFromSdcard() {
        File file= new File(getExternalFilesDir(folderName),"/");
        if (file.isDirectory()) {
            listFile = file.listFiles();
            for (int i = 0; 1<listFile.length; i++) {
                f.add(listFile[i].getAbsolutePath());
            }
        }
    }
}
